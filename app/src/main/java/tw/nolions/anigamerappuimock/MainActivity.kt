package tw.nolions.anigamerappuimock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import tw.nolions.anigamerappuimock.ui.theme.AniGamerAppUIMockTheme
import tw.nolions.anigamerappuimock.view.SearchView
import tw.nolions.anigamerappuimock.view.VideoFavoriteView
import tw.nolions.anigamerappuimock.view.VideoRecordsView
import tw.nolions.anigamerappuimock.view.home.HomeView
import tw.nolions.anigamerappuimock.widget.NavigationBar
import tw.nolions.anigamerappuimock.widget.Screen

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AniGamerAppUIMockTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainScreen()
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun MainScreen() {
    val screenState = remember { mutableStateOf(Screen.HOME) }

    Scaffold(
        bottomBar = { NavigationBar(state = screenState) },
        content = { content(screenState) }
    )
}

@ExperimentalFoundationApi
@Composable
fun content(state: MutableState<Screen>) {
    when (state.value) {
        Screen.HOME -> {
            HomeView()
        }
        Screen.SEARCH -> {
            SearchView()
        }
        Screen.FAVORITE -> {
            VideoFavoriteView()
        }
        Screen.RECORD -> {
            VideoRecordsView()
        }
        Screen.MY -> {
        }
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AniGamerAppUIMockTheme {
        MainScreen()
    }
}