package com.example.btown.user

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDAO{
    // Add user
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(vararg user: UserEntity)

    // Select User information
    @Query("SELECT * FROM user WHERE userID = :userID")
    fun getUser(userID: String): UserEntity

    // Check userID
    @Query("SELECT userID FROM user WHERE userID = :userID")
    fun checkID(userID: String): String?

    @Query("SELECT * FROM user")
    fun getAllUser() :LiveData<List<UserEntity>>
}