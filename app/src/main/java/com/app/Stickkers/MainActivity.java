package com.app.Stickkers;


import static com.stickkers.Views.ImagePipelineConfigUtils.getDefaultImagePipelineConfig;

import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.drawee.backends.pipeline.Fresco;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(MainActivity.this);

        UiModeManager uiManager = (UiModeManager) getSystemService(Context.UI_MODE_SERVICE);

        if (Build.VERSION.SDK_INT <= 22) {
            uiManager.enableCarMode(0);
        }

        uiManager.setNightMode(UiModeManager.MODE_NIGHT_NO);

        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Fresco.initialize(this, getDefaultImagePipelineConfig(this));
        }



        findViewById(R.id.buttonResponse).setOnClickListener(this);
        findViewById(R.id.buttonStickerView).setOnClickListener(this);
        findViewById(R.id.buttonSearchView).setOnClickListener(this);
        findViewById(R.id.buttonBottomSheetView).setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonResponse:
                    startActivity(new Intent(MainActivity.this, ResponseActivity.class ));
                break;

            case R.id.buttonStickerView:
                startActivity(new Intent(MainActivity.this, StickerViewActivity.class ));
                break;

            case R.id.buttonSearchView:
                startActivity(new Intent(MainActivity.this, SearchViewActivity.class ));
                break;

            case R.id.buttonBottomSheetView:
                startActivity(new Intent(MainActivity.this, BottomSheetGiphView.class ));
                break;

            default:
                break;
        }


    }
}