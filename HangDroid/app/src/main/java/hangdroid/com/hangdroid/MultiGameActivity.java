package hangdroid.com.hangdroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by kapilsoni on 21-12-2016.
 */
public class MultiGameActivity extends AppCompatActivity{

    String mWord;
    String mWrongLetter = "";
    int letterFailedCount = 0;
    int letterGuessedCount = 0;
    int mPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_game);
        String introducedWord = getIntent().getStringExtra("WORD_INTRO");
        mWord = introducedWord;
        createTextViews(mWord);
    }

    private void createTextViews(String mWord) {
        LinearLayout myLayout = (LinearLayout) findViewById(R.id.textViewGroup);

        for (int i=0;i< mWord.length();i++) {
            TextView myTextView  = (TextView) getLayoutInflater().inflate(R.layout.textview,null);
            myLayout.addView(myTextView);
        }
    }

    /**
     * Retrieving a letter from EditText
     * @param v (Button Clicked)
     * */
    public void introduceLetter(View v){

        EditText myEditText = (EditText) findViewById(R.id.editTextLetter);
        String letter = myEditText.getText().toString();
        myEditText.setText("");
        if (letter.length() == 0) {
            Toast.makeText(this,"Please introduce a letter",Toast.LENGTH_SHORT).show();
        }else {
            checkLetter(letter);
        }
    }

    /**
     * Validation of letter whether it's belong to the actual String or not.
     * @param introducedLetter
     * */
    public void checkLetter(String introducedLetter){
        char charIntroduced = introducedLetter.charAt(0);
        Boolean letterGuessed = false;
        for (int i=0;i<mWord.length();i++) {
            char charFromTheWord = mWord.charAt(i);
            if (charFromTheWord == charIntroduced) {
                letterGuessed = true;
                showLetterGuessed(i,charIntroduced);
                letterGuessedCount++;
            }
        }

        if (letterGuessed == false) {
            letterFailed(charIntroduced);
        }

        if (letterGuessedCount == mWord.length()) {
            nextPlayerTurn();
        }
    }

    public void nextPlayerTurn() {
        finish();
    }

    public void clearScreen(){
        letterFailedCount = 0;
        letterGuessedCount = 0;
        TextView letterFailed = (TextView) findViewById(R.id.wrongLetters);
        letterFailed.setText("");
        ImageView myImageView = (ImageView) findViewById(R.id.hangDroidImage);
        myImageView.setImageResource(R.drawable.hangdroid_0);
        LinearLayout myLinearLayout = (LinearLayout) findViewById(R.id.textViewGroup);
        for(int i=0;i<mWord.length();i++){
            TextView myTextView = (TextView) myLinearLayout.getChildAt(i);
            myTextView.setText("__");
        }
    }
    public void letterFailed(char charIntroduced) {
        letterFailedCount++;
        mWrongLetter = mWrongLetter + charIntroduced;
        TextView myTextView  = (TextView) findViewById(R.id.wrongLetters);
        myTextView.setText(mWrongLetter);

        ImageView myImageView = (ImageView) findViewById(R.id.hangDroidImage);

        if(letterFailedCount == 1){
                myImageView.setImageResource(R.drawable.hangdroid_1);
        } else if(letterFailedCount == 2){
                myImageView.setImageResource(R.drawable.hangdroid_2);
        } else if (letterFailedCount == 3) {
                myImageView.setImageResource(R.drawable.hangdroid_3);
        } else if (letterFailedCount == 4) {
                myImageView.setImageResource(R.drawable.hangdroid_4);
        } else if (letterFailedCount == 5) {
                myImageView.setImageResource(R.drawable.hangdroid_5);
        } else if(letterFailedCount == 6){
            Intent gameOverIntent  = new Intent(this,MultiGameOverActivity.class);
            gameOverIntent.putExtra("WORD_WAS",mWord);
            startActivity(gameOverIntent);
            finish();
        }
    }


    /**
     * Show the letter guessed by the user at the specific position.
     * @param index //position of a letter according to string.
     * @param letterGuessed //letter belong to the particular string.
     * */
    public void showLetterGuessed(int index, char letterGuessed){
        LinearLayout textViewLayout = (LinearLayout) findViewById(R.id.textViewGroup);
        TextView textViewTextView = (TextView) textViewLayout.getChildAt(index);
        textViewTextView.setText(Character.toString(letterGuessed));
    }

}