package adapter;

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
 * Date: 2016/12/15
 * Email: 13102169005@163.com
 * Description:
 */

public class MenuAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> menuList;

    public MenuAdapter(Context mContext, List<String> menuList) {
        this.mContext = mContext;
        this.menuList = menuList;
    }

    @Override
    public int getCount() {
        return menuList.size();
    }

    @Override
    public Object getItem(int i) {
        return menuList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_menu, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.tvName.setText(menuList.get(i));
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
