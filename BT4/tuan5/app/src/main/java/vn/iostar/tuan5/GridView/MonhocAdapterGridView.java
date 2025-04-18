package vn.iostar.tuan5.GridView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.iostar.tuan5.R;

public class MonhocAdapterGridView extends BaseAdapter {
    private Context context;
    private int layout;
    private List<MonHocGridView> monHocList;

    public MonhocAdapterGridView(Context context, int layout, List<MonHocGridView> monHocList) {
        this.context = context;
        this.layout = layout;
        this.monHocList = monHocList;
    }

    @Override
    public int getCount() {
        return monHocList.size();
    }

    @Override
    public Object getItem(int position) {
        return monHocList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(layout, parent, false);
            holder = new ViewHolder();

            // Sửa lại ID cho đúng với row_monhocgridview.xml
            holder.textName = convertView.findViewById(R.id.name);
            holder.textDesc = convertView.findViewById(R.id.desc);
            holder.imagePic = convertView.findViewById(R.id.pic);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Gán dữ liệu từ danh sách vào View
        MonHocGridView monHoc = monHocList.get(position);
        holder.textName.setText(monHoc.getName());
        holder.textDesc.setText(monHoc.getDesc());
        holder.imagePic.setImageResource(monHoc.getPic());

        return convertView;
    }

    private static class ViewHolder {
        TextView textName, textDesc;
        ImageView imagePic;
    }
}
