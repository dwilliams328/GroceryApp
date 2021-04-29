package com.example.httprequest.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.httprequest.models.Employee

class DBHelper(var mContext: Context) : SQLiteOpenHelper(mContext, DATABASE_NAME, null, DATABASE_VERSION) {

    var db: SQLiteDatabase = writableDatabase

    companion object{
        const val DATABASE_NAME = "mydb"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "employee"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_EMAIL = "email"
    }


    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "create table $TABLE_NAME ($COLUMN_ID integer, $COLUMN_NAME char(50), $COLUMN_EMAIL varchar(200))"
        db?.execSQL(createTable)
        Log.d("abc", "onCreate")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.d("abc", "onUpgrade")
        val dropTable = "drop table $TABLE_NAME"
        db?.execSQL(dropTable)
        onCreate(db)

    }

    fun addEmployee(employee: Employee){
        var contentValues = ContentValues()
        contentValues.put(COLUMN_ID, employee.id)
        contentValues.put(COLUMN_NAME, employee.name)
        contentValues.put(COLUMN_EMAIL, employee.email)
        db.insert(TABLE_NAME, null, contentValues)
        Log.d("abc", "addEmployee")
    }

    //update employee - set name ,email where id = ?
    fun updateEmployee(employee: Employee) :Int{
        var contentValues = ContentValues()
        contentValues.put(COLUMN_NAME,employee.name)
        contentValues.put(COLUMN_EMAIL,employee.email)
        //Filter
        var whereClause = "$COLUMN_ID = ?" //value provided at runtime not compilation

        // Convert into string because this is expecting a string array
         var whereArgs = arrayOf(employee.id.toString())

        Log.d("abc", "UpdateEmployee")

        //returns integer value of number of rows
        return db.update(TABLE_NAME,contentValues,whereClause,whereArgs)

    }

    // Delete from employee where id = ?
    fun deleteEmployee(employee: Employee): Int{
        //Filter
        var whereClause = "$COLUMN_ID = ?" //value provided at runtime not compilation

        // Convert into string because this is expecting a string array
        var whereArgs = arrayOf(employee.id.toString())

        Log.d("abc", "DeleteEmployee")

        return db.delete(TABLE_NAME,whereClause,whereArgs)
    }

}