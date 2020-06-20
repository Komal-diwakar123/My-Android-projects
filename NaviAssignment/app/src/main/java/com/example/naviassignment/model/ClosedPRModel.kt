package com.example.naviassignment.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ClosedPRModel {
    @SerializedName("title")
    @Expose
    var title : String? = null
    @SerializedName("created_at")
    @Expose
    var createdAt : String? = null
    @SerializedName("closed_at")
    @Expose
    var closedAt : String? = null
    @SerializedName("user")
    @Expose
    var user : UserModel? = null
}