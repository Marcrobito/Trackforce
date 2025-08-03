package dev.eighteendev.trackforce.presentation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import dev.eighteendev.trackforce.R;
import dev.eighteendev.trackforce.databinding.ItemWeatherDetailBinding;
import dev.eighteendev.trackforce.presentation.model.DailyWeatherUi;

/**
 * Adapter class for displaying detailed weather information in a vertical RecyclerView.
 * <p>
 * Each item represents a specific weather data point within a selected day,
 * showing attributes like temperature, humidity, wind speed, and weather description.
 */
public class DailyDetailAdapter extends RecyclerView.Adapter<DailyDetailAdapter.ViewHolder> {

    private List<DailyWeatherUi> items;

    /**
     * Constructs a new adapter with the provided list of weather details.
     *
     * @param items the list of {@link DailyWeatherUi} objects to display.
     */
    public DailyDetailAdapter(List<DailyWeatherUi> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemWeatherDetailBinding binding = ItemWeatherDetailBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
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
     * Updates the adapter's data set with a new list of weather details.
     * Notifies the RecyclerView to refresh all items.
     *
     * @param items the new list of {@link DailyWeatherUi} to display.
     */
    public void updateItems(List<DailyWeatherUi> items){
        this.items = items;
        notifyDataSetChanged();
    }

    /**
     * ViewHolder class responsible for binding each weather detail item to its corresponding layout.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ItemWeatherDetailBinding binding;

        public ViewHolder(ItemWeatherDetailBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        /**
         * Binds a {@link DailyWeatherUi} object to the item layout.
         *
         * @param dailyWeather the weather detail to display.
         */
        public void bind(DailyWeatherUi dailyWeather){
            Context context = binding.getRoot().getContext();
            binding.txtHumidity.setText(context.getString(R.string.humidity_label, dailyWeather.getHumidity()));
            binding.txtApparentTemperature.setText(context.getString(R.string.apparent_temperature_label, dailyWeather.getApparentTemperature()));
            binding.txtWindSpeed.setText(context.getString(R.string.wind_speed_label, dailyWeather.getWindSpeed()));
            binding.txtTemperature.setText(context.getString(R.string.temperature_label, dailyWeather.getTemperature()));
            binding.txtWeather.setText(dailyWeather.getWeatherState());
            Glide.with(binding.imgIcon.getContext())
                    .load(getIconUrl(dailyWeather.getIcon()))
                    .into(binding.imgIcon);
        }

        private String getIconUrl(String icon){
            return "https://openweathermap.org/img/wn/" + icon + "@2x.png";
        }
    }
}