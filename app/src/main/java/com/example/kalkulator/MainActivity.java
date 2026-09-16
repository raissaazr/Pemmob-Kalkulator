package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Deklarasi widget
    private EditText etAngka1, etAngka2;
    private TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hubungkan widget XML ke objek Java lewat findViewById()
        etAngka1 = findViewById(R.id.etAngka1);
        etAngka2 = findViewById(R.id.etAngka2);
        tvHasil = findViewById(R.id.tvHasil);
    }

    private double[] ambilAngka() {
        String input1 = etAngka1.getText().toString();
        String input2 = etAngka2.getText().toString();

        if (input1.isEmpty() || input2.isEmpty()) {
            Toast.makeText(this, "Isi kedua angka terlebih dahulu", Toast.LENGTH_SHORT).show();
            return null;
        }

        double a = Double.parseDouble(input1);
        double b = Double.parseDouble(input2);
        return new double[]{a, b};
    }

    public void tambah(View v) {
        double[] angka = ambilAngka();
        if (angka == null) return;
        double hasil = angka[0] + angka[1];
        tvHasil.setText("Hasil: " + hasil);
    }

    public void kurang(View v) {
        double[] angka = ambilAngka();
        if (angka == null) return;
        double hasil = angka[0] - angka[1];
        tvHasil.setText("Hasil: " + hasil);
    }

    public void kali(View v) {
        double[] angka = ambilAngka();
        if (angka == null) return;
        double hasil = angka[0] * angka[1];
        tvHasil.setText("Hasil: " + hasil);
    }

    public void bagi(View v) {
        double[] angka = ambilAngka();
        if (angka == null) return;
        if (angka[1] == 0) {
            Toast.makeText(this, "Tidak bisa membagi dengan nol", Toast.LENGTH_SHORT).show();
            return;
        }
        double hasil = angka[0] / angka[1];
        tvHasil.setText("Hasil: " + hasil);
    }

    // Dipanggil dari android:onClick="modulus" pada btnModulus
    public void modulus(View v) {
        double[] angka = ambilAngka();
        if (angka == null) return;
        if (angka[1] == 0) {
            Toast.makeText(this, "Tidak bisa modulus dengan nol", Toast.LENGTH_SHORT).show();
            return;
        }
        double hasil = angka[0] % angka[1];
        tvHasil.setText("Hasil: " + hasil);
    }
}