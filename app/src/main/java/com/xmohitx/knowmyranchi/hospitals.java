package com.xmohitx.knowmyranchi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class hospitals extends AppCompatActivity {
    ListView list;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitals);
        mAdView = (AdView) findViewById(R.id.adView5);
        AdRequest adRequest = new AdRequest.Builder()
                //.addTestDevice("DD00043B08133B6D4FF1AC350641EEE1")
                .build();
        mAdView.loadAd(adRequest);
        list=(ListView)findViewById(R.id.listView1);
        String[] names=getResources().getStringArray(R.array.hmanes);
        String[] details=getResources().getStringArray(R.array.hd);
        String[] rates=getResources().getStringArray(R.array.hrates);
        final String[] calls=getResources().getStringArray(R.array.hcall);
        adapter adapter= new adapter(this,names,details,rates);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, final int pos, long id) {
                PopupMenu popup=new PopupMenu(hospitals.this,v);
                popup.getMenuInflater().inflate(R.menu.popup,popup.getMenu());
                popup.setOnMenuItemClickListener(new OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        String value=(String)list.getItemAtPosition(pos);
                        switch(item.getItemId()) {
                            case R.id.map:
                            { Uri uri = Uri.parse("geo:0,0?q=" + Uri.encode(value) + Uri.encode(" Ranchi"));
                                Intent in = new Intent(Intent.ACTION_VIEW, uri);
                                in.setPackage("com.google.android.apps.maps");
                                if (in.resolveActivity(getPackageManager()) != null)
                                    startActivity(in);
                                break;
                            }
                            case R.id.call:
                            {
                                Intent ci=new Intent(Intent.ACTION_DIAL);
                                ci.setData(Uri.parse("tel:"+Uri.encode(calls[pos])));
                                startActivity(ci);
                                break;
                            }
                        }
                        return false;
                    }
                });
                popup.show();
            }
        });
    }
}
