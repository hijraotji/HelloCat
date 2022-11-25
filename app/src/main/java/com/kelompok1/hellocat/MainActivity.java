package com.kelompok1.hellocat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] dataName;
    private TypedArray datapoto;
    private Koneksi koneksi;
    private ArrayList<Gambar> heroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        koneksi = new Koneksi(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(koneksi);

        prepare();
        additem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                if (position == 0) {
                    startActivity(new Intent(MainActivity.this, Whiskas.class));
                } else if (position == 1) {
                    startActivity(new Intent(MainActivity.this, Felibite.class));
                } else if (position == 2) {
                    startActivity(new Intent(MainActivity.this, Bolt.class));
                }
            }
        });
    }
    private void additem() {
        heroes = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Gambar hero = new Gambar();
            hero.setPhoto(datapoto.getResourceId(i, -1));
            hero.setNama(dataName[i]);
            heroes.add(hero);
        }
        koneksi.setHeroes(heroes);
    }
    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        datapoto = getResources().obtainTypedArray(R.array.datapoto);
    }
}