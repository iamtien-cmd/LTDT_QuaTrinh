package vn.iostar.tuan5.GridView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import vn.iostar.tuan5.R;

public class CustomAdapterGridViewActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<MonHocGridView> arrayList;
    MonhocAdapterGridView adapter;
    EditText editText1;
    Button btnNhap, btnCapNhat;
    int vitri = -1; // Biến lưu vị trí item được chọn

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview); // Đảm bảo tên file XML đúng

        // Ánh xạ view và khởi tạo dữ liệu
        AnhXa();

        // Xử lý sự kiện nút bấm
        btnNhap.setOnClickListener(v -> themMonHoc());
        btnCapNhat.setOnClickListener(v -> capNhatDanhSach());

        // Xử lý sự kiện chọn item trên GridView
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                vitri = position;
                MonHocGridView monHoc = arrayList.get(position);
                editText1.setText(monHoc.getName()); // Hiển thị tên lên EditText
            }
        });
    }

    private void AnhXa() {
        gridView = findViewById(R.id.gridview1);
        editText1 = findViewById(R.id.editText1);
        btnNhap = findViewById(R.id.btnNhap);
        btnCapNhat = findViewById(R.id.btnCapNhat);

        // Khởi tạo danh sách môn học
        arrayList = new ArrayList<>();
        arrayList.add(new MonHocGridView("Java", "Lập trình Java", R.drawable.java1));
        arrayList.add(new MonHocGridView("C#", "Lập trình C#", R.drawable.c));
        arrayList.add(new MonHocGridView("PHP", "Lập trình PHP", R.drawable.php));
        arrayList.add(new MonHocGridView("Kotlin", "Lập trình Kotlin", R.drawable.kotlin));
        arrayList.add(new MonHocGridView("Dart", "Lập trình Dart", R.drawable.dart));

        // Khởi tạo Adapter và gán vào GridView
        adapter = new MonhocAdapterGridView(this, R.layout.row_monhocgridview, arrayList);
        gridView.setAdapter(adapter);
    }

    private void themMonHoc() {
        String tenMonHoc = editText1.getText().toString().trim();

        if (tenMonHoc.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập tên môn học!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Thêm vào danh sách (dùng icon mặc định)
        arrayList.add(new MonHocGridView(tenMonHoc, "Mô tả mới", R.drawable.dart));

        // Cập nhật GridView
        adapter.notifyDataSetChanged();
        editText1.setText(""); // Xóa nội dung sau khi nhập
    }

    private void capNhatDanhSach() {
        if (vitri != -1) { // Kiểm tra xem có chọn vị trí nào chưa
            String name = editText1.getText().toString().trim();
            if (!name.isEmpty()) {
                MonHocGridView monHoc = arrayList.get(vitri);
                monHoc.setName(name); // Cập nhật tên môn học

                adapter.notifyDataSetChanged(); // Cập nhật GridView
                editText1.setText("");
                vitri = -1; // Reset lại vị trí

                Toast.makeText(this, "Cập nhật thành công!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Vui lòng nhập tên!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Vui lòng chọn một mục để cập nhật!", Toast.LENGTH_SHORT).show();
        }
    }
}
