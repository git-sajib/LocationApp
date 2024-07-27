package com.example.locationapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import android.Manifest
import androidx.compose.material3.Button

import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import com.example.locationapp.ui.theme.LocationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LocationAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //codebase
                }
            }
        }
    }
}

@Composable
    fun LocationDisplay(
        locationUtils: LocationUtils,
        context: Context
    ) {

        val requestPermissionLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestMultiplePermissions(),
            onResult = { permissions ->
                if(permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true
                    && permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true){
                    // I have ACCESS to location
                } else {
                    // Ask for permission
                }
            })

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "Location not available")
        Button(onClick = {
            if(locationUtils.hasLocationPermission(context)){
                // Permission already granted update the location
            } else {
                // Request location permission
                // ...
            }
        }) {
            Text(text = "Get Location")
        }
        }
    }