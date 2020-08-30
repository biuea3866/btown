package com.example.btown.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.btown.Board.BoardEntity
import com.example.btown.user.BoardDAO
import com.example.btown.user.UserDAO
import com.example.btown.user.UserEntity

@Database(entities = [UserEntity::class, BoardEntity:class], version = 2)
abstract class userDatabase : RoomDatabase(){
    abstract fun userDAO(): UserDAO
    abstract fun boardDAO(): BoardDAO

    companion object {
        @Volatile private var database: userDatabase? = null
        private const val ROOM_DB = "btown.db"

        fun getInstance(context: Context): userDatabase{
            if(database == null){
                synchronized(userDatabase::class){
                    database = Room.databaseBuilder(context.applicationContext,
                    userDatabase::class.java, ROOM_DB).fallbackToDestructiveMigration().build()
                }
            }
            return database!!
        }

        fun destroyInstance(){
            database = null
        }
    }
}