package com.example.matsayya.ihorizonsdemo.api;



import com.example.matsayya.ihorizonsdemo.mvp.model.RepoMainResponse;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import rx.Observable;

public interface CommonApiService
{

   @Headers({
           "Accept: application/vnd.github.v3+json"
   })
    @GET("/search/repositories?q=kotlindemo")
    Observable<RepoMainResponse> getMobiles();



}
