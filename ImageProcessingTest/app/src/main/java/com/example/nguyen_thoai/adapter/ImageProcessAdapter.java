package com.example.nguyen_thoai.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.nguyen_thoai.com.example.nguyen_thoai.objects.ImageProcess;
import com.example.nguyen_thoai.imageprocessingtest.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

public class ImageProcessAdapter extends ArrayAdapter<ImageProcess> {

    public ImageProcessAdapter(Context context, int resource, ArrayList<ImageProcess> objects) {
        super(context, resource, objects);
        this.context = context;
        this.imageProcesses = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.e("", "position: " + position);
        ViewHolder holder = null;
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_image_layout, parent, false);
            convertView = layoutInflater.inflate(R.layout.item_image_layout, parent, false);
            holder = new ViewHolder(convertView);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        Glide.with(context).load(imageProcesses.get(position).getPathImage()).into(holder.imageView);

        return convertView;
    }

    private Context context;
    private ArrayList<ImageProcess> imageProcesses;
    private DisplayImageOptions options;

    private class ViewHolder {

        public ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.item_image);
            view.setTag(this);
        }

        public ImageView imageView;
    }
}
