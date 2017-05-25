package com.xmohitx.knowmyranchi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by HP on 5/25/2017.
 */
public class adapter extends ArrayAdapter<String> {
    String[] names={};
    String[] details={};
    float[] rate={};
    Context c;
    LayoutInflater inflater;

    public adapter(Context context, String[] names, String[] details, float[] rate) {
        super(context, R.layout.list,names);
        this.c=context;
        this.names=names;
        this.details=details;
        this.rate=rate;
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
        holder.detail.setText(details[position]);
        holder.rat.setRating(rate[position]);
        return super.getView(position, convertView, parent);
    }
}
