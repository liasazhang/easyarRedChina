package cn.easyar.samples.helloar.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.easyar.samples.helloar.R;

public class TitleHolder extends RecyclerView.ViewHolder {
    public TextView title;

    public TitleHolder(@NonNull View view) {
        super(view);
        title = view.findViewById(R.id.bannerTitle);
    }
}
