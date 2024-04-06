package com.mehrdad.freenews.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
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
import com.mehrdad.freenews.presentation.LocalSpacing
import com.mehrdad.freenews.ui.theme.Secondary
import com.mehrdad.freenews.ui.theme.Tertiary

@Composable
fun FilterButton(
    modifier: Modifier,
    text:String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val spacing = LocalSpacing.current
    OutlinedButton(
        modifier = modifier,
        onClick = {
            if (!isSelected) {
                onClick()
            }
        },
        border = if (isSelected) {
            BorderStroke(width = 1.dp, color = Tertiary)
        } else BorderStroke(width = 1.dp, color = Secondary)
    ) {
        Text(
            modifier = Modifier.padding(
                horizontal = spacing.spaceSemiMedium),
            text = text,
            fontFamily = FontFamily(Font(R.font.archivo_variable_font_wdth_wght)),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            letterSpacing = (-0.8).sp,
            color = if (isSelected) Tertiary else Secondary,
        )
    }
}

@Preview(
    device = "spec:width=1440px,height=2560px,dpi=560", showSystemUi = true,
    showBackground = true
)
@Composable
fun FilterButtonPreview() {
    FilterButton(modifier = Modifier.padding(8.dp), text = "General",isSelected = true,onClick = { })
}