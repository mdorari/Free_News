package com.mehrdad.freenews.presentation.profile

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.mehrdad.freenews.data.local.defaultCountries
import com.mehrdad.freenews.data.remote.model.Country

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryDropdown(
    modifier: Modifier = Modifier,
//    viewModel: ProfileViewModel = hiltViewModel(),
    onCountrySelected: (Country) -> Unit,
    countries:List<Country>,
    selectedCountryIndex:Int,
    selectedCountryName:String
) {
//    val countries = viewModel.state.countries

    var expanded by remember {
        mutableStateOf(false)
    }
//    val selectedCountryText = defaultCountries[selectedCountryIndex].name

    ExposedDropdownMenuBox(
        modifier = Modifier.fillMaxWidth(),
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        TextField(
            modifier = Modifier.menuAnchor(),
            value = selectedCountryName,
            readOnly = true,
            onValueChange = {},
            label = { Text(text = "Select your country") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) }
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }) {
            countries.forEachIndexed { index, country ->
                DropdownMenuItem(
                    text = { Text(text = country.name) },
                    onClick = {
//                        selectedCountryText = countries[index].name
                        onCountrySelected(countries[index])
                        expanded = false
                    })
            }
        }
    }
}