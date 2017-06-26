package com.xmohitx.knowmyranchi;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 *Adapter class which is used to populate customListView
 */
public class adapter extends ArrayAdapter<String> {
    String[] names={};
    String[] details={};
    String[] rate={};
    Context c;
    LayoutInflater inflater;
    Typeface tf;
    public adapter(Context context, String[] names, String[] details, String[] rate) {
        super(context, R.layout.list,names);
        this.c=context;
        this.names=names;
        this.details=details;
        this.rate=rate;
        this.tf=Typeface.createFromAsset(context.getAssets(), "fonts/robotom.ttf");
    }
    public class ViewHolder{
        TextView name;
        TextView detail;
        RatingBar rat;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.list,null);
        }
        final ViewHolder holder=new ViewHolder();
        holder.name=(TextView)convertView.findViewById(R.id.txt1);
        holder.detail=(TextView)convertView.findViewById(R.id.txt2);
        holder.rat=(RatingBar) convertView.findViewById(R.id.ratingBar);
        holder.name.setText(names[position]);
        holder.name.setTypeface(tf);
        holder.detail.setText(details[position]);
        holder.rat.setRating(Float.parseFloat(rate[position]));
        return convertView;
    }
}
