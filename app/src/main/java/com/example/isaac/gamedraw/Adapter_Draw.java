package com.example.isaac.gamedraw;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter_Draw extends RecyclerView.Adapter<Adapter_Draw.DrawViewHolder> {


    private Context mContext;
    private List<FixtureInfo> mlist;

    public Adapter_Draw(Context mContext, List<FixtureInfo> mlist) {
        this.mContext = mContext;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public DrawViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.one_game_draw, viewGroup, false);
        return new DrawViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DrawViewHolder drawViewHolder, int i) {

       drawViewHolder.game.setText(mlist.get(i).getTeam1());
       drawViewHolder.time.setText(mlist.get(i).getTime());
       drawViewHolder.location.setText(mlist.get(i).getLocation());




    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class DrawViewHolder extends RecyclerView.ViewHolder{


       TextView game, time, location;


        public DrawViewHolder(@NonNull View itemView) {
            super(itemView);

            game = itemView.findViewById(R.id.game);
            location = itemView.findViewById(R.id.location);
            time = itemView.findViewById(R.id.time1);


        }
    }
}

