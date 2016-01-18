package com.example.nguyen_thoai.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.nguyen_thoai.com.example.nguyen_thoai.objects.ImageProcess;
import com.example.nguyen_thoai.imageprocessingtest.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Nguyen_Thoai on 1/18/2016.
 */
public class ImageProcessAdapter extends ArrayAdapter<ImageProcess> {

    public ImageProcessAdapter(Context context, int resource, ArrayList<ImageProcess> objects) {
        super(context, resource, objects);
        this.context = context;
        this.imageProcesses = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.image_layout, parent, false);
            new ViewHolder(convertView);
        }
        final ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        Picasso.with(context)
                .load(new File(imageProcesses.get(position).getPathImage()))
                .noFade()
                .into(viewHolder.imageView);

        return convertView;
    }

    private Context context;
    private ArrayList<ImageProcess> imageProcesses;

    private class ViewHolder {

        public ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.item_image);
            view.setTag(this);
        }

        private ImageView imageView;
    }
}
