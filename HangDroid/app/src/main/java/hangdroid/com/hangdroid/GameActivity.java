package hangdroid.com.hangdroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by kapilsoni on 21-12-2016.
 */
public class GameActivity extends AppCompatActivity{

//    String words = "able acid aged also area army away baby back ball band bank base bath bear beat been beer bell belt best bill bird blow blue boat body bomb bond bone book boom born boss both bowl bulk burn bush busy call calm came camp card care case cash cast cell chat chip city club coal coat code cold come cook cool cope copy core cost crew crop dark data date dawn days dead deal dean dear debt deep deny desk dial dick diet disc disk does done door dose down draw drew drop drug dual duke dust duty each earn ease east easy edge else even ever evil exit face fact fail fair fall farm fast fate fear feed feel feet fell felt file fill film find fine fire firm fish five flat flow food foot ford form fort four free from fuel full fund gain game gate gave gear gene gift girl give glad rely rent rest sent sign site size skin slip slow snow soft soil sold sole some song soon sort soul spot star stay step stop such suit sure take tale talk tall tank tape task team tech tell tend term test text than that them then they thin this thus till time tiny told toll tone tony took tool tour town tree trip true tune turn twin type unit upon used user vary vast very vice view vote wage wait wake walk wall want ward warm wash wave ways weak wear week well went were west what when whom wide wife wild will wind wine wing wire wise wish with wood word wore work yard yeah year your zero zone";
//    String wordsArr[] = words.split(" ");
    String mWord = "word";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    /**
     * Retrieving a letter from EditText
     * @param v (Button Clicked)
     * */
    public void introduceLetter(View v){
        EditText myEditText = (EditText) findViewById(R.id.editTextLetter);
        String letter = myEditText.getText().toString();
        //String letter = myEditText.getText().toString();
        Log.d("MYLOG","Letter introduced is"+letter);
        if (letter.length() == 0) {
            Toast.makeText(this,"Please introduce a letter",Toast.LENGTH_SHORT).show();
        }else {
            checkLetter(letter);
        }
    }

    public void checkLetter(String introducedLetter){
        char charIntroduced = introducedLetter.charAt(0);
        for (int i=0;i<mWord.length();i++) {
            char charFromTheWord = mWord.charAt(i);
            if (charFromTheWord == charIntroduced) {
                //TODO show letter
            }
        }
    }

}
