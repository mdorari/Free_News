package com.mehrdad.freenews.presentation.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryDropdown(
    modifier: Modifier = Modifier,
//    selectedCountry: String,
    onCountrySelected: (String) -> Unit
) {
    val countries = listOf(
        "United Arab Emirates",
        "Argentina",
        "Austria",
        "Australia",
        "Belgium",
        "Brazil",
        "Canada",
        "Switzerland",
        "Chile",
        "China",
        "Colombia",
        "Costa Rica",
        "Czech Republic",
        "Germany",
        "Egypt",
        "Spain",
        "France",
        "United Kingdom",
        "Greece",
        "Hong Kong",
        "Hungary",
        "Indonesia",
        "Ireland",
        "Israel",
        "India",
        "Italy",
        "Japan",
        "South Korea",
        "Lithuania",
        "Latvia",
        "Macau",
        "Mexico",
        "Malaysia",
        "Nigeria",
        "Netherlands",
        "Norway",
        "New Zealand",
        "Philippines",
        "Poland",
        "Portugal",
        "Romania",
        "Russia",
        "Saudi Arabia",
        "Sweden",
        "Singapore",
        "Slovenia",
        "Slovakia",
        "Thailand",
        "Turkey",
        "Taiwan",
        "Ukraine",
        "United States",
        "Venezuela",
        "South Africa"
    )

    var expanded by remember {
        mutableStateOf(false)
    }
    var selectedCountryText by remember { mutableStateOf(countries[0]) }

    ExposedDropdownMenuBox(
        modifier = Modifier.fillMaxWidth(),
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        TextField(
            modifier = Modifier.menuAnchor(),
            value = selectedCountryText,
            readOnly = true,
            onValueChange = {},
            label = { Text(text = "Select your country") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) }
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }) {
            countries.forEachIndexed { index, text ->
                DropdownMenuItem(
                    text = { Text(text = text) },
                    onClick = {
                        selectedCountryText = countries[index]
                        onCountrySelected(countries[index])
                        expanded = false
                    })
            }
        }
    }
}