package com.example.sqlmcqapplication.view

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.sqlmcqapplication.R
import com.example.sqlmcqapplication.db.AppDatabase
import com.example.sqlmcqapplication.db.QuestionEntity
import com.example.sqlmcqapplication.factory.DbFactory
import com.example.sqlmcqapplication.model.Question
import com.example.sqlmcqapplication.repository.AppRepository
import com.example.sqlmcqapplication.viewModel.DbViewModel
import com.google.gson.Gson

class DashboardActivity : AppCompatActivity() {
    lateinit var viewModel: DbViewModel
    lateinit var questionList: ArrayList<Question>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        questionList = ArrayList<Question>()
        val dao = AppDatabase.getInstance(this).dao
        val factory = DbFactory(AppRepository(dao))
        viewModel = ViewModelProvider(this, factory)[DbViewModel::class.java]
        viewModel.getQuestion.observe(this, Observer {it: List<QuestionEntity> ->
            Log.d("TAG", "onCreate: $it")
            for (position in 0..it.size){
                questionList.add(Gson().fromJson(it[position].question, Question::class.java))
                Log.d("Question", ""+questionList.get(0))
            }
        })
    }
}