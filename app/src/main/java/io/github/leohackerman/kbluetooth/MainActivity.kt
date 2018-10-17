package io.github.leohackerman.kbluetooth

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import io.github.leohackerman.bluetooth.KBluetoothManager
import kotlinx.android.synthetic.main.activity_main.*
import android.Manifest.permission
import android.Manifest.permission.ACCESS_COARSE_LOCATION
import java.util.jar.Manifest


class MainActivity : AppCompatActivity() {

    val kBluetoothManager = KBluetoothManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start_discovery.setOnClickListener{
            kBluetoothManager.discover(this)
        }

    }


}
