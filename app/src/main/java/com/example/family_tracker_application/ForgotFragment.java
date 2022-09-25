package com.example.family_tracker_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.family_tracker_application.ForgotPasswordScreens.ForgotPasswordScreen;
import com.example.family_tracker_application.ForgotPasswordScreens.ForgotProgressScreen;
import com.example.family_tracker_application.ForgotPasswordScreens.ForgotProgressStageFour;
import com.example.family_tracker_application.ForgotPasswordScreens.ForgotProgressStageOne;
import com.example.family_tracker_application.ForgotPasswordScreens.ForgotProgressStageThree;
import com.example.family_tracker_application.ForgotPasswordScreens.ForgotProgressStageTwo;

public class ForgotFragment extends AppCompatActivity {

    Button button;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_fragment);
        button = findViewById(R.id.button);

        ForgotPasswordScreen fps= new ForgotPasswordScreen();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.forgotpasswordfragment, fps);
        ft.commit();
        //Loading First fragment on beginning.............................
//        ForgotPasswordScreen fs = new ForgotPasswordScreen();
//        ft.replace(R.id.forgotpasswordfragment, fs);
//        ft.commit();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position) {
                    case 0:
                    /*//                    FragmentManager fragmentManager = getSupportFragmentManager();
//                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                        ForgotProgressScreen fp = new ForgotProgressScreen();
                        ft.replace(R.id.forgotpasswordfragment, fp);
                        ft.commit();*/
                        gotoFragment(new ForgotProgressScreen());
                        button.setText("Sign In");
                        position = 1;
                        break;
                    case 1:
                     /*   ForgotProgressStageOne f1 = new ForgotProgressStageOne();
                        ft.replace(R.id.forgotpasswordfragment, f1);
                        ft.commit();*/
                        gotoFragment(new ForgotProgressStageOne());
                        position = 2;
                        button.setText("Continue");
                        break;
                    case 2:
                        gotoFragment(new ForgotProgressStageTwo());
                        position=3;
                        button.setText("Continue");
                        break;
                    case 3:
                        gotoFragment(new ForgotProgressStageThree());
                        position=4;
                        button.setText("Continue");
                        break;
                    case 4:
                        gotoFragment(new ForgotProgressStageFour());
                        position=5;
                        button.setText("Get Started");
                        break;
                    case 5:
                        Intent intent = new Intent(ForgotFragment.this,MainActivity.class);
                        startActivity(intent);
                        position=0;
                        break;
                }
            }
        });
    }
    private void gotoFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.forgotpasswordfragment, fragment).addToBackStack(null);
        transaction.commit();
    }
}