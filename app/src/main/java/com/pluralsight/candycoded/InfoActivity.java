package com.pluralsight.candycoded;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity {

    TextView mTextViewAddress;
    TextView mTextViewPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView) findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);

        createMapIntent();
        createPhoneIntent();

    }

    // TODO - Task 2 - Launch the Google Maps Activity
    public void createMapIntent(){
        mTextViewAddress = (TextView) findViewById(R.id.text_view_address);
        mTextViewAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri mapIntentUri = Uri.parse("geo:0,0?q=618 E South St Orlando, FL 32801");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }


    // TODO - Task 3 - Launch the Phone Activity
    public void createPhoneIntent(){
        mTextViewPhone = (TextView) findViewById(R.id.text_view_phone);
        mTextViewPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phoneIntent = new Intent(Intent.ACTION_CALL);
                phoneIntent .setData(Uri.parse("tel:0123456789"));
                startActivity(phoneIntent);
            }
        });
    }

}
