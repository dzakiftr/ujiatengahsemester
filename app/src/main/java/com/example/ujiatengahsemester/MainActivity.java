package com.example.ujiatengahsemester;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    AdapterList adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.list_job);

        adp = new AdapterList(this, R.layout.list_layout);
        lv.setAdapter(adp);

        datas();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DataJob data = (DataJob) parent.getAdapter().getItem(position);
                Intent intent = new Intent(MainActivity.this,DetailBerita.class);
                intent.putExtra("deskripsi",data.getDeskripsi());
                intent.putExtra("about",data.getAbout());
                intent.putExtra("level",data.getSenior());
                intent.putExtra("func",data.getFunc());
                intent.putExtra("image",data.getImageurl());
                intent.putExtra("type",data.getType());
                intent.putExtra("lastupdt",data.getLastupdt());
                intent.putExtra("location",data.getLokasi());
                intent.putExtra("posisi",data.getPosisi());
                intent.putExtra("nama",data.getPerusahaan());
                intent.putExtra("img",data.getImageurl());
                startActivity(intent);
            }
        });
    }

    private void datas()
    {
        ArrayList<DataJob> da = new ArrayList<>();
        DataJob dj1 = new DataJob();
        dj1.setPerusahaan("As Salam Company");
        dj1.setPosisi("Mentor Dakwah");
        dj1.setLokasi("Amman, Jordania");
        dj1.setLastupdt("10 menit yang lalu");
        dj1.setDeskripsi("Dibutuhkan Mentor Dakwah untuk membantu mahasiswa memahami agama.");
        dj1.setAbout("As Salam Company adalah perusahaan yang berjalan dibidang perbankan syariah..");
        dj1.setSenior("Senior Level");
        dj1.setType("Part Time");
        dj1.setFunc("Pendakwah");
        dj1.setImageurl("https://geotimes.co.id/wp-content/uploads/2018/01/dakwah-virtual.jpg");

        DataJob dj2 = new DataJob();
        dj2.setPerusahaan("Islamify");
        dj2.setPosisi("Muadzin");
        dj2.setLokasi("Deir Al Ahmar, Lebanon");
        dj2.setLastupdt("12 menit yang lalu");
        dj2.setDeskripsi("Dibutuhkan Muadzin untuk direkam suaranya");
        dj2.setAbout("Islamify adalah perusahaan yang bergerak di bidang Teknologi syariah");
        dj2.setSenior("Intermediate");
        dj2.setType("Part Time");
        dj2.setFunc("Voice Artist");
        dj2.setImageurl("https://image.shutterstock.com/image-vector/assalam-the-peace-asmaul-husna-450w-571070875.jpg");
        da.add(dj2);
        da.add(dj1);
        adp.addAll(da);
        adp.notifyDataSetChanged();
    }
}
