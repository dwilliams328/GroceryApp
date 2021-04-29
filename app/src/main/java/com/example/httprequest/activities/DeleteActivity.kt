package com.example.httprequest.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.httprequest.R
import com.example.httprequest.database.DBHelper
import com.example.httprequest.models.Employee
import kotlinx.android.synthetic.main.activity_delete.*

class DeleteActivity : AppCompatActivity() {

    lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)

        dbHelper = DBHelper(this)

        init()
    }

    private fun init() {
        button_delete.setOnClickListener {
            var id = edit_text_id.text.toString().toInt()

            var employee = Employee(id,null,null)

            dbHelper.deleteEmployee(employee)
            Toast.makeText(applicationContext,"Employee ID: ${employee.id} deleted", Toast.LENGTH_SHORT).show()

            var intent = Intent(this,CRUDActivity::class.java)

            startActivity(intent)

        }
    }
}