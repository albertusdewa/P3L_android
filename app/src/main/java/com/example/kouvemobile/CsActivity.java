package com.example.kouvemobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CsActivity extends AppCompatActivity implements View.OnClickListener {
    TextView nama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs);

        Button btnKelolaCst = findViewById(R.id.kelolacst_btn);
        btnKelolaCst.setOnClickListener(this);

        Button btnLogout = findViewById(R.id.logout_btn);
        btnLogout.setOnClickListener(this);

        SharedPreferences sp = getSharedPreferences("login", MODE_PRIVATE);

        String mnama = sp.getString("name","");
        nama = findViewById(R.id.nama_cs);
        nama.setText(mnama);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.kelolacst_btn:
                Intent kelolacst = new Intent(CsActivity.this, PengCustActivity.class);
                startActivity(kelolacst);
                break;

            case R.id.logout_btn:
                SharedPreferences sp = getSharedPreferences("login", MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();
                ed.putString("login_cred", "null");
                ed.apply();

                finish();
                startActivity(new Intent(CsActivity.this, MainActivity.class));
                break;
        }
    }
}