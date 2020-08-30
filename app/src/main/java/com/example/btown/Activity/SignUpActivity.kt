package com.example.btown

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.btown.Database.userDatabase
import com.example.btown.user.UserEntity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class SignUpActivity:CoroutineScope, AppCompatActivity(){
    val userDAO by lazy {
        userDatabase.getInstance(this).userDAO()
    }
    override val coroutineContext: CoroutineContext get() = Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        signup.setOnClickListener(){
            join.setOnClickListener(){
                launch(coroutineContext + Dispatchers.IO) {
                    insertUser(UserEntity(userID = userID.text.toString(), userPW = userPW.text.toString(),
                        userEmail = userEmail.text.toString(), userGender = userGender.selectedItem.toString(),
                        userName = userName.text.toString(), userNickName = userNickName.text.toString(),
                        userSocialNumber = userSocialNumber.text.toString(), userPhoneNumber = userPhoneNumber.text.toString(),
                        userMileage = 0))

                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@SignUpActivity,
                            "Register your information",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
            val intent = Intent(this@SignUpActivity, SignUpActivity::class.java)

            startActivity(intent)
        }
    }

    suspend fun insertUser(user: UserEntity) = withContext(Dispatchers.IO) {
        userDAO.insertUser(user)
    }
}