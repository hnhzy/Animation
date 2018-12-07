package com.hzy.animationdeom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 *
 * 补间动画
 *
 */
public class TweenAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 透明度
     */
    private Button mBtnTm;
    /**
     * 缩放
     */
    private Button mBtnSf;
    /**
     * 旋转
     */
    private Button mBtnXz;
    /**
     * 平移
     */
    private Button mBtnPy;
    /**
     * 组合
     */
    private Button mBtnZh;
    private ImageView mImvAnim;
    private Animation mAnim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);
        initView();
    }

    private void initView() {
        mBtnTm = (Button) findViewById(R.id.btn_tm);
        mBtnTm.setOnClickListener(this);
        mBtnSf = (Button) findViewById(R.id.btn_sf);
        mBtnSf.setOnClickListener(this);
        mBtnXz = (Button) findViewById(R.id.btn_xz);
        mBtnXz.setOnClickListener(this);
        mBtnPy = (Button) findViewById(R.id.btn_py);
        mBtnPy.setOnClickListener(this);
        mImvAnim = (ImageView) findViewById(R.id.imv_anim);
        mBtnZh = (Button) findViewById(R.id.btn_zh);
        mBtnZh.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_tm://透明度
                /**
                 * fromAlpha:开始时透明度
                 * toAlpha： 结束时透明度
                 * duration：动画持续时间
                 * fillAfter：设置动画结束后保持当前的位置
                 */
                //xml实现动画
                mAnim = AnimationUtils.loadAnimation(this, R.anim.anim_tm);
                mImvAnim.startAnimation(mAnim);
                mAnim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {//动画开始执行
                        Toast.makeText(TweenAnimationActivity.this, "动画开始", Toast.LENGTH_SHORT)
                                .show();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {//动画结束时执行
                        Toast.makeText(TweenAnimationActivity.this, "动画结束", Toast.LENGTH_SHORT)
                                .show();

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {//动画重复时执行

                    }
                });

                //代码实现动画
//                mAnim = new mAnim(1.0f, 0.0f);
//                mAnim.setDuration(500);//设置动画持续时间为500毫秒
//                mAnim.setFillAfter(false);//设置动画结束后保持当前的位置（即不返回到动画开始前的位置）
//                mImvAnim.startAnimation(mAnim);
                break;
            case R.id.btn_sf://缩放
                /**
                 * fromXDelta,fromYDelta 起始时X，Y座标,屏幕右下角的座标是X:320,Y:480
                 * toXDelta， toYDelta 动画结束时X,Y的座标
                 * interpolator 指定动画插入器
                 * fromXScale,fromYScale， 动画开始前X,Y的缩放，0.0为不显示， 1.0为正常大小
                 * toXScale，toYScale， 动画最终缩放的倍数， 1.0为正常大小，大于1.0放大
                 * pivotX， pivotY 动画起始位置，相对于屏幕的百分比,两个都为50%表示动画从自身中间开始
                 * startOffset， 动画多次执行的间隔时间，如果只执行一次，执行前会暂停这段时间，单位毫秒
                 * duration，一次动画效果消耗的时间，单位毫秒，值越小动画速度越快
                 * repeatCount，动画重复的计数，动画将会执行该值+1次
                 * repeatMode，动画重复的模式，reverse为反向，当第偶次执行时，动画方向会相反。restart为重新执行，方向不变
                 */
                //xml实现动画
                mAnim = AnimationUtils.loadAnimation(this, R.anim.anim_sf);
                mImvAnim.startAnimation(mAnim);

                //代码实现动画
//                mAnim = new ScaleAnimation(0.0f, 1.5f, 0.0f, 1.5f, Animation
// .RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//                mAnim.setDuration(500);//设置动画持续时间为500毫秒
//                mAnim.setFillAfter(true);//如果fillAfter的值为true,则动画执行后，控件将停留在执行结束的状态
//                mAnim.setFillBefore(false);//如果fillBefore的值为true，则动画执行后，控件将回到动画执行之前的状态
//                mAnim.setRepeatCount(3);//设置动画循环次数
//                mAnim.setRepeatMode(Animation.REVERSE);
//                mAnim.setStartOffset(0);
//                mAnim.setInterpolator(this, android.R.anim.decelerate_interpolator);
// 设置动画插入器
//                mImvAnim.startAnimation(mAnim);
                break;
            case R.id.btn_xz://旋转
                /**
                 * fromDegrees 动画开始时的角度
                 * toDegrees 动画结束时物件的旋转角度,正代表顺时针
                 * pivotX 属性为动画相对于物件的X坐标的开始位置
                 * pivotY 属性为动画相对于物件的Y坐标的开始位置
                 */
                //xml实现动画
                mAnim = AnimationUtils.loadAnimation(this, R.anim.anim_xz);
                mImvAnim.startAnimation(mAnim);

                //代码实现动画
//                mAnim = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF, 0.5f);
//                mAnim.setDuration(500);
//                mAnim.setFillAfter(true);
//                mAnim.setInterpolator(this, android.R.anim.accelerate_decelerate_interpolator);//设置动画插入器
//                mImvAnim.startAnimation(mAnim);
                break;
            case R.id.btn_py://平移
                /**
                 * fromXDelta,fromYDelta 起始时X，Y座标,屏幕右下角的座标是X:320,Y:480
                 * toXDelta， toYDelta 动画结束时X,Y的座标
                 */
                //xml实现动画
                mAnim = AnimationUtils.loadAnimation(this, R.anim.anim_py);
                mImvAnim.startAnimation(mAnim);

                //代码实现动画
//                mAnim = new TranslateAnimation(0, 100, 0, 0);
//                mAnim.setDuration(500);
//                mAnim.setInterpolator(this, android.R.anim.cycle_interpolator);//设置动画插入器
//                mAnim.setFillAfter(true);//设置动画结束后保持当前的位置（即不返回到动画开始前的位置）
//                mImvAnim.startAnimation(mAnim);
                break;
            case R.id.btn_zh:
                //xml实现动画
//                mAnim = AnimationUtils.loadAnimation(this, R.anim.anim_zh);
//                mImvAnim.startAnimation(mAnim);

                //代码实现动画
                AnimationSet animationSet = new AnimationSet(true);
                Animation mAnim = new AlphaAnimation(1.0f, 0.1f);
                mAnim.setDuration(500);//设置动画持续时间为500毫秒
                Animation scaleAnimation = new ScaleAnimation(0.0f, 1.5f, 0.0f, 1.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation.setDuration(500);//设置动画持续时间为500毫秒
                scaleAnimation.setRepeatMode(Animation.REVERSE);
                scaleAnimation.setStartOffset(0);
                scaleAnimation.setInterpolator(this, android.R.anim.decelerate_interpolator);//设置动画插入器
                animationSet.addAnimation(mAnim);
                animationSet.addAnimation(scaleAnimation);
                mImvAnim.startAnimation(animationSet);
                break;
            default:
                break;
        }
    }
}
