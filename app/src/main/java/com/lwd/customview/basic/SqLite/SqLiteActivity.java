package com.lwd.customview.basic.SqLite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.lwd.customview.R;
import com.lwd.customview.utils.LogUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

import butterknife.ButterKnife;


public class SqLiteActivity extends AppCompatActivity {

    @Bind(R.id.lv_menuLeft)
    ListView lvMenuLeft;
    @Bind(R.id.lv_menuRight)
    ListView lvMenuRight;

    DBUtil dbUtil;

    private List<MenuLeft> lefts;
    private List<MenuRight> rights;

    private MenuLeftAdapter menuLeftAdapter;
    private MenuRightAdapter menuRightAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sq_lite);
        ButterKnife.bind(this);
        if(dbUtil==null){
            dbUtil = new DBUtil(this);
        }


        JSONObject jsonObject = readAssets();
        JSONArray arrayright = jsonObject.optJSONArray("menuright");
        JSONArray arrayleft = jsonObject.optJSONArray("menuleft");

        LogUtil.d("menuleft",arrayright.toString());
        LogUtil.d("menuright",arrayleft.toString());
        lefts = new ArrayList<>();
        rights = new ArrayList<>();


        for(int i = 0;i<arrayleft.length();i++){
            JSONObject object = arrayleft.optJSONObject(i);
            MenuLeft menuLeft = new MenuLeft();
            menuLeft.set_Id(object.optString("_id"));
            menuLeft.set_Name(object.optString("_name"));
            dbUtil.InsertLeft(menuLeft);
        }

        for(int i = 0;i<arrayright.length();i++){
            JSONObject object = arrayleft.optJSONObject(i);
            MenuRight menuRight = new MenuRight();
            menuRight.set_ID(object.optString("_id"));
            menuRight.set_Name(object.optString("_name"));
            menuRight.set_CurrentNum(object.optString("_CurrentNum"));
            menuRight.set_TotalNum(object.optString("_TotalNum"));
            dbUtil.InsertRight(menuRight);
        }

        lefts = dbUtil.GetAllLeft();
        rights = dbUtil.GetAllRight();
        menuLeftAdapter = new MenuLeftAdapter(this,lefts);
        lvMenuLeft.setAdapter(menuLeftAdapter);
        menuRightAdapter = new MenuRightAdapter(this,rights);
        lvMenuRight.setAdapter(menuRightAdapter);
    }

    /**
     * 读取Assets 中的Json数据
     * @return
     */
    JSONObject readAssets(){

        JSONObject jsonObject = null;

        try {
            InputStream is = getAssets().open("gson.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonObject =new JSONObject(new String(buffer));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
