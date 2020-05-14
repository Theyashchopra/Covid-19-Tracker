package com.example.covid;
public class State {
    String mName;
    String mPositiveCases;
    String mActivecases;
    String mNewCases;
    String mRecovered;
    public State(String mName, String mPositiveCases, String mActivecases, String mNewCases, String mRecovered) {
        this.mName = mName;
        this.mPositiveCases = mPositiveCases;
        this.mActivecases = mActivecases;
        this.mNewCases = mNewCases;
        this.mRecovered = mRecovered;
    }
    public String getmName() {
        return mName;
    }
    public String getmPositiveCases() {
        return mPositiveCases;
    }
    public String getmActivecases() {
        return mActivecases;
    }
    public String getmNewCases() {
        return mNewCases;
    }
    public String getmRecovered() {
        return mRecovered;
    }
}
