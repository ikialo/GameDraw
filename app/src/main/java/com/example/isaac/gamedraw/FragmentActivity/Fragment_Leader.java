package com.example.isaac.gamedraw.FragmentActivity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.isaac.gamedraw.Adapter_Draw;
import com.example.isaac.gamedraw.FixtureInfo;
import com.example.isaac.gamedraw.OneGameDraw;
import com.example.isaac.gamedraw.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Leader extends Fragment {

    private View v;
    private RecyclerView recyclerView;
    private List<OneGameDraw> list_game_draws;
    private Adapter_Draw adapter;
    private List<FixtureInfo> fixture;


    public Fragment_Leader() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        


       v = inflater.inflate(R.layout.leader_fragment,container, false);

        recyclerView = v.findViewById(R.id.recyclerViewLeader);
        adapter  = new Adapter_Draw(getContext(),fixture);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



        recyclerView.setAdapter(adapter);
       return v;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        fixture = new ArrayList<>();
        fixture.add(new FixtureInfo("1 vs 2", "time", "location"));

    }


}
