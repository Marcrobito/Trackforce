package dev.eighteendev.trackforce.data;

import dev.eighteendev.trackforce.domain.NetworkStatusChecker;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;

/**
 * Implementation of {@link NetworkStatusChecker} that checks the device's current network connectivity.
 * <p>
 * Uses Android's {@link ConnectivityManager} and {@link NetworkCapabilities} to verify if the device
 * is connected to a network with internet access.
 */
public class NetworkStatusCheckerImpl implements NetworkStatusChecker {

    private final Context context;

    /**
     * Constructs a {@link NetworkStatusCheckerImpl} with the provided Android {@link Context}.
     *
     * @param context the context used to access system services.
     */
    public NetworkStatusCheckerImpl(Context context) {
        this.context = context;
    }

    /**
     * Checks if the device is currently connected to a network with internet access.
     *
     * @return {@code true} if the device is online; {@code false} otherwise.
     */
    @Override
    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkCapabilities capabilities = cm.getNetworkCapabilities(cm.getActiveNetwork());
            return capabilities != null && capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET);
        }
        return false;
    }
}