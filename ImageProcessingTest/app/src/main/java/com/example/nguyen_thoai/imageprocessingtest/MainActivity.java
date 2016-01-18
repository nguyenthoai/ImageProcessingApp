package com.example.nguyen_thoai.imageprocessingtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.nguyen_thoai.adapter.ImageProcessAdapter;
import com.example.nguyen_thoai.com.example.nguyen_thoai.objects.ImageProcess;
import com.example.nguyen_thoai.systemanager.SystemManager;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static SystemManager systemManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        systemManager = new SystemManager();
        systemManager.getListImage(new File(SystemManager.HOME_PATH));
        imageProcesses = new ArrayList<>();
        imageProcesses = systemManager.getListImageProcess();

        gridView = (GridView) this.findViewById(R.id.gridView);
        imageProcessAdapter = new ImageProcessAdapter(getApplicationContext(), 1, imageProcesses);
        gridView.setAdapter(imageProcessAdapter);
    }


    private GridView gridView;
    private ArrayList<ImageProcess> imageProcesses;
    private ImageProcessAdapter imageProcessAdapter;

}
