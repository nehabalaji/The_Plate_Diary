package com.nbapps.theplatediary.feature.dashboard.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DashboardScreen(
    uiState: DashboardUiState,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            text = "Dashboard",
            style = MaterialTheme.typography.headlineSmall,
        )
        Text(
            text = "Hello ${uiState.displayName.ifEmpty { "there" }}",
            style = MaterialTheme.typography.bodyLarge,
        )
        Text(
            text = "Daily calorie goal: ${uiState.dailyCalorieGoal?.toString() ?: "Not set"}",
            style = MaterialTheme.typography.bodyLarge,
        )
        Text(
            text = "Meals logged today: ${uiState.todayLoggedMeals}",
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}
