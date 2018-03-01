package ideasworls.pictures_app;



import android.app.Application;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class RetroClient extends Application{

    private static DribbbleAPI dribbbleAPI;
    private Retrofit retrofit;
    private String BASE_URL = "https://api.dribbble.com/v1/" ;

    @Override
    public void onCreate() {
        super.onCreate();
        Retrofit client = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        dribbbleAPI = client.create(DribbbleAPI.class);
    }

    public static DribbbleAPI getDribbbleAPI() {
        return dribbbleAPI;
    }
}
