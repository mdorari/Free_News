package com.mehrdad.freenews.presentation.profile

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
    navController: NavController
) {
    var selectedCountry by remember { mutableStateOf("Select Country")}

    Text(text = "Profile Screen")
    CountryDropdown(selectedCountry = selectedCountry) {country ->
        selectedCountry = country
    }
}