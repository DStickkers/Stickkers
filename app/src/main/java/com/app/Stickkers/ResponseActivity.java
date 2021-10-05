package com.app.Stickkers;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.qboxus.qkeyboard.GPhApiClient.GiphyApiHelper;
import com.qboxus.qkeyboard.GPhApiClient.ApiListener;

public class ResponseActivity extends AppCompatActivity implements View.OnClickListener {
    private GiphyApiHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);

        helper = new GiphyApiHelper(Constants.SDK_API_KEY);

        findViewById(R.id.buttonTrendingPack).setOnClickListener(this);
        findViewById(R.id.buttonSearchPack).setOnClickListener(this);
        findViewById(R.id.buttonTrendingSticker).setOnClickListener(this);
        findViewById(R.id.buttonSearchSticker).setOnClickListener(this);
        findViewById(R.id.backbtn).setOnClickListener(this);
    }

    private void searchStickerIcon(){
        helper.searchStickerIcon("sticker", "ho" ,  new ApiListener() {
            @Override
            public void success(Object response) {
                showToast(response.toString());
            }

            @Override
            public void error(String error) {
                showToast(error.toString());
            }

            @Override
            public void failure(String message) {
                showToast(message.toString());
            }
        });
    }


    private void searchpack(){
        helper.searchpack("sticker", "ho" ,  new ApiListener() {
            @Override
            public void success(Object response) {
                showToast(response.toString());
            }

            @Override
            public void error(String error) {
                showToast(error.toString());
            }

            @Override
            public void failure(String message) {
                showToast(message.toString());
            }
        });
    }


    private void trendingPack(){
        helper.trendingPack("sticker", "" ,  new ApiListener() {
            @Override
            public void success(Object response) {
                showToast(response.toString());
            }

            @Override
            public void error(String error) {
                showToast(error.toString());
            }

            @Override
            public void failure(String message) {
                showToast(message.toString());
            }
        });
    }


    private void trendingStickerIcon(){
        helper.trendingStickerIcon("sticker", "" ,  new ApiListener() {
            @Override
            public void success(Object response) {
                showToast(response.toString());
            }

            @Override
            public void error(String error) {
                showToast(error.toString());
            }

            @Override
            public void failure(String message) {
                showToast(message.toString());
            }
        });
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonTrendingPack:
                trendingPack();
                break;

            case R.id.buttonSearchPack:
                searchpack();
                break;

            case R.id.buttonTrendingSticker:
                trendingStickerIcon();
                break;

            case R.id.buttonSearchSticker:
                searchStickerIcon();
                break;

            case R.id.backbtn:
                onBackPressed();
                break;

            default:
                break;
        }


    }

    private  void showToast(String message){
        Toast.makeText(ResponseActivity.this, ""+message, Toast.LENGTH_SHORT).show();
    }

}