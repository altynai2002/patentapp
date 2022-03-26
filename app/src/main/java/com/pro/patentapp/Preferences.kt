package com.pro.patentapp
import android.content.Context

interface Preferences {
    fun savePin(email: String)
    fun savePassword(password: String)
    fun saveName(txt: String)
    fun saveSurname(txt: String)
    fun saveOtchestvo(txt: String)

    fun getPin(email: String): String
    fun getPassword(password: String): String
    fun getName(txt: String): String
    fun getSurname(txt: String): String
    fun getOtchestvo(txt: String): String
}

class PreferencesImpl(context: Context) : Preferences {
    private val preferences = context.getSharedPreferences("Pref", Context.MODE_PRIVATE)

    override fun savePin(pin: String) {
        preferences.edit().apply {
            putString(PIN, pin)
        }.apply()
    }

    override fun savePassword(password: String) {
        preferences.edit().apply {
            putString(PASSWORD, password)
        }.apply()
    }

    override fun saveName(txt: String) {
        preferences.edit().apply {
            putString(NAME, txt)
        }.apply()
    }

    override fun saveSurname(txt: String) {
        preferences.edit().apply {
            putString(SURNAME, txt)
        }.apply()
    }

    override fun saveOtchestvo(txt: String) {
        preferences.edit().apply {
            putString(OTCHESTVO, txt)
        }.apply()
    }


    override fun getPin(email: String): String {
        return preferences.getString(PIN, "") ?: ""
    }

    override fun getPassword(password: String): String {
        return preferences.getString(PASSWORD, "") ?: ""
    }

    override fun getName(txt: String): String {
        return preferences.getString(PASSWORD, "") ?: ""
    }

    override fun getSurname(txt: String): String {
        return preferences.getString(PASSWORD, "") ?: ""
    }

    override fun getOtchestvo(txt: String): String {
        return preferences.getString(PASSWORD, "") ?: ""
    }

    companion object {
        const val PIN = "EMAIL"
        const val NAME = "NAME"
        const val SURNAME = "SURNAME"
        const val OTCHESTVO = "OTCHESTVO"
        const val PASSWORD = "PASSWORD"
    }

}