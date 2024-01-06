package kh.edu.rupp.ite.daytoon.view.viewmodel

import android.content.Context
import android.content.SharedPreferences

// ... (imports and other code)

class PreferencesManager(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    companion object {
        private const val WELCOME_PAGE_SHOWN_KEY = "welcome_page_shown"
        private const val WELCOME_SHOWN_KEY = "welcome_shown"
        private const val INTRO_SHOWN_KEY = "intro_shown"
        private const val IS_LOGGED_IN_KEY = "is_logged_in"
    }

    var isWelcomePageShown: Boolean
        get() = prefs.getBoolean(WELCOME_PAGE_SHOWN_KEY, false)
        set(value) = prefs.edit().putBoolean(WELCOME_PAGE_SHOWN_KEY, value).apply()

    var isWelcomeShown: Boolean
        get() = prefs.getBoolean(WELCOME_SHOWN_KEY, false)
        set(value) = prefs.edit().putBoolean(WELCOME_SHOWN_KEY, value).apply()

    var isIntroShown: Boolean
        get() = prefs.getBoolean(INTRO_SHOWN_KEY, false)
        set(value) = prefs.edit().putBoolean(INTRO_SHOWN_KEY, value).apply()

    var isLoggedIn: Boolean
        get() = prefs.getBoolean(IS_LOGGED_IN_KEY, false)
        set(value) = prefs.edit().putBoolean(IS_LOGGED_IN_KEY, value).apply()
}
