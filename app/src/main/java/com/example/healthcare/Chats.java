package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthcare.adapters.FriendsAdapter;
import com.example.healthcare.databinding.ActivityChatsBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class Chats extends AppCompatActivity {

    private ActivityChatsBinding binding;
    private ArrayList<com.example.healthcare.User> users;

    private FriendsAdapter.OnUserClicked onUserClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        users = new ArrayList<>();

        boolean isViewingAsDoctor = getIntent().getBooleanExtra("is_viewing_as_doctor" , false);

        onUserClicked = (position -> startActivity(new Intent(Chats.this, ViewMessages.class)
                .putExtra("emailOfMyFriend", users.get(position).getEmail())
                .putExtra("nameOfMyFriend", users.get(position).getUsername())));


        if (!isViewingAsDoctor) {
            FirebaseDatabase.getInstance().getReference()
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            users.clear();
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                String role = dataSnapshot.child("role").getValue(String.class);
                                if (role != null && role.equals("Doctor")) {
                                    users.add(dataSnapshot.getValue(User.class));
                                }
                            }
                            binding.recycler.setHasFixedSize(true);
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Chats.this);
                            binding.recycler.setLayoutManager(layoutManager);
                            binding.recycler.setAdapter(new FriendsAdapter(users, Chats.this, onUserClicked));
                            binding.progress3.setVisibility(View.GONE);
                            binding.recycler.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
        } else {
            FirebaseDatabase.getInstance().getReference()
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            users.clear();
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                String role = dataSnapshot.child("role").getValue(String.class);
                                if (role != null && role.equals("Patient")) {
                                    users.add(dataSnapshot.getValue(User.class));
                                }
                            }
                            binding.recycler.setHasFixedSize(true);
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Chats.this);
                            binding.recycler.setLayoutManager(layoutManager);
                            binding.recycler.setAdapter(new FriendsAdapter(users, Chats.this, onUserClicked));
                            binding.progress3.setVisibility(View.GONE);
                            binding.recycler.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
        }
    }
}