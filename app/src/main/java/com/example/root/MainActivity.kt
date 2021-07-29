package com.example.root

import android.os.Bundle
import android.provider.DocumentsContract
import androidx.appcompat.app.AppCompatActivity
import com.example.root.databinding.ActivityMainBinding
import com.example.root.utils.GeneralUtils
import com.example.root.utils.RootUtils

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)

        wireUI()
    }

    private fun wireUI() {
        with(binding) {
            powerOffButton.setOnClickListener {
                if (RootUtils.getSuPath().isNullOrBlank()) {
                    try {
                        val process = Runtime.getRuntime().exec(arrayOf(RootUtils.getSuPath(), "-c", "reboot -p"))
                        process.waitFor()
                    } catch (ex: Exception) {
                        ex.printStackTrace()
                    }
                } else {
                    GeneralUtils.makeToast(applicationContext, "Device is not rooted.")
                }
            }

            rebootButton.setOnClickListener {
                if (RootUtils.getSuPath().isNullOrBlank()) {
                    try {
                        val process = Runtime.getRuntime().exec(arrayOf(RootUtils.getSuPath(), "-c", "reboot"))
                        process.waitFor()
                    } catch (ex: Exception) {
                        ex.printStackTrace()
                    }
                } else {
                    GeneralUtils.makeToast(applicationContext, "Device is not rooted.")
                }
            }

            installApkButton.setOnClickListener {
                if (RootUtils.getSuPath().isNullOrBlank()) {
                    try {
                        val process = Runtime.getRuntime().exec(arrayOf(RootUtils.getSuPath(), "-c", "pm install pathToApk.apk"))
                        process.waitFor()
                    } catch (ex: Exception) {
                        ex.printStackTrace()
                    }
                } else {
                    GeneralUtils.makeToast(applicationContext, "Device is not rooted.")
                }
            }
        }
    }
}