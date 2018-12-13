package com.reynaldiwijaya.belajarintent;

import android.content.PeriodicSync;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PindahBawaObjek extends AppCompatActivity {

    @BindView(R.id.txtIsiData)
    TextView txtIsiData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pindah_bawa_objek);
        ButterKnife.bind(this);

        //TODO Membuat variable untuk menampung object dari Intent sebelumnya
        Person person = getIntent().getParcelableExtra(MainActivity.OBJ);

        //TODO Membuat variable penampung data dari dalam object person
        String isiData = "Nama: " + person.getNama() + "\nUmur: " + person.getAge() + "\nAlamat: " + person.getAlamat() + "\nAsal: " + person.getAsal() + "\nPekerjaan: " + person.getPekerjaan();

        //TODO Menampilkan data ke widget textView
        txtIsiData.setText(isiData);
    }
}
