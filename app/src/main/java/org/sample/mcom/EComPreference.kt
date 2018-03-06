package org.sample.mcom

import android.content.Context
import android.content.SharedPreferences


class EComPreference private constructor() {

    private val PREFERENCE_FILE = "ecom"

    private val PREFERENCE_KEY_TOKEN = "PREFERENCE_KEY_TOKEN"

    private var mSharedPreferences: SharedPreferences = ECommerceApplication.instance!!.getSharedPreferences(
            PREFERENCE_FILE, Context.MODE_PRIVATE)

    companion object {
        var mInstance: EComPreference = EComPreference()
    }

    fun getToken(): String {
        return mSharedPreferences.getString(PREFERENCE_KEY_TOKEN, null)
    }

    fun setToken(token: String?) {
        val editor = mSharedPreferences.edit()
        editor.putString(PREFERENCE_KEY_TOKEN, token)
        editor.apply()
    }
}
