package com.geek.recyclehomework;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainAdapter.itemClickListener {

// private   ActivityMainBinding binding;
    RecyclerView recyclerView;
    MainAdapter adapter;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //    binding = ActivityMain3Binding.inflate(getLayoutInflater());
     //   setContentView(binding.getRoot());
        recyclerView = findViewById(R.id.recycler);
        fab = findViewById(R.id.fab);
        adapter = new MainAdapter();
        adapter.addListener(this);
        recyclerView.setAdapter(adapter);


        fab.setOnClickListener(v -> {
            Intent intent = new Intent(this,Form_activity.class);
            startActivityForResult(intent,100);
        });
//        public Dialog onCreateDialog(Bundle savedInstanceState) {
//            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//            builder.setTitle("Важное сообщение!")
//                    .setMessage("Покормите кота!")
//                    .setIcon(R.drawable.ic_launcher_cat)
//                    .setPositiveButton("ОК, иду на кухню", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int id) {
//                            // Закрываем окно
//                            dialog.cancel();
//                        }
//                    });
//            return builder.create();
//        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK && data != null);
        adapter.addStudents(new Students(data.getStringExtra("name"),data.getStringExtra("surname")));
    }


    @Override
    public void onLong(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Вы точно хотите удалить ?").setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                adapter.removeItem(position);
            }
        }).setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}