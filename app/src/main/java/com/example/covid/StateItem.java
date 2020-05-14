package com.example.covid;

public class StateItem {
    String mName;
    String mConfirmedCases;
    String mActivecases;
    String mNewCases;
    String mNewDeath;

    String mDeath;
    public StateItem(String mName, String mConfirmedCases, String mActivecases, String mNewCases, String mDeath,String mNewDeath) {
        this.mName = mName;
        this.mConfirmedCases = mConfirmedCases;
        this.mActivecases = mActivecases;
        this.mNewCases = mNewCases;
        this.mDeath = mDeath;
        this.mNewDeath=mNewDeath;
    }
    public String getmName() {
        return mName;
    }
    public String getmConfirmedCases() {
        return mConfirmedCases;
    }
    public String getmActivecases() {
        return mActivecases;
    }
    public String getmNewCases() {
        return mNewCases;
    }
    public String getmDeath() {
        return mDeath;
    }
    public String getmNewDeath() {
        return mNewDeath;
    }
    public void setmNewDeath(String mNewDeath) {
        this.mNewDeath = mNewDeath;
    }

}
