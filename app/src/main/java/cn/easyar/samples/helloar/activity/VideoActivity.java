package cn.easyar.samples.helloar.activity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.VideoView;

import java.util.Timer;

import androidx.appcompat.app.AppCompatActivity;
import cn.easyar.samples.helloar.R;

public class VideoActivity extends AppCompatActivity {
    private static final String TAG = "VideoActivity";
    public static final int PROGRESSINDEX = 1;
    public static final int ENDINDEX = 2;
    private Timer timer;
    private SeekBar progress;
    private VideoView screen;
    private int length=0;

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏顶部状态栏
        hideNavigationBar();//隐藏底部导航栏
        videoView = (VideoView) findViewById(R.id.videoView);
        videoView.setMediaController(new MediaController(this));
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        videoView.setVideoURI(uri);
        videoView.start();

    }

    public void hideNavigationBar()
    {
        int uiFlags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                | View.SYSTEM_UI_FLAG_FULLSCREEN; // hide status bar

        if( android.os.Build.VERSION.SDK_INT >= 19 ){
            uiFlags |= 0x00001000;  //SYSTEM_UI_FLAG_IMMERSIVE_STICKY: hide navigation bars - compatibility: building API level is lower thatn 19, use magic number directly for higher API target level
        } else {
            uiFlags |= View.SYSTEM_UI_FLAG_LOW_PROFILE;
        }
        getWindow().getDecorView().setSystemUiVisibility(uiFlags);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if( hasFocus ) {
            hideNavigationBar();
        }
    }
}