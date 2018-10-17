package io.github.leohackerman.bluetooth

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Intent

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

    fun getPairedDevices():Set<BluetoothDevice>?{
        val pairedDevices: Set<BluetoothDevice>? = btAdapter?.bondedDevices
        pairedDevices?.forEach { device ->
            val deviceName = device.name
            val deviceHardwareAddress = device.address // MAC address
        }
        return pairedDevices
    }

}