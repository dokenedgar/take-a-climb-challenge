package com.edgar.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    boolean PLAYER_X = true;

    int TURN_COUNT = 0;

    Button row00;
    Button row01;
    Button row02;

    Button row10;
    Button row11;
    Button row12;

    Button row20;
    Button row21;
    Button row22;

    Button ResetButton;

    TextView tvInfo;

    int[][] boardStatus = new int[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        row00 =  findViewById(R.id.row00);
        row01 =  findViewById(R.id.row01);
        row02 =  findViewById(R.id.row02);

        row10 =  findViewById(R.id.row10);
        row11 =  findViewById(R.id.row11);
        row12 =  findViewById(R.id.row12);

        row20 =  findViewById(R.id.row20);
        row21 =  findViewById(R.id.row21);
        row22 =  findViewById(R.id.row22);

        ResetButton =  findViewById(R.id.ResetButton);
        tvInfo =  findViewById(R.id.tvInfo);

        ResetButton.setOnClickListener(this);

        row00.setOnClickListener(this);
        row01.setOnClickListener(this);
        row02.setOnClickListener(this);

        row10.setOnClickListener(this);
        row11.setOnClickListener(this);
        row12.setOnClickListener(this);

        row20.setOnClickListener(this);
        row21.setOnClickListener(this);
        row22.setOnClickListener(this);

        initializeBoardStatus();

        setInfo("Player 'X' Turn ");

    }

    @Override
    public void onClick(View view) {


        boolean resetButtonPressed = false;

        switch (view.getId()){
            case R.id.row00:
                if(PLAYER_X){
                    row00.setText("X");
                    boardStatus[0][0] = 1;
                }
                else{
                    row00.setText("0");
                    boardStatus[0][0] = 0;
                }
                row00.setEnabled(false);
                break;

            case R.id.row01:
                if(PLAYER_X){
                    row01.setText("X");
                    boardStatus[0][1] = 1;
                }
                else{
                    row01.setText("0");
                    boardStatus[0][1] = 0;
                }
                row01.setEnabled(false);
                break;

            case R.id.row02:
                if(PLAYER_X){
                    row02.setText("X");
                    boardStatus[0][2] = 1;
                }
                else{
                    row02.setText("0");
                    boardStatus[0][2] = 0;
                }
                row02.setEnabled(false);
                break;

            case R.id.row10:
                if(PLAYER_X){
                    row10.setText("X");
                    boardStatus[1][0] = 1;
                }
                else{
                    row10.setText("0");
                    boardStatus[1][0] = 0;
                }
                row10.setEnabled(false);
                break;

            case R.id.row11:
                if(PLAYER_X){
                    row11.setText("X");
                    boardStatus[1][1] = 1;
                }
                else{
                    row11.setText("0");
                    boardStatus[1][1] = 0;
                }
                row11.setEnabled(false);
                break;

            case R.id.row12:
                if(PLAYER_X){
                    row12.setText("X");
                    boardStatus[1][2] = 1;
                }
                else{
                    row12.setText("0");
                    boardStatus[1][2] = 0;
                }
                row12.setEnabled(false);
                break;

            case R.id.row20:
                if(PLAYER_X){
                    row20.setText("X");
                    boardStatus[2][0] = 1;
                }
                else{
                    row20.setText("0");
                    boardStatus[2][0] = 0;
                }
                row20.setEnabled(false);
                break;

            case R.id.row21:
                if(PLAYER_X){
                    row21.setText("X");
                    boardStatus[2][1] = 1;
                }
                else{
                    row21.setText("0");
                    boardStatus[2][1] = 0;
                }
                row21.setEnabled(false);
                break;

            case R.id.row22:
                if(PLAYER_X){
                    row22.setText("X");
                    boardStatus[2][2] = 1;
                }
                else{
                    row22.setText("0");
                    boardStatus[2][2] = 0;
                }
                row22.setEnabled(false);
                break;

            case R.id.ResetButton:
                resetButtonPressed = true;
                break;

            default:
                break;

        }

        if(resetButtonPressed){
            resetBoard();
        }
        else{
            TURN_COUNT ++;
            PLAYER_X = !PLAYER_X;

            if(PLAYER_X){
                setInfo("Player X turn");
            }
            else {
                setInfo("Player 0 turn");
            }

            if(TURN_COUNT==9){
                result("Game is a Draw");
            }

            checkWinner();
        }
    }

    private void checkWinner(){

        //Check Horizontal (Rows)
        for(int i=0; i<3; i++){
            if(boardStatus[i][0] == boardStatus[i][1] && boardStatus[i][0] == boardStatus[i][2]){
                if (boardStatus[i][0]==1){
                    result("Player X winner\n" + (i+1)+" row");
                    break;
                }
                else if (boardStatus[i][0]==0) {
                    result("Player 0 winner\n" + (i+1)+" row");
                    break;
                }
            }
        }

        //Check Vertical (Columns)
        for(int i=0; i<3; i++){
            if(boardStatus[0][i] == boardStatus[1][i] && boardStatus[0][i] == boardStatus[2][i]){
                if (boardStatus[0][i]==1){
                    result("Player X winner\n" + (i+1)+" column");
                    break;
                }
                else if (boardStatus[0][i]==0) {
                    result("Player 0 winner\n" + (i+1)+" column");
                    break;
                }
            }
        }

        //Diagonal 1
        if(boardStatus[0][0] == boardStatus[1][1] && boardStatus[0][0] == boardStatus[2][2]){
            if (boardStatus[0][0]==1){
                result("Player X winner\nFirst Diagonal");
            }
            else if (boardStatus[0][0]==0) {
                result("Player 0 winner\nFirst Diagonal");
            }
        }

        //Diagonal 2
        if(boardStatus[0][2] == boardStatus[1][1] && boardStatus[0][2] == boardStatus[2][0]){
            if (boardStatus[0][2]==1){
                result("Player X winner\nSecond Diagonal");
            }
            else if (boardStatus[0][2]==0) {
                result("Player 0 winner\nSecond Diagonal");
            }
        }
    }

    private void enableAllBoxes(boolean value){

        row00.setEnabled(value);
        row01.setEnabled(value);
        row02.setEnabled(value);

        row10.setEnabled(value);
        row11.setEnabled(value);
        row12.setEnabled(value);

        row20.setEnabled(value);
        row21.setEnabled(value);
        row22.setEnabled(value);
    }

    private void result(String winner){


        setInfo(winner);
        enableAllBoxes(false);
    }

    private void resetBoard(){

        row00.setText("");
        row01.setText("");
        row02.setText("");

        row10.setText("");
        row11.setText("");
        row12.setText("");

        row20.setText("");
        row21.setText("");
        row22.setText("");

        enableAllBoxes(true);

        PLAYER_X = true;
        TURN_COUNT = 0;

        initializeBoardStatus();

        setInfo("Player 'X' Turn ");

        Toast.makeText(this,"Board Reset",Toast.LENGTH_SHORT).show();
    }

    private void setInfo(String text){
        tvInfo.setText(text);
    }

    private void initializeBoardStatus(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                boardStatus[i][j] = -1;
            }
        }

    }


}