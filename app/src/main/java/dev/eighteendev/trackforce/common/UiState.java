package dev.eighteendev.trackforce.common;

/**
 * Represents the UI state of a data-loading operation.
 * This sealed-like class models common states such as Loading, Success, Error, and Empty.
 *
 * @param <T> The type of data associated with a successful state.
 */
public abstract class UiState<T> {
    private UiState() {}

    /**
     * Represents a loading state, indicating that a background operation is in progress.
     *
     * @param <T> The type of data expected once the loading completes.
     */
    public static final class Loading<T> extends UiState<T> {}

    /**
     * Represents a successful state, holding the resulting data.
     *
     * @param <T> The type of data returned upon successful completion.
     */
    public static final class Success<T> extends UiState<T> {
        /**
         * The data resulting from the successful operation.
         */
        public final T data;

        /**
         * Constructs a {@code Success} state with the specified data.
         *
         * @param data The resulting data.
         */
        public Success(T data) {
            this.data = data;
        }
    }

    /**
     * Represents an error state, holding the encountered exception.
     *
     * @param <T> The type of data that was expected.
     */
    public static final class Error<T> extends UiState<T> {
        /**
         * The error encountered during the operation.
         */
        public final Throwable error;

        /**
         * Constructs an {@code Error} state with the specified throwable.
         *
         * @param error The encountered exception.
         */
        public Error(Throwable error) {
            this.error = error;
        }
    }

    /**
     * Represents an empty state, indicating that no data is available.
     *
     * @param <T> The type of data that was expected.
     */
    public static final class Empty<T> extends UiState<T> {}
}