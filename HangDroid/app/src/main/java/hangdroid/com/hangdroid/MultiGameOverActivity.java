package hangdroid.com.hangdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MultiGameOverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_game_over);

        String word  = getIntent().getStringExtra("WORD_WAS");
        TextView letterWasTV = (TextView) findViewById(R.id.letterWas);
        letterWasTV.setText(word);
    }
}