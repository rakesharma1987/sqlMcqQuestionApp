package com.example.sqlmcqapplication.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sqlmcqapplication.db.QuestionEntity
import com.example.sqlmcqapplication.repository.AppRepository
import kotlinx.coroutines.launch

class DbViewModel(private var appRepository: AppRepository): ViewModel() {
    fun saveQuestion(data: QuestionEntity){
        viewModelScope.launch {
            appRepository.saveQuestion(data)
        }
    }

    val getQuestion = appRepository.getQuestion
}