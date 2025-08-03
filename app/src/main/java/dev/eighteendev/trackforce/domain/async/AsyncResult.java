package dev.eighteendev.trackforce.domain.async;

/**
 * Represents an asynchronous result of an operation that emits either a success or an error.
 * This interface abstracts away reactive libraries, allowing domain logic to remain agnostic
 * of specific frameworks like RxJava or coroutines.
 *
 * @param <T> The type of the result produced upon successful completion.
 */
public interface AsyncResult<T> {
    /**
     * Subscribes to the asynchronous result.
     * The provided {@link Callback} will be invoked once the operation completes,
     * either with a successful result or with an error.
     *
     * @param callback The callback to handle success or failure events.
     */
    void subscribe(Callback<T> callback);

    /**
     * Callback interface to receive the result of an asynchronous operation.
     *
     * @param <T> The type of the result.
     */
    interface Callback<T> {
        /**
         * Invoked when the operation completes successfully.
         *
         * @param value The resulting value.
         */
        void onSuccess(T value);

        /**
         * Invoked when the operation encounters an error.
         *
         * @param error The exception describing the failure.
         */
        void onError(Throwable error);
    }
}