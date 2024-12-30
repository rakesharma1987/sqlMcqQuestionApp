package com.example.sqlmcqapplication.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.sqlmcqapplication.util.JsonConverter

@Entity
data class QuestionEntity (
    @PrimaryKey(autoGenerate = true)
    var srNo: Int = 0,

    @TypeConverters(JsonConverter::class)
    var question: String
)