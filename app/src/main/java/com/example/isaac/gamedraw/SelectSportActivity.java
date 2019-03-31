package com.example.isaac.gamedraw;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SelectSportActivity extends AppCompatActivity implements  SportAdapter
.OnItemClickListener{

    RecyclerView recyclerView;
    SportAdapter adapter;
    List<String> listSports;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_sport);

// Access a Cloud Firestore instance from your Activity
        FirebaseFirestore db = FirebaseFirestore.getInstance();




        listSports = new ArrayList<>();




//        listSports.add("Soccer");
//        listSports.add("Rugby");
//        listSports.add("Basket Ball");
//        listSports.add("Vollyball");
//        listSports.add("Union");listSports.add("Netball");listSports.add("Futsal");









        db.collection("sport")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            int i =0;
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                listSports.add(document.getId());
                                Log.d("retet", document.getId() + " => " + listSports.get(i));
                                i++;

                            }

                            recyclerView = findViewById(R.id.typeSportRecView);
                            adapter  = new SportAdapter(SelectSportActivity.this,listSports);
                            recyclerView.setLayoutManager(new LinearLayoutManager(SelectSportActivity.this));

                            adapter.setOnItemClickListener(SelectSportActivity.this);

                            recyclerView.setAdapter(adapter);
                        } else {
                            Log.w("retet", "Error getting documents.", task.getException());
                        }
                    }


                });

    }

    @Override
    public void onItemClick(int position) {

        Toast.makeText(this, listSports.get(position), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(SelectSportActivity.this, AssociationActivity.class);

        intent.putExtra("ASSOC", listSports.get(position));

        startActivity(intent);

    }
}
