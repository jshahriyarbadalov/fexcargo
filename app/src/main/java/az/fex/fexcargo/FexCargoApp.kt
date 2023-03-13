package az.fex.fexcargo

import android.app.Application
import androidx.databinding.ktx.BuildConfig
import androidx.work.Configuration
import androidx.work.DelegatingWorkerFactory
import az.fex.core.network.NetworkMonitor
import az.fex.fexcargo.di.DataSourceModule
import az.fex.fexcargo.di.RepositoryModule
import az.fex.fexcargo.di.ViewModelModule
import az.fex.fexcargo.domain.worker.DailyRequestNewsWorker
import az.fex.fexcargo.domain.worker.DailyWorkerNewsFactory
import com.onurcan.core.helper.WorkHelper
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class FexCargoApp : Application(), Configuration.Provider {
    private val dailyWorkerNewsFactory: DailyWorkerNewsFactory by inject()

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
         NetworkMonitor(this).startNetworkCallback()

        startKoin {
            androidContext(this@FexCargoApp)
            val list = arrayListOf(
                DataSourceModule.repo,
                ViewModelModule.vm,
                RepositoryModule.repo
            )
            modules(list)
        }
        val initDelay = 1L
        WorkHelper.launchWork<DailyRequestNewsWorker>(applicationContext, initDelay)
    }

    override fun onTerminate() {
        super.onTerminate()
         NetworkMonitor(this).stopNetworkCallback()
    }

    override fun getWorkManagerConfiguration(): Configuration {
        val delegater = DelegatingWorkerFactory()
          delegater.addFactory(dailyWorkerNewsFactory)

        return Configuration.Builder()
            .setWorkerFactory(delegater)
            .build()
    }

}