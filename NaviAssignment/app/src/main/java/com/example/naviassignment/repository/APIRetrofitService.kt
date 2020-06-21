package com.example.naviassignment.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIRetrofitService {

    companion object {
        private var retrofit: Retrofit? = null
        fun createApiService(): GitHubRestAPI {
            if (retrofit == null) {
                createNewInstance()
            }
            return retrofit!!.create(GitHubRestAPI::class.java)
        }


        private fun createNewInstance() {
            retrofit = Retrofit.Builder()
                .baseUrl(GitHubRestAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}