package com.reynaldiwijaya.belajarintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    public static final int REQUEST_CODE = 1;
    public static final String EXTRA_DATA = "data";
    @BindView(R.id.btnPindahHalaman)
    Button btnPindahHalaman;
    @BindView(R.id.btnPindahBawaData)
    Button btnPindahBawaData;
    @BindView(R.id.btnPindahBawaObjek)
    Button btnPindahBawaObjek;
    @BindView(R.id.btnPindahCallPhone)
    Button btnPindahCallPhone;
    @BindView(R.id.btnPindahEmail)
    Button btnPindahEmail;
    @BindView(R.id.btnPindahCallBack)
    Button btnPindahCallBack;
    public static final String nama = "nama";
    public static final String umur = "umur";
    public static final String berat = "berat";
    public static final String status = "status";
    public static final String jenisKelamin = "jenisKelamin";
    public static final String OBJ = "OBJ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnPindahHalaman, R.id.btnPindahBawaData, R.id.btnPindahBawaObjek, R.id.btnPindahCallPhone, R.id.btnPindahEmail, R.id.btnPindahCallBack})
    public void onViewClicked(View view) {
        Intent pindah;
        switch (view.getId()) {
            //TODO Membuat object intent untuk berpindah ke activity tujuan
            case R.id.btnPindahHalaman:
               pindah = new Intent(MainActivity.this, PindahHalaman.class);
                startActivity(pindah);
                break;
            case R.id.btnPindahBawaData:
                pindah = new Intent(MainActivity.this,PindahBawaData.class);
                //TODO Mengisi data ke Intent
                pindah.putExtra(nama,"Reynaldi Wijaya");
                pindah.putExtra(umur, 16);
                pindah.putExtra(berat,55.0);
                pindah.putExtra(status, false);
                pindah.putExtra(jenisKelamin,true);
                startActivity(pindah);
                break;
            case R.id.btnPindahBawaObjek:
                //TODO membuat objek dari class Person
                Person person = new Person();

                //TODO Masukan data kedalam Objek
                person.setNama("Reynaldi Wijaya(David Beckham)");
                person.setAge(16);
                person.setAlamat("Jl.Venus Taman Kutabumi Blok D5/3, Tangerang");
                person.setAsal("Tangerang");
                person.setPekerjaan("Student");

                //TODO Membuat object Intent untuk berpindah activity tujuan
                pindah = new Intent(MainActivity.this,PindahBawaObjek.class);

                //TODO Mengisikan Object person kedalam Intent
                pindah.putExtra(OBJ,person);
                startActivity(pindah);
                break;
            case R.id.btnPindahCallPhone:
                //TODO Membuat variable untuk menampung no Hp yang kita inginkan
                String noTelp = "081288825005";

                //TODO Membuat Object Intent untuk memanggil Intent telpon
                pindah = new Intent(Intent.ACTION_DIAL);

                //TODO Menset no telp ke dalam Intent
                pindah.setData(Uri.parse("tel: " + noTelp));

                //TODO menjalankan Intent
                startActivity(pindah);
                break;
            case R.id.btnPindahEmail:
                //TODO Me=uat Intent Untuk memanggil Email
                pindah = new Intent(Intent.ACTION_SENDTO,Uri.fromParts("mailto","reynaldiwijaya2306@gmail.com",null));

                //TODO memasukkan subject dan isi pesan de dalam Intent
                pindah.putExtra(Intent.EXTRA_SUBJECT,"Surat Diterimanya Kerja di Google");
                pindah.putExtra(Intent.EXTRA_TEXT,"Selamat, anda dinyatakan diterima untuk bekerja di Google, USA." + "\nAnda juga mendapatkan beasiswa penuh untuk kuliah di MIT");

                //TODO Mencek apakah user memiliki aplikasi email
                if (pindah.resolveActivity(getPackageManager()) != null){
                    startActivity(Intent.createChooser(pindah,"Pilih Email Client"));
                }else{
                    //TODO Menampilkan pesan dengan toast
                    Toast.makeText(MainActivity.this,"Donwload dlu tong aplikasi email, masa Google ga punya aplikasi email, ga punya atau ga ada kuota, malu dong!!!", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btnPindahCallBack:
                //TODO membuat object Intent untuk berpindah ke halaman tujuan
                pindah = new Intent(this, PindahCallBack.class);

                //TODO Jalankan Intent dan membawa name key untuk request data
                startActivityForResult(pindah, REQUEST_CODE);

                break;
        }
    }
//TODO Membuat method dengan cara Control + O
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //TODO Mencek Request Code apakah sama dengan yang dikirimkan
        if (requestCode == REQUEST_CODE){
            //TODO Mencek apakah requestCode nya itu apakah Ok
            if (resultCode == RESULT_OK){
                //TODO Menampung data dari callBack
                String menampilkanData = data.getStringExtra(EXTRA_DATA);
                //TODO Menampilkan data ke Toast
                Toast.makeText(this,"Ini data callback nya adalah" + menampilkanData, Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"Tidak ada hasil", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
