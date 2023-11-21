package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.HomeScreen.HomeFragment;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding; // Generated binding class
    FirebaseAuth auth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.homes) {
                replaceFragment(new HomeFragment());
            } else if (itemId == R.id.creates) {
                replaceFragment(new CreateFragment());
            } else if (itemId == R.id.profiles) {
                replaceFragment(new ProfileFragment());
            }

            return true;
        });

        auth = FirebaseAuth.getInstance();

        // Use binding to access views
        if (binding.textView != null) {
            user = auth.getCurrentUser();
            if (user == null) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            } else {
                binding.textView.setText(user.getEmail());
            }
        }

        // Note: You should also initialize and use 'button' using the binding if needed
        // binding.button = findViewById(R.id.logout);
        // binding.button.setOnClickListener(new View.OnClickListener() { ... });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}


//        setContentView(R.layout.activity_main);
//        auth = FirebaseAuth.getInstance();
//        button = findViewById(R.id.logout);
//        textView = findViewById(R.id.textView);
//        user = auth.getCurrentUser();
//        if (user == null){
//            Intent intent = new Intent(getApplicationContext(), Login.class);
//            startActivity(intent);
//            finish();
//        }
//        else{
//            textView.setText(user.getEmail());
//
//        }
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FirebaseAuth.getInstance().signOut();
//                Intent intent = new Intent(getApplicationContext(), Login.class);
//                startActivity(intent);
//                finish();
//            }
//        });