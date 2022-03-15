package com.example.appabroadcast

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object
    {
        private lateinit var myReceiver: MyReceiver
        const val NAME = "Name"
        const val ADDRESS = "Addr"
        const val PHONE = "Phone"
        const val TESTING = "Testing"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myReceiver = MyReceiver()
        val actionBar = supportActionBar
        actionBar!!.setDisplayShowHomeEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        actionBar.setCustomView(R.layout.center_app_name)

       /* val intentFilter = IntentFilter()
        intentFilter.addAction(TESTING)
        registerReceiver(myReceiver,intentFilter)*/

        btnSend.setOnClickListener {
            val name:String = etName.text.toString()
            val addr :String = etAddress.text.toString()
            val phone :String = etPhone.text.toString()

            if(phone.length != 11)
            {
                Toast.makeText(this, "Invalid digits", Toast.LENGTH_SHORT).show()
            }
            else
            {
                val intent = Intent()
                intent.action = TESTING
                intent.putExtra(NAME, name)
                intent.putExtra(ADDRESS, addr)
                intent.putExtra(PHONE,phone)
                sendBroadcast(intent)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myReceiver)
    }
}