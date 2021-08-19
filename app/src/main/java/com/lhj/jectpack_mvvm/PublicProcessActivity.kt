package com.lhj.jectpack_mvvm;


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import util.ProcessUtils

class PublicProcessActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_public_process)
        Log.d(TAG, "PublicProcessActivity#onCreate process Id is " + ProcessUtils.processId)
        Log.d(TAG, "PublicProcessActivity#onCreate process Name is " + ProcessUtils.processName)
    }

    companion object {
        private val TAG: String = "PublicProcessActivity"
    }
}