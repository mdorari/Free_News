package com.mehrdad.freenews.presentation.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mehrdad.freenews.data.model.getCountryInitials

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
    navController: NavController
) {
    var selectedCountry by remember { mutableStateOf("Select Country")}

    Column(Modifier.fillMaxWidth()) {
        Text(text = selectedCountry)
        CountryDropdown(
            modifier = Modifier.fillMaxWidth()
//        selectedCountry = selectedCountry
        ) {country ->
            selectedCountry = getCountryInitials(country)
        }
    }
}