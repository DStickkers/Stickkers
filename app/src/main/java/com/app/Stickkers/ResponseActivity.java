package com.app.Stickkers;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.stickkers.ApiClient.ApiHelper;
import com.stickkers.ApiClient.StickkerListener;


public class ResponseActivity extends AppCompatActivity implements View.OnClickListener {
    private ApiHelper helper;
    TextView responseText;
    ProgressBar progressCircular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);

        helper = new ApiHelper(Constants.SDK_API_KEY);
        responseText = (TextView) findViewById(R.id.responseText);
        progressCircular =  findViewById(R.id.progress_circular);
        findViewById(R.id.buttonTrendingPack).setOnClickListener(this);
        findViewById(R.id.buttonSearchPack).setOnClickListener(this);
        findViewById(R.id.buttonTrendingSticker).setOnClickListener(this);
        findViewById(R.id.buttonSearchSticker).setOnClickListener(this);
        findViewById(R.id.backbtn).setOnClickListener(this);
    }

    private void searchStickerIcon(){
        progressCircular.setVisibility(View.VISIBLE);
        helper.searchStickerIcon("sticker", "ho" ,  new StickkerListener() {
            @Override
            public void success(Object response) {
                progressCircular.setVisibility(View.GONE);
                showToast(response.toString());
            }

            @Override
            public void error(String error) {
                progressCircular.setVisibility(View.GONE);
                showToast(error.toString());
            }

            @Override
            public void failure(String message) {
                progressCircular.setVisibility(View.GONE);
                showToast(message.toString());
            }
        });
    }


    private void searchpack(){
        progressCircular.setVisibility(View.VISIBLE);
        helper.searchpack("sticker", "ho" ,  new StickkerListener() {
            @Override
            public void success(Object response) {
                progressCircular.setVisibility(View.GONE);
                responseText.setText(response.toString());

            }

            @Override
            public void error(String error) {
                progressCircular.setVisibility(View.GONE);
                showToast(error.toString());
            }

            @Override
            public void failure(String message) {
                progressCircular.setVisibility(View.GONE);
                showToast(message.toString());
            }
        });
    }


    private void trendingPack(){
        progressCircular.setVisibility(View.VISIBLE);
        helper.trendingPack("sticker", "" ,  new StickkerListener() {
            @Override
            public void success(Object response) {
                progressCircular.setVisibility(View.GONE);
                responseText.setText(response.toString());
            }

            @Override
            public void error(String error) {
                progressCircular.setVisibility(View.GONE);
                showToast(error.toString());
            }

            @Override
            public void failure(String message) {
                progressCircular.setVisibility(View.GONE);
                showToast(message.toString());
            }
        });
    }


    private void trendingStickerIcon(){
        progressCircular.setVisibility(View.VISIBLE);
        helper.trendingStickerIcon("sticker", "" ,  new StickkerListener() {
            @Override
            public void success(Object response) {
                progressCircular.setVisibility(View.GONE);
                responseText.setText(response.toString());
            }

            @Override
            public void error(String error) {
                progressCircular.setVisibility(View.GONE);
                showToast(error.toString());
            }

            @Override
            public void failure(String message) {
                progressCircular.setVisibility(View.GONE);
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