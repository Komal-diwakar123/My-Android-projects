package com.example.naviassignment.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.naviassignment.model.ClosedPRModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ClosedPRRepo(private val context: Context){

    private var gitHubRestAPI: GitHubRestAPI = APIRetrofitService.createApiService()
    val gitClosedPRLiveData = MutableLiveData<List<ClosedPRModel>>()
    val TAG = "GitHubRepo"

    fun getBalanceResponse(){
        val gitClosedPRResponse = gitHubRestAPI.getBalance()
        Log.d(TAG,"enqueue started")
        gitClosedPRResponse.enqueue( object : Callback<List<ClosedPRModel> > {
            override fun onResponse(call: Call<List<ClosedPRModel>>, response: Response<List<ClosedPRModel>>) {
                Log.d(TAG,"onResponse finished")
                if (response.isSuccessful){
                    gitClosedPRLiveData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<List<ClosedPRModel>>, error: Throwable?) {
                Toast.makeText(context, error?.message, Toast.LENGTH_SHORT).show()
            }
        })

    }
}