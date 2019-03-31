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
import com.example.isaac.gamedraw.AssociationActivity;
import com.example.isaac.gamedraw.AssociationAdapter;
import com.example.isaac.gamedraw.DivisionActivity;
import com.example.isaac.gamedraw.FixtureInfo;
import com.example.isaac.gamedraw.OneGameDraw;
import com.example.isaac.gamedraw.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Fragment_Draw extends Fragment {

    private View v;
    private RecyclerView recyclerView;
    private List<OneGameDraw> list_game_draws;
    private Adapter_Draw adapter;
    private List<String> fixtures, listSports;
    CollectionReference colRef;
    private List<FixtureInfo> fixtureInfos;



    public Fragment_Draw() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.draw_fragment,container, false);
        listSports = new ArrayList<>();
        fixtureInfos = new ArrayList<>();



        colRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {

                    int i =0;
                    for (QueryDocumentSnapshot document : task.getResult()) {

                        listSports.add(document.get("team 1") +" vs " + document.get("team 2"));

                        fixtureInfos.add(new FixtureInfo(document.get("team 1") +" vs " + document.get("team 2"),
                                document.get("time"),document.get("location")));


                        Log.d("retet", document.getId() + " => " + document.get("team 1") +" vs " + document.get("team 2"));
                        i++;


                        recyclerView = v.findViewById(R.id.recyclerViewDraw);


                        adapter  = new Adapter_Draw(getContext(),fixtureInfos);
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
                    // Log.w(TAG, "Error getting documents.", task.getException());
                }
            }
        });




//                .collection()
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//
//                            int i =0;
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//
//                                fixtures.add(document.getId());
//                                Log.d("retet", document.getId() + " => " + fixtures.get(i));
//                                i++;
//
//                            }
//
//
//
//                        } else {
//                            // Log.w(TAG, "Error getting documents.", task.getException());
//                        }
//                    }
//                });
//





        return v;



    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





        String association = getActivity().getIntent().getStringExtra("ASSOC");
        String division = getActivity().getIntent().getStringExtra("DIV");
        String sport = getActivity().getIntent().getStringExtra("SPORT");


        Toast.makeText(getContext(), association + division+ sport, Toast.LENGTH_SHORT).show();


        FirebaseFirestore db = FirebaseFirestore.getInstance();

//
//        DocumentReference docRef = db.collection("sport")
//                .document(sport)
//                .collection("Association")
//                .document(association)
//                .collection("Division")
//                .document(division)
//                .collection("Fixture or Leader")
//                .document("Fixture")
//                .collection("Game")
//                .document("Game " + gameNumber);


        colRef = db.collection("sport")
                .document(sport)
                .collection("Association")
                .document(division)
                .collection("Division")
                .document(association)
                .collection("Fixture or Leader")
                .document("Fixture")
                .collection("Game");



//        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//
//
//                if (task.isSuccessful()) {
//                    DocumentSnapshot document = task.getResult();
//                    if (document.exists()) {
//                        //Log.d(TAG, "DocumentSnapshot data: " + document.getData());
//
//                        fixtures.add(document.get("game 2").toString());
//                        fixtures.add(document.get("game 3").toString());
//                        fixtures.add(document.get("game 2").toString());
//                        fixtures.add(document.get("game 4").toString());
//
//                    } else {
//                        // Log.d(TAG, "No such document");
//                    }
//                } else {
//                    // Log.d(TAG, "get failed with ", task.getException());
//                }
//            }
//        });



        fixtures = new ArrayList<>();
        list_game_draws = new ArrayList<>();

        list_game_draws.add(new OneGameDraw("storms", "broncos"));
        list_game_draws.add(new OneGameDraw("Sharks", "bull dogs"));
        list_game_draws.add(new OneGameDraw("Eels", "Pathers"));
        list_game_draws.add(new OneGameDraw("worriers", "Sea Eagles"));
        list_game_draws.add(new OneGameDraw("titans", "Rooster"));
        list_game_draws.add(new OneGameDraw("Raiders", "Tigers"));
        list_game_draws.add(new OneGameDraw("Cowboys", "Nights"));
        list_game_draws.add(new OneGameDraw("Rabbitohs", "Dragons"));


    }
}
