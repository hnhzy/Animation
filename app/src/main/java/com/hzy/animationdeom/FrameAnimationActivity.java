package com.hzy.animationdeom;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * 帧动画
 */
public class FrameAnimationActivity extends AppCompatActivity {

    private ImageView mAnimationIv;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);
        initView();
    }

    private void initView() {
        mAnimationIv = findViewById(R.id.animation_iv);
        //xml文件实现帧动画
        mAnimationIv.setImageResource(R.drawable.frame_animlist);
        animationDrawable = (AnimationDrawable) mAnimationIv.getDrawable();
        animationDrawable.start();

        //代码实现帧动画
//        animationDrawable = new AnimationDrawable();
//        for (int i = 1; i <= 6; i++) {
//            int id = getResources().getIdentifier("anim_" + i, "drawable", getPackageName());
//            Drawable drawable = getResources().getDrawable(id);
//            animationDrawable.addFrame(drawable, 200);
//        }
//        animationDrawable.setOneShot(false);
//        mAnimationIv.setImageDrawable(animationDrawable);
//        animationDrawable.start();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        animationDrawable.stop();
    }
}
