package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Reuben Oluyali", "Hospital Address : Nairobi", "Exp : 15yrs", "Mobile No:0792744763","2500"},
                    {"Doctor Name : Cleophas Mochoge", "Hospital Address : Nakuru", "Exp : 13yrs", "Mobile No:0714228749","2000"},
                    {"Doctor Name : Ian Ambula", "Hospital Address : Kitale", "Exp : 8yrs", "Mobile No:0790074955","1800"},
                    {"Doctor Name : Josephat Omolo", "Hospital Address : Kisumu", "Exp : 13yrs", "Mobile No:0724949342","2000"},
                    {"Doctor Name : Samuel Amala", "Hospital Address : Kakamega", "Exp : 14yrs", "Mobile No:0769319921","2300"},
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Deborah Adhiambo", "Hospital Address : Kajiado", "Exp : 15yrs", "Mobile No:0721577451","2500"},
                    {"Doctor Name : Lokol Ekitela", "Hospital Address : Kabarak", "Exp : 13yrs", "Mobile No:0714228749","2000"},
                    {"Doctor Name : Sharon Chebet", "Hospital Address : Kericho", "Exp : 8yrs", "Mobile No:0790074955","1800"},
                    {"Doctor Name : Ballack Esuron", "Hospital Address : Transnzoia", "Exp : 13yrs", "Mobile No:0724949342","2000"},
                    {"Doctor Name : David Rimao", "Hospital Address : Lodwar", "Exp : 14yrs", "Mobile No:0769319921","2300"},
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : David Eripon", "Hospital Address : Kibish", "Exp : 15yrs", "Mobile No:0721577451","2500"},
                    {"Doctor Name : Milton Omolo", "Hospital Address : Vihiga", "Exp : 13yrs", "Mobile No:0714228749","2000"},
                    {"Doctor Name : David Nasilo", "Hospital Address : Lokori", "Exp : 8yrs", "Mobile No:0790074955","1800"},
                    {"Doctor Name : Alex Lokwawi", "Hospital Address : TransAfrica", "Exp : 13yrs", "Mobile No:0724949342","2000"},
                    {"Doctor Name : Zephaniah Best", "Hospital Address : GreatRift", "Exp : 14yrs", "Mobile No:0769319921","2300"},
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Brother Alex", "Hospital Address : Nakwamekwi", "Exp : 15yrs", "Mobile No:0721577451","2500"},
                    {"Doctor Name : Loice Awoton", "Hospital Address : Kilifi", "Exp : 13yrs", "Mobile No:0714228749","2000"},
                    {"Doctor Name : Faith Kamar", "Hospital Address : Nairobi", "Exp : 8yrs", "Mobile No:0790074955","1800"},
                    {"Doctor Name : Bethany Ewoi", "Hospital Address : Machakos", "Exp : 13yrs", "Mobile No:0724949342","2000"},
                    {"Doctor Name : Moses Amoni", "Hospital Address : Nandi", "Exp : 14yrs", "Mobile No:0769319921","2300"},
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Kevin Elaar", "Hospital Address : Salga", "Exp : 15yrs", "Mobile No:0721577451","2500"},
                    {"Doctor Name : Magdalene Lotwei", "Hospital Address : Mombasa", "Exp : 13yrs", "Mobile No:0714228749","2000"},
                    {"Doctor Name : Freddy Daktari", "Hospital Address : Eldoret", "Exp : 8yrs", "Mobile No:0790074955","1800"},
                    {"Doctor Name : MarryAnne Atiir", "Hospital Address : Coast", "Exp : 13yrs", "Mobile No:0724949342","2000"},
                    {"Doctor Name : Reuben Omolo", "Hospital Address : South DG", "Exp : 14yrs", "Mobile No:0769319921","2300"},
            };
    TextView tv, tv1;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        tv1 = findViewById(R.id.textViewProfiles);
        btn = findViewById(R.id.buttonLDAddToCart);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if (title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if (title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if (title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, MainActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees"+" "+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}