package dev.folomkin.books

import android.app.Application


// представляет из себя Context
class BookApplication : Application() {
    // регистрируется в манифесте
    companion object {
        // можно ссылаться как BookApplication.instance
        lateinit var instance: BookApplication
    }

    // запускается при старте приложения
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}