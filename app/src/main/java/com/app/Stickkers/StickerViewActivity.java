package com.app.Stickkers;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.app.Stickkers.Utils.Functions;
import com.facebook.drawee.view.SimpleDraweeView;
import com.qboxus.qkeyboard.GiphyNew.GiphyView;
import com.qboxus.qkeyboard.Interfaces.GifSelectedCallback;

public class StickerViewActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton uploadStikerBtn;
    SimpleDraweeView draweeView;
    GiphyView giphy;
    EditText msgEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sticker_view);

        draweeView = findViewById(R.id.gifpreview);
        uploadStikerBtn = findViewById(R.id.upload_stiker_btn);
        msgEdit = findViewById(R.id.msgEdit);

        giphy = findViewById(R.id.giphy);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);
        giphy.initialize(StickerViewActivity.this, Constants.SDK_API_KEY);

        giphy.setSdkView(giphy, uploadStikerBtn, msgEdit);

        giphy.setSelectedCallback(new GifSelectedCallback() {
            @Override
            public void onGifSelected(String uri) {
                Log.d("stickkers_", "image uri at activity: " + uri.toString());
                Functions.showStickerFresco(uri, draweeView);
            }
        });
        findViewById(R.id.backbtn).setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        if (giphy.getVisibility() == View.VISIBLE) {
            giphy.setCallback();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backbtn:
                onBackPressed();
                break;

            default:
                break;

        }
    }

}