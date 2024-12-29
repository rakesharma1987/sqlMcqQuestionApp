package com.example.sqlmcqapplication.model

data class Question(
    var question: String,
    var type: String,
    var options: List<Option>,
    var correctAnswerId: Int,
    var correctAnsIdList: List<Int>,
    var explanation: String
)
