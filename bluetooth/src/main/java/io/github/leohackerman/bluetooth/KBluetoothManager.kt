package io.github.leohackerman.bluetooth

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.core.app.ActivityCompat

class KBluetoothManager {

    val btAdapter : BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()

    /**
     * Checks if BT is supported by the device
     */
    fun isBTSupported():Boolean{
        return (btAdapter != null)
    }

    /**
     * If BT is not enabled, it asks the user to do it
     */
    fun enableBT(activity: Activity){
        if (btAdapter?.isEnabled == false){
            val enableBTIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            activity.startActivityForResult(enableBTIntent, REQUEST_ENABLE_BT)
        }
    }

    /**
     * Returns a set of paired devices
     */
    fun getPairedDevices():Set<BluetoothDevice>?{
        val pairedDevices: Set<BluetoothDevice>? = btAdapter?.bondedDevices
        pairedDevices?.forEach { device ->
            val deviceName = device.name
            val deviceHardwareAddress = device.address // MAC address
        }
        return pairedDevices
    }

    fun discover(activity: Activity){
        // Request for the location permission. THIS IS REQUIRED in order to discover BT devices
        ActivityCompat.requestPermissions(activity,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_DISCOVERY_BT)
        val filter = IntentFilter(BluetoothDevice.ACTION_FOUND)
        activity.registerReceiver(mReceiver,filter)
        btAdapter?.startDiscovery()
    }

    private val mReceiver = object : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            val action: String = intent.action
            when(action) {
                BluetoothDevice.ACTION_FOUND -> {
                    // Discovery has found a device. Get the BluetoothDevice
                    // object and its info from the Intent.
                    val device: BluetoothDevice =
                            intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
                    val deviceName = device.name
                    val deviceHardwareAddress = device.address // MAC address
                }
            }
        }
    }

}