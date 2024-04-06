package com.mehrdad.freenews.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mehrdad.freenews.R
import com.mehrdad.freenews.data.Filter
import com.mehrdad.freenews.presentation.LocalSpacing
import com.mehrdad.freenews.presentation.components.FilterButton
import com.mehrdad.freenews.ui.theme.Primary
import com.mehrdad.freenews.ui.theme.Tertiary

@Composable
fun HomeScreen() {
    val spacing = LocalSpacing.current
    val filterItems = listOf<Filter>(
        Filter("General", true),
        Filter("Health", false),
        Filter("Finance", false),
    )
    Scaffold(
        modifier = Modifier.padding(spacing.spaceExtraSmall),
        topBar = {
            Spacer(
                modifier = Modifier
                    .height(spacing.spaceXXLarge)
                    .fillMaxWidth()
                    .background(Primary)
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(paddingValues = it)
                .padding(horizontal = spacing.spaceSmall)
        ) {
            LazyRow(
                modifier = Modifier.padding(vertical = spacing.spaceMedium),
            ) {
                items(filterItems) { filter ->
                    FilterButton(
                        modifier = Modifier.padding(end = spacing.spaceSmall),
                        text = filter.text,
                        isSelected = filter.isSelected,
                        onClick = {})
                }
            }
            Text(
                text = "Now!",
                fontFamily = FontFamily(Font(R.font.archivo_variable_font_wdth_wght)),
                color = Tertiary,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = (-0.5).sp
            )

        }
    }
}

@Preview(
    device = "spec:width=1440px,height=2560px,dpi=560", showSystemUi = true,
    showBackground = true
)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}