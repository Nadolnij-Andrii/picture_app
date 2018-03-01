package ideasworls.pictures_app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import android.view.View.OnClickListener;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity{

    RecyclerView recyclerView;
     List<PicturesList> pictures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fresco.initialize(this);

        pictures = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.posts_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Context context = MainActivity.this;
        RecycleViewAdapter adapter = new RecycleViewAdapter(context, pictures);
        recyclerView.setAdapter(adapter);
        RetroClient.getDribbbleAPI().getData("6ed972085fecb7078ef53a3056562c05de38514ebd7d095b6a84f6dba7743031").enqueue(new Callback<List<PicturesList>>() {
            @Override
            public void onResponse(Response<List<PicturesList>> response, Retrofit retrofit) {
                if(response.body() != null) {
                    pictures.addAll(response.body());
                    recyclerView.getAdapter().notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }


        });


    }


}
