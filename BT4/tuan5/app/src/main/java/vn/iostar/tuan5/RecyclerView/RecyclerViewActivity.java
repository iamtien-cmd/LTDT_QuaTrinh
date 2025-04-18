package vn.iostar.tuan5.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.iostar.tuan5.R;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView rvSongs;
    private SongAdapter mSongAdapter;
    private List<SongModel> mSongs;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);
        rvSongs = (RecyclerView) findViewById(R.id.rv_songs);
        mSongs = new ArrayList<>();
        mSongs.add(new SongModel("10101", "Hãy Trao Cho Anh", "Anh muốn đưa em đi xa nơi đây", "Sơn Tùng M-TP"));
        mSongs.add(new SongModel("20202", "Em Gì Ơi", "Đếm bước chân em đi về nơi đâu", "Jack & K-ICM"));
        mSongs.add(new SongModel("30303", "Có Chắc Yêu Là Đây", "Mưa trôi cả bầu trời nắng", "Sơn Tùng M-TP"));
        mSongs.add(new SongModel("40404", "Từ Đó", "Nhìn theo bóng em xa khuất chân trời", "Phan Mạnh Quỳnh"));
        mSongs.add(new SongModel("50505", "Nàng Thơ", "Em, ngày xưa đó", "Hoàng Dũng"));
        mSongs.add(new SongModel("60606", "Chúng Ta Của Hiện Tại", "Đừng khóc lóc hãy cứ bước đi", "Sơn Tùng M-TP"));
        mSongs.add(new SongModel("70707", "Hồng Nhan", "Hồng nhan bạc phận, duyên trời lận đận", "Jack"));
        mSongs.add(new SongModel("80808", "Lạc Trôi", "Ta đang lạc trôi giữa đời", "Sơn Tùng M-TP"));
        mSongs.add(new SongModel("90909", "Bông Hoa Đẹp Nhất", "Em là bông hoa đẹp nhất trong đời", "Quân A.P"));
        mSongs.add(new SongModel("11111", "Tháng Tư Là Lời Nói Dối Của Em", "Em đã xa anh mùa thu ấy", "Hà Anh Tuấn"));
        mSongs.add(new SongModel("12121", "Người Lạ Ơi", "Người lạ ơi xin hãy cho tôi mượn bờ vai", "Karik, Orange"));
        mSongs.add(new SongModel("13131", "Hẹn Một Mai", "Hẹn một mai ta chung lối về", "Bùi Anh Tuấn"));
        mSongs.add(new SongModel("14141", "Đừng Quên Tên Anh", "Đừng quên tên anh, kẻ đã yêu em", "Hoa Vinh"));
        mSongs.add(new SongModel("15151", "Yêu 5", "Chẳng ai có thể hiểu nổi một người", "Rhymastic"));
        mSongs.add(new SongModel("16161", "Đã Lỡ Yêu Em Nhiều", "Anh biết anh chẳng là gì của em", "JustaTee"));
        mSongs.add(new SongModel("17171", "Hết Thương Cạn Nhớ", "Chuyện tình yêu đôi ta ai ngờ", "Đức Phúc"));
        mSongs.add(new SongModel("18181", "Sóng Gió", "Hồng trần trên đôi cánh tay", "Jack & K-ICM"));


        mSongAdapter = new SongAdapter(this, mSongs);
        Log.d("RecyclerViewActivity", "Số lượng bài hát trước khi setAdapter: " + mSongs.size());
        mSongAdapter.notifyDataSetChanged();
        rvSongs.setAdapter(mSongAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvSongs.setLayoutManager(linearLayoutManager);
    }

}
