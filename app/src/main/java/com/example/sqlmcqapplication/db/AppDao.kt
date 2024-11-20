package com.example.sqlmcqapplication.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.sqlmcqapplication.model.Question


@Dao
interface AppDao {
    @Insert
    suspend fun saveQuestion(question: List<QuestionEntity>)

    @Query("SELECT * FROM questionentity")
    fun getAllQuestion(): LiveData<List<QuestionEntity>>

}