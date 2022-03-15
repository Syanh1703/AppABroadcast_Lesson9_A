package com.example.appabroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyReceiver :BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val name :String = intent?.getStringExtra(MainActivity.NAME).toString()
        val addr :String = intent?.getStringExtra(MainActivity.ADDRESS).toString()
        val phone :String = intent?.getStringExtra(MainActivity.PHONE).toString()
        Log.d("SyAnh", "The name is $name \n" +
                "The address is $addr \n" +
                "The phone is $phone \n")
    }
}