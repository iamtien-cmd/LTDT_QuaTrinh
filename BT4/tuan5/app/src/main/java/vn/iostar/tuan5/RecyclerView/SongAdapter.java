package vn.iostar.tuan5.RecyclerView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import vn.iostar.tuan5.R;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    private final List<SongModel> mSongs;
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;

    public SongAdapter(Context context, List<SongModel> datas) {
        this.mContext = context;
        this.mSongs = datas;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.row_item_song, parent, false);
        return new SongViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        SongModel song = mSongs.get(position);
        Log.d("RecyclerView", "Binding bài hát: " + song.getmTitle());
        holder.tvCode.setText(song.getmCode());
        holder.tvTitle.setText(song.getmTitle());
        holder.tvLyric.setText(song.getmLyric());
        holder.tvArtist.setText(song.getmArtist());
    }

    @Override
    public int getItemCount() {
        Log.d("RecyclerView", "Số lượng bài hát: " + mSongs.size());
        return mSongs.size();
    }

    class SongViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvCode;
        private final TextView tvTitle;
        private final TextView tvLyric;
        private final TextView tvArtist;

        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCode = itemView.findViewById(R.id.tv_code);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvLyric = itemView.findViewById(R.id.tv_lyric);
            tvArtist = itemView.findViewById(R.id.tv_artist);

            // Sự kiện khi nhấn vào một item trong RecyclerView
            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    SongModel song = mSongs.get(position);
                    Toast.makeText(mContext, "Bài hát: " + song.getmTitle(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
