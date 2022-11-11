package cn.easyar.samples.helloar.activity;



import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;

    public MyFragmentAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);

        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
