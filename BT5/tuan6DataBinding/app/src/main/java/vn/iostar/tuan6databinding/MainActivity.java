package vn.iostar.tuan6databinding;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import vn.iostar.tuan6databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private UserModel userModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        userModel = new UserModel("Hue", "Tien");
        binding.setUser(userModel);
        //Thêm để tự cập nhật;
        userModel.setFirstName("Vinh");
        userModel.setLastName("Hien");
    }

}
