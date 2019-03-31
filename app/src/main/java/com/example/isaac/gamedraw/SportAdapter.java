package com.example.isaac.gamedraw;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.SportViewHolder> {


    private Context mContext;
    private List<String> mlist;
    private OnItemClickListener mListener;

    public SportAdapter(Context mContext, List<String> mlist) {
        this.mContext = mContext;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public SportViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.sport_itemview, viewGroup, false);
        return new SportAdapter.SportViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SportViewHolder sportViewHolder, int i) {

        sportViewHolder.sport.setText(mlist.get(i).toString());

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class SportViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        TextView sport;

        public SportViewHolder(@NonNull View itemView) {
            super(itemView);

            sport = itemView.findViewById(R.id.sportName);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            if (mListener != null){
                int position = getAdapterPosition();

                if (position != RecyclerView.NO_POSITION){
                    mListener.onItemClick(position);
                }
            }
        }
    }
    public interface OnItemClickListener{
        void onItemClick (int position);

//        void onJourneyInfoClick(int position);
//
//        void onDeleteClick(int position);
//
//        void onAmendClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

}
