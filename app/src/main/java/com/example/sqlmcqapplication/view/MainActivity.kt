package com.example.sqlmcqapplication.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import com.example.sqlmcqapplication.R
import com.example.sqlmcqapplication.databinding.ActivityMainBinding
import com.example.sqlmcqapplication.db.AppDatabase
import com.example.sqlmcqapplication.db.QuestionEntity
import com.example.sqlmcqapplication.factory.DbFactory
import com.example.sqlmcqapplication.model.QuestionData
import com.example.sqlmcqapplication.repository.AppRepository
import com.example.sqlmcqapplication.viewModel.DbViewModel
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: DbViewModel
    lateinit var assetFile: String
    lateinit var arrayList: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        window.statusBarColor = ContextCompat.getColor(this, R.color.black)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        supportActionBar!!.hide()
        setContentView(R.layout.activity_main)

        val dao = AppDatabase.getInstance(this).dao
        val factory = DbFactory(AppRepository(dao))
        viewModel = ViewModelProvider(this, factory)[DbViewModel::class.java]

        assetFile = readJSONFromAsset("mcq.json")
        arrayList = ArrayList<String>()
        val list = Gson().fromJson(assetFile, QuestionData::class.java)

        Handler().postDelayed({
//            viewModel.saveQuestion(list)
            startActivity(Intent(this, DashboardActivity::class.java))
        }, 3000)

    }

    private fun readJSONFromAsset(jsonFileName: String): String{
        val assetManager = assets
        val inputStream = assetManager.open(jsonFileName)
        val bufferReader = BufferedReader(InputStreamReader(inputStream))
        val jsonString = bufferReader.readText()
        return jsonString
    }
}