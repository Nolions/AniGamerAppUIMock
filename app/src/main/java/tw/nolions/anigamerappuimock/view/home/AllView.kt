package tw.nolions.anigamerappuimock.view.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tw.nolions.anigamerappuimock.model.Video
import tw.nolions.anigamerappuimock.ui.theme.AniGamerAppUIMockTheme
import tw.nolions.anigamerappuimock.widget.VerticalVideoItemView

@ExperimentalFoundationApi
@Composable
fun allView() {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(4.dp),

        ) {
        allViewList().forEachIndexed { index, item ->
            item {
                VerticalVideoItemView(index, item)
            }
        }
    }
}

private fun allViewList() = listOf(
    Video(title = "終末後宮", ep = 1, date = "01/23"),
    Video(title = "一拳超人", ep = 1, date = "01/23"),
    Video(title = "世界頂尖暗殺者轉生為異世界貴族", ep = 1, date = "01/23"),
    Video(title = "機動戰士鋼彈 OO 第二季", ep = 1, date = "01/23"),
    Video(title = "機動戰士鋼彈 00", ep = 1, date = "01/23"),
    Video(title = "星期一的豐滿", ep = 1, date = "01/23"),
    Video(title = "境界戰機 第二季", ep = 1, date = "01/23"),
    Video(title = "月光下的異世界之旅", ep = 1, date = "01/23"),
    Video(title = "星期一的豐滿 第二季", ep = 1, date = "01/23")
)


@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun AllViewPreview() {
    AniGamerAppUIMockTheme {
        allView()
    }
}