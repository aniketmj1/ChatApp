 package com.mooi.chatapp;

 import android.annotation.SuppressLint;
 import android.content.Intent;
 import android.os.Bundle;
 import android.view.Menu;
 import android.view.MenuInflater;
 import android.view.MenuItem;
 import android.widget.Toast;

 import androidx.annotation.NonNull;
 import androidx.appcompat.app.AppCompatActivity;
 import androidx.viewpager.widget.ViewPager;

 import com.google.android.material.tabs.TabLayout;
 import com.google.firebase.auth.FirebaseAuth;
 import com.mooi.chatapp.Adapter.FragmentAdapter;
 import com.mooi.chatapp.databinding.ActivityMainBinding;
 import com.mooi.chatapp.databinding.ActivitySignUpBinding;
 import com.mooi.chatapp.R;

 public class MainActivity extends AppCompatActivity {
     ActivityMainBinding binding;
     private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

     @Override
     public boolean onCreateOptionsMenu(Menu menu) {

         MenuInflater inflater = getMenuInflater();
         inflater.inflate(R.menu.menu,menu);
         return super.onCreateOptionsMenu(menu);
     }



     @Override
     public boolean onOptionsItemSelected(@NonNull MenuItem item) {

         int itemId = item.getItemId();

         if (itemId == R.id.settings) {
             // Handle the "settings" menu item
             Intent intent2 = new Intent(MainActivity.this,SettingActivity.class);
//                    startActivity(intent2);
         } else if (itemId == R.id.groupChat) {
             // Handle the "groupChat" menu item
             Toast.makeText(this, "Group Chat clicked", Toast.LENGTH_SHORT).show();
         } else if (itemId == R.id.logout) {
             // Handle the "logout" menu item
             mAuth.signOut();
             Intent intent = new Intent(MainActivity.this,SignInActivity.class);
             startActivity(intent);
         }

//        switch (itemId){
//
//            case R.id.settings:
//                   //  Toast.makeText(this, "setting clicked", Toast.LENGTH_SHORT).show();
//                    Intent intent2 = new Intent(MainActivity.this,SettingActivity.class);
//                    startActivity(intent2);
//                    break;
//            case R.id.groupChat:
//                    Toast.makeText(this, "Group Chat clicked", Toast.LENGTH_SHORT).show();
//                    break;
//            case R.id.logout:
//                   mAuth.signOut();
//                   Intent intent = new Intent(MainActivity.this,SignInActivity.class);
//                   startActivity(intent);
//                   break;
//        }
         return super.onOptionsItemSelected(item);
     }
 }