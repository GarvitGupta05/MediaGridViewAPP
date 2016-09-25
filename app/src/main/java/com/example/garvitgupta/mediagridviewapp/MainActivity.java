package com.example.garvitgupta.mediagridviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.example.garvitgupta.adapter.AudioAdapter;
import com.example.garvitgupta.adapter.PhotoAdapter;
import com.example.garvitgupta.adapter.VideoAdapter;
import com.example.garvitgupta.model.Media;
import com.example.garvitgupta.network.Client;
import com.example.garvitgupta.util.MediaUtil;

import org.json.JSONException;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private List<Media> photoList;
    private List<Media> audioList;
    private List<Media> videoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gridView);
        photoList = MediaUtil.getPhoto(getContentResolver());
        audioList = MediaUtil.getAudio(getContentResolver());
        videoList = MediaUtil.getVideo(getContentResolver());
    }

    public void setGridView(View view) throws JSONException {

        switch (view.getId()) {
            case R.id.photo:
                gridView.setNumColumns(3);
                gridView.setAdapter(new PhotoAdapter(getApplicationContext(), photoList));
                break;
            case R.id.audio:
                gridView.setNumColumns(1);
                gridView.setAdapter(new AudioAdapter(getApplicationContext(), audioList));
                break;
            case R.id.video:
                gridView.setNumColumns(1);
                gridView.setAdapter(new VideoAdapter(getApplicationContext(), videoList));
                break;
            default:
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
