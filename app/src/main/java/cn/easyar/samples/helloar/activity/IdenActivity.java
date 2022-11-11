//================================================================================================================================
//
// Copyright (c) 2015-2021 VisionStar Information Technology (Shanghai) Co., Ltd. All Rights Reserved.
// EasyAR is the registered trademark or trademark of VisionStar Information Technology (Shanghai) Co., Ltd in China
// and other countries for the augmented reality technology developed by VisionStar Information Technology (Shanghai) Co., Ltd.
//
//================================================================================================================================

package cn.easyar.samples.helloar.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

import cn.easyar.samples.helloar.ARActivity;
import cn.easyar.samples.helloar.Constants;
import cn.easyar.samples.helloar.R;

public class IdenActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Constants.b_status1 =0;
        setContentView(R.layout.iden_main);

        findViewById(R.id.button_start).setOnClickListener(new View.OnClickListener() {
            private long mLastClickTime = 0;
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                Log.e("jerry","IdenActivity");
                startActivity(new Intent(IdenActivity.this, ARActivity.class));
            }
        });
    }
}
