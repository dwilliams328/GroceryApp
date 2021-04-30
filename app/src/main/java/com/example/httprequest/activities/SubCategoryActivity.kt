package com.example.httprequest.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.httprequest.R
import com.example.httprequest.app.Endpoints
import com.example.httprequest.models.CategoryResponse
import com.example.httprequest.models.SubCategoryResponse
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class SubCategoryActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_category)

        init()
    }

    private fun init() {

        getData()

//        var adapterSubCategoryFragment = AdapterSubCategoryFragment(supportFragmentManager)
//        view_pager.adapter = adapterSubCategoryFragment
//
//        tab_layout.setupWithViewPager(view_pager)
    }

    private fun getData() {

        // Instantiate the Volley
        var requestQueue = Volley.newRequestQueue(this)
        // request object pass or fail.
        var request = StringRequest(
            Request.Method.GET,
            Endpoints.getSubCategory(),
            {
                var gson = Gson()
                var subCategoryResponse = gson.fromJson(it, SubCategoryResponse::class.java)
                //adapterSubCategory.setData(subCategoryResponse.data)
                progress_bar.visibility = View.GONE
            },
            {
                Toast.makeText(applicationContext, it.message, Toast.LENGTH_SHORT).show()
                Log.d("abc", it.message.toString())
            }
        )
        // Add request to Volley RequestQueue for network operations
        requestQueue.add(request)
    }
}