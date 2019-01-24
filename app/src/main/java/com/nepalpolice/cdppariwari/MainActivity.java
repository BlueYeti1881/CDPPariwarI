package com.nepalpolice.cdppariwari;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.nepalpolice.cdppariwari.profile.Sendemail;
import com.nepalpolice.cdppariwari.profile.profile;

public class MainActivity extends AppCompatActivity {

    private Toolbar mainToolbar;

    private BottomNavigationView mainbottomNav;
    private StudentFragment studentFragment;
    private TeacherFragment teacherFragment;
    private StaffFragment staffFragment;
    private NonStaffFragment nonstaffFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcq);



        mainToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);

        getSupportActionBar().setTitle("CDP Circle");
           getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#8abe50")));





        mainbottomNav = findViewById(R.id.mainBottomNav);
        BottomNavigationViewHelper.removeShiftMode(mainbottomNav);//disable BottomNavigationView shift mode
        // FRAGMENTS

        studentFragment = new StudentFragment();
         teacherFragment = new TeacherFragment();
          staffFragment = new StaffFragment();
           nonstaffFragment = new NonStaffFragment();
        replaceFragment(studentFragment);

        mainbottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.bottom_action_home :
                        replaceFragment(studentFragment);
                        return true;

                          case R.id.bottom_action_notif:
                         replaceFragment(teacherFragment);
                        return true;

                    case R.id.bottom_action_account:
                          replaceFragment(staffFragment);

                        return true;


                    case R.id.other:
                          replaceFragment(nonstaffFragment);
                          return true;
                    default:
                        return false;


                }
            }
        });




        }
        @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.profile:

                  Intent i1 = new Intent(MainActivity.this, profile.class);
            startActivity(i1);

               return true;

            case R.id.send_mail:
                Intent email = new Intent(MainActivity.this, Sendemail.class);
                startActivity(email);

                return true;

          case R.id.terms:

     startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.freeprivacypolicy.com/privacy/view/7016d07aec9c4f2a15b880e292ce1846")));
                return true;
               default:
                   return false;


        }

    }



    private void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, fragment);
        fragmentTransaction.commit();

    }



}
