package com.austinevick.androidtest.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.austinevick.androidtest.data.Routes


@Composable
fun HomeScreen(navController: NavHostController) {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var isVisible by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Home Screen", fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name, onValueChange = { name = it },
            shape = RoundedCornerShape(10.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words),
            label = { Text(text = "Enter Name") },
            trailingIcon = {
                if (name.isNotEmpty()) IconButton(
                    onClick = {
                        navController.currentBackStackEntry?.savedStateHandle?.set("name", name)
                        navController.navigate(Routes.HomeDetail.route)
                    },
                    colors = IconButtonDefaults.iconButtonColors(containerColor = Color.LightGray)
                ) {
                    Icon(imageVector = Icons.Default.Send, contentDescription = "Info")
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Composable
fun HomeDetailScreen(name: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Home Detail Screen", fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Name: $name",fontWeight = FontWeight.SemiBold)

    }
}


