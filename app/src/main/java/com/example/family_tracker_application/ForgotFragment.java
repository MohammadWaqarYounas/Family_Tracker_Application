package com.example.family_tracker_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.family_tracker_application.ForgotPasswordScreens.ForgotPasswordScreen;
import com.example.family_tracker_application.ForgotPasswordScreens.ForgotProgressScreen;
import com.example.family_tracker_application.ForgotPasswordScreens.ForgotProgressStageOne;

public class ForgotFragment extends AppCompatActivity {

    Button button;
    int position=0;
    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_fragment);
        button=findViewById(R.id.button);

        //Loading First fragment on beginning.............................
        ForgotPasswordScreen fs= new ForgotPasswordScreen();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.forgotpasswordfragment, fs);
        ft.commit();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position){
                    case 0:
//                    ForgotProgressScreen fp= new ForgotProgressScreen();
//                    ft.replace(R.id.forgotpasswordfragment, fp);
//                    ft.commit();
                    button.setText("Sign In");
                    position=1;
                    break;
                    case 1:
//                        ForgotProgressStageOne f1= new ForgotProgressStageOne();
//                        ft.replace(R.id.forgotpasswordfragment, f1);
//                        ft.commit();
                        position=2;
                        button.setText("Continue");
                        break;
                }

            }
        });
    }
}