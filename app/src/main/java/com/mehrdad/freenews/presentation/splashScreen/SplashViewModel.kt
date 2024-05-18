package com.mehrdad.freenews.presentation.splashScreen

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehrdad.freenews.data.repository.DataStoreRepository
import com.mehrdad.freenews.presentation.navigation.Route
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val repository: DataStoreRepository,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    private val _startDestination: MutableState<String> = mutableStateOf(Route.WELCOME)
    val startDestination: State<String> = _startDestination

    private val _hadNotificationPermission: MutableState<Boolean> = mutableStateOf(
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED
        } else {
            true
        }
    )
    val hadNotificationPermission: State<Boolean> = _hadNotificationPermission

    fun saveNotificationPermissionState(hasPermission: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveNotificationPermissionState(hasPermission)
        }
    }

    init {
        viewModelScope.launch {
            repository.readOnBoardingState().collect { completed ->
                if (completed) {
                    _startDestination.value = Route.HOME
                } else {
                    _startDestination.value = Route.WELCOME
                }
            }
            repository.readNotificationPermissionState().collect { hadPermission ->
                _hadNotificationPermission.value = hadPermission
            }
            _isLoading.value = false
        }
    }
}