package com.mahmood.mediaapp;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class PostActivity extends AppCompatActivity {

    private EditText postContent;
    private Button postButton;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        postContent = findViewById(R.id.postContent);
        postButton = findViewById(R.id.postButton);

        db = FirebaseFirestore.getInstance();

        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPost();
            }
        });
    }

    private void createPost() {
        String content = postContent.getText().toString();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null && !content.isEmpty()) {
            Map<String, Object> post = new HashMap<>();
            post.put("content", content);
            post.put("userId", user.getUid());

            db.collection("posts").add(post).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    finish();
                } else {
                    // Handle the error
                }
            });
        }
    }
}