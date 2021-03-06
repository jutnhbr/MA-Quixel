package com.example.quizz.gameLogic.gamemodes;

import android.os.Bundle;
import com.example.quizz.R;
import com.example.quizz.exceptions.QueryException;
import com.example.quizz.network.Wrapper;
import com.example.quizz.questionManager.Question;
import com.example.quizz.view.GamemodeActivity;
import java.io.IOException;
import java.util.ArrayList;


public class Gamemode_mp extends GamemodeActivity implements IGameSettings, IGamemode {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamemode);

        setup();
        try {
            begin();
        } catch (IOException | QueryException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void setup() {
        super.setup();
    }

    public void begin() throws IOException, QueryException {
        Wrapper wrap = (Wrapper) getIntent().getSerializableExtra("flag");
        super.begin(wrap.getqList());
    }

    public String description() {
        return super.description("Multiplayer Gamemode");

    }

    @Override
    public String getGamemodeName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }


}