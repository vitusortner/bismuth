package com.vitusortner.patterns.util

import android.util.Log

@Suppress("unused")
class Logger<T>(javaClass: Class<T>) {

    private val tag = "${javaClass.simpleName}::class"

    fun i(message: String, throwable: Throwable? = null) = Log.i(tag, message, throwable)

    fun d(message: String, throwable: Throwable? = null) = Log.d(tag, message, throwable)

    fun e(message: String, throwable: Throwable? = null) = Log.e(tag, message, throwable)

    fun v(message: String, throwable: Throwable? = null) = Log.v(tag, message, throwable)

    fun w(message: String, throwable: Throwable? = null) = Log.w(tag, message, throwable)

}

@Suppress("FunctionName")
fun <T : Any> T.Logger() = lazy { Logger(javaClass) }
