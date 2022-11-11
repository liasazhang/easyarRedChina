package cn.easyar.samples.helloar.game;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import androidx.appcompat.app.AppCompatActivity;
import cn.easyar.samples.helloar.R;

public class GameActivity extends AppCompatActivity {
    int i = -1;
    int[] image = {
            R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,R.drawable.p6,R.drawable.p7, R.drawable.p8,R.drawable.p9,
            R.drawable.p10,R.drawable.p10,R.drawable.p11,R.drawable.p12,R.drawable.p13,R.drawable.p14,R.drawable.p15,R.drawable.p16,R.drawable.p17,
            R.drawable.p18,R.drawable.p19,R.drawable.p20,R.drawable.p21,R.drawable.p22,R.drawable.p23,R.drawable.p24,R.drawable.p25,R.drawable.p26,
            R.drawable.p27,R.drawable.p28,R.drawable.p29,R.drawable.p30,R.drawable.p31,R.drawable.p32,R.drawable.p33,R.drawable.p34,R.drawable.p35,
            R.drawable.p36,R.drawable.p37,R.drawable.p38,R.drawable.p39,R.drawable.p40,R.drawable.p41,R.drawable.p42,R.drawable.p43,R.drawable.p44,
            R.drawable.p45,R.drawable.p46,R.drawable.p47,R.drawable.p48,R.drawable.p49,R.drawable.p50,R.drawable.p51,R.drawable.p52,R.drawable.p53,
            R.drawable.p54,R.drawable.p55,R.drawable.p56,R.drawable.p57,R.drawable.p58,R.drawable.p59,R.drawable.p60,R.drawable.p61,R.drawable.p62,

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏顶部状态栏
        hideNavigationBar();//隐藏底部导航栏
        Animation inAnimation = AnimationUtils.loadAnimation(this, R.anim.in);
        Animation outAnimation = AnimationUtils.loadAnimation(this, R.anim.out);//动画对象实例化
        final ImageButton backgroundbutton = findViewById(R.id.btn);//实例化
        final ImageButton backbutton = findViewById(R.id.btn1);//实例化
//        Animation myAnimation_Alpha=new AlphaAnimation(0.1f, 1.0f);
//        LottieAnimationView gif= findViewById(R.id.animation_view);
//        gif.setAnimation("changcheng.json");
//        gif.setImageAssetsFolder("images/");
//        gif.setRepeatCount(-1);
//        gif.playAnimation();  //这里是JSon动画的实现，但是出现图层不能渲染的问题

        //创建点击事件
        backgroundbutton.setOnClickListener(view -> {
            i++;

            backgroundbutton.startAnimation(inAnimation);//这里是图片转场动画 渐黒
            backgroundbutton.setBackgroundResource(image[i]);//切换图片
            if(i == 62)
                i = -1;

        });
        backbutton.setOnClickListener(view -> {
            i--;

            backgroundbutton.startAnimation(inAnimation);//这里是图片转场动画 渐黒
            backgroundbutton.setBackgroundResource(image[i]);//切换图片
            if(i == 0){
                i = 1;
                Toast.makeText(this, "这已经是第一张了", Toast.LENGTH_SHORT).show();
            }


        });

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            exitBy2Click(); //调用双击退出函数
        }
        return false;
    }
    /**
     * 双击退出函数
     */
    private static Boolean isExit = false;

    private void exitBy2Click() {
        Timer tExit = null;
        if (isExit == false) {
            isExit = true; // 准备退出
            Toast.makeText(this, "再按一次返回菜单", Toast.LENGTH_SHORT).show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false; // 取消退出
                }
            }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务

        } else {
            finish();
            System.exit(0);
        }
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