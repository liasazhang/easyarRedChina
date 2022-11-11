package cn.easyar.samples.helloar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.youth.banner.Banner;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.listener.OnPageChangeListener;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.easyar.samples.helloar.R;
import cn.easyar.samples.helloar.adapter.MultipleTypesAdapter;
import cn.easyar.samples.helloar.bean.DataBean;
import cn.easyar.samples.helloar.viewholder.VideoHolder;

public class OneFragment extends Fragment {
    @BindView(R.id.banner)
    Banner banner;
    StandardGSYVideoPlayer player;
    //绑定视图
    @BindView(R.id.home_history)
    ImageView home_history;
    //绑定视图
    @BindView(R.id.changzhen)
    ImageView changzhen;
    //绑定视图
    @BindView(R.id.ar)
    ImageView ar;
    //绑定视图
    @BindView(R.id.process)
    ImageView process;
//    @BindView(R.id.srl)
//    SwipeRefreshLayout mSwipeRefreshLayout;

    private List<String> stringList;
    private ArrayAdapter lvAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        ButterKnife.bind(this, view);
        initData();

        banner.addBannerLifecycleObserver(this)
                .setAdapter(new MultipleTypesAdapter(this.getActivity(), DataBean.getTestDataVideo()))
//                .setIndicator(new NumIndicator(this.getActivity()))
//                .setIndicatorGravity(IndicatorConfig.Direction.RIGHT)
                .addOnPageChangeListener(new OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        Log.e("--","position:"+position);
                        if (player == null) {
                            RecyclerView.ViewHolder viewHolder = banner.getAdapter().getViewHolder();
                            if (viewHolder instanceof VideoHolder) {
                                VideoHolder holder = (VideoHolder) viewHolder;
                                player = holder.player;
                            }
                            return;
                        }
                        if (position != 0) {
                            player.onVideoReset();
                        }
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });
        return view;
    }

    private void initData() {
        home_history.setOnTouchListener(new View.OnTouchListener() {

            @Override

            public boolean onTouch(View v, MotionEvent event) {

                Log.e("jerry","IdenActivity");
                startActivity(new Intent(getActivity(), FamousShowActivity.class));
                return false;
            }
        });
        changzhen.setOnTouchListener(new View.OnTouchListener() {

            @Override

            public boolean onTouch(View v, MotionEvent event) {

                Log.e("jerry","RoadActivity");
                startActivity(new Intent(getActivity(), RoadActivity.class));
                return false;
            }
        });
        ar.setOnTouchListener(new View.OnTouchListener() {

            @Override

            public boolean onTouch(View v, MotionEvent event) {

                Log.e("jerry","IdenActivity");
                startActivity(new Intent(getActivity(), IdenActivity.class));
                return false;
            }
        });
        process.setOnTouchListener(new View.OnTouchListener() {

            @Override

            public boolean onTouch(View v, MotionEvent event) {

                Log.e("jerry","IdenActivity");
                startActivity(new Intent(getActivity(), VideoActivity.class));
                return false;
            }
        });
    }
}
