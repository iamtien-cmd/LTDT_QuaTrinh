package vn.iostar.tuan5.RecyclerView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.iostar.tuan5.R;

public class CustomAdapterRecyclerView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<Object> mObjects;
    public static final int TEXT = 0;
    public static final int IMAGE = 1;
    public static final int USER = 2;

    public CustomAdapterRecyclerView(Context context, List<Object> objects) {
        this.mContext = context;
        this.mObjects = objects;
    }

    public class TextViewHolder extends RecyclerView.ViewHolder {
        private TextView tvText;
        public TextViewHolder(View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tv_text);
            itemView.setOnClickListener(view -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Toast.makeText(mContext, mObjects.get(position).toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        private ImageView imvImage;
        public ImageViewHolder(View itemView) {
            super(itemView);
            imvImage = itemView.findViewById(R.id.imv_image);
            itemView.setOnClickListener(view -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Toast.makeText(mContext, mObjects.get(position).toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName, tvAddress;
        public UserViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAddress = itemView.findViewById(R.id.tv_address);
            itemView.setOnClickListener(view -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    UserModel user = (UserModel) mObjects.get(position);
                    Toast.makeText(mContext, user.getName() + ", " + user.getAddress(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mObjects.get(position) instanceof String) {
            return TEXT;
        } else if (mObjects.get(position) instanceof Integer) {
            return IMAGE;
        } else if (mObjects.get(position) instanceof UserModel) {
            return USER;
        }
        return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        switch (viewType) {
            case TEXT:
                return new TextViewHolder(inflater.inflate(R.layout.row_text, parent, false));
            case IMAGE:
                return new ImageViewHolder(inflater.inflate(R.layout.row_image, parent, false));
            case USER:
                return new UserViewHolder(inflater.inflate(R.layout.row_user, parent, false));
            default:
                throw new IllegalArgumentException("Invalid view type");
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (getItemViewType(position)) {
            case TEXT:
                ((TextViewHolder) holder).tvText.setText(mObjects.get(position).toString());
                break;
            case IMAGE:
                ((ImageViewHolder) holder).imvImage.setImageResource((int) mObjects.get(position));
                break;
            case USER:

                UserModel user = (UserModel) mObjects.get(position);
                UserViewHolder userHolder = (UserViewHolder) holder;
                userHolder.tvName.setText(user.getName());
                userHolder.tvAddress.setText(user.getAddress());
                break;
        }
    }

    @Override
    public int getItemCount() {
        Log.d("RecyclerView", "Số lượng bài hát: " + mObjects.size());
        return mObjects.size();
    }
    public void addItem(Object item) {
        mObjects.add(item);
        notifyItemInserted(mObjects.size() - 1);
    }

    public void removeItem(int position) {
        if (position >= 0 && position < mObjects.size()) {
            mObjects.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void replaceItem(int position, Object item) {
        if (position >= 0 && position < mObjects.size()) {
            mObjects.set(position, item);
            notifyItemChanged(position);
        }
    }
}
