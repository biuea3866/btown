package com.example.btown.Rental

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.btown.user.UserEntity

@Entity(tableName = "rental",
    foreignKeys = arrayOf(
        ForeignKey(entity = UserEntity::class,
            parentColumns = arrayOf("userID"),
            childColumns = arrayOf("userID"))
    ))
data class RentalEntity(
    @PrimaryKey(autoGenerate = true)
    var rentalID: Int? = null,
    var userID: String?
)