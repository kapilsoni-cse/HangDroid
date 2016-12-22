package hangdroid.com.hangdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MultiPlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_player);
    }

    public void startMultiGameActivity(View v) {

            EditText getWordIntroduced = (EditText) findViewById(R.id.getWord);
            String word = getWordIntroduced.getText().toString().toUpperCase();

            getWordIntroduced.setText("");

            Intent myIntent = new Intent(this, MultiGameActivity.class);
            myIntent.putExtra("WORD_INTRO", word);
            startActivity(myIntent);
    }
}
