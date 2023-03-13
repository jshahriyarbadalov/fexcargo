package az.fex.fexcargo.domain.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import az.fex.fexcargo.data.repository.FexRepository
import com.onurcan.core.helper.BitmapLoader

class DailyRequestNewsWorker(
    context: Context,
    workerParameters: WorkerParameters,
    private val repository: FexRepository,
    private val notification: PhoneNotification,
    private val bitmapLoader: BitmapLoader,
) : CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {
        var result: Result = Result.retry()
//        repository.getEverything("NewsAllRequest(applicationContext.getString(string.api_key), "bitcoin")")
//            .onCompletion { result = Result.success() }
//            .catch {
//                result = Result.failure()
//            }
//            .collect {
//                result = Result.success()
//                val resultResponse = it.articles!![0]
//                val bitmap = bitmapLoader.loadBitmap(resultResponse.urlToImage.toSafeString())
//                notification.showNotifications(it, bitmap)
//            }
        return result
    }
}