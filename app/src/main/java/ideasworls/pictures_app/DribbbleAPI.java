package ideasworls.pictures_app;

import android.graphics.Picture;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit.Call;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;




public interface DribbbleAPI {
    String ENDPOINT = "https://api.dribbble.com/v1/";
    String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss Z";
    @GET("shots")
    Call<List<PicturesList>>  getData(@Query("access_token") String accessToken);
}
