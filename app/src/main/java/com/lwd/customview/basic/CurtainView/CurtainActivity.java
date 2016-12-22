package com.lwd.customview.basic.CurtainView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

import com.lwd.customview.R;

public class CurtainActivity extends AppCompatActivity {
    private SeekBar pb_my;
    private CurtainView curtain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curtain);
        pb_my = (SeekBar) findViewById(R.id.pb_my);
        curtain = (CurtainView) findViewById(R.id.curtain);
        pb_my.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                curtain.setmFactor((float) i/100);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
