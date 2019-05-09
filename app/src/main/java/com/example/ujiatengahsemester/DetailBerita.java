package com.example.ujiatengahsemester;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailBerita extends AppCompatActivity {

    TextView nama, posisi, lokasi, lastupdt, desc, senior, employment, func, about;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jobdetail_layout);

        Bundle extras = getIntent().getExtras();
        nama = findViewById(R.id.company_name);
        posisi = findViewById(R.id.position);
        lokasi = findViewById(R.id.location);
        lastupdt = findViewById(R.id.time);
        desc = findViewById(R.id.jobdesc);
        senior = findViewById(R.id.joblevel);
        employment = findViewById(R.id.jobemptype);
        func = findViewById(R.id.jobfunction);
        about = findViewById(R.id.jobcompanydesc);
        img = findViewById(R.id.companypicdetail);

        if(extras != null)
        {
            nama.setText(extras.getString("nama", ""));
            posisi.setText(extras.getString("posisi", ""));
            lokasi.setText(extras.getString("location", ""));
            lastupdt.setText(extras.getString("lastupdt", ""));
            desc.setText(extras.getString("deskripsi", ""));
            senior.setText(extras.getString("level", ""));
            employment.setText(extras.getString("type", ""));
            func.setText(extras.getString("func", ""));
            about.setText(extras.getString("about", ""));
            new getimageurl(img).execute(extras.getString("img",""));
        }
    }
}
