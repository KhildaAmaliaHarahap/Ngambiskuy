package com.example.ngambiskuy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {


    Button  btnquotes, btncatatan, btndokumentasi, btnreminder;
    private TextView tmplEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.prfl:
                        startActivity(new Intent(getApplicationContext()
                        ,Profil.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.home:


                    case R.id.logout:
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Apakah anda yakin ingin keluar?");
                        builder.setCancelable(true);

                        AlertDialog.Builder builder1 = builder.setNegativeButton("YA", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(MainActivity.this, login.class));
                                finish();
                            }
                        });

                        AlertDialog.Builder builder2 = builder.setPositiveButton("TIDAK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(getApplicationContext(), "Batal", Toast.LENGTH_SHORT).show();
                            }
                        });

                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                }
                return false;
            }
        });

        btncatatan = (Button) findViewById(R.id.btnNote);
        btndokumentasi = (Button) findViewById(R.id.btnDoc);
        btnreminder = (Button) findViewById(R.id.btnReminder);
        btnquotes = (Button) findViewById(R.id.btnQuotes);


        btnquotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Quotes.class));
                Toast.makeText(getApplicationContext(), "Quotes", Toast.LENGTH_SHORT).show();
            }
        });

        btncatatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Database.class));
                Toast.makeText(getApplicationContext(), "Catatan", Toast.LENGTH_SHORT).show();
            }
        });

        btndokumentasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Dokumentasi.class));
                Toast.makeText(getApplicationContext(), "Dokumentasi", Toast.LENGTH_SHORT).show();
            }
        });

        btnreminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Reminder.class));
                Toast.makeText(getApplicationContext(), "Reminder", Toast.LENGTH_SHORT).show();
            }
        });
    }
}