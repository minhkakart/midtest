package com.minhkakart.midtest1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.minhkakart.midtest1.activities.ProductActivity;
import com.minhkakart.midtest1.activities.SignUpActivity;
import com.minhkakart.midtest1.database.DataBaseHelper;
import com.minhkakart.midtest1.models.UserModel;

public class MainActivity extends AppCompatActivity {
    EditText etUsername, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etUsername = findViewById(R.id.usernameLogin);
        etPassword = findViewById(R.id.passwordLogin);
        btnLogin = findViewById(R.id.buttonLogin);
        Button btnSignUp = findViewById(R.id.btnSignup);

        btnSignUp.setOnClickListener(v -> {
            startActivity(new Intent(this, SignUpActivity.class));
        });

        btnLogin.setOnClickListener(v -> {
            login();
        });

    }

    public void login() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
        UserModel user = dataBaseHelper.findUser(username, password);

        if (user != null) {
            // login success
            Toast.makeText(this, "Login Successfully. Employee: " + user.getName(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ProductActivity.class);
            startActivity(intent);
        } else {
            // login failed
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }

    }

}