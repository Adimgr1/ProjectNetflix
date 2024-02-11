package com.example.projectnetflix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectnetflix.ui.theme.ProjectNetflixTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            mainUI()

        }
    }
}
@Composable
@Preview
fun mainUI(){
    val hollywoodActions= mutableListOf<MovieItem>()
    hollywoodActions.add(MovieItem(R.drawable.p1))
    hollywoodActions.add(MovieItem(R.drawable.p2))
    hollywoodActions.add(MovieItem(R.drawable.p3))
    hollywoodActions.add(MovieItem(R.drawable.p4))
    hollywoodActions.add(MovieItem(R.drawable.p5))
    hollywoodActions.add(MovieItem(R.drawable.p6))
    hollywoodActions.add(MovieItem(R.drawable.p7))
    val bollywoodAction= mutableListOf<MovieItem>()
    bollywoodAction.add(MovieItem(R.drawable.b1))
    bollywoodAction.add(MovieItem(R.drawable.b2))
    bollywoodAction.add(MovieItem(R.drawable.b3))
    bollywoodAction.add(MovieItem(R.drawable.b4))
    bollywoodAction.add(MovieItem(R.drawable.b5))
    val romanticMovies= mutableListOf<MovieItem>()
    romanticMovies.add(MovieItem(R.drawable.l1))
    romanticMovies.add(MovieItem(R.drawable.l2))
    romanticMovies.add(MovieItem(R.drawable.l3))
    romanticMovies.add(MovieItem(R.drawable.l4))
    romanticMovies.add(MovieItem(R.drawable.l5))


    Column( modifier= Modifier
        .fillMaxSize()
        .background(Color.Black)
        .verticalScroll(rememberScrollState())) {
        UpperBar()
        Selector()
        FeaturedMovie()
        Play()
        movies("Hollywood Actions",hollywoodActions)
        movies(name = "Bollywood Actions",bollywoodAction)
        movies("Romantic Movies",romanticMovies)

    }

}
@Composable
fun UpperBar(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(Color.Black),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(painter = painterResource(id = R.drawable.netflixlogo),
            contentDescription ="Logo",
            modifier= Modifier.size(110.dp))
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(end=15.dp)){
            Image(painter = painterResource(id = R.drawable.baseline_search_24),
                contentDescription ="Logo",
                modifier= Modifier
                    .size(65.dp)
                    .padding(end = 15.dp))
            Image(painter = painterResource(id = R.drawable.baseline_account_circle_24),
                contentDescription ="Logo",
                modifier= Modifier.size(50.dp))

        }


    }
}
@Composable
fun Selector(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(Color.Black)
        .padding(start = 30.dp, end = 30.dp),
        horizontalArrangement = Arrangement.SpaceBetween){
        Text(text = "TV Shows", color = Color.White, fontSize = 20.sp)
        Text(text = "Movies", color = Color.White,fontSize=20.sp)
        Row {
            Text(text = "Categories", color = Color.White,fontSize= 20.sp)
            Image(painter = painterResource(id = R.drawable.baseline_arrow_drop_down_24),
                contentDescription ="Arrow" )

        }
    }
}
@Composable
fun FeaturedMovie(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 40.dp)
        .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally){
        Image(painter = painterResource(id = R.drawable.dunkifeatured),
            contentDescription ="Featured Movie", modifier = Modifier.height(360.dp) )
        Row(modifier= Modifier
            .padding(top = 40.dp, start = 35.dp, end = 35.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
            ) {
            Text(text = "Drama", fontSize = 15.sp, color = Color.White)
            Text(text = "Comedy", fontSize = 15.sp, color = Color.White)
            Text(text = "Noble Language", fontSize = 15.sp, color = Color.White)
            Text(text = "Romance", fontSize = 15.sp, color = Color.White)
        }

    }

}
@Composable

fun Play(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 50.dp, end = 50.dp, top = 30.dp)
    , horizontalArrangement = Arrangement.SpaceBetween,){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.baseline_add_24), contentDescription ="My List" )
            Text("My List",color= Color.White)
        }
        Box(modifier = Modifier
            .background(Color.White)
            .width(70.dp)
            .height(40.dp),
            contentAlignment = Alignment.Center,
            ) {
            Text(text = "Play", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
        Column {
            Image(painter = painterResource(id = R.drawable.baseline_assignment_late_24),
                contentDescription ="Info" )
            Text(text = "info", color = Color.White)
        }

    }


}
@Composable
fun movies(name:String,list:List<MovieItem>){




    Column(modifier= Modifier.padding(top = 10.dp, start = 5.dp)) {
        Text(text = name, fontSize = 20.sp, color = Color.White)
        LazyRow(modifier= Modifier.padding(top=10.dp)){
            itemsIndexed(list){
                index, item ->
                ModelUi(image =item.image)
            }
        }

    }

}


@Composable
fun ModelUi(image:Int){
    Image(painter = painterResource(id = image), contentDescription ="" ,
        modifier= Modifier
            .width(150.dp)
            .height(200.dp)
            .padding(start = 0.dp)
    )




}
data class MovieItem(
    val image:Int
)
