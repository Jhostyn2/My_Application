// LocationAdapter.java

package com.example.myapplication.ui.map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.data.database.DatabaseHelper;
import com.example.myapplication.ui.map.model.LocationModel;

import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder> {

    private List<LocationModel> locationList;
    private Context context;
    private DatabaseHelper databaseHelper;

    public LocationAdapter(List<LocationModel> locationList, Context context) {
        this.locationList = locationList;
        this.context = context;
        databaseHelper = new DatabaseHelper(context);
    }

    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_location, parent, false);
        return new LocationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {
        LocationModel location = locationList.get(position);
        holder.latitudeTextView.setText("Latitud: " + location.getLatitude());
        holder.longitudeTextView.setText("Longitud: " + location.getLongitude());

        holder.deleteButton.setOnClickListener(v -> {
            // Conversión explícita de `long` a `int`
            databaseHelper.eliminarUbicacion((int) location.getId());
            locationList.remove(position);
            notifyItemRemoved(position);
            Toast.makeText(context, "Ubicación eliminada", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return locationList.size();
    }

    public static class LocationViewHolder extends RecyclerView.ViewHolder {

        TextView latitudeTextView;
        TextView longitudeTextView;
        Button deleteButton;

        public LocationViewHolder(@NonNull View itemView) {
            super(itemView);
            latitudeTextView = itemView.findViewById(R.id.latitudeTextView);
            longitudeTextView = itemView.findViewById(R.id.longitudeTextView);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }
    }
}
