package com.eatl.dmrd.disastermanagement;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.eatl.dmrd.disastermanagement.R;

public class SplashScreenActivity extends Activity {


    ImageView mImageView;

    private static int SPLASH_TIME_OUT = 2000;
    private Handler myHandler = new Handler();
    private Runnable runnable = new Runnable() {

        public void run() {
            Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        mImageView = (ImageView) findViewById(R.id.imageView1);
    }
    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onResume() {
        myHandler.postDelayed(runnable, SPLASH_TIME_OUT);
        super.onResume();
    }

    @Override
    protected void onPause() {
        myHandler.removeCallbacks(runnable);
        super.onPause();
    }

}
