package vn.iostar.tuan5.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import vn.iostar.tuan5.R;

public class CustomAnimationAdapter extends RecyclerView.Adapter<CustomAnimationAdapter.ViewHolder> {
    private List<String> mDatas;

    public CustomAnimationAdapter(List<String> data) {
        this.mDatas = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View itemView = li.inflate(R.layout.row_animation, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String item = mDatas.get(position);
        holder.tvItem.setText(item);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void addItem(String item) {
        mDatas.add(item);
        notifyItemInserted(mDatas.size() - 1);
    }

    public void addItem(int position, String item) {
        mDatas.add(position, item);
        notifyItemInserted(position);
    }

    public void removeItem(int position) {
        if (position >= 0 && position < mDatas.size()) {
            mDatas.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void removeItems(String item) {
        int index = mDatas.indexOf(item);
        if (index >= 0) {
            mDatas.remove(index);
            notifyItemRemoved(index);
        }
    }

    public void replaceItem(int position, String item) {
        if (position >= 0 && position < mDatas.size()) {
            mDatas.set(position, item);
            notifyItemChanged(position);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvItem;

        public ViewHolder(final View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tv_item);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    removeItem(getAdapterPosition());
                    Toast.makeText(itemView.getContext(), "Removed Animation", Toast.LENGTH_SHORT).show();
                    return true;
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    replaceItem(getAdapterPosition(), "Item Changed");
                    Toast.makeText(itemView.getContext(), "Changed Animation", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
