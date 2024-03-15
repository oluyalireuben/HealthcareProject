package com.example.healthcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.HashMap;

public class AdminDashboardActivity extends AppCompatActivity {

    private String[][] order_details = {};

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        lst = findViewById(R.id.listViewOD);


        Database db = new Database(getApplicationContext(),"healthcare",null,1);
        SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedpreferences.getString("username","").toString();
        ArrayList dbData = db.getOrderData(username);

        order_details = new String[dbData.size()][];
        for (int i=0;i<order_details.length;i++) {
            order_details[i] = new String[5];
            String arrData = dbData.get(i).toString();
            String[] strData = arrData.split(java.util.regex.Pattern.quote("$"));
            order_details[i][0] = strData[0];
            order_details[i][1] = strData[1];//+" "+StrData[3];
            if (strData[7].compareTo("medicine") == 0) {
                order_details[i][3] = "Deliver on:" + strData[4];
            } else {
                order_details[i][3] = "Deliver on:" + strData[4] + " "+"At" + " "+strData[5];
            }
            order_details[i][2] = "Total Paid." + strData[6];
            order_details[i][4] = strData[7];
        }

        list = new ArrayList();
        for(int i=0;i<order_details.length;i++) {
            item = new HashMap<String, String>();
            item.put("line1", order_details[i][0]);
            item.put("line2", order_details[i][1]);
            item.put("line3", order_details[i][2]);
            item.put("line4", order_details[i][3]);
            item.put("line5", order_details[i][4]);
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        lst.setAdapter(sa);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navHome:
                            // Start HomeActivity or perform relevant action
                            startActivity(new Intent(AdminDashboardActivity.this, AdminDashboardActivity.class));
                            Toast.makeText(AdminDashboardActivity.this, "Home", Toast.LENGTH_SHORT).show();
                            return true;
                        case R.id.navdocs:
                            // Start ProfileActivity or perform relevant action
                            startActivity(new Intent(AdminDashboardActivity.this, MainActivity.class));
                            Toast.makeText(AdminDashboardActivity.this, "View Fellow Doctors", Toast.LENGTH_SHORT).show();
                            return true;

                        case R.id.navChat:
                            startActivity(new Intent(AdminDashboardActivity.this, Chats.class)
                                    .putExtra("is_viewing_as_doctor" , true));
                            return true;

                        case R.id.navLogout:
                            // Sign out the user from Firebase Authentication
                            FirebaseAuth.getInstance().signOut();

                            // Start LoginActivity or perform relevant action
                            startActivity(new Intent(AdminDashboardActivity.this, LoginActivity.class));

                            Toast.makeText(AdminDashboardActivity.this, "You have successfully logged out", Toast.LENGTH_SHORT).show();
                            finish();
                    }
                    finish();
                    return false;
                }
            };

}