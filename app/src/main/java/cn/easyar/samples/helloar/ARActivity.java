//================================================================================================================================
//
// Copyright (c) 2015-2021 VisionStar Information Technology (Shanghai) Co., Ltd. All Rights Reserved.
// EasyAR is the registered trademark or trademark of VisionStar Information Technology (Shanghai) Co., Ltd in China
// and other countries for the augmented reality technology developed by VisionStar Information Technology (Shanghai) Co., Ltd.
//
//================================================================================================================================

package cn.easyar.samples.helloar;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.graphics.PixelFormat;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.threed.jpct.Object3D;

import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;
import cn.easyar.CameraDevice;
import cn.easyar.Engine;
import cn.easyar.ImageTracker;

public class ARActivity extends AppCompatActivity
{
    public final static int MSG_LOAD_MODEL_SUC=0;


    private GLSurfaceView myGLView;
    private RenderView myRenderer;
    private Button btnLoad;
    private Button btnLeft;
    private Button btnRight;
    private Button btnTop;
    private Button btnDown;

    private Thread threadLoadModel;
    public static Handler handler;
    /*
    * Steps to create the key for this sample:
    *  1. login www.easyar.com
    *  2. create app with
    *      Name: HelloAR
    *      Package Name: cn.easyar.samples.helloar
    *  3. find the created item in the list and show key
    *  4. set key string bellow
    */
    private static String key = "7psyd+qIKmvy7lW7dnrGUuWwwoc/XykLwLAaDN6pBFzquQJB3rQVDJH4UBab7lgck+1THJiaUBiY9AJBxvhNDMa7ElrOqCpL0pMFDJHrTQzHswJLxakEXYngOlWJuBRAz7YEZ8+pQxTwh00M3bsTR8q0FV2J4DoMyLUMQ960CFrS+DwCiaoNT9+8DlzGqUMU8PgWR8W+DlnY+E0MxrsCDPb2Q0PEvhRCzqlDFPD4EkvFqQQA4rcASc6OE0/IsQhAzPhNDNi/D13O9CJCxK8FfM65DknFsxVHxLRDAompBEDYv098zrkOXM+zD0mJ9kNdzrQSS4WVA0TOuRV62bsCRcK0BgyH+BJLxakEAPivE0jKuQR62bsCRcK0BgyH+BJLxakEAPiqAFzYvzJeyq4IT8eXAF6J9kNdzrQSS4WXDlrCtQ962bsCRcK0BgyH+BJLxakEAO+/D13OiRFP37MAQua7EQyH+BJLxakEAOibJXrZuwJFwrQGDPb2Q0vTqghczo4IQ86JFU/GqkMUxa8NQof4CF3ntQJPx/hbSMq2EkvW9hoMya8PSse/KErY+Ft1ibkPAM67ElfKqE9dyrcRQs6pT0bOtg1ByqhDc4f4F0/ZswBA36lDFPD4AkHGtxRAwq4YDPb2Q17HuxVIxKgMXYngOgzKtAVcxLMFDPb2Q0PEvhRCzqlDFPD4EkvFqQQA4rcASc6OE0/IsQhAzPhNDNi/D13O9CJCxK8FfM65DknFsxVHxLRDAompBEDYv098zrkOXM+zD0mJ9kNdzrQSS4WVA0TOuRV62bsCRcK0BgyH+BJLxakEAPivE0jKuQR62bsCRcK0BgyH+BJLxakEAPiqAFzYvzJeyq4IT8eXAF6J9kNdzrQSS4WXDlrCtQ962bsCRcK0BgyH+BJLxakEAO+/D13OiRFP37MAQua7EQyH+BJLxakEAOibJXrZuwJFwrQGDPb2Q0vTqghczo4IQ86JFU/GqkMUxa8NQof4CF3ntQJPx/hbSMq2EkvW9hoMya8PSse/KErY+Ft1ifg8AomsAFzCuw9a2PhbdYm5DkPGrw9H36NDc4f4EULKrgdB2bcSDJGBQ0fEqUNzh/gMQc+vDUvY+Ft1iakEQNi/T2fGuwZL/6gATcCzD0mJ9kNdzrQSS4WZDUHevjNLyLUGQMKuCEHF+E0M2L8PXc70M0vItRNKwrQGDIf4EkvFqQQA5LgLS8iuNVzKuQpHxb1DAompBEDYv0993qgHT8i/NVzKuQpHxb1DAompBEDYv09927sTXc6JEU/fswBC5rsRDIf4EkvFqQQA5rUVR8S0NVzKuQpHxb1DAompBEDYv09qzrQSS/iqAFrCuw1jyqpDAompBEDYv09t6p41XMq5CkfFvUNzh/gEVtuzE0v/swxL+K4AQ9v4W0Detg0CibMSYsS5AEKJ4AdPx6kEU/anA2WhyeDKlrBHIFIvtdlqPfYtsIVCkdHv5VZOrBBc75nf3SisnHVZO23HvYOLjL1QwSz1lHFMQ0uCn4PUNuYkOc2dzw/TevrTM++KhWoFTmykeaijMR6rHmPaKlY+tg4Qf8Y9jxAGVcMeIHYwqIaeeE8SJW6fOuZ7Fs2Xmqr6XsG/PIO90bbjaP9PaCTu3YIPv/U278HjqWdOM8YiTK5tLrak3pyGQ/yQT6x645nQE5MQOPTivymWtaJEMEFXMSneiPLjeZ3YgHN1H4I3A1EYM7voT878SLaUSd5St68gUIG8t/B6ShPfgwyEraFfSRVeITQbHynqXLCy5MOjq9phLg==";
    private GLView glView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {   Constants.flag = 0;
        Constants.b_status1 =0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        Log.e("ARActivity","ARActivity");
//        if(Constants.b_status1 == 1){
//            bottom_init();
//        }
        if (!Engine.initialize(this, key)) {
            Log.e("HelloAR", "Initialization Failed.");
            Toast.makeText(ARActivity.this, Engine.errorMessage(), Toast.LENGTH_LONG).show();
            return;
        }
        if (!CameraDevice.isAvailable()) {
            Toast.makeText(ARActivity.this, "CameraDevice not available.", Toast.LENGTH_LONG).show();
            return;
        }
        if (!ImageTracker.isAvailable()) {
            Toast.makeText(ARActivity.this, "ImageTracker not available.", Toast.LENGTH_LONG).show();
            return;
        }

        glView = new GLView(this);

        requestCameraPermission(new PermissionCallback() {
            @Override
            public void onSuccess() {
                ((ViewGroup) findViewById(R.id.preview)).addView(glView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            }

            @Override
            public void onFailure() {
            }
        });
        View ar_top = (View) findViewById(R.id.ar_top);
        ar_top.findViewById(R.id.imageBack).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Constants.b_status1 = 0;
                Log.e("return","MainActivity");
                finish();

            }
        });

    }

    private interface PermissionCallback
    {
        void onSuccess();
        void onFailure();
    }
    private HashMap<Integer, PermissionCallback> permissionCallbacks = new HashMap<Integer, PermissionCallback>();
    private int permissionRequestCodeSerial = 0;
    @TargetApi(23)
    private void requestCameraPermission(PermissionCallback callback)
    {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                int requestCode = permissionRequestCodeSerial;
                permissionRequestCodeSerial += 1;
                permissionCallbacks.put(requestCode, callback);
                requestPermissions(new String[]{Manifest.permission.CAMERA}, requestCode);
            } else {
                callback.onSuccess();
            }
        } else {
            callback.onSuccess();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
    {
        if (permissionCallbacks.containsKey(requestCode)) {
            PermissionCallback callback = permissionCallbacks.get(requestCode);
            permissionCallbacks.remove(requestCode);
            boolean executed = false;
            for (int result : grantResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    executed = true;
                    callback.onFailure();
                }
            }
            if (!executed) {
                callback.onSuccess();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        if (glView != null) { glView.onResume(); }
    }

    @Override
    protected void onPause()
    {
        if (glView != null) { glView.onPause(); }
        super.onPause();
    }

    //成功后调用此函数，弹出对应框
    protected void bottom_init(){
        handler=new Handler(){
            @Override
            public void handleMessage(Message msg){
                switch (msg.what){
                    case MSG_LOAD_MODEL_SUC:
                        Toast.makeText(ARActivity.this, "模型加载成功", Toast.LENGTH_SHORT).show();
                        Object3D object3D=(Object3D) msg.obj;
                        myRenderer.myWorld.addObject(object3D);
                        break;
                }
            }
        };
        Toast.makeText(ARActivity.this, "开始加载模型", Toast.LENGTH_SHORT).show();
        threadLoadModel.start();
        myGLView = (GLSurfaceView) this.findViewById(R.id.surfaceView);
        myGLView.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        myGLView.getHolder().setFormat(PixelFormat.TRANSLUCENT);
        myGLView.setZOrderOnTop(true);
        myRenderer = new RenderView(this);
        myGLView.setRenderer(myRenderer);

        threadLoadModel=new Thread(new Runnable() {
            @Override
            public void run() {
                myRenderer.addObject(ARActivity.this);
            }
        });

    }
}
