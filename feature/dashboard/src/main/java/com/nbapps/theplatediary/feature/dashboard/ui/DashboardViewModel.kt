package com.nbapps.theplatediary.feature.dashboard.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nbapps.theplatediary.core.domain.repository.GoalRepository
import com.nbapps.theplatediary.core.domain.repository.MealLogRepository
import com.nbapps.theplatediary.core.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class DashboardViewModel @Inject constructor(
    userRepository: UserRepository,
    goalRepository: GoalRepository,
    mealLogRepository: MealLogRepository,
) : ViewModel() {

    // Placeholder until auth/onboarding picks active user.
    private val userId = "demo-user"

    val uiState: StateFlow<DashboardUiState> = combine(
        userRepository.observeUser(userId),
        goalRepository.observeActiveGoal(userId),
        mealLogRepository.observeMealLogs(userId),
    ) { user, goal, mealLogs ->
        DashboardUiState(
            displayName = user?.displayName.orEmpty(),
            dailyCalorieGoal = goal?.dailyCalories,
            todayLoggedMeals = mealLogs.size,
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = DashboardUiState(),
    )
}
