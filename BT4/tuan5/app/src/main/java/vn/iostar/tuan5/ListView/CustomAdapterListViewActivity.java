package vn.iostar.tuan5.ListView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import vn.iostar.tuan5.R;

public class CustomAdapterListViewActivity extends AppCompatActivity {
    private ListView listView;
    private EditText editText1;
    private Button btnNhap, btnCapNhat;
    private ArrayList<MonHoc> arrayList;
    private MonhocAdapter adapter;
    private int vitri = -1; // Vị trí mặc định không hợp lệ

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ view
        listView = findViewById(R.id.listview1);
        editText1 = findViewById(R.id.editText1);
        btnNhap = findViewById(R.id.btnNhap);
        btnCapNhat = findViewById(R.id.btnCapNhat);

        // Khởi tạo dữ liệu
        arrayList = new ArrayList<>();
        arrayList.add(new MonHoc("Java", "Java 1", R.drawable.java1));
        arrayList.add(new MonHoc("C#", "C# 1", R.drawable.c));
        arrayList.add(new MonHoc("PHP", "PHP 1", R.drawable.php));
        arrayList.add(new MonHoc("Kotlin", "Kotlin 1", R.drawable.kotlin));
        arrayList.add(new MonHoc("Dart", "Dart 1", R.drawable.dart));

        // Tạo Adapter
        adapter = new MonhocAdapter(this, R.layout.row_monhoc, arrayList);
        listView.setAdapter(adapter);

        // Xử lý khi chọn một item trong ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Lấy nội dung đổ lên EditText
                editText1.setText(arrayList.get(i).getName());
                vitri = i;
            }
        });

        // Xử lý sự kiện khi nhấn nút "Thêm"
        btnNhap.setOnClickListener(view -> {
            String name = editText1.getText().toString().trim();
            if (!name.isEmpty()) {
                arrayList.add(new MonHoc(name, "Mô tả " + name, R.drawable.dart));
                adapter.notifyDataSetChanged();
                editText1.setText(""); // Xóa nội dung EditText sau khi nhập
            } else {
                Toast.makeText(CustomAdapterListViewActivity.this, "Vui lòng nhập tên môn học!", Toast.LENGTH_SHORT).show();
            }
        });

        // Xử lý sự kiện khi nhấn nút "Cập nhật"
        btnCapNhat.setOnClickListener(view -> {
            if (vitri != -1) { // Kiểm tra xem đã chọn phần tử chưa
                arrayList.get(vitri).setName(editText1.getText().toString().trim());
                adapter.notifyDataSetChanged();
                editText1.setText(""); // Xóa nội dung EditText
                vitri = -1; // Reset vị trí sau khi cập nhật
            } else {
                Toast.makeText(CustomAdapterListViewActivity.this, "Vui lòng chọn một môn học để cập nhật!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
