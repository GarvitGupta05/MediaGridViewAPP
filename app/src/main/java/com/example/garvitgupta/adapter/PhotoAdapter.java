package com.example.garvitgupta.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.garvitgupta.mediagridviewapp.R;
import com.example.garvitgupta.model.Media;
import com.example.garvitgupta.model.Photo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Garvit Gupta on 8/27/2016.
 */
public class PhotoAdapter extends BaseAdapter {

    private Context context;
    private List<Media> mediaList;
    private static LayoutInflater inflater;
    private ExecutorService executorService;

    public PhotoAdapter(Context context, List<Media> mediaList) {
        this.context = context;
        this.mediaList = mediaList;
        executorService = Executors.newFixedThreadPool(10);
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Media media = mediaList.get(position);
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.photo_layout, null);

            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.textView);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(media.getName());

        try {
            int width = Integer.parseInt(((Photo) media).getWidth());
            int height = Integer.parseInt(((Photo) media).getHeight());

            final Bitmap resized = ThumbnailUtils.extractThumbnail(
                    BitmapFactory.decodeFile(media.getPath()), width, height);

            holder.imageView.setImageBitmap(resized);

        } catch (NumberFormatException nfe){
            System.out.println("Garvit NumberFormatException at : "+position);
        }

        System.out.println("Garvit Photo position : " + position);
        return convertView;
    }

    private static class ViewHolder {
        public TextView textView;
        public ImageView imageView;
    }

    public String getStringImage(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        System.out.println("Garvit Image : " + encodedImage);
        return encodedImage;
    }


}

