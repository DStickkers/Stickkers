package com.app.Stickkers;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.app.Stickkers.Utils.Functions;
import com.facebook.drawee.view.SimpleDraweeView;
import com.stickkers.Interfaces.StickkerCallback;
import com.stickkers.Views.StickkerBottomSheet;

public class BottomSheetGiphView extends AppCompatActivity implements View.OnClickListener {
    ImageButton uploadStikerBtn;
    SimpleDraweeView draweeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet_giph_view);

        draweeView = findViewById(R.id.gifpreview);
        uploadStikerBtn = findViewById(R.id.upload_stiker_btn);
        uploadStikerBtn.setOnClickListener(this::onClick);

        findViewById(R.id.backbtn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.upload_stiker_btn:
                StickkerBottomSheet stickyBottomSheet = StickkerBottomSheet.newInstance(new StickkerCallback() {
                    @Override
                    public void onGifSelected(String uri) {
                        Functions.showStickerFresco(uri, draweeView);
                    }
                }, Constants.SDK_API_KEY);

                if (!stickyBottomSheet.isAdded())
                    stickyBottomSheet.show(getSupportFragmentManager(), "StickyBottomSheet");

                break;

            case R.id.backbtn:
                onBackPressed();
                break;

            default:
                break;

        }
    }
}