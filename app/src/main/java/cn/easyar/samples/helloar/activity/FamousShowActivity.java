package cn.easyar.samples.helloar.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnPageChangeListener;
import com.youth.banner.util.BannerUtils;
import com.youth.banner.util.LogUtils;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.easyar.samples.helloar.R;
import cn.easyar.samples.helloar.adapter.ImageAdapter;
import cn.easyar.samples.helloar.bean.DataBean;

//import部分

public class FamousShowActivity extends AppCompatActivity implements OnPageChangeListener
{
    @BindView(R.id.banner)
     Banner banner;
    private List<String> mListImage, mListTitle;
    //声明TextView对象
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_famous_people_show);

        ButterKnife.bind(this);

        ImageAdapter adapter = new ImageAdapter(DataBean.getTestData());
        banner.setAdapter(adapter)//设置适配器
//              .setCurrentItem(3,false)
                .addBannerLifecycleObserver(this)//添加生命周期观察者
                .setBannerRound(BannerUtils.dp2px(5))//圆角
//              .addPageTransformer(new RotateYTransformer())//添加切换效果
                .setIndicator(new CircleIndicator(this))//设置指示器
                .addOnPageChangeListener(this)//添加切换监听
                .setOnBannerListener((data, position) -> {
                    Snackbar.make(banner, ((DataBean) data).title, Snackbar.LENGTH_SHORT).show();
                    LogUtils.d("position：" + position);
                });//设置点击事件,传this也行

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        LogUtils.d("onPageSelected:" + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
