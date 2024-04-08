package nikita.app.ntiteam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import nikita.app.ntiteam.ui.theme.NtiteamTheme
import nikita.app.ntiteam.viewmodels.ViewModelGetInfo

class MainActivity : ComponentActivity() {
    
    private lateinit var viewModelGetInfo: ViewModelGetInfo
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NtiteamTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    TopLine()
                }
            }
        }

        viewModelGetInfo = ViewModelProvider(this)[ViewModelGetInfo::class.java]
        viewModelGetInfo.getRequestApi()
    }

    @Composable
    fun TopLine() {
        Column {
            Row (
                modifier = Modifier
                    .padding(16.dp, 8.dp, 16.dp, 8.dp)
                    .fillMaxWidth()
            ) {
                Image(painterResource(id = R.drawable.filter), contentDescription = "")
                Image(painterResource(id = R.drawable.logo), contentDescription = "")
                Image(painterResource(id = R.drawable.search), contentDescription = "")
            }
            LazyRow(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 0.dp, 0.dp, 0.dp)) {
                items(viewModelGetInfo.categoriesFlow) {index ->
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .height(40.dp)
                            .padding(8.dp, 0.dp, 8.dp, 0.dp),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = "Button $index")
                    }
                }
            }
            ListCategories()
        }

    }

}


@Composable
fun ListCategories() {
    LazyVerticalGrid(
        GridCells.Fixed(2),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(16) {index ->  
            GridItem(index)
        }
    }
}

@Composable
fun GridItem(index: Int) {
    Text(
        text = "Item $index",
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}

@Preview(showBackground = true, device = "id:pixel_xl")
@Composable
fun GreetingPreview() {
    NtiteamTheme {
        TopLine()
    }
}