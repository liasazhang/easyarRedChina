package cn.easyar.samples.helloar.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import cn.easyar.samples.helloar.R;


/**
 *
 */
public class ThreeFragment extends Fragment {
//    @BindView(R.id.phouse_follow)
//    ImageView phouse_follow;
//    @BindView(R.id.phouse_comment)
//    ImageView phouse_comment;

    private MyRecyclerViewAdapter mAdapter;
    private List<String> stringList;


    public ThreeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {





    }
}
