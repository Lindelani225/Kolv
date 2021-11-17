package com.example.koivl;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.CountDownTimer;

import javax.xml.validation.Validator;

public class MainActivity extends AppCompatActivity {
    //Validaltion
    ProgressDialog progressDialog;
    Button login_button;
    EditText user;
    EditText password;
    TextView ErrorMessage;
    int counter =10;
    String validName = "Admin";
    String validPassword = "Password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user =(EditText)findViewById(R.id.UserName);
        password=(EditText)findViewById(R.id.Password);
        login_button=(Button)findViewById(R.id.login);
        ErrorMessage =(TextView)findViewById(R.id.errorMessage);
    }

    //Validating method.
   public  void Validation (String Name , String Password){

       Intent i = new Intent(this,SecondActivity.class);
       if (Name.equals(validName) && Password.equals(validPassword)) {
           super.onStart();
           progressDialog  = ProgressDialog.show(this,"Please Wait !",
                   "Processing..");
           CountDownTimer count = new CountDownTimer(5000,1000) {
               @Override
               public void onTick(long l) { }
               @Override
               public void onFinish() { }
           };

           i.putExtra("UserName",Name);
           startActivity(i);
       }

       else {

           counter--;

           if((!Name.equals(validName))&&(!Password.equals(validPassword)))
               ErrorMessage.setText("Incorrect User Name and Password.\n Attempts : "+ String.valueOf(counter));

           else if(!Name.equals(validName))
               ErrorMessage.setText("Incorrect User Name.\n Attempts : "+ String.valueOf(counter));

           else if(!Password.equals(validPassword))
               ErrorMessage.setText("Incorrect Password.\n Attempts : "+ String.valueOf(counter));
       }
       if(counter== 0){
           login_button.setEnabled(false);
           ErrorMessage.setText("You have been blocked for 24 Hours");
       }

   }

    public void onClick(View view) {
        String userName = user.getText().toString();
        String PASS = password.getText().toString();
        Validation(userName,PASS);
//
    }
}