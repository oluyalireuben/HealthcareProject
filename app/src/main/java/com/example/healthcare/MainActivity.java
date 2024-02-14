package com.example.healthcare;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);



        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Reuben Oluyali","oluyali@kabarak.ac.ke \nExp : 15yrs\nMobile No: 0792744763\nSpecialization: Family Physician \nEducation: Harvard Medical School \nAchievements: Board Certification \nAvailability: onsite",R.drawable.oluyali));
        items.add(new Item("Cleophas Mochoge","cleomochoge@gmail.com\nExp : 13yrs\nMobile No: 0714228749\nSpecialization: Family Physician \nEducation: Kigali University \nAchievements: Clinical Excellence Awards \nAvailability: onsite",R.drawable.dokta7));
        items.add(new Item("Ian Ambula","ian@gmail.com\nExp : 8yrs\nMobile No: 0790074955\nSpecialization: Family Physician \nEducation: Kabarak University \nAchievements: Research Grants \nAvailability: onsite",R.drawable.docc));
        items.add(new Item("Josephat Omolo","omolo@yahoo.com\nExp : 13yrs\nMobile No: 0724949342\nSpecialization: Family Physician \nEducation: University of Oxford \nAchievements: Leadership Roles \nAvailability: onsite",R.drawable.dokta4));
        items.add(new Item("Samuel Amala","sam.mouse@email.com\nExp : 14yrs\nMobile No: 0769319921\nSpecialization: Family Physician \nEducation: Johns Hopkins University \nAchievements: Community Service Awards \nAvailability: onsite",R.drawable.dokta5));
        items.add(new Item("Deborah Adhiambo","deborah@jkuut.ac.ke\nExp : 15yrs\nMobile No: 0721577451\nSpecialization: Dietician \nEducation: University of Tokyo \nAchievements: Fellowships \nAvailability: onsite",R.drawable.dokta));
        items.add(new Item("Lokol Ekitela","lokol.piece@email.com\nExp : 13yrs\nMobile No: 0714228749\nSpecialization: Dietician \nEducation: University of Melbourne \nAchievements: Presentations at Conferences \nAvailability: onsite",R.drawable.g));
        items.add(new Item("Sharon Chebet","sharon-chebet@email.com\nExp : 18yrs\nMobile No: 0790074955\nSpecialization: Dietician \nEducation: India Institute of Medical Sciences \nAchievements: Innovation in Patient Care \nAvailability: onsite",R.drawable.c));
        items.add(new Item("Ballack Esuron","ballack.wick@gmail.com\nExp : 13yrs\nMobile No: 0724949342\nSpecialization: Dietician \nEducation: University of Toronto \nAchievements: Teaching Awards \nAvailability: onsite",R.drawable.a));
        items.add(new Item("David Rimao","robert.j@email.com\nExp : 14yrs\nMobile No: 0769319921\nSpecialization: Dietician\nEducation: Peking University \nAchievements: Clinical Excellence Awards \nAvailability: onsite",R.drawable.b));
        items.add(new Item("David Eripon","david@gmail.com\nExp : 15yrs\nMobile No: 0721577451\nSpecialization: Dentist \nEducation: University of Cape Town \nAchievements: Community Service Awards \nAvailability: onsite",R.drawable.c));
        items.add(new Item("Milton Omolo","milton.tales@email.com\nExp : 13yrs\nMobile No: 0714228749\nSpecialization: Dentist \nEducation: University of Nairobi \nAchievements: Board Certification  \nAvailability: onsite",R.drawable.d));
        items.add(new Item("David Nasilo","nasilo.mouse@email.com\nExp : 8yrs\nMobile No: 0790074955\nSpecialization: Dentist \nEducation: Jomo Kentatta University\nAchievements: Teaching Awards \nAvailability: onsite",R.drawable.e));
        items.add(new Item("Alex Lokwawi","lokwawi.war@email.com\nExp : 13yrs\nMobile No: 0724949342\nSpecialization: Dentist \nEducation: Laikipia University \nAchievements: Board Certification  \nAvailability:onsite",R.drawable.f));
        items.add(new Item("Zephaniah Best","zephan.piece@email.com\nExp : 14yrs\nMobile No: 0769319921\nSpecialization: Dentist \nEducation: Maseno University \nAchievements: Community Service Awards \nAvailability: onsite",R.drawable.d));
        items.add(new Item("Brother Alex","alex@gmail.com\nExp : 15yrs\nMobile No: 0721577451\nSpecialization: Surgeon \nEducation: kabarak University \nAchievements: Leadership Roles  \nAvailability: onsite",R.drawable.b));
        items.add(new Item("Loice Awoton","loice@kabarak.ac.ke\nExp : 13yrs\nMobile No: 0714228749\nSpecialization: Surgeon \nEducation: Harvard University \nAchievements: Community Service Awards \nAvailability: onsite",R.drawable.c));
        items.add(new Item("Faith Kamar","faithkamar@yahoo.com\nExp : 8yrs\nMobile No: 0790074955\nSpecialization: Surgeon \nEducation: University of California \nAchievements: Teaching Awards \nAvailability: onsite",R.drawable.h));
        items.add(new Item("Bethany Ewoi","bethany.org\nExp : 13yrs\nMobile No: 0724949342\nSpecialization: Surgeon \nEducation: Makerere University \nAchievements: Leadership Roles  \nAvailability: onsite",R.drawable.g));
        items.add(new Item("Moses Amoni","amoni@gmail.com\nExp : 14yrs\nMobile No: 0769319921\nSpecialization: Surgeon \nEducation: Jkuat University \nAchievements: Leadership Roles  \nAvailability: onsite",R.drawable.f));
        items.add(new Item("Kevin Elaar","elaar@gmail.com\nExp : 15yrs\nMobile No: 0721577451\nSpecialization: Cardiologist \nEducation: KMTC Kitale \nAchievements: Community Service Awards \nAvailability: onsite",R.drawable.e));
        items.add(new Item("Magdalene Lotwei","lotwei@kabarak.ac.ke\nExp : 13yrs\nMobile No: 0714228749\nSpecialization: Cardiologist \nEducation: KMTC Nakuru \nAchievements: Presentations at Conferences \nAvailability: onsite",R.drawable.d));
        items.add(new Item("Freddy Daktari","freddy@mmust.ac.ke\nExp : 8yrs\nMobile No: 0790074955\nSpecialization: Cardiologist \nEducation: India Institute of Medical Sciences \nAchievements: Presentations at Conferences \nAvailability: onsite",R.drawable.c));
        items.add(new Item("MarryAnne Atiir","atiir@gmail.com\nExp : 13yrs\nMobile No: 0724949342\nSpecialization: Cardiologist \nEducation: University of Nairobi \nAchievements: Community Service Awards\nAvailability: onsite",R.drawable.b));
        items.add(new Item("Reuben Omolo","reuomolo@gmail.com\nExp : 14yrs\nMobile No: 0769319921\nSpecialization: Cardiologist \nEducation: University of China \nAchievements: Teaching Awards \nAvailability: onsite",R.drawable.a));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));

    }
}