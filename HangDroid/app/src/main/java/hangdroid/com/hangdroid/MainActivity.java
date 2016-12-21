package hangdroid.com.hangdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Method for Single Player Game
    public void singlePlayerGame(View v){
        Intent myIntent = new Intent(this,GameActivity.class);
        startActivity(myIntent);
    }

    //Method for Multi Player Game
    public void multiPlayerGame(View v){
        Intent myIntent = new Intent(this,MainActivity.class);
        startActivity(myIntent);
    }

    //Method for Scores Storage
    public void scoresGame(View v){
        Intent myIntent = new Intent(this,MainActivity.class);
        startActivity(myIntent);
    }
}
