package com.example.covid;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DistrictAdapter extends RecyclerView.Adapter<DistrictAdapter.DistrictViewHolder> {
    private Context mContext;
    public ArrayList<DistrictItem> mDistrictList;

    public DistrictAdapter(Context context,ArrayList<DistrictItem> districtList){
        mContext=context;
        mDistrictList=districtList;
    }
    @NonNull
    @Override
    public DistrictViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.districts_card,parent,false);
        return new DistrictAdapter.DistrictViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DistrictAdapter.DistrictViewHolder holder, int position) {
        DistrictItem currentItem=mDistrictList.get(position);
        final String name=currentItem.getmName();
        String confirmedCases=currentItem.getmConfirmedCases();
        String activecases=currentItem.getmActivecases();
        String newCases=currentItem.getmActivecases();
        String death=currentItem.getmDeath();
        final int zone=currentItem.getZone();

        holder.mDistrictName.setText(name);
        holder.mDistrictName.setTextColor(zone);
        holder.mConfirmedDistrict.setText(confirmedCases);
        holder.mActiveDistrict.setText(activecases);
        holder.mDeathDistrict.setText(death);
        //holder.mcardLinearLayout.setBackgroundColor(zone);
        holder.mcardLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open=new Intent(v.getContext(),DistrictDetailsActivity.class);
                open.putExtra("zone",zone);
                open.putExtra("name",name);
                v.getContext().startActivity(open);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDistrictList.size();
    }
    public class DistrictViewHolder extends RecyclerView.ViewHolder{
        public TextView mDistrictName,mConfirmedDistrict,mActiveDistrict,mDeathDistrict;
        LinearLayout mcardLinearLayout;
        public DistrictViewHolder(@NonNull View itemView) {
            super(itemView);
            mDistrictName=itemView.findViewById(R.id.districtname);
            mActiveDistrict=itemView.findViewById(R.id.districtactive);
            mConfirmedDistrict=itemView.findViewById(R.id.districtconfirmed);
            mDeathDistrict=itemView.findViewById(R.id.districtdeath);
            mcardLinearLayout=itemView.findViewById(R.id.districtcardll);
        }
    }
}
