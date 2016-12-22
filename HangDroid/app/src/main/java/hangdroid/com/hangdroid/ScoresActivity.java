package hangdroid.com.hangdroid;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        SharedPreferences preferences = getSharedPreferences("MY_PREFERENCES",MODE_PRIVATE);
        String scores = preferences.getString("SCORES","NO SCORES");

        TextView myTextView  = (TextView) findViewById(R.id.textViewScores);
        myTextView.setText(scores);

    }
}