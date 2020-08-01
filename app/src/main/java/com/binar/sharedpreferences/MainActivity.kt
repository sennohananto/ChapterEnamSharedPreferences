package com.binar.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val sharedPreferences = getSharedPreferences("MySF", Context.MODE_PRIVATE)

        val username = sharedPreferences.getString("username","No Username in SF")

        tvUsername.text = username

        btnLogout.setOnClickListener {
            val editor = sharedPreferences.edit()

            //hapus satu data
            editor.remove("username")
            //hapus semua data
            editor.clear()
            editor.apply()
            finish()
        }
    }
}