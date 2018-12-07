package com.hzy.animationdeom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 帧动画
     */
    private Button mBtnFrame;
    /**
     * 补间动画
     */
    private Button mBtnTween;
    /**
     * 属性动画
     */
    private Button mBtnProperty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtnFrame = (Button) findViewById(R.id.btn_frame);
        mBtnFrame.setOnClickListener(this);
        mBtnTween = (Button) findViewById(R.id.btn_tween);
        mBtnTween.setOnClickListener(this);
        mBtnProperty = (Button) findViewById(R.id.btn_property);
        mBtnProperty.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_frame:
                startActivity(new Intent(this,FrameAnimationActivity.class));
                break;
            case R.id.btn_tween:
                startActivity(new Intent(this,TweenAnimationActivity.class));
                break;
            case R.id.btn_property:
                startActivity(new Intent(this,PropertyAnimationActivity.class));
                break;
        }
    }
}
