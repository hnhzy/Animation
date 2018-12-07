package com.hzy.animationdeom;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class PropertyAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 透明
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
    private Animator mAnim;
    private ObjectAnimator scaleXAnimator;
    private ObjectAnimator scaleYAnimator;
    private ObjectAnimator translationXAnimator;
    private ObjectAnimator rotationAnimator;
    private ObjectAnimator alphaAnimation;

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
        mBtnZh = (Button) findViewById(R.id.btn_zh);
        mBtnZh.setOnClickListener(this);
        mImvAnim = (ImageView) findViewById(R.id.imv_anim);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_tm:
//                mAnim = AnimatorInflater.loadAnimator(this, R.animator.anim_object_tm);
//                mAnim.setTarget(mImvAnim);
//                mAnim.start();
//                mAnim.addListener(new Animator.AnimatorListener() {
//                    @Override
//                    public void onAnimationStart(Animator animation) {
//                        //TODO 动画开始前的操作
//                    }
//
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//                        //TODO 动画结束的操作
//                    }
//
//                    @Override
//                    public void onAnimationCancel(Animator animation) {
//                        //TODO 动画取消的操作
//                    }
//
//                    @Override
//                    public void onAnimationRepeat(Animator animation) {
//                        //TODO 动画重复的操作
//                    }
//                });



                alphaAnimation = ObjectAnimator.ofFloat(mImvAnim, "alpha", 0f, 1f);
                alphaAnimation.setDuration(500);
                alphaAnimation.setRepeatCount(0);
                alphaAnimation.setRepeatMode(ValueAnimator.REVERSE);
                alphaAnimation.setStartDelay(200);
                alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                alphaAnimation.start();

                alphaAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float value = (float) animation.getAnimatedValue();
                        //可以根据自己的需要来获取动画更新值。
                        Log.e("AnimatorUpdateListener", "the animation value is " + value);
                    }
                });
                break;
            case R.id.btn_sf:
//                mAnim = AnimatorInflater.loadAnimator(this, R.animator.anim_object_sf);
//                mAnim.setTarget(mImvAnim);
//                mAnim.start();

                scaleXAnimator = ObjectAnimator.ofFloat(mImvAnim, "scaleX", 1f, 1.5f);
                scaleXAnimator.setDuration(500);
                scaleXAnimator.setRepeatCount(1);
                scaleXAnimator.setRepeatMode(ValueAnimator.REVERSE);
                scaleXAnimator.start();
                break;
            case R.id.btn_xz:
//                mAnim = AnimatorInflater.loadAnimator(this, R.animator.anim_object_xz);
//                mAnim.setTarget(mImvAnim);
//                mAnim.start();

                rotationAnimator = ObjectAnimator.ofFloat(mImvAnim, "rotation", 0f, 360f);
                rotationAnimator.setDuration(500);
                rotationAnimator.setRepeatCount(1);
                rotationAnimator.setRepeatMode(ValueAnimator.REVERSE);
                rotationAnimator.start();
                break;
            case R.id.btn_py:
//                mAnim = AnimatorInflater.loadAnimator(this, R.animator.anim_object_py);
//                mAnim.setTarget(mImvAnim);
//                mAnim.start();

                translationXAnimator = ObjectAnimator.ofFloat(mImvAnim, "translationX", 0f, 100f);
                translationXAnimator.setDuration(500);
                translationXAnimator.setRepeatCount(1);
                translationXAnimator.setRepeatMode(ValueAnimator.REVERSE);
                translationXAnimator.start();
                break;
            case R.id.btn_zh:
                //xml实现组合动画
//                Animator anim = AnimatorInflater.loadAnimator(this, R.animator.anim_object_zh);
//                anim.setTarget(mImvAnim);
//                anim.start();

                //代码方式实现组合动画
                //方式一：AnimatorSet
                AnimatorSet animatorSet = new AnimatorSet();
                scaleXAnimator = ObjectAnimator.ofFloat(mImvAnim, "scaleX", 1f, 1.5f);
                scaleXAnimator.setDuration(500);
                scaleXAnimator.setRepeatCount(1);
                scaleXAnimator.setRepeatMode(ValueAnimator.REVERSE);
//                scaleXAnimator.start();
                scaleYAnimator = ObjectAnimator.ofFloat(mImvAnim, "scaleY", 1f, 1.5f);
                scaleYAnimator.setDuration(500);
                scaleYAnimator.setRepeatCount(1);
                scaleYAnimator.setRepeatMode(ValueAnimator.REVERSE);
                /**
                 * after(Animator anim) 将现有动画插入到传入的动画之后执行
                 * after(long delay) 将现有动画延迟指定毫秒后执行
                 * before(Animator anim) 将现有动画插入到传入的动画之前执行
                 * with(Animator anim) 将现有动画和传入的动画同时执行
                 */
//                animatorSet.play(scaleXAnimator).before(scaleYAnimator);
//                animatorSet.play(scaleXAnimator).after(scaleYAnimator);
//                animatorSet.play(scaleXAnimator).with(scaleYAnimator);
//                animatorSet.play(scaleXAnimator).after(500);
                animatorSet.playTogether(scaleXAnimator, scaleYAnimator);//两个动画同时执行
                animatorSet.start();

                //方式二：PropertyValuesHolder
                //缺点：只能实现同时执行的动画组合
                PropertyValuesHolder scaleXValuesHolder = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 1.5f);
                PropertyValuesHolder scaleYValuesHolder = PropertyValuesHolder.ofFloat("scaleY", 1.0f, 1.5f);
                ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(mImvAnim, scaleXValuesHolder, scaleYValuesHolder);
                objectAnimator.setDuration(500);
                objectAnimator.setRepeatCount(1);
                objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
                objectAnimator.start();

                //方式三：viewPropertyAnimator
                //多属性动画，作用于View，能够实现的动画相对单一，只能实现比如缩放，透明度改变，平移、旋转等，
                // 具体函数名字：平移 translationX，translationY, X，Y，缩放 scaleX，scaleY， 旋转 rotationX， rotationY，透明度 alpha
                ViewPropertyAnimator viewPropertyAnimator=mImvAnim.animate();
                viewPropertyAnimator.scaleXBy(1.0f).scaleX(1.5f).scaleYBy(1.0f).scaleY(1.5f).setDuration(500).start();
                break;
        }
    }
}
