package dev.eighteendev.trackforce.presentation;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import dev.eighteendev.trackforce.databinding.ItemDailyWeatherBinding;
import dev.eighteendev.trackforce.presentation.model.DailyWeatherSummary;

/**
 * Adapter for displaying a horizontal list of daily weather summaries.
 * <p>
 * Each item shows a day's name, minimum and maximum temperatures, and an associated weather icon.
 * The adapter notifies a listener when a day is selected.
 */
public class DailyWeatherSummaryAdapter extends RecyclerView.Adapter<DailyWeatherSummaryAdapter.ViewHolder> {

    private final List<DailyWeatherSummary> items;
    private final OnDaySelectedListener listener;

    /**
     * Constructs a new adapter with the given list of daily summaries and a click listener.
     *
     * @param items    the list of {@link DailyWeatherSummary} to display.
     * @param listener the listener to notify when a day is selected.
     */
    public DailyWeatherSummaryAdapter(List<DailyWeatherSummary> items, OnDaySelectedListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemDailyWeatherBinding binding = ItemDailyWeatherBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    /**
     * ViewHolder for individual daily weather summary items.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemDailyWeatherBinding binding;
        private final OnDaySelectedListener listener;

        /**
         * Constructs a new ViewHolder.
         *
         * @param binding  the ViewBinding for the item layout.
         * @param listener the listener to notify on click events.
         */
        public ViewHolder(ItemDailyWeatherBinding binding, OnDaySelectedListener listener) {
            super(binding.getRoot());
            this.binding = binding;
            this.listener = listener;
        }

        /**
         * Binds the data from a {@link DailyWeatherSummary} object to the UI components.
         *
         * @param summary the daily weather summary to display.
         */
        public void bind(DailyWeatherSummary summary) {
            String minTemp = summary.getMinTemperature() + "°";
            String maxTemp = summary.getMaxTemperature() + "°";
            binding.txtWeekDay.setText(summary.getDay());
            binding.txtMinTemp.setText(minTemp);
            binding.txtMaxTemp.setText(maxTemp);

            Glide.with(binding.imgWeatherIcon.getContext())
                    .load(getIconUrl(summary.getIcon()))
                    .into(binding.imgWeatherIcon);

            binding.getRoot().setOnClickListener(v -> {
                if (listener != null) {
                    listener.onDaySelected(summary.getDay());
                }
            });
        }

        /**
         * Constructs the URL for fetching the weather icon image.
         *
         * @param icon the icon code from the weather API.
         * @return the full URL for the icon.
         */
        private String getIconUrl(String icon) {
            return "https://openweathermap.org/img/wn/" + icon + "@2x.png";
        }
    }

    /**
     * Listener interface for handling day selection events.
     */
    public interface OnDaySelectedListener {
        /**
         * Called when a day is selected by the user.
         *
         * @param day the selected day's name.
         */
        void onDaySelected(String day);
    }
}