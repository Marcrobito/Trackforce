package dev.eighteendev.trackforce;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;

/**
 * Main Application class for initializing dependency injection using Hilt.
 * <p>
 * Annotating this class with {@link HiltAndroidApp} triggers Hilt's code generation,
 * setting up the application-level dependency container.
 * This is the entry point for dependency injection in the app.
 */
@HiltAndroidApp
public class WeatherApplication extends Application {
}