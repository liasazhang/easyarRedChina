package cn.easyar.samples.helloar.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import cn.easyar.samples.helloar.R;




public class MeFragment extends Fragment {




    Button mButtonTry;
    ArrayList<ImageView> mList;
    ArrayList<String> mMainTitle;
    ArrayList<String> mSubTitle;
    View current_view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View  current_view = inflater.inflate(R.layout.me_fragment,container, false);
//        Log.e(TAG,"Msg");


        return current_view;

    }


}
