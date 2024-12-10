package com.austinevick.androidtest.screens


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.austinevick.androidtest.data.Routes
import com.austinevick.androidtest.data.navigationItems

@Composable
fun BottomNavigationBar() {

    val navController = rememberNavController()

    Scaffold(bottomBar = {

        NavigationBar {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            navigationItems.forEach { item ->
                val isSelected = currentRoute == item.route
                NavigationBarItem(
                    selected = isSelected,
                    onClick = {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        Icon(
                            painterResource(id = if (isSelected) item.activeIcon else item.inactiveIcon),
                            contentDescription = item.route,
                            tint = if (isSelected) Color.Black else Color.Black.copy(0.5f),
                            modifier = Modifier.size(22.dp)
                        )
                    },
                    label = {
                        Text(
                            text = item.route,
                            color = if (isSelected) Color.Black else Color.Gray,
                            fontSize = 10.sp
                        )
                    })
            }
        }

    }) { paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            startDestination = Routes.Shelf.route
        ) {
            composable(Routes.Shelf.route) {
                HomeScreen(navController)
            }
            composable(Routes.Invoice.route) {
                InvoiceScreen()
            }
            composable(Routes.Expense.route) {
                ExpenseScreen()
            }
            composable(Routes.Journal.route) {
                JournalScreen()
            }
            composable(Routes.Todo.route) {
                TodoScreen()
            }
            composable(Routes.Calendar.route) {
                CalendarScreen()
            }
            composable(Routes.HomeDetail.route) {
                val name = navController.previousBackStackEntry?.savedStateHandle?.get<String>("name")
                if (name != null) {
                    HomeDetailScreen(name)
                }
            }
        }
    }
}





