package com.nbapps.theplatediary.feature.dashboard.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.nbapps.theplatediary.feature.dashboard.ui.DashboardScreen
import com.nbapps.theplatediary.feature.dashboard.ui.DashboardViewModel

const val DASHBOARD_ROUTE = "dashboard"

fun NavGraphBuilder.dashboardScreen() {
    composable(DASHBOARD_ROUTE) {
        val viewModel: DashboardViewModel = hiltViewModel()
        val uiState = viewModel.uiState.collectAsStateWithLifecycle()
        DashboardScreen(uiState = uiState.value)
    }
}
