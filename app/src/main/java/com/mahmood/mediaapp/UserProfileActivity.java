package com.mahmood.mediaapp;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

public class UserProfileActivity extends AppCompatActivity {

    private Button followButton;
    private FirebaseFirestore db;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        followButton = findViewById(R.id.followButton);
        db = FirebaseFirestore.getInstance();
        currentUser = FirebaseAuth.getInstance().getCurrentUser();

        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                followUser();
            }
        });
    }

    private void followUser() {
        String userIdToFollow = getIntent().getStringExtra("userId");

        db.collection("users").document(currentUser.getUid())
                .update("following", FieldValue.arrayUnion(userIdToFollow))
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(UserProfileActivity.this, "Followed user", Toast.LENGTH_SHORT).show();
                });
    }
}