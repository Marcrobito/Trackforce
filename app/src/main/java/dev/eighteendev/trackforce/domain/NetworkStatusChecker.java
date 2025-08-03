package dev.eighteendev.trackforce.domain;

/**
 * Interface for checking the network connectivity status of the device.
 * <p>
 * Implementations of this interface should determine whether the device
 * has an active internet connection.
 */
public interface NetworkStatusChecker {

    /**
     * Checks if the device is currently connected to the internet.
     *
     * @return {@code true} if the device has internet access, {@code false} otherwise.
     */
    boolean isOnline();
}