package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LabTestBookActivity extends AppCompatActivity {

    EditText edname, edaddress, edcontact,edpincode;
    Button btnBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_book);

        edname = findViewById(R.id.editTextLTBFullName);
        edaddress = findViewById(R.id.editTextLTBAddress);
        edpincode = findViewById(R.id.editTextLTBPinCode);
        edcontact = findViewById(R.id.editTextLTBPhoneNumber);
        btnBooking = findViewById(R.id.buttonLTBBook);

       Intent intent=getIntent();
       String[] price = intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
       String date  = intent.getStringExtra("date");
       String time  = intent.getStringExtra("time");

       btnBooking.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
               String username = sharedpreferences.getString("username","").toString();

               Database db = new Database(getApplicationContext(),"healthcare",null,1);
               db.addOrder(username,edname.getText().toString(),edaddress.getText().toString(),edcontact.getText().toString(),Integer.parseInt(edpincode.getText().toString()),date.toString(),time.toString(),Float.parseFloat(price[1].toString()),"lab");
               db.removeCart(username,"lab");
               Toast.makeText(getApplicationContext(), "You have successfully ordered", Toast.LENGTH_SHORT).show();
               startActivity( new Intent(LabTestBookActivity.this, HomeActivity.class));
           }
       });
    }
}