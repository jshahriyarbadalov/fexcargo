package az.fex.fexcargo.domain.worker

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import az.fex.fexcargo.data.repository.FexRepository
import com.onurcan.core.helper.BitmapLoader

class DailyWorkerNewsFactory(
    private val newsAllRepository: FexRepository,
    private val notification: PhoneNotification,
    private val bitmapLoader: BitmapLoader,
) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters,
    ): ListenableWorker? {
        return when (workerClassName) {
            DailyRequestNewsWorker::class.java.name -> {
                DailyRequestNewsWorker(
                    appContext,
                    workerParameters,
                    newsAllRepository,
                    notification,
                    bitmapLoader
                )
            }
            else -> null
        }
    }
}