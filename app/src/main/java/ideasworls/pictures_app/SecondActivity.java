package ideasworls.pictures_app;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;



public class SecondActivity extends AppCompatActivity{
    TextView discrView;
    TextView titleView;
    TextView dateView;
    SimpleDraweeView draweeView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent second_intent = getIntent();
        String discription = second_intent.getStringExtra("discr");
        String title = second_intent.getStringExtra("title");
        String date = second_intent.getStringExtra("date");
        String image = second_intent.getStringExtra("image");

        discrView = (TextView) findViewById(R.id.second_post);
        titleView = (TextView) findViewById(R.id.second_title);
        dateView = (TextView) findViewById(R.id.second_date);
        draweeView = (SimpleDraweeView) findViewById(R.id.second_image);

        discrView.setText(discription);
        titleView.setText(title);
        dateView.setText(date);

        Uri uri = Uri.parse(image);

        draweeView.setImageURI(uri);

    }
}
