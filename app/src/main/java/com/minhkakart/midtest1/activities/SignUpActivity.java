package com.minhkakart.midtest1.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.minhkakart.midtest1.R;
import com.minhkakart.midtest1.database.DataBaseHelper;
import com.minhkakart.midtest1.models.UserModel;

public class SignUpActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword, edtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnSignUp = findViewById(R.id.btnSignUp);
        edtUsername = findViewById(R.id.usernameSignUp);
        edtPassword = findViewById(R.id.passwordSignUp);
        edtName = findViewById(R.id.employeeNameSignUp);

        btnSignUp.setOnClickListener(v -> {
            signUp();
        });

    }

    private void signUp(){
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();
        String name = edtName.getText().toString();

        UserModel userModel = new UserModel(username, password, name);

        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
        long result = dataBaseHelper.addUser(userModel);
        if (result > 0){
            finish();
        } else {
            // show error
            Toast.makeText(this, "SignUp failed!", Toast.LENGTH_SHORT).show();
        }
    }

}