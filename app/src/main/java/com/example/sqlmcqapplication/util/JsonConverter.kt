package com.example.sqlmcqapplication.util

import androidx.room.TypeConverter
import com.example.sqlmcqapplication.db.QuestionEntity
import com.example.sqlmcqapplication.model.Question
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class JsonConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromObjectList(value: List<Question>): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toObjectList(value: String): List<Question> {
        val type = object : TypeToken<List<Question>>() {}.type
        return gson.fromJson(value, type)
    }
}