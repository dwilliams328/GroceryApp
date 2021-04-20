package com.example.httprequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        button_submit.setOnClickListener {
            getData()
        }
    }

    //Get Data from REMOTE API
    private fun getData() {
        var requestQueue = Volley.newRequestQueue(this)
        var request = StringRequest(
                Request.Method.GET,
                "https://jsonplaceholder.typicode.com/posts",
                Response.Listener {
                    //Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
                    //text_view_data.text = it
                    var data = ""
                    var jsonArrayData = JSONArray(it)
                    for(i in 0 until jsonArrayData.length()){
                        var jsonObjData = jsonArrayData.getJSONObject(i)
                        var userId = jsonObjData.getInt("userId")
                        var id = jsonObjData.getInt("id")
                        var title = jsonObjData.getString("title")
                        var body = jsonObjData.getString("body")
                        data += "$title \n"
                    }
                    text_view_data.text = data

                },
                Response.ErrorListener {
                    Toast.makeText(applicationContext, it.message, Toast.LENGTH_SHORT).show()
                }
        )
        requestQueue.add(request)
    }
}