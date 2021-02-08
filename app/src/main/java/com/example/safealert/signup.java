package com.example.safealert;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signup extends AppCompatActivity {

    Button btn_login,btn_signup,reset_Pass;
    ProgressDialog PD;
    EditText e_mail,p_asswprd,cnfrm_password;
    String se_mail,sp_assword,scnfrm_password;

    //    SessionManager sessionManager;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        btn_login = findViewById(R.id.btnLogin);
        e_mail = findViewById(R.id.email);
        p_asswprd = findViewById(R.id.password);
        cnfrm_password = findViewById(R.id.cnfrmPassword);
        btn_signup = findViewById(R.id.btnSignup);
        reset_Pass = findViewById(R.id.resetPass);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                se_mail = e_mail.getText().toString();
                sp_assword = p_asswprd.getText().toString();
                scnfrm_password = cnfrm_password.getText().toString();
                if(se_mail.isEmpty()) {
                    openDialog();
                } else if(!se_mail.matches(emailPattern)) {
                    dialog1();
                } else if(sp_assword.isEmpty()){
                    dialog2();
                } else if(sp_assword.length() < 8) {
                    dialog3();
                } else if(!scnfrm_password.equals(sp_assword)) {
                    dialog4();
                } else {
//                    sessionManager.setLogin(true);
//
//                    sessionManager.setEmail(se_mail);
//
//                    sleepMethod();
                    PD = new ProgressDialog(signup.this);

                    PD.show();

                    PD.setContentView(R.layout.progress);

                    PD.getWindow().setBackgroundDrawableResource(
                            android.R.color.transparent
                    );

                    Thread timer = new Thread() {
                        @Override
                        public void run() {
                            try {
                                sleep(5000);
                                Intent loc = new Intent(signup.this,fetchLocation.class);
                                startActivity(loc);
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

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intnt = new Intent(signup.this,validation.class);
                startActivity(intnt);
            }
        });

        reset_Pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resetPass = new Intent(signup.this,resetPassword.class);
                startActivity(resetPass);
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
    public void dialog4() {
        dialogbox4 db4 = new dialogbox4();
        db4.show(getSupportFragmentManager(),"Dialog Box 4");
    }
//    private void sleepMethod() {
//
//    }
    // class.forName(

//    static {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        }
//        Connection conn= null;
//        try {
//            conn = getConnection("jdbc:mysql://localhost:3306/alertsystem","root","");
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        String query = "select * from point";
//        Statement st = null;
//        try {
//            st = conn.createStatement();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        try {
//            st.execute(query);
//            System.out.println("selected successfully");
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
//
//    }
}