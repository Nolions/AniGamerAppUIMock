package tw.nolions.anigamerappuimock.view.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tw.nolions.anigamerappuimock.ui.theme.AniGamerAppUIMockTheme

@ExperimentalFoundationApi
@Composable
fun HomeView() {
    var tabIndex by remember { mutableStateOf(1) }
    val tabTitles = listOf("全部", "推薦", "分類")

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment =  Alignment.CenterHorizontally,
    ) {
        TabRow(
            selectedTabIndex = tabIndex,
            backgroundColor = Color.White,
            modifier = Modifier.width(300.dp)
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(selected = tabIndex == index,
                    onClick = { tabIndex = index },
                    text = { Text(text = title) })
            }
        }
        when (tabIndex) { // 6.
            0 -> Text("Hello content")
            1 -> recommendView()
            2 -> Text("World content")
        }
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun HomeViewPreview() {
    AniGamerAppUIMockTheme {
        HomeView()
    }
}