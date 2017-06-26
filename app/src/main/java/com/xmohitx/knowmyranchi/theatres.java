package com.xmohitx.knowmyranchi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class theatres extends AppCompatActivity {

    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theatres);
        list=(ListView)findViewById(R.id.listView3);
        String[] names=getResources().getStringArray(R.array.cnames);
        String[] details=getResources().getStringArray(R.array.cdet);
        String[] rates=getResources().getStringArray(R.array.crates);
        adapter adapter= new adapter(this,names,details,rates);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, final int pos, long id) {
                PopupMenu popup=new PopupMenu(theatres.this,v);
                popup.getMenuInflater().inflate(R.menu.popup_t,popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        String value=(String)list.getItemAtPosition(pos);
                        switch(item.getItemId()) {
                            case R.id.mp:
                            { Uri uri = Uri.parse("geo:0,0?q=" + Uri.encode(value) + Uri.encode(" Ranchi"));
                                Intent in = new Intent(Intent.ACTION_VIEW, uri);
                                in.setPackage("com.google.android.apps.maps");
                                if (in.resolveActivity(getPackageManager()) != null)
                                    startActivity(in);
                                break;
                            }
                            case R.id.bt:
                            {
                                switch(pos)
                                {
                                    case 0: Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://in.bookmyshow.com/cinemas/carnival-jd-high-street-mall/GLRC"));
                                            startActivity(intent); break;
                                    case 1: Intent inten= new Intent(Intent.ACTION_VIEW, Uri.parse("https://in.bookmyshow.com/cinemas/fun-cinemas-springcity-ranchi/FLMB"));
                                        startActivity(inten); break;
                                    case 2: Intent inte= new Intent(Intent.ACTION_VIEW, Uri.parse("https://in.bookmyshow.com/cinemas/srs-cinemas-ranchi/SRSR"));
                                        startActivity(inte); break;
                                    case 3: Intent u= new Intent(Intent.ACTION_VIEW, Uri.parse("https://in.bookmyshow.com/cinemas/popkorn-cinemas-galaxia-mall-ranchi/PKCM"));
                                        startActivity(u); break;
                                    case 4: Intent in= new Intent(Intent.ACTION_VIEW, Uri.parse("https://in.bookmyshow.com/cinemas/plaza-cinema-ranchi/PACI"));
                                    startActivity(in); break;
                                    case 5: Intent i= new Intent(Intent.ACTION_VIEW, Uri.parse("https://in.bookmyshow.com/cinemas/pvr-nucleus-mall-ranchi/PVMN"));
                                    startActivity(i); break;
                                    case 6: Intent v= new Intent(Intent.ACTION_VIEW, Uri.parse("https://in.bookmyshow.com/cinemas/sujata-picture-palace-ranchi/SPPR"));
                                        startActivity(v); break;


                                }
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
