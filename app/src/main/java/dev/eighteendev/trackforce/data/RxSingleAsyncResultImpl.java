package dev.eighteendev.trackforce.data;

import android.annotation.SuppressLint;

import dev.eighteendev.trackforce.domain.async.AsyncResult;
import io.reactivex.rxjava3.core.Single;

/**
 * Adapter class that bridges RxJava's {@link Single} with the custom {@link AsyncResult} interface.
 * <p>
 * This implementation allows using RxJava's reactive streams while exposing a callback-based
 * subscription model defined by {@link AsyncResult}.
 *
 * @param <T> the type of result emitted by the Single.
 */
public class RxSingleAsyncResultImpl<T> implements AsyncResult<T> {
    private final Single<T> single;

    /**
     * Constructs a new {@link RxSingleAsyncResultImpl} with the provided {@link Single}.
     *
     * @param single the RxJava Single to be adapted.
     */
    public RxSingleAsyncResultImpl(Single<T> single) {
        this.single = single;
    }

    /**
     * Subscribes to the underlying {@link Single} and routes success and error callbacks
     * to the provided {@link Callback}.
     *
     * @param callback the callback to be invoked upon success or error.
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    @SuppressLint("CheckResult")
    @Override
    public void subscribe(Callback<T> callback) {
        single.subscribe(callback::onSuccess, callback::onError);
    }

    /**
     * Exposes the underlying {@link Single} for direct RxJava chaining if needed.
     *
     * @return the encapsulated {@link Single}.
     */
    public Single<T> asSingle() {
        return single;
    }
}