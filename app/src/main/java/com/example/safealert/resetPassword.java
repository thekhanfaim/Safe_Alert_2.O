package com.example.safealert;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class resetPassword extends AppCompatActivity {

    Button btn_reset;
    EditText enter_email;
    String myEmailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String my_Email;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        btn_reset = (Button) findViewById(R.id.btnResetPassword);
        enter_email = (EditText)findViewById(R.id.enterEmail);

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                my_Email = enter_email.getText().toString();
                if(my_Email.isEmpty()) {
                    openDialog();
                }
                else if(!my_Email.matches(myEmailPattern)) {
                    dialog1();
                }
                else if(counter == 0) {
                    Random r = new Random();
                    int a = r.nextInt(999999);
                    String s = String.format("%06d",a);
                    TextView tx = (TextView)findViewById(R.id.myPassword);
                    tx.setText(s);
                    counter = 1;
                }
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
}