package hangdroid.com.hangdroid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {

    int mPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        int points = getIntent().getIntExtra("POINTS_IDENTIFIER",0);

        TextView myTextView = (TextView) findViewById(R.id.textViewPoints);
        myTextView.setText(String.valueOf(points));

        String word  = getIntent().getStringExtra("WORD_WAS");
        TextView letterWasTV = (TextView) findViewById(R.id.letterWas);
        letterWasTV.setText(word);
        mPoints = points;
    }

    public void saveScore(View v){

        SharedPreferences preferences = getSharedPreferences("MY_PREFERENCES", Context.MODE_PRIVATE);

        EditText myEditText = (EditText) findViewById(R.id.editName);
        String name = myEditText.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();
        String previousScores = preferences.getString("SCORES","");
        editor.putString("SCORES",name.toUpperCase() + " | " + mPoints + " POINTS \n" + previousScores );
        editor.commit();

        goToMainActivity();
    }

    public void goToMainActivity() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}