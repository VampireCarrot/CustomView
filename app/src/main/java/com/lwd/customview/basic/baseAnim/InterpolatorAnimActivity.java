package com.lwd.customview.basic.baseAnim;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lwd.customview.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InterpolatorAnimActivity extends AppCompatActivity {

    @Bind(R.id.btn_accdanim)
    Button btnAccdanim;
    @Bind(R.id.btn_acceianim)
    Button btnAcceianim;
    @Bind(R.id.btn_antianim)
    Button btnAntianim;
    @Bind(R.id.btn_anticoanim)
    Button btnAnticoanim;
    @Bind(R.id.btn_bounanim)
    Button btnBounanim;
    @Bind(R.id.btn_cycleanim)
    Button btnCycleanim;
    @Bind(R.id.btn_deceanim)
    Button btnDeceanim;
    @Bind(R.id.btn_lineranim)
    Button btnLineranim;
    @Bind(R.id.btn_overanim)
    Button btnOveranim;
    @Bind(R.id.tv_text)
    TextView tvText;
    @Bind(R.id.activity_interpolator_anim)
    LinearLayout activityInterpolatorAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolator_anim);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_accdanim, R.id.btn_acceianim, R.id.btn_antianim, R.id.btn_anticoanim, R.id.btn_bounanim, R.id.btn_cycleanim, R.id.btn_deceanim, R.id.btn_lineranim, R.id.btn_overanim, R.id.tv_text})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_accdanim:
                Animation hyperspaceJumpAnimation1 = AnimationUtils.loadAnimation(this, R.anim.interpolatoralphaanim);
                tvText.startAnimation(hyperspaceJumpAnimation1);
                break;
            case R.id.btn_acceianim:
                Animation hyperspaceJumpAnimation2 = AnimationUtils.loadAnimation(this, R.anim.interpolatorrotateanim);
                tvText.startAnimation(hyperspaceJumpAnimation2);
                break;
            case R.id.btn_antianim:
                Animation hyperspaceJumpAnimation3 = AnimationUtils.loadAnimation(this, R.anim.interpolaterscaleanim);
                tvText.startAnimation(hyperspaceJumpAnimation3);
                break;
            case R.id.btn_anticoanim:
                Animation hyperspaceJumpAnimation4 = AnimationUtils.loadAnimation(this, R.anim.interpolatortranslateanim);
                tvText.startAnimation(hyperspaceJumpAnimation4);
                break;
            case R.id.btn_bounanim:
                Animation hyperspaceJumpAnimation5 = AnimationUtils.loadAnimation(this, R.anim.interpolatorsetanim);
                tvText.startAnimation(hyperspaceJumpAnimation5);
                break;
            case R.id.btn_cycleanim:
                Animation hyperspaceJumpAnimation6 = AnimationUtils.loadAnimation(this, R.anim.interpolatorcyclesetanim);
                tvText.startAnimation(hyperspaceJumpAnimation6);
                break;
            case R.id.btn_deceanim:
                Animation hyperspaceJumpAnimation7 = AnimationUtils.loadAnimation(this, R.anim.interpolatordecelersetanim);
                tvText.startAnimation(hyperspaceJumpAnimation7);
                break;
            case R.id.btn_lineranim:
                Animation hyperspaceJumpAnimation8 = AnimationUtils.loadAnimation(this, R.anim.interpolatorlinerersetanim);
                tvText.startAnimation(hyperspaceJumpAnimation8);
                break;
            case R.id.btn_overanim:
                Animation hyperspaceJumpAnimation9 = AnimationUtils.loadAnimation(this, R.anim.interpolatoroverersetanim);
                tvText.startAnimation(hyperspaceJumpAnimation9);
                break;
            case R.id.tv_text:
                break;
        }
    }
}
