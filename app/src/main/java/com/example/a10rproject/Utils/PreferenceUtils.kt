package com.example.a10rproject.Utils

import android.content.Context
import android.content.SharedPreferences
import java.util.*

class PreferenceUtils(context: Context) {

    private var preferences: SharedPreferences
    private var preEditor: SharedPreferences.Editor

    init {
        preferences = context.getSharedPreferences("TEMP", Context.MODE_PRIVATE)
        preEditor = preferences.edit()
    }


    var saveBoolean: Boolean
        get() = preferences.getBoolean(KEY_BOOLEAN, false)
        set(value) {
            preEditor.run {
                putBoolean(KEY_BOOLEAN, value)
                commit()
            }
        }


    var saveString: String
        get() = preferences.getString(KEY_STRING, "")?: ""
        set(value) {
            preEditor.run {
                putString(KEY_STRING, value)
                commit()
            }
        }


    var saveLong: Long
        get() = preferences.getLong(KEY_LONG, 0L)
        set(value) {
            preEditor.run {
                putLong(KEY_LONG, value)
                commit()
            }
        }



    var saveInt: Int
        get() = preferences.getInt(KEY_INT, 0)
        set(value) {
        preEditor.run {
            putInt(KEY_INT, value)
            commit()
        }
    }

    companion object {
        private val KEY_STRING = "KEY_STRING"

        private val KEY_INT = "KEY_INT"

        private val KEY_LONG = "KEY_INT"

        private val KEY_BOOLEAN = "KEY_INT"


        private var instance: PreferenceUtils? = null

        fun getInstance(context: Context) = instance
            ?: PreferenceUtils(context).also { instance = it }
    }



}