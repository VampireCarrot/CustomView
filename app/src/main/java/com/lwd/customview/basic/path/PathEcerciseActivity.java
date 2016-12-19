package com.lwd.customview.basic.path;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lwd.customview.R;

import butterknife.Bind;
import butterknife.OnClick;

public class PathEcerciseActivity extends AppCompatActivity {

    @Bind(R.id.pv_path)
    PathView pvPath;
    AJMDPath ajmdPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parh_ecercise);
        ajmdPath = (AJMDPath) findViewById(R.id.ahmdp);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick(R.id.pv_path)
    public void onClick() {
    }
}
