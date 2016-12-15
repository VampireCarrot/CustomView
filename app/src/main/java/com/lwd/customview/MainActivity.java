package com.lwd.customview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lwd.customview.Clock.ClockActivity;
import com.lwd.customview.basic.PaintExerciseActivity;

import java.util.ArrayList;
import java.util.List;

import adapter.MenuAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.lv_muenu)
    ListView lvMuenu;
    private MenuAdapter menuAdapter;
    private List<String> menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {



        menuList = new ArrayList<>();
        menuList.add("Paint基础教程 ");
        menuList.add("实现时钟效果 ");
        menuAdapter = new MenuAdapter(this,menuList);
        lvMuenu.setAdapter(menuAdapter);

        lvMuenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = null;
                switch (i){
                    case 0:
                        intent = new Intent(MainActivity.this, PaintExerciseActivity.class);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, ClockActivity.class);
                        break;
                }
                startActivity(intent);
            }
        });


    }


}
