package com.example.asus.capturebugsbunny

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class StartPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_page)
    }

    fun start(view: View){
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }
}
