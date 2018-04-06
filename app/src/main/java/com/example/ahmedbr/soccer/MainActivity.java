package com.example.ahmedbr.soccer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    //Binding TextViews
    @BindView(R.id.firstPlayer_result)
    TextView firstPlayerResult;
    @BindView(R.id.secondPlayer_result)
    TextView secondPlayerResult;
    @BindView(R.id.numof_fouls1)
    TextView numOfFouls1;
    @BindView(R.id.numof_fouls2)
    TextView numOfFouls2;
    @BindView(R.id.first_player_yellow_card)
    TextView numOfYellowCard1;
    @BindView(R.id.second_player_yellow_card)
    TextView numOfYellowCard2;
    @BindView(R.id.first_player_red_card)
    TextView numOfRedCard1;
    @BindView(R.id.second_player_red_card)
    TextView numOfRedCard2;

    // Binding Buttons
    @BindView(R.id.first_player_goal)
    Button goalBtn1;
    @BindView(R.id.second_player_goal)
    Button goalBtn2;
    @BindView(R.id.first_player_foul)
    Button foulBtn1;
    @BindView(R.id.second_player_foul)
    Button foulBtn2;
    @BindView(R.id.reset_button)
    Button resetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        goalBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increaseAndSet(firstPlayerResult, 1);
            }
        });

        goalBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increaseAndSet(secondPlayerResult, 1);
            }
        });

        foulBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increaseAndSet(numOfFouls1, 1);
                setYellowAndRedTextViews(getValueFromTextView(numOfFouls1), numOfYellowCard1, numOfRedCard1);
            }
        });

        foulBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increaseAndSet(numOfFouls2, 1);
                setYellowAndRedTextViews(getValueFromTextView(numOfFouls2), numOfYellowCard2, numOfRedCard2);
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstPlayerResult.setText("0");
                secondPlayerResult.setText("0");
                numOfFouls1.setText("0");
                numOfFouls2.setText("0");
                numOfYellowCard1.setText("0");
                numOfRedCard1.setText("0");
                numOfYellowCard2.setText("0");
                numOfRedCard2.setText("0");
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(new Intent(MainActivity.this, popupWindow.class));
        return true;
    }

    public void increaseAndSet(TextView textView1, int value) {
        int x = getValueFromTextView(textView1);
        x += value;
        textView1.setText("" + x);
    }

    public int getValueFromTextView(TextView textView1) {
        return Integer.parseInt(textView1.getText().toString());
    }

    public void setYellowAndRedTextViews(int numberOfFouls, TextView yellowCardsTextView, TextView redCardsTextView) {
        int numOfYellowCards = numberOfFouls / 2;
        yellowCardsTextView.setText(numOfYellowCards + "");
        int numOfRedCards = getValueFromTextView(yellowCardsTextView);
        redCardsTextView.setText(numOfRedCards / 2 + "");
    }
}