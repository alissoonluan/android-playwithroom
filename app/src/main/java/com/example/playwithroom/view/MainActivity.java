package com.example.playwithroom.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.playwithroom.R;
import com.example.playwithroom.adapters.PlayGamesAdapter;
import com.example.playwithroom.database.DatabaseConnection;
import com.example.playwithroom.databinding.ActivityMainBinding;
import com.example.playwithroom.model.PlayGame;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<PlayGame> gamesList;
    DatabaseConnection connection;
    PlayGamesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        gamesList = new ArrayList<>();
        connection = DatabaseConnection.getInstance(this);

        adapter = new PlayGamesAdapter(gamesList);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);

        binding.buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayGame playGame = new PlayGame("Amarelinha", 10, "Pular amarelinha");
                connection.playGameDao().insert(playGame);
            }
        });

        binding.buttonGetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gamesList.clear();
                gamesList.addAll(connection.playGameDao().getAllGames());
                binding.recyclerView.scrollToPosition(adapter.getItemCount() - 1);
                adapter.notifyDataSetChanged();
            }
        });

        binding.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!gamesList.isEmpty()){
                    connection.playGameDao().delete((gamesList.size() -1));
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
}
