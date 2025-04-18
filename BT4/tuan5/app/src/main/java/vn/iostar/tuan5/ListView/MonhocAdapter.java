package vn.iostar.tuan5.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.iostar.tuan5.R;

public class MonhocAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<MonHoc> monHocList;

    public MonhocAdapter(Context context, int layout, List<MonHoc> monHocList) {
        this.context = context;
        this.layout = layout;
        this.monHocList = monHocList;
    }

    @Override
    public int getCount() {
        return monHocList.size();
    }

    @Override
    public Object getItem(int i) {
        return monHocList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);

            viewHolder = new ViewHolder();
            viewHolder.textName = view.findViewById(R.id.textView);
            viewHolder.textDesc = view.findViewById(R.id.textView2);
            viewHolder.imagePic = view.findViewById(R.id.imageView);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        MonHoc monHoc = monHocList.get(i);
        viewHolder.textName.setText(monHoc.getName());
        viewHolder.textDesc.setText(monHoc.getDesc());
        viewHolder.imagePic.setImageResource(monHoc.getPic());

        return view;
    }

    static class ViewHolder {
        TextView textName;
        TextView textDesc;
        ImageView imagePic;
    }
}
