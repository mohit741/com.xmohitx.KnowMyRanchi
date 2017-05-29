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

public class hospitals extends AppCompatActivity {
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitals);
        list=(ListView)findViewById(R.id.listView1);
        String[] names=getResources().getStringArray(R.array.hmanes);
        String[] details=getResources().getStringArray(R.array.hd);
        String[] rates=getResources().getStringArray(R.array.hrates);
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
                            case R.id.call: break;
                    }
                        return false;
                    }
                });
                popup.show();
            }
        });
    }
}
