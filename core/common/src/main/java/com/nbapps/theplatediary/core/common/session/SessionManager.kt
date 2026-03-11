package com.nbapps.theplatediary.core.common.session

import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@Singleton
class SessionManager @Inject constructor() {
    private val _currentUserId = MutableStateFlow<String?>(null)
    val currentUserId: StateFlow<String?> = _currentUserId.asStateFlow()

    fun setCurrentUserId(userId: String?) {
        _currentUserId.value = userId
    }

    fun clearSession() {
        _currentUserId.value = null
    }
}
