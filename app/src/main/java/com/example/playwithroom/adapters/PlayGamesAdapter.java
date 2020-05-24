package com.example.playwithroom.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playwithroom.R;
import com.example.playwithroom.model.PlayGame;

import org.w3c.dom.Text;

import java.util.List;

public class PlayGamesAdapter extends RecyclerView.Adapter<PlayGamesAdapter.ViewHolder> {

    private List<PlayGame> playGames;

    public PlayGamesAdapter(List<PlayGame> playGames) {
        this.playGames = playGames;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.playgame_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PlayGame thisGame = playGames.get(position);
        holder.id.setText(String.valueOf(thisGame.getId()));
        holder.name.setText(thisGame.getName());
        holder.description.setText(thisGame.getDescription());
        holder.player.setText(String.valueOf(thisGame.getPlayers()));
    }

    @Override
    public int getItemCount() {
        return playGames.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView id, name, description, player;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.textViewId);
            name = itemView.findViewById(R.id.textViewName);
            description = itemView.findViewById(R.id.textViewDescription);
            player = itemView.findViewById(R.id.textViewPlayers);
        }
    }
}
