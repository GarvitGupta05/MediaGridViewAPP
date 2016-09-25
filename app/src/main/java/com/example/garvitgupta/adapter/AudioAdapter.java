package com.example.garvitgupta.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.garvitgupta.mediagridviewapp.R;
import com.example.garvitgupta.model.Media;
import com.example.garvitgupta.model.Photo;

import java.util.List;

/**
 * Created by Garvit Gupta on 8/27/2016.
 */
public class AudioAdapter extends BaseAdapter {

    private Context context;
    private List<Media> mediaList;
    private static LayoutInflater inflater;

    public AudioAdapter(Context context, List<Media> mediaList) {
        this.context = context;
        this.mediaList = mediaList;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mediaList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private static class ViewHolder {
        public TextView textView;
        public ImageView imageView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Media media = mediaList.get(position);
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.audio_layout, null);

            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.textView);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(media.getName());
        System.out.println("Garvit Audio position : " + position);

        return convertView;
    }
}
