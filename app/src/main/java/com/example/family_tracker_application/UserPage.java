package com.example.family_tracker_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class UserPage extends AppCompatActivity {

    GoogleSignInOptions gso;
    GoogleSignInClient mGoogleSignInClient;
    TextView name,email;
    ImageView userimage;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);
        name=findViewById(R.id.username);
        email=findViewById(R.id.useremail);
        userimage=findViewById(R.id.userimage);
        button=findViewById(R.id.button);



        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount acc= GoogleSignIn.getLastSignedInAccount(this);
        if (acc != null) {
            String Name= acc.getDisplayName();
            String Email= acc.getEmail();
            Uri image=acc.getPhotoUrl();
            name.setText(Name);
            email.setText(Email);
            Glide.with(this).load(String.valueOf(image)).into(userimage);
        }


        //Button Onclick for signout.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignOUt();
            }
        });
    }
    public  void SignOUt(){
        mGoogleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                finish();
                startActivity(new Intent(UserPage.this,MainActivity.class));

            }
        });
    }
}