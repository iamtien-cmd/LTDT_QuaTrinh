package vn.iostar.tuan5.GridView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

import vn.iostar.tuan5.R;

public class GridViewActivity extends AppCompatActivity {
    // Khai báo biến toàn cục
    GridView gridView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    EditText editText1;
    Button btnNhap, btnCapnhat;
    private int vitri = -1; // Biến lưu vị trí

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview); // Đặt đúng file XML của bạn

        // Ánh xạ View
        gridView = findViewById(R.id.gridview1);
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

        // Khởi tạo Adapter và truyền dữ liệu
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        gridView.setAdapter(adapter); // Gán adapter cho GridView

        // Xử lý khi click vào item trong GridView
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                vitri = i; // Lưu vị trí được chọn
                String monHoc = arrayList.get(i); // Lấy đối tượng tại vị trí i
                editText1.setText(monHoc); // Lấy tên môn học để hiển thị
                Toast.makeText(GridViewActivity.this, "Chọn: " + monHoc, Toast.LENGTH_SHORT).show();
            }
        });

        // Xử lý thêm dữ liệu vào GridView
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText1.getText().toString();
                if (!name.isEmpty()) {
                    arrayList.add(name);
                    adapter.notifyDataSetChanged(); // Cập nhật giao diện
                    editText1.setText(""); // Xóa nội dung EditText
                } else {
                    Toast.makeText(GridViewActivity.this, "Vui lòng nhập tên!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Xử lý cập nhật dữ liệu
        btnCapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vitri != -1) { // Kiểm tra xem có chọn vị trí nào chưa
                    String name = editText1.getText().toString();
                    if (!name.isEmpty()) {
                        arrayList.set(vitri, name); // Cập nhật giá trị
                        adapter.notifyDataSetChanged();
                        editText1.setText("");
                        vitri = -1; // Reset lại vị trí
                    } else {
                        Toast.makeText(GridViewActivity.this, "Vui lòng nhập tên!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(GridViewActivity.this, "Vui lòng chọn một mục để cập nhật!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
