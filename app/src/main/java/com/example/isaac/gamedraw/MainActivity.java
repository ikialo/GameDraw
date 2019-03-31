package com.example.isaac.gamedraw;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.isaac.gamedraw.FragmentActivity.Fragment_Draw;
import com.example.isaac.gamedraw.FragmentActivity.Fragment_Leader;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<OneGameDraw> mList;
    private RecyclerView recyclerView;
    private Adapter_Draw mAdapter;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_id_layout);
        viewPager = findViewById(R.id.view_pager_id);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new Fragment_Draw(), "Draw");
        adapter.AddFragment(new Fragment_Leader(), "Leader");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


        ActionBar actionBar = getSupportActionBar();

        actionBar.setElevation(0);




//
//        mList = new ArrayList<>();
//
//
//
//        mList.add(new OneGameDraw("storms", "broncos"));
//        mList.add(new OneGameDraw("Sharks", "bull dogs"));
//
//        mList.add(new OneGameDraw("Eels", "Pathers"));
//
//        mList.add(new OneGameDraw("worriers", "Sea Eagles"));
//
//        mList.add(new OneGameDraw("titans", "Rooster"));
//
//        mList.add(new OneGameDraw("Raiders", "Tigers"));
//
//        mList.add(new OneGameDraw("Cowboys", "Nights"));
//
//        mList.add(new OneGameDraw("Rabbitohs", "Dragons"));
//
//        recyclerView = findViewById(R.id.recyclerview_draws);
//        mAdapter = new Adapter_Draw(MainActivity.this, mList);
//        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//
////        mAdapter.setOnItemClickListener(EditListActivity.this);
//
//        recyclerView.setAdapter(mAdapter);


    }
}
