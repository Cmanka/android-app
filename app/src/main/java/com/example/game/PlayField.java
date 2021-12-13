package com.example.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PlayField extends AppCompatActivity {

    private Integer tries = 5;
    private String currentWord = "";
    private String finalWord = "";
    private String selectedLetters = "";
    private ConstraintLayout getLayout(){
        return findViewById(R.id.layout);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_field);
        showStartWord();
        DisplayTries(tries);
    }

    private void showStartWord(){
        TextView wordView = findViewById(R.id.word);
        String[] words = getResources().getStringArray(R.array.words);
        Integer randomNum = (int) Math.floor(Math.random()*words.length);
        for(int i=0;i<words[randomNum].length();i++){
            currentWord+="*";
        }
        finalWord = words[randomNum];
        wordView.setText(currentWord);
    }

    private void DisplayTries(Integer tries){
        TextView triesView = findViewById(R.id.tries);
        triesView.setText(tries.toString());
    }

    private void EndGame(Boolean status){
        getLayout().removeView(findViewById(R.id.btn1));
        getLayout().removeView(findViewById(R.id.btn2));
        getLayout().removeView(findViewById(R.id.btn3));
        getLayout().removeView(findViewById(R.id.btn4));
        getLayout().removeView(findViewById(R.id.btn5));
        getLayout().removeView(findViewById(R.id.btn6));
        getLayout().removeView(findViewById(R.id.btn7));
        getLayout().removeView(findViewById(R.id.btn8));
        getLayout().removeView(findViewById(R.id.btn9));
        getLayout().removeView(findViewById(R.id.btn10));
        getLayout().removeView(findViewById(R.id.btn11));
        getLayout().removeView(findViewById(R.id.btn12));
        getLayout().removeView(findViewById(R.id.btn13));
        getLayout().removeView(findViewById(R.id.btn14));
        getLayout().removeView(findViewById(R.id.btn15));
        getLayout().removeView(findViewById(R.id.btn16));
        getLayout().removeView(findViewById(R.id.btn17));
        getLayout().removeView(findViewById(R.id.btn18));
        getLayout().removeView(findViewById(R.id.btn19));
        getLayout().removeView(findViewById(R.id.btn20));
        getLayout().removeView(findViewById(R.id.btn21));
        getLayout().removeView(findViewById(R.id.btn22));
        getLayout().removeView(findViewById(R.id.btn23));
        getLayout().removeView(findViewById(R.id.btn24));
        getLayout().removeView(findViewById(R.id.btn25));
        getLayout().removeView(findViewById(R.id.btn26));
        getLayout().removeView(findViewById(R.id.btn28));
        getLayout().removeView(findViewById(R.id.btn29));
        getLayout().removeView(findViewById(R.id.btn30));
        getLayout().removeView(findViewById(R.id.btn31));
        getLayout().removeView(findViewById(R.id.btn32));
        getLayout().removeView(findViewById(R.id.btn33));
        getLayout().removeView(findViewById(R.id.btn34));
        getLayout().removeView(findViewById(R.id.btn35));
        TextView finalText = findViewById(R.id.finalText);
        if(status){
            finalText.setText("Вы победили! нажмите для рестарта");
        }
        else{
            finalText.setText("Вы проиграли! нажмите для рестарта");
        }
    }

    private void updateWord(String letter){
        TextView wordView = findViewById(R.id.word);
        selectedLetters+=" "+letter;
        String newWord = "";
        Boolean isFound = false;

        for(int i=0;i<finalWord.length();i++){
          String currentLetter = Character.toString(finalWord.charAt(i));
          if(selectedLetters.contains(currentLetter)){
              newWord+=currentLetter;
              if(letter.equals(currentLetter))
                isFound=true;
          }else{
              newWord+="*";
          }
        }

        if(!isFound){
            tries-=1;
            DisplayTries(tries);
        }
        if(finalWord.equals(newWord)){
            EndGame(true);
        }
        if(tries==0){
            EndGame(false);
        }

        wordView.setText(newWord);
    }


    public void onClickLetter(View view){
       Button button = findViewById(view.getId());
       button.setEnabled(false);
       String currentLetter = button.getText().toString();
       updateWord(currentLetter);
    }

    public void onClickRestartGame(View view){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}