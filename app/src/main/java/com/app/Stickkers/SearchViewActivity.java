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
import com.stickkers.Interfaces.StickkerCallback;
import com.stickkers.SearchSticker.SearchStickkerView;
import com.stickkers.Views.StickkerView;


public class SearchViewActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton uploadStikerBtn;
    SimpleDraweeView draweeView;
    StickkerView giphy;
    EditText msgEdit ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);

        draweeView = findViewById(R.id.gifpreview);
        uploadStikerBtn = findViewById(R.id.upload_stiker_btn);
        msgEdit = findViewById(R.id.msgEdit);
        giphy = findViewById(R.id.giphy);
        SearchStickkerView searchStickerView = findViewById(R.id.searchStickkerView);

        giphy.initialize(SearchViewActivity.this, Constants.SDK_API_KEY);
        giphy.setSdkView(giphy,searchStickerView, uploadStikerBtn , msgEdit);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);
        giphy.setSelectedCallback(new StickkerCallback() {
            @Override
            public void onGifSelected(String uri) {
                Log.d("qboard_", "image uri at activity: " + uri.toString());
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