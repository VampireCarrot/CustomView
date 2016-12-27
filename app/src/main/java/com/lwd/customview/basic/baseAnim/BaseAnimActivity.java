package com.lwd.customview.basic.baseAnim;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.lwd.customview.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class BaseAnimActivity extends AppCompatActivity {


    @Bind(R.id.btn_alpha)
    Button btnAlpha;
    @Bind(R.id.btn_scale)
    Button btnScale;
    @Bind(R.id.btn_rotate)
    Button btnRotate;
    @Bind(R.id.trans)
    Button trans;
    @Bind(R.id.bnt_set)
    Button btnSet;
    @Bind(R.id.iv_view)
    TextView ivView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_anim);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_alpha, R.id.btn_scale, R.id.btn_rotate, R.id.trans, R.id.iv_view,R.id.bnt_set})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_alpha:
                Animation hyperspaceJumpAnimation1 = AnimationUtils.loadAnimation(this, R.anim.alphaanim);
                ivView.startAnimation(hyperspaceJumpAnimation1);
                break;
            case R.id.btn_scale:
                Animation hyperspaceJumpAnimation2 = AnimationUtils.loadAnimation(this, R.anim.scaleanim);
                ivView.startAnimation(hyperspaceJumpAnimation2);
                break;
            case R.id.btn_rotate:
                Animation hyperspaceJumpAnimation3 = AnimationUtils.loadAnimation(this, R.anim.rotateanim);
                ivView.startAnimation(hyperspaceJumpAnimation3);
                break;
            case R.id.trans:
                Animation hyperspaceJumpAnimation4 = AnimationUtils.loadAnimation(this, R.anim.translateanim);
                ivView.startAnimation(hyperspaceJumpAnimation4);
                break;
            case R.id.bnt_set:
                Animation hyperspaceJumpAnimation5 = AnimationUtils.loadAnimation(this, R.anim.setanim);
                ivView.startAnimation(hyperspaceJumpAnimation5);
                break;
            case R.id.iv_view:
                break;
        }
    }
}
