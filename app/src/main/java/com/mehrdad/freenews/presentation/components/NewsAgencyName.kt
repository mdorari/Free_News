package com.mehrdad.freenews.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mehrdad.freenews.R
import com.mehrdad.freenews.presentation.LocalSpacing
import com.mehrdad.freenews.ui.theme.Primary
import com.mehrdad.freenews.ui.theme.Secondary

@Composable
fun NewsAgencyName() {
    val spacing = LocalSpacing.current
    Row (verticalAlignment = Alignment.CenterVertically){
        Image(
            modifier = Modifier
                .padding(end = spacing.spaceSemiMedium)
                .width(40.dp)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(spacing.spaceXXLarge)),
            painter = painterResource(id = R.drawable.news_agency_icon),
            contentDescription = "News agency icon"
        )
        Column(verticalArrangement = Arrangement.SpaceAround) {
            Text(text = "CNN Philippines",
                color = Primary,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily(Font(R.font.archivo_variable_font_wdth_wght)),
                fontSize = 16.sp,
                letterSpacing = (-0.5).sp,
                )
            Text(text = "10 minutes ago",
                color = Primary,
                fontWeight = FontWeight.Thin,
                fontFamily = FontFamily(Font(R.font.archivo_variable_font_wdth_wght)),
                fontSize = 12.sp,
                letterSpacing = (-0.5).sp,
                )
        }
    }
}
@Preview(
    device = "spec:width=1440px,height=2560px,dpi=560", showSystemUi = true,
    showBackground = true
)
@Composable
fun NewsAgencyNamePrev() {
    NewsAgencyName()
}