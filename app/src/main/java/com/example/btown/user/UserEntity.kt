package com.example.btown.user

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "user") @Parcelize
data class UserEntity(
                @PrimaryKey
                @NonNull
                var userID: String,
                var userPW: String?,
                var userEmail: String?,
                var userName: String?,
                var userNickName: String?,
                var userPhoneNumber: String?,
                var userSocialNumber: String?,
                var userGender : String?,
                var userMileage: Int
) : Parcelable{
    constructor() : this("", "", "", "",
    "", "", "", "",
    0)
}/*{

    constructor() : this(null, null, null, null, null, null, null, null, null) {
        this.userID = userID
        this.userPW = userPW
        this.userEmail = userEmail
        this.userName = userName
        this.userNickName = userNickName
        this.userPhoneNumber = userPhoneNumber
        this.userSocialNumber = userSocialNumber
        this.userGender = userGender
        this.userMileage = userMileage
    }

    fun getUserID() = this.userID

    fun setUserID(userID: String){
        this.userID = userID
    }

    fun getUserPW() = this.userPW

    fun setUserPW(userPW: String){
        this.userPW = userPW
    }

    fun getUserEmail() = this.userEmail

    fun setUserEmail(userEmail: String){
        this.userEmail = userEmail
    }

    fun getUserName() = this.userName

    fun setUserName(userName: String){
        this.userName = userName
    }

    fun getUserNickName() = this.userNickName

    fun setUserNickName(userNickName: String){
        this.userNickName = userNickName
    }

    fun getUserPhoneNumber() = this.userPhoneNumber

    fun setUserPhoneNumber(userPhoneNumber: String){
        this.userPhoneNumber = userPhoneNumber
    }

    fun getUserSocialNumber() = this.userSocialNumber

    fun setUserSocialNumber(userSocialNumber: String){
        this.userSocialNumber = userSocialNumber
    }

    fun getUserGender() = this.userGender

    fun setUserGender(userGender: String){
        this.userGender = userGender
    }

    fun getUserMileage() = this.userMileage

    fun setUserMileage(userMileage: Int){
        this.userMileage
    }
}
        */