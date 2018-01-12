package com.example.micha.camerapersoninterest;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.micha.camerapersoninterest.utils.Constants;

import java.io.IOException;
import java.net.URI;

public class CameraActivity extends AppCompatActivity {

    private static final String TAG = CameraActivity.class.getSimpleName();
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        image = findViewById(R.id.image);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},Constants.REQUESTS.CAMERA_REQUEST);
    }

    public void takePicture(View view) {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, Constants.REQUESTS.CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case Constants.REQUESTS.CAMERA_REQUEST:
                if(resultCode == RESULT_OK){
                    Bitmap pic = (Bitmap) data.getExtras().get("data");
                    image.setImageBitmap(pic);
                }
                break;
        }
    }
}
