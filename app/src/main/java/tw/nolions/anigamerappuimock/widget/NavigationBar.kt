package tw.nolions.anigamerappuimock.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tw.nolions.anigamerappuimock.R
import tw.nolions.anigamerappuimock.ui.theme.AniGamerAppUIMockTheme

enum class Screen {
    HOME, SEARCH, FAVORITE, RECORD, MY
}

data class NavigationItem(val title: String, val iconResId: Int, val screen: Screen)

fun navigationItemList() = listOf(
    NavigationItem(title = "首頁", iconResId = R.drawable.ic_home, screen = Screen.HOME),
    NavigationItem(title = "搜尋", iconResId = R.drawable.ic_search, screen = Screen.SEARCH),
    NavigationItem(title = "收藏", iconResId = R.drawable.ic_favorite, screen = Screen.FAVORITE),
    NavigationItem(title = "紀錄", iconResId = R.drawable.ic_record, screen = Screen.RECORD),
    NavigationItem(title = "我的", iconResId = R.drawable.ic_my, screen = Screen.MY),
)

/**
 * App Main Navigation Bar Composable method
 */
@Composable
fun NavigationBar(state: MutableState<Screen>) {
    BottomAppBar(
        backgroundColor = Color.White,
        modifier = Modifier.border(
            BorderStroke(width = 1.dp, color = Color.Black)
        )
    ) {
        Row(
            modifier = Modifier.weight(5f)
        ) {
            navigationItemList().forEach {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(1f)
                        .absolutePadding(left = 8.dp, right = 8.dp)
                ) {
                    NavigationItem(
                        painter = painterResource(it.iconResId),
                        text = it.title,
                        clickEnable = state.value == it.screen,
                        click = {
                            state.value = it.screen
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun NavigationItem(clickEnable: Boolean, painter: Painter, text: String, click: () -> Unit) {
    IconButton(onClick = click, enabled = !clickEnable) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painter, contentDescription = null,
                tint = Color.Black
            )
            Text(text = text, color = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNavigationBar() {
    AniGamerAppUIMockTheme {
        val state = remember { mutableStateOf(Screen.HOME) }
        NavigationBar(state)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNavigationItem() {
    AniGamerAppUIMockTheme {
        NavigationItem(
            painter = painterResource(R.drawable.ic_record),
            text = "紀錄",
            clickEnable = false,
            click = {
            }
        )
    }
}
