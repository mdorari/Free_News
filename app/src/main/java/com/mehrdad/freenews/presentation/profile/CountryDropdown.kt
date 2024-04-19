package com.mehrdad.freenews.presentation.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun CountryDropdown(
    selectedCountry:String,
    onCountrySelected:(String) -> Unit
) {
    val countries = listOf(
        "United Arab Emirates", "Argentina", "Austria", "Australia", "Belgium", "Brazil",
        "Canada", "Switzerland", "Chile", "China", "Colombia", "Costa Rica", "Czech Republic",
        "Germany", "Egypt", "Spain", "France", "United Kingdom", "Greece", "Hong Kong", "Hungary",
        "Indonesia", "Ireland", "Israel", "India", "Italy", "Japan", "South Korea", "Lithuania",
        "Latvia", "Macau", "Mexico", "Malaysia", "Nigeria", "Netherlands", "Norway", "New Zealand",
        "Philippines", "Poland", "Portugal", "Romania", "Russia", "Saudi Arabia", "Sweden", "Singapore",
        "Slovenia", "Slovakia", "Thailand", "Turkey", "Taiwan", "Ukraine", "United States", "Venezuela",
        "South Africa"
    )

    val expanded = remember {
        mutableStateOf(false)
    }
    val selectedIndex = remember {
        mutableIntStateOf(0)
    }

    Column(modifier = Modifier.fillMaxWidth().height(100.dp)) {
        BasicTextField(
            value = selectedCountry,
            onValueChange = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            readOnly = true,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { expanded.value = !expanded.value })
        )
        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false }
        ) {
            countries.forEachIndexed { index, country ->
                DropdownMenuItem(
                    text = {Text(text = country)},
                    onClick = {
                    selectedIndex.value = index
                    onCountrySelected(countries[index])
                    expanded.value = false
                })
            }
        }
    }
}