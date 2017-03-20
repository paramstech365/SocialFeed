package com.katemayorenko.socialfeed;

import android.accounts.Account;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;
import com.vk.sdk.util.VKUtil;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] fingerprints = VKUtil.getCertificateFingerprint(this, this.getPackageName());
        System.out.println(Arrays.asList(fingerprints));


        Switch onFB = (Switch) findViewById(R.id.s1);
        Switch onInsta = (Switch) findViewById(R.id.s2);
        Switch onVK = (Switch) findViewById(R.id.s3);

        onFB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i("OnFB State=", "" + isChecked); // FB auth
                if (isChecked == true) {

                    Intent intent = new Intent(getApplicationContext(), VKAuthActivity.class);

                    startActivity(intent);


                }
            }

        });
        onInsta.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i("onInsta State=", "" + isChecked); //Insta auth
                if (isChecked == true) {

                    Intent intent = new Intent(getApplicationContext(), InstaAuthActivity.class);

                    startActivity(intent);

                }
            }

        });
        onVK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i("onVK State=", "" + isChecked);    //VK auth
                if (isChecked == true) {

                    Intent intent = new Intent(getApplicationContext(), VKAuthActivity.class);

                    startActivity(intent);


                }
            }

        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                Toast.makeText(getApplicationContext(),"User has authorized successfully",Toast.LENGTH_LONG).show();
            }
            @Override
            public void onError(VKError error) {
                Toast.makeText(getApplicationContext(),"Auth' error",Toast.LENGTH_LONG).show();
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
