package com.example.naviassignment.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.naviassignment.model.ClosedPRModel
import com.example.naviassignment.repository.ClosedPRRepo

class ClosedPRViewmodel : ViewModel() {

    private lateinit var closedPRRepo: ClosedPRRepo
    fun init(context: Context){
        closedPRRepo= ClosedPRRepo(context)
    }

    fun getClosedPRLiveData(): MutableLiveData<List<ClosedPRModel> > {
        return closedPRRepo.gitClosedPRLiveData
    }

    fun getClosedPRResponse(){
        closedPRRepo.getBalanceResponse()
    }
}