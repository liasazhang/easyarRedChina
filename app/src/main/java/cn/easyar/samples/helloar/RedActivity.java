package cn.easyar.samples.helloar;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class RedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_famous_people_show);
        Constants.flag = 0;
        Log.e("jerry","RedActivity");
    }
}