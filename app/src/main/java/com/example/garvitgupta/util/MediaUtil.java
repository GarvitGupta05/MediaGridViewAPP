package com.example.garvitgupta.util;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import com.example.garvitgupta.model.Audio;
import com.example.garvitgupta.model.Media;
import com.example.garvitgupta.model.Photo;
import com.example.garvitgupta.model.Video;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Garvit Gupta on 8/27/2016.
 */
public class MediaUtil {


    public static List<Media> getPhoto(ContentResolver contentResolver) {

        List<Media> list = new ArrayList<>();

        Uri url = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Uri uri = Uri.parse(String.valueOf(url));

        String[] columns = new String[]{
                MediaStore.Images.Media.DISPLAY_NAME,
                MediaStore.Images.Media.DATA,
                MediaStore.Images.Media.WIDTH,
                MediaStore.Images.Media.HEIGHT};

        Cursor cursor = contentResolver.query(uri, columns, null, null, null);

        while (cursor.moveToNext()) {

            Photo media = new Photo();

            media.setName(cursor.getString(0));
            media.setPath(cursor.getString(1));
            media.setWidth(cursor.getString(2));
            media.setHeight(cursor.getString(3));


            list.add(media);
        }

        return list;
    }

    public static List<Media> getAudio(ContentResolver contentResolver) {

        List<Media> list = new ArrayList<>();

        Uri url = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Uri uri = Uri.parse(String.valueOf(url));

        String[] columns = new String[]{
                MediaStore.Audio.Media.DISPLAY_NAME,
                MediaStore.Audio.Media.DATA};

        Cursor cursor = contentResolver.query(uri, columns, null, null, null);

        while (cursor.moveToNext()) {

            Audio media = new Audio();

            media.setName(cursor.getString(0));
            media.setPath(cursor.getString(1));

            list.add(media);
        }

        return list;
    }

    public static List<Media> getVideo(ContentResolver contentResolver) {

        List<Media> list = new ArrayList<>();

        Uri url = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        Uri uri = Uri.parse(String.valueOf(url));

        String[] columns = new String[]{
                MediaStore.Video.Media.DISPLAY_NAME,
                MediaStore.Video.Media.DATA,
                MediaStore.Video.Media.WIDTH,
                MediaStore.Video.Media.HEIGHT};

        Cursor cursor = contentResolver.query(uri, columns, null, null, null);

        while (cursor.moveToNext()) {

            Video media = new Video();

            media.setName(cursor.getString(0));
            media.setPath(cursor.getString(1));
            media.setWidth(cursor.getString(2));
            media.setHeight(cursor.getString(3));

            list.add(media);
        }

        return list;
    }
}
