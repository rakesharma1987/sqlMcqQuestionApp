package com.example.sqlmcqapplication.repository

import com.example.sqlmcqapplication.db.AppDao
import com.example.sqlmcqapplication.db.QuestionEntity

class AppRepository(private var appDao: AppDao) {
    suspend fun saveQuestion(question: List<String>): Long{
        return appDao.saveQuestion(question)
    }

    val getQuestion = appDao.getAllQuestion()
}