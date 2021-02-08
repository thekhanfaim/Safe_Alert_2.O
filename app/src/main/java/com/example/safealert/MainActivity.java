package com.example.safealert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView scroll_Bar,T_C,txt_view;
    Button btn_NEXT;
    View line_View;
    CheckBox btn_checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scroll_Bar = (TextView) findViewById(R.id.scrollBar);
        T_C = (TextView) findViewById(R.id.TandC);
        String TermsAndConditions = "We are not responsible if information made available on this site is not accurate, complete or current. The material on this site is provided for general information only and should not be relied upon or used as the sole basis for making decisions without consulting primary, more accurate, more complete or more timely sources of information. Any reliance on the material on this site is at your own risk. This site may contain certain historical information. Historical information, necessarily, is not current and is provided for your reference only. We reserve the right to modify the contents of this site at any time, but we have no obligation to update any information on our site. You agree that it is your responsibility to monitor changes to our site.The failure of us to exercise or enforce any right or provision of these Terms of Service shall not constitute a waiver of such right or provision. These Terms of Service and any policies or operating rules posted by us on this site or in respect to The Service constitutes the entire agreement and understanding between you and us and govern your use of the Service, superseding any prior or contemporaneous agreements, communications and proposals, whether oral or written, between you and us (including, but not limited to, any prior versions of the Terms of Service). Any ambiguities in the interpretation of these Terms of Service shall not be construed against the drafting party.";

        scroll_Bar.setText(TermsAndConditions);

        scroll_Bar.setMovementMethod(new ScrollingMovementMethod());

        btn_NEXT = findViewById(R.id.btnNEXT);
        btn_checkBox = findViewById(R.id.btncheckBox);
        T_C = findViewById(R.id.TandC);

        btn_NEXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn_checkBox.isChecked())
                {
                    Intent intent = new Intent(MainActivity.this,validation.class);
                    startActivity(intent);
                }
                else
                {
                    //Toast.makeText(getApplicationContext(), "Please Accept the Terms and Conditions to Proceed Further", Toast.LENGTH_LONG).show();
                    openMyDialog();
                }
            }
        });
    }
    public void openMyDialog() {
        openMyDialog dbox = new openMyDialog();
        dbox.show(getSupportFragmentManager(),"My Dialog box");
    }
}