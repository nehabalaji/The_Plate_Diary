package com.nbapps.theplatediary.feature.dashboard.ui

data class DashboardUiState(
    val displayName: String = "",
    val dailyCalorieGoal: Int? = null,
    val todayLoggedMeals: Int = 0,
)
