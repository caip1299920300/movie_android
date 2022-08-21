package com.example.oss_movie3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.squareup.picasso.Picasso;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

public class MainActivity extends AppCompatActivity {

    JzvdStd jzvdStd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jzvdStd = findViewById(R.id.item_main_jzvd);

        // 视频网址
        String path = "https://vd4.bdstatic.com/mda-kfmi6042m94u0pdb/sc/mda-kfmi6042m94u0pdb.mp4?v_from_s=hkapp-haokan-hnb&auth_key=1661067006-0-0-7ab874e96fe8497734042bc7a3e6820b&bcevod_channel=searchbox_feed&pd=1&cd=0&pt=3&logid=0006206421&vid=5195914434946548038&abtest=103579_1&klogid=0006206421";
        // (视频网址，视频显示名字，。。)
        jzvdStd.setUp(path,"test",JzvdStd.SCREEN_NORMAL);
        // 视频显示的图片
        Picasso.with(this).
                load("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fy.gtimg.cn%2Fmusic%2Fphoto_new%2FT023R750x750M000001n4xOm0umd79.jpg%3Fmax_age%3D2592000&refer=http%3A%2F%2Fy.gtimg.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1663657261&t=71176fd951c489550b65b2f9eb5e1f29").
                into(jzvdStd.posterImageView);
        // 视频在列表中的位置
        jzvdStd.positionInList = 0;

    }

    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.goOnPlayOnPause();
    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Jzvd.goOnPlayOnResume();
    }

        @Override
    protected void onStop() {
        super.onStop();
        JzvdStd.releaseAllVideos();    //释放正在被播放的视频信息
    }
}