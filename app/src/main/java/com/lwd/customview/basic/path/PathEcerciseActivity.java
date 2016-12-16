package com.lwd.customview.basic.path;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lwd.customview.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PathEcerciseActivity extends AppCompatActivity {

    @Bind(R.id.pv_path)
    PathView pvPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parh_ecercise);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        pvPath.clearAnim();
    }

    @OnClick(R.id.pv_path)
    public void onClick() {
    }
}
