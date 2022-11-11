package cn.easyar.samples.helloar.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.easyar.samples.helloar.R;

public class TwoFragment extends Fragment implements MyRecyclerViewOnclickInterface {

    private Intent intent;

    @BindView(R.id.video1)
    ImageView video1;
    int b1,b2;

    private MyRecyclerViewAdapter mAdapter;
    private List<String> stringList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        ButterKnife.bind(this, view);
        b1 = 1;
        b2 = 0;


//        final ImageView video1 = getActivity().findViewById(R.id.video1);//实例化
//        final ImageView phouse_comment = getActivity().findViewById(R.id.phouse_comment);//实例化
        video1.setOnTouchListener(new View.OnTouchListener() {


            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                intent=new Intent(getActivity(),VideoActivity.class);
                startActivity(intent);
                return false;
            }
        });




        return view;
    }


    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getActivity(), stringList.get(position), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClick(View view, int position) {
        Toast.makeText(getActivity(), "onItemLongClick" + stringList.get(position), Toast.LENGTH_SHORT).show();
    }
}
