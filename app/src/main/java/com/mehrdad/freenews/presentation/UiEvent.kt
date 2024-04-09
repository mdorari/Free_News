package com.mehrdad.freenews.presentation

sealed class UiEvent {
    object Success:UiEvent()
    data class showSnackBar(val message:UiText):UiEvent()
}