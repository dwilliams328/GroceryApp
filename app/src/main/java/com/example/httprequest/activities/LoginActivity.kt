package com.example.httprequest.activities

import User
import Users
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.httprequest.R
import com.example.httprequest.app.Endpoints
import com.example.httprequest.services.SessionManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()
    }

    private fun init() {
        validLogin()
    }


    private fun validLogin() {
        button_login.setOnClickListener {

            var email = edit_text_email.text.toString()
            var password = edit_text_password.text.toString()


            var jsonObjects = JSONObject()
            jsonObjects.put("email",email)
            jsonObjects.put("password",password)

            var requestQueue = Volley.newRequestQueue(this)
            var jsonRequest = JsonObjectRequest(
                Request.Method.POST,
                Endpoints.getLogin(),
                jsonObjects,
                //Store token and user response values in Shared Preference.
                {
                    Log.d("abc",it.toString())

                    var gson = Gson()
                    var userResponse = gson.fromJson(it.toString(),Users::class.java)
                    Log.d("abc",userResponse.toString())

                    var sessionManager = SessionManager(this)

                    sessionManager.login(userResponse.user)

                },
                {
                    Toast.makeText(applicationContext,it.message, Toast.LENGTH_SHORT).show()
                    Log.d("abc",it.toString())

                }

            )
            requestQueue.add(jsonRequest)

            var intent = Intent(this,MainActivity::class.java)

            startActivity(intent)
        }
    }
}