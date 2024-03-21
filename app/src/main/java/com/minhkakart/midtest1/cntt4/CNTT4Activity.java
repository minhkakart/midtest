package com.minhkakart.midtest1.cntt4;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.minhkakart.midtest1.R;

import java.util.ArrayList;
import java.util.List;

public class CNTT4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cntt4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        ListView lv = findViewById(R.id.lv_cntt4);
        List<String> list = new ArrayList<>();
        list.add("Lập trình hướng đối tượng");
        list.add("Cấu trúc dữ liệu và giải thuật");
        list.add("Cơ sở dữ liệu");
        list.add("Lập trình web");
        list.add("Lập trình di động");
        list.add("Mạng máy tính");
        list.add("Hệ điều hành");
        list.add("An toàn và bảo mật hệ thống");

        ListViewCNTT4Adapter adapter = new ListViewCNTT4Adapter(list);
        lv.setAdapter(adapter);

    }


}