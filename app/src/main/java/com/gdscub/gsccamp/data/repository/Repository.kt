package com.gdscub.gsccamp.data.repository

import com.gdscub.gsccamp.data.Resource
import com.gdscub.gsccamp.data.retrofit.RetrofitSource
import com.gdscub.gsccamp.model.AllArticleResponse
import com.gdscub.gsccamp.model.ArticleByIdResponse
import com.gdscub.gsccamp.model.JournalingResultRequest
import com.gdscub.gsccamp.model.JournalingResultResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository {
    val retrofitSource = Retrofit
        .Builder()
        .baseUrl("https://article-gdsc.herokuapp.com/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RetrofitSource::class.java)

    fun getAllArticle(): Flow<Resource<AllArticleResponse>> = flow{
        emit(Resource.Loading())

        val response = retrofitSource.getAllArticle().execute()

        if(response.isSuccessful){
            val result = response.body()

            if(result == null) emit(Resource.Error(response.message()))
            else emit(Resource.Success(result))
        }else{
            emit(Resource.Error(response.message()))
        }
    }

    fun getArticleById(id:String):Flow<Resource<ArticleByIdResponse>> = flow{
        emit(Resource.Loading())

        val response = retrofitSource.getArticleById(id).execute()

        if(response.isSuccessful){
            val result = response.body()

            if(result == null) emit(Resource.Error(response.message()))
            else emit(Resource.Success(result))
        }else{
            emit(Resource.Error(response.message()))
        }
    }

    fun predictDepression(message:String):Flow<Resource<JournalingResultResponse>> = flow{
        emit(Resource.Loading())

        val body = JournalingResultRequest(message)
        val response = retrofitSource.predictDepression(body).execute()

        if(response.isSuccessful){
            val result = response.body()

            if(result == null) emit(Resource.Error(response.message()))
            else emit(Resource.Success(result))
        }else{
            emit(Resource.Error(response.message()))
        }
    }
}