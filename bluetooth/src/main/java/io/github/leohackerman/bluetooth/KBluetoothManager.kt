package io.github.leohackerman.bluetooth

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.content.Intent

class KBluetoothManager {

    val btAdapter : BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()

    fun isBTSupported():Boolean{
        return (btAdapter != null)
    }

    fun enableBT(activity: Activity){
        if (btAdapter?.isEnabled == false){
            val enableBTIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            activity.startActivityForResult(enableBTIntent, REQUEST_ENABLE_BT)
        }
    }
}