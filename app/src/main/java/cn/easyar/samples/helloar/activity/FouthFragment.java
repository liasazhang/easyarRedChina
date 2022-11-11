package cn.easyar.samples.helloar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.easyar.samples.helloar.R;

public class FouthFragment extends Fragment {
    @BindView(R.id.feedback)
    ImageView feedback;
    @BindView(R.id.feedback1)
    ImageView feedback1;

    @BindView(R.id.version)
    ImageView version;
    @BindView(R.id.version1)
    ImageView version1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fouth, container, false);
        ButterKnife.bind(this, view);
        initData();

        return view;

    }
    private void initData() {
        feedback.setOnTouchListener(new View.OnTouchListener() {

            @Override

            public boolean onTouch(View v, MotionEvent event) {

                Log.e("jerry","IdenActivity");
                startActivity(new Intent(getActivity(), VersionActivity.class));
                return false;
            }
        });
        feedback1.setOnTouchListener(new View.OnTouchListener() {

            @Override

            public boolean onTouch(View v, MotionEvent event) {

                Log.e("jerry","IdenActivity");
                startActivity(new Intent(getActivity(), VersionActivity.class));
                return false;
            }
        });

        version.setOnTouchListener(new View.OnTouchListener() {

            @Override

            public boolean onTouch(View v, MotionEvent event) {

                Log.e("jerry","IdenActivity");
                startActivity(new Intent(getActivity(), VersionActivity.class));
                return false;
            }
        });
        version1.setOnTouchListener(new View.OnTouchListener() {

            @Override

            public boolean onTouch(View v, MotionEvent event) {

                Log.e("jerry","IdenActivity");
                startActivity(new Intent(getActivity(), VersionActivity.class));
                return false;
            }
        });

//        famous_people.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//
//            public boolean onTouch(View v, MotionEvent event) {
//
//                Log.e("jerry","IdenActivity");
//                startActivity(new Intent(getActivity(), IdenActivity.class));
//                return false;
//            }
//        });
    }
}
