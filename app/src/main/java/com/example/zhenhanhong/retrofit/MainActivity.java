package com.example.zhenhanhong.retrofit;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.zhenhanhong.retrofit.bean.Article;
import com.example.zhenhanhong.retrofit.bean.Contributor;
import com.example.zhenhanhong.retrofit.bean.RetrofitBean;
import com.example.zhenhanhong.retrofit.net.GitHubApi;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.example.zhenhanhong.retrofit.*;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //添加打印日志
//        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
//        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(httpLoggingInterceptor)
//                .build();
//
//        Retrofit retrofit = new Retrofit.Builder().addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .client(okHttpClient)
//                .baseUrl("https://api.github.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();

//TODO 网络请求 retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GitHubApi repo = retrofit.create(GitHubApi.class);
        Call<RetrofitBean> call = repo.queryRetrofitByGetCall("retrofit","2016-03-29",1,3);
        call.enqueue(new Callback<RetrofitBean>() {
            @Override
            public void onResponse(Call<RetrofitBean> call, Response<RetrofitBean> response) {
                RetrofitBean retrofit = response.body();
                List<RetrofitBean.ItemsBean> list = retrofit.getItems();
                if (list == null)
                    return;
                String TAG = "TAG";
                Log.d("count", "total:" + retrofit.getTotal_count());
                Log.d("isIncomplete_results", "incompleteResults:" + retrofit.isIncomplete_results());
                for (RetrofitBean.ItemsBean itemsBean: list) {
                    Log.d(TAG, "name:" + itemsBean.getName());
                    Log.d(TAG, "full_name:" + itemsBean.getFull_name());
                    Log.d(TAG, "description:" + itemsBean.getDescription());
                    RetrofitBean.ItemsBean.OwnerBean owner = itemsBean.getOwner();
                    Log.d(TAG, "login:" + owner.getLogin());
                    Log.d(TAG, "type:" + owner.getType());
                }

            }

            @Override
            public void onFailure(Call<RetrofitBean> call, Throwable t) {

            }
        });
        //TODO 图片加载 picaaso
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        //加载网络图片
        String imgurl = "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png";
//        Picasso.with(this).load(imgurl).into(imageView);
        //加载本地图片
        Picasso.with(this).load(new File("/mipmap/ic_launcher.png/ic_launcher.png")).into(imageView);




    }
}
