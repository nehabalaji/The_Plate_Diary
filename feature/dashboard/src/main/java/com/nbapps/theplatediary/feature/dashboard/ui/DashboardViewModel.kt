package com.nbapps.theplatediary.feature.dashboard.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nbapps.theplatediary.core.common.session.SessionManager
import com.nbapps.theplatediary.core.domain.repository.GoalRepository
import com.nbapps.theplatediary.core.domain.repository.MealLogRepository
import com.nbapps.theplatediary.core.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
@OptIn(ExperimentalCoroutinesApi::class)
class DashboardViewModel @Inject constructor(
    sessionManager: SessionManager,
    userRepository: UserRepository,
    goalRepository: GoalRepository,
    mealLogRepository: MealLogRepository,
) : ViewModel() {
    val uiState: StateFlow<DashboardUiState> = sessionManager.currentUserId
        .flatMapLatest { userId ->
            if (userId.isNullOrBlank()) {
                flowOf(DashboardUiState(isAuthenticated = false))
            } else {
                combine(
                    userRepository.observeUser(userId),
                    goalRepository.observeActiveGoal(userId),
                    mealLogRepository.observeMealLogs(userId),
                ) { user, goal, mealLogs ->
                    DashboardUiState(
                        isAuthenticated = true,
                        displayName = user?.displayName.orEmpty(),
                        dailyCalorieGoal = goal?.dailyCalories,
                        todayLoggedMeals = mealLogs.size,
                    )
                }
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = DashboardUiState(),
        )
}
