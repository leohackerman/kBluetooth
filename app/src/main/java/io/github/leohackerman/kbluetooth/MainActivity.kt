package io.github.leohackerman.kbluetooth

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.github.leohackerman.bluetooth.KBluetoothManager

class MainActivity : AppCompatActivity() {

    val kBluetoothManager = KBluetoothManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("bluetooth",kBluetoothManager.hello())
    }
}
