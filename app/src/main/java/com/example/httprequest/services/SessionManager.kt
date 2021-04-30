package com.example.httprequest.services

import User
import android.content.Context

class SessionManager(var mContext: Context) {

    var mList: ArrayList<User> = ArrayList()

    private val FILE_NAME = "my_pref"
    private val KEY_EMAIL = "email"
    private val KEY_PASSWORD = "password"
    private val KEY_NAME = "name"
    private val KEY_IS_LOGGED_IN = "isLoggedIn"

    var sharedPreferences = mContext.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE)
    var editor = sharedPreferences.edit()


    fun register(user: User){
        //alreadyUser() If Registerer attempts to added already existing user, then notify
        //and intent to login screen for credentials. logic needed.


        //If User Doesn't exist then add to api
        editor.putString(KEY_NAME,user.firstName)
        editor.putString(KEY_EMAIL,user.email)
        editor.putString(KEY_PASSWORD,user.password)

        editor.putBoolean(KEY_IS_LOGGED_IN,true)

        editor.commit()
    }


    fun login(user: User): Boolean{
        var saveEmail = sharedPreferences.getString(KEY_EMAIL,null)
        var savePassword = sharedPreferences.getString(KEY_PASSWORD,null)

        return  saveEmail.equals(user.email) && savePassword.equals(user.password)

    }

    //Already have user registered logic inside. From Register screen intent to Login
    fun alreadyUser(): Boolean{
        return true

    }

    fun setData(user: User){

        mList.add(user)

    }















}