package com.example.zhenhanhong.retrofit.net;


import com.example.zhenhanhong.retrofit.bean.Contributor;
import com.example.zhenhanhong.retrofit.bean.RetrofitBean;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Created by zhenhanhong on 2016/11/21.
 */

public interface GitHubApi {
//http://blog.csdn.net/ljd2038/article/details/51046512
@GET("repos/{owner}/{repo}/contributors")
Call<List<Contributor>> contributorsByAddConverterGetCall(@Path("owner") String owner, @Path("repo") String repo);



//    @GET("search/repositories")
//    Call<RetrofitBean> queryRetrofitByGetCall(@Query("q")String owner,
//                                              @Query("since")String time,
//                                              @Query("page")int page,
//                                              @Query("per_page")int per_Page);

//@GET("search/repositories")
//Call<RetrofitBean> queryRetrofitByGetCallMap(@QueryMap Map<String,String> map);

    @GET("search/repositories")
    Call<RetrofitBean> queryRetrofitByGetCall(@Query("q")String owner,
                                              @Query("since")String time,
                                              @Query("page")int page,
                                              @Query("per_page")int per_Page);
}
