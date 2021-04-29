package com.example.httprequest.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.httprequest.R
import com.example.httprequest.database.DBHelper
import com.example.httprequest.models.Employee
import kotlinx.android.synthetic.main.activity_create.*


class CreateActivity : AppCompatActivity() {
    lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        dbHelper = DBHelper(this)

        init()
    }

    private fun init() {
        button_create.setOnClickListener {
            var id = edit_text_id.text.toString().toInt()
            var name = edit_text_name.text.toString()
            var email = edit_text_email.text.toString()
            var employee = Employee(id, name, email)

            dbHelper.addEmployee(employee)
            Toast.makeText(applicationContext,"Employee Created", Toast.LENGTH_SHORT).show()

            var intent = Intent(this,CRUDActivity::class.java)

            startActivity(intent)
        }
    }
}