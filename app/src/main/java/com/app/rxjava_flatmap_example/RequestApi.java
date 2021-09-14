package com.app.rxjava_flatmap_example;

import com.app.rxjava_flatmap_example.models.Comment;
import com.app.rxjava_flatmap_example.models.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

interface RequestApi {

    @GET("posts")
    Observable<List<Post>> getPosts();

    @GET("posts/{id}/comments")
    Observable<List<Comment>> getComments(@Path("id") int id);



}
