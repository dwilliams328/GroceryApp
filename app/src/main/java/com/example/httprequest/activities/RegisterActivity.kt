package com.example.httprequest.activities

import android.app.DownloadManager
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
import kotlinx.android.synthetic.main.activity_register.*
import org.json.JSONObject

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        init()
    }

    private fun init() {
        //submit requested new user info to custom api
        button_register.setOnClickListener {
            var firstName = edit_text_fname.text.toString()
            var email = edit_text_email.text.toString()
            var password = edit_text_password.text.toString()
            var mobile = edit_text_phone.text.toString()

            var jsonObjects = JSONObject()
            jsonObjects.put("firstName",firstName)
            jsonObjects.put("email",email)
            jsonObjects.put("password",password)
            jsonObjects.put("mobile", mobile)

            var requestQueue = Volley.newRequestQueue(this)
            var jsonRequest = JsonObjectRequest(
                Request.Method.POST,
                Endpoints.getRegister(),
                jsonObjects,
                Response.Listener {
                    Toast.makeText(
                    applicationContext,it.toString(),Toast.LENGTH_SHORT).show()
                    Log.d("abc",it.toString())
                },
                Response.ErrorListener {
                    Toast.makeText(applicationContext,it.message,Toast.LENGTH_SHORT).show()
                    Log.d("abc",it.toString())

                }

            )
            requestQueue.add(jsonRequest)

            var intent = Intent(applicationContext,LoginActivity::class.java)

            startActivity(intent)
        }

        button_existing_user.setOnClickListener {
            var intent = Intent(this,LoginActivity::class.java)

            startActivity(intent)
        }
    }
}