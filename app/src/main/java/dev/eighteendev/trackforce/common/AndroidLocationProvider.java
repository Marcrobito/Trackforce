package dev.eighteendev.trackforce.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.Priority;

import io.reactivex.rxjava3.core.Single;

public class AndroidLocationProvider implements LocationProvider {

    private final FusedLocationProviderClient locationClient;

    public AndroidLocationProvider(Context context) {
        this.locationClient = LocationServices.getFusedLocationProviderClient(context);
    }

    @SuppressLint("MissingPermission")
    @Override
    public Single<Location> getLastKnownLocation() {
        return Single.<Location>create(emitter -> {
                    locationClient.getLastLocation()
                            .addOnSuccessListener(androidLocation -> {
                                if (androidLocation != null) {
                                    emitter.onSuccess(new Location(
                                            androidLocation.getLatitude(),
                                            androidLocation.getLongitude()
                                    ));
                                } else {
                                    LocationRequest request = new LocationRequest.Builder(
                                            Priority.PRIORITY_HIGH_ACCURACY, 5000
                                    ).setMaxUpdates(1).build();

                                    locationClient.requestLocationUpdates(request, new LocationCallback() {
                                        @Override
                                        public void onLocationResult(LocationResult locationResult) {
                                            locationClient.removeLocationUpdates(this);
                                            android.location.Location freshLocation = locationResult.getLastLocation();
                                            if (freshLocation != null) {
                                                emitter.onSuccess(new Location(
                                                        freshLocation.getLatitude(),
                                                        freshLocation.getLongitude()
                                                ));
                                            } else {
                                                emitter.onError(new IllegalStateException("Still couldn't fetch location."));
                                            }
                                        }
                                    }, Looper.getMainLooper()); // <- ESTE ES EL CAMBIO IMPORTANTE
                                }
                            })
                            .addOnFailureListener(emitter::onError);
                })
                .timeout(30, java.util.concurrent.TimeUnit.SECONDS)
                .doOnError(error -> Log.e("LocationProvider", "Timeout or location error", error));
    }
}