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
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class AssociationActivity extends AppCompatActivity implements AssociationAdapter.OnItemClickListener {


    RecyclerView recyclerView;
    AssociationAdapter adapter;
    List<String> listSports;
    private String string;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_association);


       string = getIntent().getStringExtra("ASSOC");

        Toast.makeText(this, "string "+string, Toast.LENGTH_SHORT).show();


        FirebaseFirestore db = FirebaseFirestore.getInstance();
        listSports = new ArrayList<>();





        db.collection("sport")
                .document(string)
                .collection("Association")
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

                            recyclerView = findViewById(R.id.assocRecView);
                            adapter  = new AssociationAdapter(AssociationActivity.this,listSports);
                            recyclerView.setLayoutManager(new LinearLayoutManager(AssociationActivity.this));

                            adapter.setOnItemClickListener(AssociationActivity.this);

                            recyclerView.setAdapter(adapter);
                        } else {
                           // Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });

 }

    @Override
    public void onItemClick(int position) {

        Toast.makeText(this, listSports.get(position), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(AssociationActivity.this, DivisionActivity.class);

        intent.putExtra("ASSOC", string );
        intent.putExtra("DIV",listSports.get(position) );

        startActivity(intent);
    }
}
