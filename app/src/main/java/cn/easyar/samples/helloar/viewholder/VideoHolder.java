package cn.easyar.samples.helloar.viewholder;

import android.view.View;

import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.easyar.samples.helloar.R;

public class VideoHolder extends RecyclerView.ViewHolder {
    public StandardGSYVideoPlayer player;

    public VideoHolder(@NonNull View view) {
        super(view);
        player = view.findViewById(R.id.player);
    }
}
