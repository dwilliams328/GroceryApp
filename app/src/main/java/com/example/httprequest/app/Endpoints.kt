package com.example.httprequest.app

import com.example.httprequest.models.Category

class Endpoints {

    companion object{

        private const val URL_CATEGORY ="category"
        private const val URL_SUB_CATEGORY = "subcategory/"
        private const val URL_PRODUCT_BY_SUB_ID = "products/"
        private const val URL_REGISTER =  "auth/register"
        private const val URL_LOGIN =  "auth/login"

        fun getCategory(): String{
            return "${Config.BASE_URL + URL_CATEGORY}"
        }

        fun getImage(category: Category): String{
            return "${Config.IMAGE_URL + category.catImage}"
        }

        fun getSubCategoryByCatId(catId: Int):String{
            return "${Config.BASE_URL + URL_SUB_CATEGORY + catId}"
        }

        fun getProductBySubId(subId: Int): String{
            return "${Config.BASE_URL + URL_PRODUCT_BY_SUB_ID + subId}"
        }

        fun getRegister(): String{
            return "${Config.BASE_URL + URL_REGISTER}"
        }

        fun getLogin(): String{
            return "${Config.BASE_URL + URL_LOGIN}"
        }


    }

}