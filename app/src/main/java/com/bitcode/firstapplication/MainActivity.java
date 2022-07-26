package com.bitcode.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{
    TextView textView;
    EditText editTextUserName, editTextPassword;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setPadding(20, 20, 20, 20);
        linearLayout.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );

        linearLayout.setLayoutParams(layoutParams);

        ViewGroup.LayoutParams paramsForViews = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        textView = new TextView(this);
        textView.setText("Welcome to Android at Bitcode!");
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(20);

        textView.setLayoutParams(paramsForViews);
        linearLayout.addView(textView);

        editTextUserName = new EditText(this);
        editTextUserName.setHint("Enter UserName");

        editTextUserName.setLayoutParams(paramsForViews);
        linearLayout.addView(editTextUserName);

        editTextPassword = new EditText(this);
        editTextPassword.setLayoutParams(paramsForViews);

        linearLayout.addView(editTextPassword);

        btnSignIn = new Button(this);
        btnSignIn.setText("Sign In");
        btnSignIn.setBackgroundColor(Color.BLUE);

        btnSignIn.setLayoutParams(paramsForViews);
        linearLayout.addView(btnSignIn);

        setContentView(linearLayout);

        //Way 1
        /*textView.setOnClickListener(new TxtViewClickListener());
        btnSignIn.setOnClickListener(new BtnOnClickListener());
        */

        //Way 2
        /*
        View.OnClickListener listener = new MyOnClickListener();
        textView.setOnClickListener(listener);
        btnSignIn.setOnClickListener(listener);
         */

        //Way 3
        textView.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
    }

    //Way 3
    @Override
    public void onClick(View view) {
        if(view == textView){
            textView.setText("");
        }
        else{
            if(editTextUserName.getText().toString().equals("bitcode") && editTextPassword.getText().toString().equals("bitcode@123")){
                textView.setText("Welcome"+editTextUserName.getText().toString());
            }
            else{
                textView.setText("Login Failed");
            }
        }
    }

    class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view == textView) {
                textView.setText("");
            } else {
                if (editTextUserName.getText().toString().equals("Aishwarya") && editTextPassword.getText().toString().equals("Aishwarya@123")) {
                    textView.setText("Welcome" + editTextUserName.getText().toString());
                } else {
                    textView.setText("Login Failed!");
                }
            }
        }
    }

    class BtnOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (editTextUserName.getText().toString().equals("bitcode") && editTextPassword.getText().toString().equals("bitcode@123")) {
                textView.setText("Welcome" + editTextUserName.getText().toString());
            } else {
                textView.setText("Login Failed...");
            }
        }
    }


    class TxtViewClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            textView.setText("");
        }
    }
}