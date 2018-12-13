package com.reynaldiwijaya.belajarintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.reynaldiwijaya.belajarintent.MainActivity.EXTRA_DATA;

public class PindahCallBack extends AppCompatActivity {

    @BindView(R.id.btnCallBack)
    Button btnCallBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pindah_call_back);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btnCallBack)
    public void onViewClicked() {
        //TODO Membuat Intent
        Intent pindah = new Intent();
        //TODO Memasukan data ke intent
        pindah.putExtra(EXTRA_DATA, "Ini adalah data dari CallBack");
        //TODO set result untuk memberitahu bahwa result OKE
        setResult(Activity.RESULT_OK,pindah);
        //TODO Mendestroy Activity Pindah CallBack
        finish();


    }
}
