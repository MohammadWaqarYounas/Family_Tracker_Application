package com.example.family_tracker_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.family_tracker_application.Model.UserAccounts;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpPage extends AppCompatActivity {

    Button signup;
    EditText name,email,phone,password,repassword;
    FirebaseAuth FAuth;
    FirebaseDatabase MainRoot;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        signup=findViewById(R.id.createaccount);
        name=findViewById(R.id.EnterName);
        email=findViewById(R.id.EnterEmail);
        password=findViewById(R.id.EnterPassword);
        phone=findViewById(R.id.Mobile);
        repassword=findViewById(R.id.Repassword);
//        FAuth=FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Username= name.getText().toString();
                String Email= email.getText().toString();
                String Phone= phone.getText().toString();
                String Password= password.getText().toString();
                String Repass= repassword.getText().toString();

                if (TextUtils.isEmpty(Username)){
//                    name.setError("Name is mandatory");

                    Toast.makeText(SignUpPage.this, "Error in name", Toast.LENGTH_SHORT).show();return;
                }
                if (TextUtils.isEmpty(Email)) {
                    email.setError("Email is mandatory");
                    return;
                }
                if (TextUtils.isEmpty(Phone)){
                    phone.setError("Mobile no missing");
                    return;
                }
                if (TextUtils.isEmpty(Password)){
                    password.setError("Password is mandatory");
                    return;
                }
                if (TextUtils.isEmpty(Repass)){
                    password.setError("This field is mandatory");
                    return;
                }
                if (Repass!=Password){
                    repassword.setError("Password must be same");
                    return;
                }
                if(Password.length()<7){
                    Toast.makeText(SignUpPage.this, "Password must be 8 characters long", Toast.LENGTH_SHORT).show();
                    return;
                }

//                UserAccounts userAccounts= new UserAccounts(Username,Email,Phone,Password);
//                reference.child(Phone).setValue(userAccounts);
            }
        });
    }
}