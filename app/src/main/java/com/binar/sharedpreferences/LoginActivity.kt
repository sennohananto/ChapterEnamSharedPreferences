package com.binar.sharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val username = "binar123"
        val password = "abcabc123"
        val sharedPreferences = getSharedPreferences("MySF", Context.MODE_PRIVATE)

        if(sharedPreferences.contains("username")){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }


        btnLogin.setOnClickListener {
            if(etUsername.text.toString() == username && etPassword.text.toString() == password){
                if(chkIngatSaya.isChecked){
                    val editor = sharedPreferences.edit()
                    editor.putString("username",username)
                    editor.putInt("usia",23)

                    editor.apply()
                }

                //berhasil login
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                //gagal login
                Toast.makeText(this,"Username / Password Salah",Toast.LENGTH_LONG).show()
            }
        }

    }
}