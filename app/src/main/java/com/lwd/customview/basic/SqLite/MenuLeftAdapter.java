package com.lwd.customview.basic.SqLite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lwd.customview.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * User: LWD
 * Date: 2016/12/26
 * Email: 13102169005@163.com
 * Description:
 */

public class MenuLeftAdapter extends BaseAdapter {
    private Context context;
    private List<MenuLeft> lefts;

    public MenuLeftAdapter(Context context, List<MenuLeft> lefts) {
        this.context = context;
        this.lefts = lefts;
    }

    @Override
    public int getCount() {
        return lefts.size();
    }

    @Override
    public MenuLeft getItem(int i) {
        return lefts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder = null;
        if(view==null){
            view = LayoutInflater.from(context).inflate(R.layout.item_left, null);
            holder  = new ViewHolder(view);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.tvName.setText(lefts.get(i).get_Name());
        return view;
    }

    static class ViewHolder {
        @Bind(R.id.tv_name)
        TextView tvName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
