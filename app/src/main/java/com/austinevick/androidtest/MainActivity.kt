package com.austinevick.androidtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.austinevick.androidtest.screens.BottomNavigationBar
import com.austinevick.androidtest.ui.theme.AndroidTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidTestTheme {
                BottomNavigationBar()
            }
        }
    }

}

