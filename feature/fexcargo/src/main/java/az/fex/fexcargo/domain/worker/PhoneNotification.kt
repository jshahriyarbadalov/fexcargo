package az.fex.fexcargo.domain.worker

import android.app.NotificationManager
import android.app.PendingIntent
import android.graphics.Bitmap
import androidx.core.app.NotificationCompat
import androidx.databinding.ktx.BuildConfig
import androidx.navigation.NavDeepLinkBuilder
import az.fex.fexcargo.R
import az.fex.fexcargo.data.repository.FexRepository


class PhoneNotification(
    private val notificationManager: NotificationManager,
    private val notificationCompat: NotificationCompat.Builder,
    private val navDeepLinkBuilder: NavDeepLinkBuilder,
) {

    companion object {
        const val notificationId = 1210_2022
        const val channelId = "{${BuildConfig.LIBRARY_PACKAGE_NAME}.Fex}"
    }

    fun showNotifications(newsAllResponse: FexRepository, largeIcon: Bitmap) {
        //val newsAllResponseInitial = newsAllResponse.articles!![0]
//        val notificationCompat = notificationCompat.setContentTitle(newsAllResponseInitial.title)
//            .setSmallIcon(az.fex.core.R.drawable.ic_launcher_background)
//            .setLargeIcon(largeIcon)
//            .setStyle(
//                NotificationCompat.BigPictureStyle()
//                    .bigPicture(largeIcon)
//                    .bigLargeIcon(largeIcon)
//            )
//            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
//            .setAutoCancel(true)
//        val notification: Notification = notificationCompat.build()
//        notificationManager.notify(notificationId, notification)
    }

//    private fun getContentIntent(): PendingIntent {
//        return navDeepLinkBuilder.setGraph(R.navigation.nav_host)
//             .setDestination(R.id.homeFragment)
//            .createPendingIntent()
//    }
}