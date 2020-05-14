package com.example.covid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class StatesActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private StateAdapter mStateAdapter;
    private ArrayList<StateItem> mStateList;
    private RequestQueue mRequestQueue;
    TextView mtotalConfirmed,mtotalActive,mtotalDeath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_states);

        mRecyclerView=findViewById(R.id.recyclerView_States);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mStateList=new ArrayList<>();
        mRequestQueue= Volley.newRequestQueue(this);
       // parseWorld();
        parseJson();
    }
    public void parseWorld(){
        String url="https://corona-virus-stats.herokuapp.com/api/v1/cases/general-stats";
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.e("World","Started");
                            JSONObject jsonObject =response.getJSONObject("data");
                            //mStateList.add(new StateItem("World",jsonObject.getString("total_cases"),jsonObject.getString("currently_infected"),"0",jsonObject.getString("death_cases")));
                            mStateAdapter=new StateAdapter(StatesActivity.this,mStateList);
                            mRecyclerView.setAdapter(mStateAdapter);
                            Log.e("World","Done");
                        } catch (JSONException e) {
                            Log.e("World","Exception");
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.e("World","error");

            }
        });
        mRequestQueue.add(request);
    }
    void parseJson(){
        String url="https://api.covid19india.org/data.json";
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray= response.getJSONArray("statewise");
                            JSONObject totaldata=jsonArray.getJSONObject(0);
                            mStateList.add(new StateItem("India",totaldata.getString("confirmed"),totaldata.getString("active"),"new" +" "+totaldata.getString("deltaconfirmed"),totaldata.getString("deaths"),"new" +" "+totaldata.getString("deltadeaths")));
                            mStateAdapter=new StateAdapter(StatesActivity.this,mStateList);
                            mRecyclerView.setAdapter(mStateAdapter);
                            for(int i=1;i<jsonArray.length();i++){
                                JSONObject statedata=jsonArray.getJSONObject(i);
                                String name=statedata.getString("state");
                                String confirmedCases=statedata.getString("confirmed");
                                String activecases=statedata.getString("active");
                                String newCases=statedata.getString("deltaconfirmed");
                                String newdeath=statedata.getString("deltadeaths");
                                String death=statedata.getString("deaths");

                                mStateList.add(new StateItem(name,confirmedCases,activecases,"new" +" "+newCases,death,"new" +" "+newdeath));

                                mStateAdapter=new StateAdapter(StatesActivity.this,mStateList);
                                mRecyclerView.setAdapter(mStateAdapter);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mRequestQueue.add(request);
    }

    public void openMyDetails(View view) {

    }
}
