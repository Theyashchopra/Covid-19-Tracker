package com.example.covid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

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
import java.util.Iterator;

import static android.graphics.Color.rgb;

public class DistrictActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private DistrictAdapter mDistrictAdapter;
    private ArrayList<DistrictItem> mDistrictList;
    private RequestQueue mRequestQueue;
    public String statename;
    TextView mtotalConfirmed,mtotalActive,mtotalDeath,mtotalName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district);
        statename=getIntent().getStringExtra("stateName");
        Toast.makeText(this,statename,Toast.LENGTH_SHORT).show();
        mRecyclerView=findViewById(R.id.recyclerView_Districts);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mDistrictList=new ArrayList<>();

        mRequestQueue= Volley.newRequestQueue(this);
        mtotalConfirmed=findViewById(R.id.districttotalconfirmed);
        mtotalActive=findViewById(R.id.districttotalactive);
        mtotalDeath=findViewById(R.id.districttotaldeath);
        mtotalName=findViewById(R.id.districttotalname);
        parseJsonState(statename);
        parseJson(statename);
        setZoneColor();

    }
    void setZoneColor(){
        String url="https://api.covid19india.org/zones.json";
        JsonObjectRequest requestZone=new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            int pos=-1;
                            JSONArray jsonArray=response.getJSONArray("zones");
                            Log.e("Volley","started");

                            for(int i=0;i<mDistrictList.size();i++){
                                for(int j=0;j<jsonArray.length();j++){
                                    if(mDistrictList.get(i).getmName().equals(jsonArray.getJSONObject(j).getString("district"))){
                                        pos=j;
                                        break;
                                    }
                                }
                                if(pos!=-1) {
                                    setcolor(jsonArray.getJSONObject(pos).getString("zone"), i);
                                }
                                else {
                                    setcolor("Black", i);
                                }

                                Log.e("Volley", "Done color");
                                mDistrictAdapter = new DistrictAdapter(DistrictActivity.this, mDistrictList);
                                mRecyclerView.setAdapter(mDistrictAdapter);

                            }
                        }catch (JSONException e) {
                            Log.e("Volley","exception coloe");
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.e("Volley","error");
            }

        });
        mRequestQueue.add(requestZone);
    }
    void parseJson(final String statename){
        String url="https://api.covid19india.org/state_district_wise.json";
        JsonObjectRequest requestdistrict=new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject state = response.getJSONObject(statename);
                            Log.e("Volley",statename);
                            JSONObject jsonObject = state.getJSONObject("districtData");
                                Iterator<String> jsonKeys=jsonObject.keys();
                                for (; jsonKeys.hasNext(); ) {
                                    String namedistrict = jsonKeys.next();
                                    JSONObject statedata = jsonObject.getJSONObject(namedistrict);
                                    String name = namedistrict;
                                    String confirmedCases = statedata.getString("confirmed");
                                    String activecases = statedata.getString("active");
                                    String death = statedata.getString("deceased");
//                                    JSONObject deltas=state.getJSONObject(statename).getJSONObject("delta");
//                                    String newCases = deltas.getString("confirmed");
                                    DistrictItem mdi=new DistrictItem(name, confirmedCases, activecases, "1", death);
                                    mDistrictList.add(mdi);
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
        mRequestQueue.add(requestdistrict);
    }
    public void parseJsonState(String state){
        String url1="https://api.covid19india.org/data.json";
        JsonObjectRequest stateRequest=new JsonObjectRequest(Request.Method.GET, url1, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            int i;
                            Log.e("Volley","started");
                            JSONArray jsonArray= response.getJSONArray("statewise");
                            for(i=1;i<jsonArray.length();i++) {
                                if(statename.equals(jsonArray.getJSONObject(i).getString("state"))){
                                    break;
                                }
                            }
                            Log.e("Volley",i+"");
                            JSONObject statejson = jsonArray.getJSONObject(i);
                            Log.e("Volley","mid");
                            mtotalName.setText(statename);
                            mtotalConfirmed.setText(statejson.getString("confirmed"));
                            mtotalActive.setText(statejson.getString("active"));
                            mtotalDeath.setText(statejson.getString("deaths"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("Volley","exception");

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.e("Volley","error");
            }
        });
        mRequestQueue.add(stateRequest);
    }
    public void setcolor(String color, int pos){
        if(color.equals("Green")){
            mDistrictList.get(pos).setZone(Color.GREEN);
        }
        else if(color.equals("Red")){
            mDistrictList.get(pos).setZone(Color.RED);
        }
        else if(color.equals("Orange")){
            mDistrictList.get(pos).setZone(rgb(255, 165, 0));
        }
        else {
            mDistrictList.get(pos).setZone(Color.BLACK);
        }
    }
}
