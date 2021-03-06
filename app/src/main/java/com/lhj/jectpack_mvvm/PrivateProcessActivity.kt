
package com.lhj.jectpack_mvvm;


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import util.ProcessUtils

class PrivateProcessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_private_process)
        Log.d(TAG, "PrivateProcessActivity#onCreate process Id is " + ProcessUtils.processId)
        Log.d(TAG, "PrivateProcessActivity#onCreate process Name is " + ProcessUtils.processName)
    }

    companion object {
        private val TAG: String = "PrivateProcessActivity"
    }
}