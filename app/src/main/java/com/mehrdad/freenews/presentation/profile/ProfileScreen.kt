package com.mehrdad.freenews.presentation.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mehrdad.freenews.data.remote.model.Country

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
    event: (ProfileEvent) -> Unit,
    navController: NavController
) {

    Column(Modifier.fillMaxWidth()) {
        Text(text = viewModel.state.selectedCountry.name)
        CountryDropdown(
            modifier = Modifier.fillMaxWidth(),
            countries = viewModel.state.countries,
            selectedCountryIndex = viewModel.state.selectedCountryIndex,
            selectedCountryName = viewModel.state.selectedCountry.name,
            onCountrySelected = {
                viewModel.onEvent(ProfileEvent.UpdateSelectedCountry(it))
            }
        )
    }
}