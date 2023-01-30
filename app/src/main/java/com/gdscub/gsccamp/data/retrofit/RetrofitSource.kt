package com.gdscub.gsccamp.data.retrofit

import com.gdscub.gsccamp.model.AllArticleResponse
import com.gdscub.gsccamp.model.ArticleByIdResponse
import com.gdscub.gsccamp.model.JournalingResultRequest
import com.gdscub.gsccamp.model.JournalingResultResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RetrofitSource {
    @GET("article")
    fun getAllArticle():Call<AllArticleResponse>

    @GET("article/{id}")
    fun getArticleById(@Path("id") id:String):Call<ArticleByIdResponse>

    @POST("predict")
    fun predictDepression(@Body request: JournalingResultRequest):Call<JournalingResultResponse>
}