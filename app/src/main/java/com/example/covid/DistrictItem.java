package com.example.covid;

public class DistrictItem {
    String mName;
    String mConfirmedCases;
    String mActivecases;
    String mNewCases;
    String mDeath;
    int zone;
    public DistrictItem(String mName, String mConfirmedCases, String mActivecases, String mNewCases, String mDeath) {
        this.mName = mName;
        this.mConfirmedCases = mConfirmedCases;
        this.mActivecases = mActivecases;
        this.mNewCases = mNewCases;
        this.mDeath = mDeath;
    }

    public int getZone() {
        return zone;
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
    public void setZone(int zone) {
        this.zone = zone;
    }
}
