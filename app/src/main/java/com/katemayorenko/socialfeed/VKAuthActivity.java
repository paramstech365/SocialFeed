package com.katemayorenko.socialfeed;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.WebView;

public class VKAuthActivity extends AppCompatActivity {

    private String[]scope = new String[]{VKScope.MESSAGES,VKScope.FRIENDS,VKScope.WALL};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vkauth);

        Intent intent = getIntent();
        VKSdk.login(this,scope);
       



    }

}
