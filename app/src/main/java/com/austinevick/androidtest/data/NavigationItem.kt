package com.austinevick.androidtest.data

import com.austinevick.androidtest.R

data class NavigationItem(
    val route: String,
    val activeIcon: Int,
    val inactiveIcon: Int
)


val navigationItems = listOf(
    NavigationItem(Routes.Shelf.route, R.drawable.home, R.drawable.home_outline),
    NavigationItem(Routes.Invoice.route, R.drawable.invoice, R.drawable.invoice_outline),
    NavigationItem(Routes.Expense.route, R.drawable.wallet, R.drawable.wallet_outline),
    NavigationItem(Routes.Journal.route, R.drawable.journal, R.drawable.journal_outline),
    NavigationItem(Routes.Todo.route, R.drawable.todo, R.drawable.todo_outline),
    NavigationItem(Routes.Calendar.route, R.drawable.calendar, R.drawable.calendar_outline)
)

enum class Routes(val route: String) {
    Shelf("Shelf"),
    Invoice("Invoice"),
    Expense("Expense"),
    Journal("Journal"),
    Todo("Todo"),
    Calendar("Calendar"),
    HomeDetail("HomeDetail")
}