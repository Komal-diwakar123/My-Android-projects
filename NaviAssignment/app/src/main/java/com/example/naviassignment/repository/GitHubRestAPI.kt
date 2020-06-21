package com.example.naviassignment.repository

import com.example.naviassignment.model.ClosedPRModel
import retrofit2.http.GET

interface GitHubRestAPI {

    companion object {
        val BASE_URL = " https://5ec152876197530016092294.mockapi.io/api/hipbar/interview/1/"
    }
    @GET("balance")
    fun getBalance(): retrofit2.Call<List<ClosedPRModel>>
}