package com.reynaldiwijaya.belajarintent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PindahBawaData extends AppCompatActivity {

    @BindView(R.id.txtData)
    TextView txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pindah_bawa_data);
        ButterKnife.bind(this);

        //TODO Membuat variable penampung dan mengisinya dengan data dari Intent
        //TODO membuat variable String dan mengambil data dari Intent dengan tipe data String
        String nama = getIntent().getStringExtra(MainActivity.nama);
        //TODO membuat variable Int dan mengambil data dari Intent dengan tipe data Int
        Integer umur = getIntent().getIntExtra(MainActivity.umur,0);
        //TODO membuat variable Double dan mengambil data dari Intent dengan tipe data Double
        Double berat = getIntent().getDoubleExtra(MainActivity.berat, 0);
        //TODO membuat variable Boolean dan mengambil data dari Intent dengan tipe data Boolean
        Boolean jenis_kelamin = getIntent().getBooleanExtra(MainActivity.jenisKelamin, true);

        //TODO mengeset text ke dalam widget TExtView
        txtData.setText("Nama: " + nama + "\n" + "Umur: " + umur + "\n" + "Berat Badan: " + berat + "\n" + "Jenis Kelamin: " + jenis_kelamin);

    }
}