package com.example.btown.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.btown.Database.userDatabase
import com.example.btown.Home.HomeFragment
import com.example.btown.R
import com.example.btown.SignUp.SignUpFragment
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_sign_up.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class LoginActivity : AppCompatActivity(), CoroutineScope{
    val userDAO by lazy {
        userDatabase.getInstance(this).userDAO()
    }
    override val coroutineContext: CoroutineContext get() = Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login.setOnClickListener(){
            val intent = Intent(this@LoginActivity, MainActivity::class.java)

            
        }

        join.setOnClickListener(){
            val intent = Intent(this@LoginActivity,SignUpFragment::class.java)
        }
    }
}