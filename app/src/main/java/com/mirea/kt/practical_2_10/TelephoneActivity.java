package com.mirea.kt.practical_2_10;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TelephoneActivity extends AppCompatActivity implements TelephoneAdapter.OnTelephoneClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_telephone);
        Log.d("TelephoneActivity", "Created");
        telephones = db.loadAllTelephonesFromDatabase();
        Log.d("TelephoneActivity", "Database loaded");
        RecyclerView rcView = findViewById(R.id.recyclerView);
        TelephoneAdapter adapter = new TelephoneAdapter(telephones, this);
        rcView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcView.setAdapter(adapter);
    }
    public void onTelephoneClick(Telephone telephone, int position){
        Toast.makeText(this, "click on " +
                telephone.getModel(), Toast.LENGTH_LONG).show();
    }

    private DBManager db = new DBManager(new MyAppSQLiteHelper(this, "my_database.db", null, 1));
    private ArrayList<Telephone> telephones = new ArrayList<>();
}