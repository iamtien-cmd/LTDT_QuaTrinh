package vn.iostar.tuan5.ListView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import vn.iostar.tuan5.R;

public class MainActivity extends AppCompatActivity {
    // Khai báo
    private ListView listView;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    private EditText editText1;
    private Button btnNhap, btnCapnhat;
    private int vitri = -1; // Vị trí mặc định không hợp lệ

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View mainView = findViewById(R.id.main);
        ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
            WindowInsetsCompat systemBars = insets;
            v.setPadding(systemBars.getInsets(WindowInsetsCompat.Type.systemBars()).left,
                    systemBars.getInsets(WindowInsetsCompat.Type.systemBars()).top,
                    systemBars.getInsets(WindowInsetsCompat.Type.systemBars()).right,
                    systemBars.getInsets(WindowInsetsCompat.Type.systemBars()).bottom);
            return insets;
        });

        // Ánh xạ
        listView = findViewById(R.id.listview1);
        editText1 = findViewById(R.id.editText1);
        btnNhap = findViewById(R.id.btnNhap);
        btnCapnhat = findViewById(R.id.btnCapNhat);

        // Thêm dữ liệu vào List
        arrayList = new ArrayList<>();
        arrayList.add("Java");
        arrayList.add("C#");
        arrayList.add("PHP");
        arrayList.add("Kotlin");
        arrayList.add("Dart");

        // Tạo ArrayAdapter
        adapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrayList
        );
        listView.setAdapter(adapter);

        // Bắt sự kiện click trên từng dòng của ListView
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            // Lấy nội dung đổ lên EditText
            editText1.setText(arrayList.get(i));
            vitri = i;
        });

        // Xử lý sự kiện khi nhấn nút "Thêm"
        btnNhap.setOnClickListener(view -> {
            String name = editText1.getText().toString().trim();
            if (!name.isEmpty()) {
                arrayList.add(name);
                adapter.notifyDataSetChanged();
                editText1.setText(""); // Xóa nội dung EditText sau khi nhập
            } else {
                Toast.makeText(MainActivity.this, "Vui lòng nhập tên!", Toast.LENGTH_SHORT).show();
            }
        });

        // Xử lý sự kiện khi nhấn nút "Cập nhật"
        btnCapnhat.setOnClickListener(view -> {
            if (vitri != -1) { // Kiểm tra xem đã chọn phần tử chưa
                arrayList.set(vitri, editText1.getText().toString().trim());
                adapter.notifyDataSetChanged();
                editText1.setText(""); // Xóa nội dung EditText
                vitri = -1; // Reset vị trí sau khi cập nhật
            } else {
                Toast.makeText(MainActivity.this, "Vui lòng chọn một mục để cập nhật!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
