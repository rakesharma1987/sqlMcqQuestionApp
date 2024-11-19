package com.example.sqlmcqapplication.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sqlmcqapplication.repository.AppRepository
import com.example.sqlmcqapplication.viewModel.DbViewModel

class DbFactory(private val appRepository: AppRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DbViewModel::class.java)){
            return DbViewModel(appRepository) as T
        }
        throw IllegalArgumentException("Unknown class found")
    }
}