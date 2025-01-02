package com.example.sqlmcqapplication.repository

import com.example.sqlmcqapplication.db.AppDao
import com.example.sqlmcqapplication.db.QuestionEntity

class AppRepository(private var appDao: AppDao) {
    suspend fun saveQuestion(question: QuestionEntity){
        return appDao.saveQuestion(question)
    }

    val getQuestion = appDao.getAllQuestion()
//    val deleteQuestion = appDao.deleteQuestions()

    suspend fun getCount(): Int{
        return appDao.getCount()
    }
}