package com.example.safealert;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class validation extends AppCompatActivity {
    Button btn_login,btn_signup,btn_Pass;
    ProgressDialog PD;
    EditText e_mail,p_asswprd;
    String se_mail,sp_assword;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation);
        btn_login = findViewById(R.id.btnLogin);
        e_mail = findViewById(R.id.email);
        p_asswprd = findViewById(R.id.password);
        btn_signup = findViewById(R.id.btnSignup);
        btn_Pass = findViewById(R.id.btnValPass);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                se_mail = e_mail.getText().toString();
                sp_assword = p_asswprd.getText().toString();
                if(se_mail.isEmpty()) {
                    openDialog();
                } else if(!se_mail.matches(emailPattern)) {
                    dialog1();
                } else if(sp_assword.isEmpty()){
                    dialog2();
                } else if(sp_assword.length() < 8) {
                    dialog3();
                } else {
//                    sessionManager.setLogin(true);
//
//                    sessionManager.setEmail(se_mail);

//                    sleepMethod();

                    PD = new ProgressDialog(validation.this);

                    PD.show();

                    PD.setContentView(R.layout.progress);

                    PD.getWindow().setBackgroundDrawableResource(
                            android.R.color.transparent
                    );

                    Thread timer = new Thread() {
                        @Override
                        public void run() {
                            try {
                                sleep(2000);
                                Intent i = new Intent(validation.this,fetchLocation.class);
                                startActivity(i);
                                PD.dismiss();
                                finish();
                                super.run();
                            } catch(Exception e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    timer.start();
                }
            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(validation.this,signup.class);
                startActivity(in);
            }
        });

        btn_Pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent valPass = new Intent(validation.this,resetPassword.class);
                startActivity(valPass);
            }
        });
    }
    public void openDialog() {
        dialogbox db = new dialogbox();
        db.show(getSupportFragmentManager(),"Dialog Box");
    }
    public void dialog1() {
        dialogbox1 db1 = new dialogbox1();
        db1.show(getSupportFragmentManager(),"Dialog Box 1");
    }
    public void dialog2() {
        dialogbox2 db2 = new dialogbox2();
        db2.show(getSupportFragmentManager(),"Dialog Box 2");
    }
    public void dialog3() {
        dialogbox3 db3 = new dialogbox3();
        db3.show(getSupportFragmentManager(),"Dialog Box 3");
    }
//    private void sleepMethod() {
//
//    }
}