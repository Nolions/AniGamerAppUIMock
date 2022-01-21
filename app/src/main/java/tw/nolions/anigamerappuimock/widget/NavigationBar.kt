package tw.nolions.anigamerappuimock.widget

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

/**
 * App Main Navigation Bar Composable method
 */
@Composable
fun NavigationBar(state: MutableState<Screen>) {
    BottomAppBar(
        backgroundColor = Color(0xFF1976D2),
//        cutoutShape = RoundedCornerShape(10.dp),
    ) {
        Row(modifier = Modifier.weight(5f)) {
            val modifier = Modifier
                .weight(1f)
                .absolutePadding(left = 8.dp, right = 8.dp)
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
            ) {
                NavigationItem(
                    painter = painterResource(R.drawable.ic_home),
                    text = "首頁",
                    clickEnable = state.value == Screen.HOME,
                    click = {
                        state.value = Screen.HOME
                    }
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
            ) {
                NavigationItem(
                    painter = painterResource(R.drawable.ic_search),
                    text = "搜尋",
                    clickEnable = state.value == Screen.SEARCH,
                    click = {
                        state.value = Screen.SEARCH
                    }
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
            ) {
                NavigationItem(
                    painter = painterResource(R.drawable.ic_favorite),
                    text = "收藏",
                    clickEnable = state.value == Screen.FAVORITE,
                    click = {
                        state.value = Screen.FAVORITE
                    })
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
            ) {
                NavigationItem(
                    painter = painterResource(R.drawable.ic_record),
                    text = "紀錄",
                    clickEnable = state.value == Screen.RECORD,
                    click = {
                        state.value = Screen.RECORD
                    }

                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
            ) {
                NavigationItem(
                    painter = painterResource(R.drawable.ic_my),
                    text = "我的",
                    clickEnable = state.value == Screen.MY,
                    click = {
                        state.value = Screen.MY
                    })
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
                tint = Color.White
            )
            Text(text = text, color = Color.White)
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
