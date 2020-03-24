package com.kergasa.seoultoilet

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.GoogleMap
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var googleMap: GoogleMap? = null
    val permission = Permission(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mapView.onCreate(savedInstanceState)
        if (permission.checkPermissions()) {
            initMap()
        }
        else {
            permission.requestPermissios()
        }
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }
}

class Permission(val context: Context, val PERMISSION_REQUEST_CODE: Int = 1) {
    val PERMISSIONS = arrayOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION
    )

    fun checkPermissions(): Boolean {
        for (p in PERMISSIONS) {
            if (ActivityCompat.checkSelfPermission(context, p) != PackageManager.PERMISSION_GRANTED) return false
        }

        return true
    }

    fun requestPermissios(): Unit = ActivityCompat.requestPermissions(context, PERMISSIONS, PERMISSION_REQUEST_CODE)

    override fun 
}
