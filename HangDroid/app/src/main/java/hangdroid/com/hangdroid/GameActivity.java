package hangdroid.com.hangdroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
public class GameActivity extends AppCompatActivity{

//    String words = "able acid aged also area army away baby back ball band bank base bath bear beat been beer bell belt best bill bird blow blue boat body bomb bond bone book boom born boss both bowl bulk burn bush busy call calm came camp card care case cash cast cell chat chip city club coal coat code cold come cook cool cope copy core cost crew crop dark data date dawn days dead deal dean dear debt deep deny desk dial dick diet disc disk does done door dose down draw drew drop drug dual duke dust duty each earn ease east easy edge else even ever evil exit face fact fail fair fall farm fast fate fear feed feel feet fell felt file fill film find fine fire firm fish five flat flow food foot ford form fort four free from fuel full fund gain game gate gave gear gene gift girl give glad rely rent rest sent sign site size skin slip slow snow soft soil sold sole some song soon sort soul spot star stay step stop such suit sure take tale talk tall tank tape task team tech tell tend term test text than that them then they thin this thus till time tiny told toll tone tony took tool tour town tree trip true tune turn twin type unit upon used user vary vast very vice view vote wage wait wake walk wall want ward warm wash wave ways weak wear week well went were west what when whom wide wife wild will wind wine wing wire wise wish with wood word wore work yard yeah year your zero zone";
//    String wordsArr[] = words.split(" ");
    String mWord;
    String mWrongLetter = "";
    int letterFailedCount = 0;
    int letterGuessedCount = 0;
    int mPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setRandomWord();
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
            mPoints++;
            //Clear the Screen
            clearScreen();
            //Start the Game
            setRandomWord();
        }
    }

    public void setRandomWord() {
        String words = "able acid aged also area army away baby back ball band bank base bath bear beat been beer bell belt best bill bird blow blue boat body bomb bond bone book boom born boss both bowl bulk burn bush busy call calm came camp card care case cash cast cell chat chip city club coal coat code cold come cook cool cope copy CORE cost crew crop dark data date dawn days dead deal dean dear debt deep deny desk dial dick diet disc disk does done door dose down draw drew drop drug dual duke dust duty each earn ease east easy edge else even ever evil exit face fact fail fair fall farm fast fate fear feed feel feet fell felt file fill film find fine fire firm fish five flat flow food foot ford form fort four free from fuel full fund gain game gate gave gear gene gift girl give glad goal goes gold Golf gone good gray grew grey grow gulf hair half hall hand hang hard harm hate have head hear heat held hell help here hero high hill hire hold hole holy home hope host hour huge hung hunt hurt idea inch into iron item jack jane jean john join jump jury just keen keep kent kept kick kill kind king knee knew know lack lady laid lake land lane last late lead left less life lift like line link list live load loan lock logo long look lord lose loss lost love luck made mail main make male many Mark mass matt meal mean meat meet menu mere mike mile milk mill mind mine miss mode mood moon more most move much must name navy near neck need news next nice nick nine none nose note okay once only onto open oral over pace pack page paid pain pair palm park part pass past path peak pick pink pipe plan play plot plug plus poll pool poor port post pull pure push race rail rain rank rare rate read real rear rely rent rest rice rich ride ring rise risk road rock role roll roof room root rose rule rush ruth safe said sake sale salt same sand save seat seed seek seem seen self sell send sent sept ship shop shot show shut sick side sign site size skin slip slow snow soft soil sold sole some song soon sort soul spot star stay step stop such suit sure take tale talk tall tank tape task team tech tell tend term test text than that them then they thin this thus till time tiny told toll tone tony took tool tour town tree trip true tune turn twin type unit upon used user vary vast very vice view vote wage wait wake walk wall want ward warm wash wave ways weak wear week well went were west what when whom wide wife wild will wind wine wing wire wise wish with wood word wore work yard yeah year your zero zone";
        String wordsArr[] = words.split(" ");

        int randomNumber = (int) (Math.random() * wordsArr.length);

        mWord = wordsArr[randomNumber].toUpperCase();

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
            Intent gameOverIntent  = new Intent(this,GameOverActivity.class);
            gameOverIntent.putExtra("POINTS_IDENTIFIER",mPoints);
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