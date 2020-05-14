package com.example.covid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import static android.graphics.Color.rgb;

public class DistrictDetailsActivity extends AppCompatActivity {
    String name;
    int zone;
    TextView mName,mZone,mDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district_details);
        name= getIntent().getStringExtra("name");
        zone= getIntent().getIntExtra("zone",0);
        mName=findViewById(R.id.name);
        mDetails=findViewById(R.id.details);
        mZone=findViewById(R.id.zone);
        setLayout();
    }
    public void setLayout(){
        mName.setText(name);
        if(zone== Color.RED){
            mZone.setText("is marked as Red Zone");
            mDetails.setMovementMethod(new ScrollingMovementMethod());
            mDetails.setText("Movement of individuals/vehicles for permitted activities (Two persons besides the driver for four-wheelers and no pillion riding for two-wheelers).\n\n" +
                    "Special economic zones, export-oriented units, industrial estates/townships with access control in urban areas that fall into red zones have been permitted to resume operations. Manufacturing units producing essential goods (medical devices, pharmaceuticals) are also allowed to function in red zones.\n\n" +
                    "In red zones, manufacturing of IT hardware and the jute industry along with manufacturers of packaging material have been given the go-ahead to operate, provided that safety guidelines are followed.\n\n" +
                    "Construction activities in rural areas that fall in red zones, has been permitted only to in-situ construction where the workers are available on site. The construction of renewable energy projects is also allowed.\n\n" +
                    "In red areas, all standalone shops (both in urban and rural areas) and shops in residential complexes have been allowed to reopen for business.\n\n" +
                    "In red zones, e-commerce activities are allowed limited to essential goods.\n\n" +
                    "Private offices in red zones will be allowed to operate with 33 per cent of their strength.\n\n" +
                    "Government offices in red zones will be allowed to function with senior officers of the Deputy Secretary level and above at full strength, with the remaining staff attending up to 33 per cent as per requirement.\n\n" +
                    "Even in red zones, defense and security services, health and family welfare, police, prisons, home guards, civil defence, fire and emergency services, disaster management and related services, National Informatics Centre (NIC), customs, Food Corporation of India (FCI), National Cadet Corps (NCC), Nehru Yuvak Kendra (NYK) and Municipal services have been allowed to function with no restrictions.\n\n" +
                    "All industrial and construction activities in rural areas that fall in red zones have been allowed. These include MNREGA works, food-processing units and brick kilns.\n\n" +
                    "In Red zones, all agriculture and animal husbandry (including inland and marine fisheries) activities, inclusive of their supply chain, will be able to function.\n\n" +
                    "All health services, including AYUSH, have been permitted to operate in red zones.\n\n" +
                    "Banks, NBFCs, insurance and capital market activities along with credit co-operative societies will function in red zones.\n\n" +
                    "In red zones, homes for children, senior citizens and widows (including Anganwadis) have been allowed to function.\n\n" +
                    "Apart from courier/postal services, public utility offices (including internet) will remain open in red zones.\n\n" +
                    "The MHA order further clarifies that print and electronic media, IT and IT-enabled services, data and call centres, cold storage and warehousing services, private security and facility management services, and services provided by self-employed persons, except for barbers are permitted in red zones.\n");
        }
        else if(zone== Color.GREEN){
            mZone.setText("is marked as Green Zone");
            mDetails.setMovementMethod(new ScrollingMovementMethod());
            mDetails.setText("Here is what all is permitted in the green zones and what is not:\n" +
                    "\n" +
                    "All activities are permitted except those prohibited throughout the country, irrespective of the zonal division. Buses can operate with up to 50 per cent seating capacity and bus depots can operate with up to 50 per cent capacity.\n" +
                    "All goods traffic is permitted. No state/ UT shall stop the movement of cargo for cross land-border trade under treaties with neighbouring countries.\n" +
                    "No separate pass of any sort is needed for such movement, which is essential for maintaining the supply chain of goods and services across the country during the lockdown period.\n" +
                    "Air, rail, sea and metro train services are not allowed. These services are not allowed in any of the zones.\n" +
                    "E-commerce is allowed in non-essential items in green zone and also in orange zones.\n" +
                    "Sale of liquor has been allowed in all zones. However, if the shops are located in malls, marketing complexes and in containment areas, they cannot open.\n" +
                    "\n" +
                    "\"Shops selling liquor, paan, gutka, tobacco etc. in public places will ensure minimum six feet distance (2 gaz ki doori) from each other, and also that not more than 5 persons are present at one time at the shop,\" reads the government order.\n" +
                    "\n" +
                    "In all zones, person above 65 years, persons with co-morbidities, pregnant women and children below 10 years shall stay at home.\n" +
                    "OPDs and medical clinics shall be permitted to operate in red, orange and green zones with all social distancing norms.\n" +
                    "The states/ UTs can allow only select activities from list of permitted activities and impose additional restrictions based on their assessment of the situation. The primary objective, the Centre's notification says, is to keep the spread of Covid-19 in check.\n" +
                    "School, college, institutions , hospitality services , including hotels and restaurants, place of large gathering , such as cinema halls, malls, gym, sports complex, social, political, cultural and all kind of gathering, religious place/place of worship for public remain closed during lockdown 3.0.\n" +
                    "Movement of stranded foreign nationals, persons released from quarantine, stranded migrant workers and students, pilgrims, tourists and other such persons is to be facilitated following the Standard Operating Protocols (SOPs) issued by Union home ministry.");
        }
        else if(zone== rgb(255, 165, 0)){
            mZone.setText("is marked as Orange Zone");
            mDetails.setMovementMethod(new ScrollingMovementMethod());
            mDetails.setText("What is prohibited under lockdown 3.0 in Orange Zone\n" +
                    "\n" +
                    "1. All domestic and international air travel of pasengers, except for medicial services, air ambulance and for security purposes or for purposes as permitted by MHA\n" +
                    "\n" +
                    "2. All passenger movement by trains, except for security purposes or for purposes as permitted by MHA\n" +
                    "\n" +
                    "3. Inter-state buses for public tranport, except as permitted by MHA.\n" +
                    "\n" +
                    "4. Metro rail services\n" +
                    "\n" +
                    "5. Inter-state movement of citizens except for medical reasons or for activities permitted by MHA\n" +
                    "\n" +
                    "6. All schools, colleges, educational/training/coaching institutes, etc.\n" +
                    "\n" +
                    "7. Cinema halls, malls, gynasiums, sports complexes, entertainment parks, bars, etc.\n" +
                    "\n" +
                    "8. Religious, political, social, sports gatherings.\n" +
                    "\n" +
                    "9. Religious congregations are strictly prohibited.\n" +
                    "\n" +
                    "10. Inter-district and intra-district movement of buses\n" +
                    "\n" +
                    "Coronavirus lockdown: Important rules\n" +
                    "\n" +
                    "1. The movement of individuals will be strictly prohibited between 7 pm to 7 am.\n" +
                    "\n" +
                    "2. Citizens over the age of 65 years of age, pregnant women, children below the age of 10 years have to stay at home, except for health purposes.\n" +
                    "\n" +
                    "Covid lockdown: Activities allowed in Orange Zones\n" +
                    "\n" +
                    "1. OPDs, medical clinics can operate in Orange Zones, with social distancing norms and other safety, precautions.\n" +
                    "\n" +
                    "2. Taxis and cab aggregators, with a driver and two passengers only\n" +
                    "\n" +
                    "3. Inter-district movement of individuals and vehicles, only for permitted activities.\n" +
                    "\n" +
                    "All other activities will be permitted, which are not specifically prohibited/permitted with restrictions in the Orange Zone.");
        }
        else {
            mZone.setText("is not marked");
            mDetails.setText("No data available for this district");
        }
    }
}
