package tw.nolions.anigamerappuimock.widget

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import tw.nolions.anigamerappuimock.ui.theme.AniGamerAppUIMockTheme

@Composable
fun PageHeaderView(title: String) {
    Text(
        text = title,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
    )
}

@Preview(showBackground = true)
@Composable
fun PageHeaderPreview() {
    AniGamerAppUIMockTheme {
        PageHeaderView("紀錄")
    }
}
