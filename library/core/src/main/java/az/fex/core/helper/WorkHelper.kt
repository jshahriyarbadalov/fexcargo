package com.onurcan.core.helper

import android.content.Context
import androidx.work.*
import java.util.concurrent.TimeUnit


object WorkHelper {

    inline fun <reified T : CoroutineWorker> launchWork(
        context: Context,
        initDelay: Long,
    ) {
        val constraintSet = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresStorageNotLow(true)
            .build()

        val requestWorker = PeriodicWorkRequestBuilder<T>(1, TimeUnit.DAYS)
            .setInitialDelay(initDelay, TimeUnit.SECONDS)
            .setConstraints(constraintSet)
            .build()

        WorkManager.getInstance(context)
            .enqueueUniquePeriodicWork(
                T::class.java.simpleName,
                ExistingPeriodicWorkPolicy.KEEP,
                requestWorker
            )
    }
}