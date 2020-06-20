package com.example.naviassignment.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserModel{
    @SerializedName("login")
    @Expose
    var name : String? = null
    @SerializedName("avatar_url")
    @Expose
    var avatarUrl : String? = null
}
