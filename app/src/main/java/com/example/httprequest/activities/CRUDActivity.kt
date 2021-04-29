package com.example.httprequest.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.httprequest.R
import kotlinx.android.synthetic.main.activity_c_r_u_d.*

class CRUDActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c_r_u_d)

        init()
    }

    private fun init() {
        button_create.setOnClickListener(this)
        button_update.setOnClickListener(this)
        button_delete.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            button_create -> startActivity(Intent(this,CreateActivity::class.java))
            button_update -> startActivity(Intent(this,UpdateActivity::class.java))
            button_delete -> startActivity(Intent(this,DeleteActivity::class.java))
        }
    }
}