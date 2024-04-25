package com.mehrdad.freenews.presentation.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mehrdad.freenews.data.model.Country

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
    event: (ProfileEvent) -> Unit,
    navController: NavController
) {
//    var selectedCountry by remember { mutableStateOf("Select Country")}

    Column(Modifier.fillMaxWidth()) {
        Text(text = viewModel.state.selectedCountry.name)
        CountryDropdown(
            modifier = Modifier.fillMaxWidth(),
            onCountrySelected = { event(ProfileEvent.UpdateSelectedCountry(Country(it.name,it.initials))) }
//        selectedCountry = selectedCountry
        )
    }
}