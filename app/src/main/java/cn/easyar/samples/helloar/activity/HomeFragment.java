package cn.easyar.samples.helloar.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import cn.easyar.samples.helloar.R;


public class HomeFragment extends Fragment {



    private List<Integer> images = new ArrayList<>();



    //绑定视图
    @BindView(R.id.home_history)
    ImageView home_history;
//    @BindView(R.id.srl)
//    SwipeRefreshLayout mSwipeRefreshLayout;

    private List<String> stringList;
    private ArrayAdapter lvAdapter;


//
//    private void initData() {
//        home_history.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//
//            public boolean onTouch(View v, MotionEvent event) {
//
//
//                Log.e("jerry","开始跳转");
//
//                Constants.b_status1 = 1;
//                Intent intent = new Intent(mContext, IdenActivity.class);
////                intent.putExtra("fileName", fileName);
//                mContext.startActivity(intent);
//                return false;
//            }
//        });
//
//
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =LayoutInflater.from(getActivity()).inflate(R.layout.home_fragment,container,false);




        return view;
    }











}
