package com.example.android_example_view15;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.android_example_view15.model.config.BoxingConfig;
import com.example.android_example_view15.model.entity.BaseMedia;
import com.example.android_example_view15.ui.activity.BoxingActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ///////////////////////////////////////////////////////////////////////////
    // test->
    ///////////////////////////////////////////////////////////////////////////
    public static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BoxingConfig config = new BoxingConfig(BoxingConfig.Mode.MULTI_IMG).needCamera(R.drawable.ic_boxing_camera_white).needGif();
        Boxing.of(config).withIntent(this, BoxingActivity.class).start(this, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == REQUEST_CODE) {

            try {
                List<BaseMedia> medias = Boxing.getResult(data);
                if (medias != null) {
                    for (int i = 0; i < medias.size(); i++) {
                        medias.get(i).getPath();
                    }
                }
                //注意判断null
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("YJH", e + e.getMessage());
            }
        }
    }
}
