package com.example.sqlmcqapplication.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class QuestionEntity (
    @PrimaryKey
    var srNo: Int,
    var question: String
)