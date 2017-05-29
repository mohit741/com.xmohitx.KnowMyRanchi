package com.xmohitx.knowmyranchi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ListMenuItemView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class restaurants extends AppCompatActivity {
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        list=(ListView)findViewById(R.id.listView);
        String[] names=getResources().getStringArray(R.array.restnames);
        String[] details=getResources().getStringArray(R.array.restd);
        String[] rates=getResources().getStringArray(R.array.resrates);
        adapter adapter= new adapter(this,names,details,rates);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,View v,int pos,long id) {
                String value=(String)list.getItemAtPosition(pos);
                Uri uri= Uri.parse("geo:0,0?q="+Uri.encode(value)+Uri.encode(" Ranchi"));
                Intent in= new Intent(Intent.ACTION_VIEW,uri);
                in.setPackage("com.google.android.apps.maps");
                if(in.resolveActivity(getPackageManager())!=null)
                    startActivity(in);

            }
        });
    }
}
