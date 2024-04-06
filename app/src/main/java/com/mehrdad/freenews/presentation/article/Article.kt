package com.mehrdad.freenews.presentation.article

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.mehrdad.freenews.R
import com.mehrdad.freenews.presentation.LocalSpacing
import com.mehrdad.freenews.presentation.components.NewsAgencyName
import com.mehrdad.freenews.ui.theme.Primary
import com.mehrdad.freenews.ui.theme.Tertiary

@Composable
fun Article() {
    val spacing = LocalSpacing.current
    Column(modifier = Modifier.padding(spacing.spaceSmall)) {
        NewsAgencyName()
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = spacing.spaceSemiLarge)
                .clip(RoundedCornerShape(spacing.spaceMedium)),
            painter = painterResource(id = R.drawable.sample_image),

            contentDescription = "sample"
        )
        Text(text = "GENERAL NEWS",
            fontFamily = FontFamily(Font(R.font.archivo_variable_font_wdth_wght)),
            fontSize = 12.sp,
            color = Tertiary,
            fontWeight = FontWeight.Bold,
            letterSpacing = (-0.5).sp,
            maxLines = 1,
            modifier = Modifier.fillMaxWidth().padding(vertical = spacing.spaceExtraSmall)
            )
        Text(text = "Traffic in Philippines' Capital City of Manila Worsens Despite Measures to Ease Congestion",
            fontFamily = FontFamily(Font(R.font.archivo_variable_font_wdth_wght)),
            fontSize = 24.sp,
            color = Primary,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = (-0.5).sp,
            maxLines = 3,
            modifier = Modifier.fillMaxWidth().padding(vertical = spacing.spaceExtraSmall)
        )
        Text(text = "MANILA, Philippines - Despite efforts to ease traffic congestion in the capital city of Manila, residents are reporting that traffic has only gotten worse. The government has implemented a number of measures in recent years, including the construction of new roadways and the implementation of a color-coded coding scheme for vehicles, but these efforts have done little to alleviate the problem.\n" +
                "According to a recent survey, the average commuter in Manila spends an average of three hours a day stuck in traffic. This has not only caused frustration and inconvenience for residents, but it is also taking a toll on the city's economy. Businesses are struggling to keep up with the high costs of transportation and delivery, and many residents are finding it difficult to make it to work on time.\n" +
                "The government has acknowledged the problem and is looking for new solutions to ease the traffic congestion. Some officials have suggested the implementation of a more comprehensive public transportation system, while others have proposed the construction of new flyovers and underpasses.\n" +
                "As the population and urbanization of Manila is growing rapidly, traffic congestion is becoming a major problem for the city. The government is doing efforts to ease the traffic but seems not enough to solve the problem. Hopefully, new solutions will be implemented soon to improve the quality of life for the residents of Manila.",
            fontFamily = FontFamily(Font(R.font.archivo_variable_font_wdth_wght)),
            fontSize = 16.sp,
            color = Primary,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.sp,
            lineHeight = 20.sp,
            modifier = Modifier.fillMaxWidth().padding(vertical = spacing.spaceExtraSmall)
        )
    }
}

@Preview(
    device = "spec:width=1440px,height=2560px,dpi=560", showSystemUi = true,
    showBackground = true
)
@Composable
fun ArticlePrev() {
    Article()
}