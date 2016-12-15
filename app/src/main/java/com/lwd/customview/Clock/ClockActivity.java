package com.lwd.customview.Clock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lwd.customview.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * User: LWD
 * Date: 2016/12/15
 * Email: 13102169005@163.com
 * Description:
 */

public class ClockActivity extends AppCompatActivity {

    @Bind(R.id.ck_view)
    ClockVIew ckView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ck_view)
    public void onClick() {
    }
}
