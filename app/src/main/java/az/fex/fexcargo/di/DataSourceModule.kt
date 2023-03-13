package az.fex.fexcargo.di

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.navigation.NavDeepLinkBuilder
import az.fex.core.utils.Constants
import az.fex.core.utils.ResProvider
import az.fex.core.utils.RetrofitClientInstance
import az.fex.fexcargo.data.remote.ApiService
import az.fex.fexcargo.domain.usecase.auth.LoginUseCase
import az.fex.fexcargo.domain.worker.DailyWorkerNewsFactory
import az.fex.fexcargo.domain.worker.PhoneNotification
import com.bumptech.glide.Glide
import az.fex.core.helper.GlideBitmapLoader
import az.fex.fexcargo.domain.usecase.auth.RegisterUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

object DataSourceModule {
    val repo: Module = module {
        buildAndroidEntities()
        buildNetworkEntities()
        buildUseCase()
        buildGlide()
        buildWorkers()
    }

    private fun Module.buildAndroidEntities() {
        single {
            androidContext().contentResolver
        }
        single {
            ResProvider(androidContext())
        }
        single {
            androidContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        }
        single {
            NotificationCompat.Builder(androidContext(), PhoneNotification.channelId)
        }
        single {
            NavDeepLinkBuilder(androidContext())
        }
    }

    private fun Module.buildNetworkEntities() {
        single {
            RetrofitClientInstance.buildRetrofitForApi(
                Constants.BASE_URL,
                ApiService::class.java
            )
        }

    }


    private fun Module.buildUseCase() {
        factory {
            LoginUseCase(get())
        }
        factory {
            RegisterUseCase(get())
        }
    }

    private fun Module.buildGlide() {
        single {
            Glide.with(androidContext())
        }
        factory {
            GlideBitmapLoader(get())
        }
    }

    private fun Module.buildWorkers() {
        single {
            PhoneNotification(get(), get(), get())
        }
        factory {
            DailyWorkerNewsFactory(get(), get(), get<GlideBitmapLoader>())
        }
    }
}