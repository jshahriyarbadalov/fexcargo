package az.fex.core.network

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import androidx.annotation.RequiresPermission
import com.onurcan.core.helper.Variable


class NetworkMonitor constructor(private val application: Application) {

    @RequiresPermission(android.Manifest.permission.ACCESS_NETWORK_STATE)
    fun startNetworkCallback() {
        val manager =
            application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val builder = NetworkRequest.Builder()

        manager.registerNetworkCallback(
            builder.build(),
            object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    super.onAvailable(network)
                    Variable.isNetworkAvailable = true
                }

                override fun onLost(network: Network) {
                    super.onLost(network)
                    Variable.isNetworkAvailable = false
                }
            }
        )
    }

    fun stopNetworkCallback() {
        val manager =
            application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        manager.unregisterNetworkCallback(ConnectivityManager.NetworkCallback())
    }
}