package com.gdscub.gsccamp.data.repository

import com.gdscub.gsccamp.data.retrofit.RetrofitSource
import retrofit2.Retrofit

class Repository {
    val retrofitSource = Retrofit
        .Builder()
        .baseUrl("BASE URL HERE")
        .build()
        .create(RetrofitSource::class.java)
}