package com.example.sqlmcqapplication.db

class AppRepository(private var appDao: AppDao) {
    suspend fun saveQuestion(question: QuestionEntity): Long{
        return appDao.saveQuestion(question)
    }

    val getQuestion = appDao.getAllQuestion()
}