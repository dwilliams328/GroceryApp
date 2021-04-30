package com.example.httprequest.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.httprequest.R
import com.example.httprequest.activities.SubCategoryActivity
import com.example.httprequest.app.Endpoints
import com.example.httprequest.models.Category
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_category_adapter.view.*

class AdapterCategory (var mContext: Context): RecyclerView.Adapter<AdapterCategory.ViewHolder>(){

    var mList: ArrayList<Category> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.row_category_adapter,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var category = mList[position]
        holder.bind(category)
    }

    fun setData(list: ArrayList<Category>){
        mList = list
        //inform adapter dataset has completed
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    //Obtain Item
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        //Bind Data with Item
        fun bind(category: Category){
            itemView.text_view_category_name.text = category.catName

            //Load Respective Category Image in itemView
            Picasso
                .get()
                .load(Endpoints.getImage(category))
                .into(itemView.image_view_category)

            itemView.setOnClickListener {
                var intent = Intent(mContext,SubCategoryActivity::class.java)

                mContext.startActivity(intent)
            }
        }
    }
}