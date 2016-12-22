package com.lwd.customview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lwd.customview.Clock.ClockActivity;
import com.lwd.customview.basic.GameOne.GameOneActivity;
import com.lwd.customview.basic.GameTwo.TetrisActivity;
import com.lwd.customview.basic.animpath.PathAnimActivity;
import com.lwd.customview.basic.bezierPath.BezierActivity;
import com.lwd.customview.basic.paint.PaintExerciseActivity;
import com.lwd.customview.basic.path.PathEcerciseActivity;
import com.lwd.customview.basic.shader.ShaderExercixeActivity;

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
        menuList.add("Path高级用法 ");
        menuList.add("实现时钟效果 ");
        menuList.add("Shader图像渲染 ");
        menuList.add("Path动态效果 ");
        menuList.add("贝塞尔曲线效果 ");
        menuList.add("用View绘制的小游戏 ");
        menuList.add("俄罗斯方块小游戏 ");
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
                        intent = new Intent(MainActivity.this, PathEcerciseActivity.class);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, ClockActivity.class);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this, ShaderExercixeActivity.class);
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this, PathAnimActivity.class);
                        break;
                    case 5:
                        intent = new Intent(MainActivity.this, BezierActivity.class);
                        break;
                    case 6:
                        intent = new Intent(MainActivity.this, GameOneActivity.class);
                        break;
                    case 7:
                        intent = new Intent(MainActivity.this, TetrisActivity.class);
                        break;
                }
                startActivity(intent);
            }
        });


    }


}
