package com.example.android.androidvrview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gjiazhe.panoramaimageview.GyroscopeObserver;
import com.gjiazhe.panoramaimageview.PanoramaImageView;

public class MainActivity extends AppCompatActivity {

    private GyroscopeObserver gyroscopeObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gyroscopeObserver = new GyroscopeObserver();
        gyroscopeObserver.setMaxRotateRadian(Math.PI/9);

        PanoramaImageView panoramaImageView = (PanoramaImageView)findViewById(R.id.paronama_view);
        panoramaImageView.setGyroscopeObserver(gyroscopeObserver);
    }

    protected void onResume(){
        super.onResume();
        gyroscopeObserver.register(this);
    }


    protected void onPause(){
        super.onPause();
        gyroscopeObserver.unregister();
    }
}
