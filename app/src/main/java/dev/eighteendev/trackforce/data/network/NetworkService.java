package dev.eighteendev.trackforce.data.network;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Singleton service for configuring and providing Retrofit API client for OpenWeatherMap API.
 * <p>
 * This class initializes Retrofit with necessary interceptors, converters, and RxJava3 support,
 * and provides an instance of {@link OpenWeatherApi} to perform network requests.
 */
public class NetworkService {

    /**
     * Base URL for OpenWeatherMap API.
     */
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";

    /**
     * Private constructor to enforce Singleton pattern.
     */
    private NetworkService() {}

    /**
     * Inner static holder class for thread-safe Singleton instantiation.
     */
    private static class Holder {
        private static final NetworkService INSTANCE = new NetworkService();
    }

    /**
     * Provides the Singleton instance of {@link NetworkService}.
     *
     * @return the unique {@link NetworkService} instance.
     */
    public static NetworkService getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * HTTP logging interceptor for logging network requests and responses.
     */
    private static final HttpLoggingInterceptor interceptor =
            new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    /**
     * OkHttpClient configured with logging interceptor.
     */
    private static final OkHttpClient client =
            new OkHttpClient.Builder().addInterceptor(interceptor).build();

    /**
     * Retrofit instance configured with base URL, Gson converter, and RxJava3 adapter.
     */
    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(new Gson()))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build();

    /**
     * API interface instance for OpenWeatherMap endpoints.
     */
    private final OpenWeatherApi api = retrofit.create(OpenWeatherApi.class);

    /**
     * Provides the {@link OpenWeatherApi} interface to perform network requests.
     *
     * @return the API interface for weather data requests.
     */
    public OpenWeatherApi getApi() {
        return api;
    }
}