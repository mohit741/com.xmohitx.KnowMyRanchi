package com.xmohitx.knowmyranchi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class fitness extends AppCompatActivity {

    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness);
        list=(ListView)findViewById(R.id.listView4);
        String[] names=getResources().getStringArray(R.array.gymnames);
        String[] details=getResources().getStringArray(R.array.gymd);
        String[] rates=getResources().getStringArray(R.array.gymrates);
        adapter adapter= new adapter(this,names,details,rates);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {
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
