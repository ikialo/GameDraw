package com.example.isaac.gamedraw.FragmentActivity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.isaac.gamedraw.Adapter_Draw;
import com.example.isaac.gamedraw.Adapter_Leader;
import com.example.isaac.gamedraw.FixtureInfo;
import com.example.isaac.gamedraw.OneGameDraw;
import com.example.isaac.gamedraw.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Leader extends Fragment {

    private View v;
    private RecyclerView recyclerView;
    private List<OneGameDraw> list_game_draws;
    private Adapter_Leader adapter;
    private List<LeaderInfo> leader;
    private CollectionReference colRef;



    public Fragment_Leader() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        


       v = inflater.inflate(R.layout.leader_fragment,container, false);

       leader = new ArrayList<>();

        colRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {

                    int i =0;
                    for (QueryDocumentSnapshot document : task.getResult()) {


                        leader.add(new LeaderInfo(document.get("teamName"),
                                document.get("GP"),document.get("GW"), document.get("GL"), document.get("Pts")));


                        Log.d("retet", document.getId() + " => " + document.get("teamName") +" vs " + document.get("GP"));
                        i++;


                        recyclerView = v.findViewById(R.id.recyclerViewLeader);


                        adapter  = new Adapter_Leader(getContext(),leader);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


                        recyclerView.setAdapter(adapter);
                    }

//                    recyclerView = findViewById(R.id.assocRecView);
//                    adapter  = new AssociationAdapter(AssociationActivity.this,listSports);
//                    recyclerView.setLayoutManager(new LinearLayoutManager(AssociationActivity.this));
//
//                    adapter.setOnItemClickListener(AssociationActivity.this);
//
//                    recyclerView.setAdapter(adapter);
                } else {
                     Log.d("RETER", "Error getting documents.", task.getException());
                }
            }
        });



       return v;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





        String association = getActivity().getIntent().getStringExtra("ASSOC");
        String division = getActivity().getIntent().getStringExtra("DIV");
        String sport = getActivity().getIntent().getStringExtra("SPORT");


        Toast.makeText(getContext(), association + division+ sport, Toast.LENGTH_SHORT).show();
        Log.d("retet", "onCreate: "+ sport+ division+ association);


        FirebaseFirestore db = FirebaseFirestore.getInstance();




        colRef = db.collection("sport")
                .document(sport)
                .collection("Association")
                .document(division)
                .collection("Division")
                .document(association)
                .collection("Fixture or Leader")
                .document("Leader")
                .collection("Team");



        //////a change


    }


}
