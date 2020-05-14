package com.example.covid;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.StateViewHolder> {
    private Context mContext;
    public ArrayList<StateItem> mStateList;

    public StateAdapter(Context context,ArrayList<StateItem> stateList){
        mContext=context;
        mStateList=stateList;
    }

    @NonNull
    @Override
    public StateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.states_card,parent,false);
        return new StateViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StateViewHolder holder, final int position) {
        StateItem currentItem=mStateList.get(position);
        final String name=currentItem.getmName();
        String confirmedCases=currentItem.getmConfirmedCases();
        String activecases=currentItem.getmActivecases();
        String newCases=currentItem.getmNewCases();
        String death=currentItem.getmDeath();
        String newDeath=currentItem.getmNewDeath();
        holder.mStateName.setText(name);
        holder.mConfirmedState.setText(confirmedCases);
        holder.mActiveState.setText(activecases);
        holder.mDeathState.setText(death);
        holder.mNewConfirmCases.setText(newCases);
        holder.mNewDeathState.setText(newDeath);
        if(name.equals("India")||name.equals("World"))
            holder.mIV.setVisibility(View.GONE);
        holder.mcardLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(name.equals("India")||name.equals("World")))
                v.getContext().startActivity(new Intent(v.getContext(),DistrictActivity.class).putExtra("stateName",mStateList.get(position).getmName()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mStateList.size();
    }

    public class StateViewHolder extends RecyclerView.ViewHolder{
        public TextView mStateName,mConfirmedState,mActiveState,mDeathState,mNewDeathState,mNewConfirmCases;
        LinearLayout mcardLinearLayout;
        ImageView mIV;
        public StateViewHolder(@NonNull View itemView) {
            super(itemView);
            mStateName=itemView.findViewById(R.id.statename);
            mActiveState=itemView.findViewById(R.id.stateactive);
            mConfirmedState=itemView.findViewById(R.id.stateconfirmed);
            mDeathState=itemView.findViewById(R.id.statedeath);
            mcardLinearLayout=itemView.findViewById(R.id.statecardll);
            mIV=itemView.findViewById(R.id.iv);
            mNewDeathState=itemView.findViewById(R.id.statedeathnew);
            mNewConfirmCases=itemView.findViewById(R.id.stateconfirmednew);
        }
    }
}
