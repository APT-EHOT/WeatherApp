package ru.matchin.weatherapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.matchin.weatherapp.databinding.WeatherListItemBinding;

public class WeatherItemAdapter
    extends RecyclerView.Adapter<WeatherItemAdapter.WeatherItemViewHolder> {

    List<WeatherItem> data;

    public WeatherItemAdapter(List<WeatherItem> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public WeatherItemViewHolder onCreateViewHolder(
        @NonNull ViewGroup parent,
        int viewType
    ) {
        WeatherListItemBinding binding =
            WeatherListItemBinding
                .inflate(
                    LayoutInflater.from(parent.getContext()),
                    parent,
                    false
                );

        return new WeatherItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(
        @NonNull WeatherItemViewHolder holder,
        int position
    ) {
       holder.dateTime.setText(
           "Time and date: "+ data.get(position).dt_txt
       );
       holder.temp.setText(
           "Temperature: " +
               Math.round(data.get(position).main.temp - 273.15) +
               "°C"
       );
       holder.weather.setText(
           "Weather: " + data.get(position).weather.get(0).main
       );
       holder.humidity.setText(
           "Humidity: " + data.get(position).main.humidity.toString() + "%"
       );
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class WeatherItemViewHolder extends RecyclerView.ViewHolder {
        TextView dateTime;
        TextView temp;
        TextView weather;
        TextView humidity;

        public WeatherItemViewHolder(WeatherListItemBinding binding) {
            super(binding.getRoot());
            dateTime = binding.dateTime;
            temp = binding.temp;
            weather = binding.weather;
            humidity = binding.humidity;
        }
    }
}
