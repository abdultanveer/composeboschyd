package com.example.composeboschyd

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.boschyd.IAddition

/**
 * enabled aidl in build
 * created aidl file with name IAddition and method add
 * in IAddition file i changed the package name
 * refactored/renamed the package to com.example.boschyd -- the one which has the musicservice
 * added queries tag in the manifest
 * added package name to the intent
 * other steps are similar to bound services
 */
class ClientActivity : AppCompatActivity() {
var TAG = ClientActivity::class.java.simpleName
    private var mService: IAddition? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_client)

    }

    fun invokeAidl(view: View) {
        var musicIntent = Intent("ineed.addition.hyd.bosch")
        val pack = IAddition::class.java.`package`
        musicIntent.setPackage(pack.toString())
        musicIntent.setPackage(pack.name)
        intent.setPackage(pack.name)

        bindService(musicIntent,serConn, BIND_AUTO_CREATE)
    }

    private val serConn = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, aidlBinder: IBinder?) {
            mService = IAddition.Stub.asInterface(aidlBinder)
            var result = mService!!.add(10,20)
            Log.i(TAG,"the sum is --"+result)

        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            TODO("Not yet implemented")
        }
    }
    }

