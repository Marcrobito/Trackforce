package dev.eighteendev.trackforce.common;

import io.reactivex.rxjava3.core.Single;

/**
 * Provides access to the device's location services.
 * <p>
 * This interface abstracts the retrieval of the device's last known location,
 * returning it as a {@link Single} to support asynchronous operations.
 * </p>
 */
public interface LocationProvider {

    /**
     * Retrieves the device's last known location.
     * <p>
     * This method may return cached location data and does not initiate a new
     * location request. The result is provided asynchronously through a {@link Single}.
     * </p>
     *
     * @return a {@link Single} emitting the last known {@link Location},
     *         or an error if the location could not be retrieved.
     */
    Single<Location> getLastKnownLocation();
}