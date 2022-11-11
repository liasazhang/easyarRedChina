package cn.easyar.samples.helloar.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.easyar.samples.helloar.R;

public class MainActivity extends FragmentActivity {
    private Activity mContext;
    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;
    private RadioButton tab1,tab2,tab3,tab4;  //四个单选按钮
    private List<View> mViews;   //存放视图

    private Intent intent;

    @BindView(R.id.btn_one)
    RadioButton btn_one;
    @BindView(R.id.btn_two)
    RadioButton btn_two;
    @BindView(R.id.btn_three)
    RadioButton btn_three;
    @BindView(R.id.btn_four)
    RadioButton btn_four;

    private ViewPager mviewPager;
    private RadioGroup rg;
    private RadioButton rone,rtwo,rthree,rfour;
    private List<Fragment> list;
    private OneFragment one;
    private TwoFragment two;
    private ThreeFragment three;
    private cn.easyar.samples.helloar.activity.FouthFragment four;
    private MyFragmentAdapter myFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        final Drawable d_home = getResources().getDrawable(R.drawable.home_drawable);
        final Drawable d_social = getResources().getDrawable(R.drawable.social_drawable);
        final Drawable d_phouse = getResources().getDrawable(R.drawable.phouse_drawable);
        final Drawable d_me = getResources().getDrawable(R.drawable.me);


        btn_one.setBackground(d_home);
        btn_two.setBackground(d_social);
        btn_three.setBackground(d_phouse);
        btn_four.setBackground(d_me);

        btn_one.setChecked(true);
        btn_two.setChecked(false);
        btn_three.setChecked(false);
        btn_four.setChecked(false);

        mviewPager = (ViewPager) findViewById(R.id.viewpager);
        rone = (RadioButton) findViewById(R.id.btn_one);
        rtwo = (RadioButton) findViewById(R.id.btn_two);
        rthree = (RadioButton) findViewById(R.id.btn_three);
        rfour = (RadioButton) findViewById(R.id.btn_four);
        rg = (RadioGroup) findViewById(R.id.rg_menu);

        list = new ArrayList<Fragment>();
        one = new OneFragment();
        two = new TwoFragment();
        three = new ThreeFragment();
        four = new FouthFragment();
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        //显示fragment界面
        FragmentManager fm = getSupportFragmentManager();
        //初始化自定义适配器
        myFragmentAdapter =  new MyFragmentAdapter(fm,list);
        mviewPager.setAdapter(myFragmentAdapter);
        //viewPager的滑动
        mviewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btn_one:
                        //给ViewPager设置当前布局

                        btn_one.setChecked(true);
                        btn_two.setChecked(false);
                        btn_three.setChecked(false);
                        btn_four.setChecked(false);
                        mviewPager.setCurrentItem(0);
                    case R.id.btn_two:
                        //给ViewPager设置当前布局
                        btn_one.setChecked(false);
                        btn_two.setChecked(true);
                        btn_three.setChecked(false);
                        btn_four.setChecked(false);
                        mviewPager.setCurrentItem(1);
                    case R.id.btn_three:
                        //给ViewPager设置当前布局
                        btn_one.setChecked(false);
                        btn_two.setChecked(false);
                        btn_three.setChecked(true);
                        btn_four.setChecked(false);
                        mviewPager.setCurrentItem(2);
                    case R.id.btn_four:
                        //给ViewPager设置当前布局
                        btn_one.setChecked(false);
                        btn_two.setChecked(false);
                        btn_three.setChecked(false);
                        btn_four.setChecked(true);
                        mviewPager.setCurrentItem(3);
                }
            }
        });
        //RadioButton的点击事件实现联动
        rone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_one.setChecked(true);
                btn_two.setChecked(false);
                btn_three.setChecked(false);
                btn_four.setChecked(false);

                mviewPager.setCurrentItem(0);

            }
        });
        rtwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_one.setChecked(false);
                btn_two.setChecked(true);
                btn_three.setChecked(false);
                btn_four.setChecked(false);
                mviewPager.setCurrentItem(1);
            }
        });
        rthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_one.setChecked(false);
                btn_two.setChecked(false);
                btn_three.setChecked(true);
                btn_four.setChecked(false);

                mviewPager.setCurrentItem(2);
            }
        });
        rfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_one.setChecked(false);
                btn_two.setChecked(false);
                btn_three.setChecked(false);
                btn_four.setChecked(true);
                mviewPager.setCurrentItem(3);
            }
        });


    }
    public void playVideo(View view){
        intent=new Intent(this,VideoActivity.class);
        startActivity(intent);
    }

}
