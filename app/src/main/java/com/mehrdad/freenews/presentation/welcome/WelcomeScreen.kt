package com.mehrdad.freenews.presentation.welcome

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mehrdad.freenews.presentation.navigation.Route
import com.mehrdad.freenews.presentation.profile.CountryDropdown

@Composable
fun WelcomeScreen(
    navController: NavHostController,
    viewModel: WelcomeViewModel = hiltViewModel()
) {
    Column {
        Text(text = "Please select your country")
        CountryDropdown(
            modifier = Modifier.fillMaxWidth(),
            countries = viewModel.state.countries,
            selectedCountryIndex = viewModel.state.selectedCountryIndex,
            selectedCountryName = viewModel.state.selectedCountry.name,
            onCountrySelected = {
                viewModel.onEvent(WelcomeEvent.UpdateSelectedCountry(it))
            }
        )
        Button(onClick = {
            viewModel.saveOnBoardingState(completed = true)
            navController.popBackStack()
            navController.navigate(Route.HOME)
        }) {
            Text(text = "Next")
        }
    }

}