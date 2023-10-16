import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.icons.M3Icons
import androidx.compose.material3.icons.M3Icons.ArrowForward
import androidx.compose.material3.icons.M3Icons.Clear
import androidx.compose.material3.icons.M3Icons.LightMode
import androidx.compose.material3.icons.M3Icons.NightMode
import androidx.compose.material3.icons.M3Icons.Settings
import androidx.compose.material3.icons.M3Icons.SettingsSuggest
import androidx.compose.material3.icons.M3Icons.ThumbUp
import androidx.compose.material3.icons.M3Icons.ThumbUpOutlined
import androidx.compose.material3.icons.M3Icons.Web
import androidx.compose.material3.internal.capitalize
import androidx.compose.material3.internal.toggleStateFor
import androidx.compose.material3.isSystemInDarkTheme
import androidx.compose.material3.icons.Icons.Filled
import androidx.compose.material3.icons.Icons.Outlined
import androidx.compose.material3.icons.M3Icons.ThumbDown
import androidx.compose.material3.icons.M3Icons.ThumbDownOutlined
import androidx.compose.material3.icons.M3Icons.AccountCircle
import androidx.compose.material3.icons.M3Icons.Home
import androidx.compose.material3.icons.M3Icons.Menu
import androidx.compose.material3.icons.M3Icons.Search
import androidx.compose.material3.icons.M3Icons.Star
import androidx.compose.material3.icons.M3Icons.ThumbUpOutlined
import androidx.compose.material3.icons.M3Icons.ThumbDownOutlined
import androidx.compose.material3.icons.M3Icons.ThumbUp
import androidx.compose.material3.icons.M3Icons.ThumbDown
import androidx.compose.material3.icons.M3Icons.Web
import androidx.compose.material3.icons.M3Icons.AccountCircle
import androidx.compose.material3.icons.M3Icons.Home
import androidx.compose.material3.icons.M3Icons.Menu
import androidx.compose.material3.icons.M3Icons.Search
import androidx.compose.material3.icons.M3Icons.Star
import androidx.compose.material3.icons.M3Icons.Clear
import androidx.compose.material3.icons.M3Icons.Settings
import androidx.compose.material3.icons.M3Icons.SettingsSuggest
import androidx.compose.material3.icons.M3Icons.NightMode
import androidx.compose.material3.icons.M3Icons.LightMode
import androidx.compose.material3.icons.M3Icons.ArrowForward
import androidx.compose.material3.icons.M3Icons.StarOutline
import androidx.compose.material3.icons.M3Icons.StarHalf
import androidx.compose.material3.internal.capitalize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.icons.M3Icons.ThumbUp
import androidx.compose.material3.icons.M3Icons.ThumbDown
import androidx.compose.material3.icons.M3Icons.Web
import androidx.compose.material3.icons.M3Icons.AccountCircle
import androidx.compose.material3.icons.M3Icons.Home
import androidx.compose.material3.icons.M3Icons.Menu
import androidx.compose.material3.icons.M3Icons.Search
import androidx.compose.material3.icons.M3Icons.Star
import androidx.compose.material3.icons.M3Icons.Clear
import androidx.compose.material3.icons.M3Icons.Settings
import androidx.compose.material3.icons.M3Icons.SettingsSuggest
import androidx.compose.material3.icons.M3Icons.NightMode
import androidx.compose.material3.icons.M3Icons.LightMode
import androidx.compose.material3.icons.M3Icons.ArrowForward
import androidx.compose.material3.icons.M3Icons.StarOutline
import androidx.compose.material3.icons.M3Icons.StarHalf
import androidx.compose.material3.internal.capitalize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.icons.M3Icons.ThumbUp
import androidx.compose.material3.icons.M3Icons.ThumbDown
import androidx.compose.material3.icons.M3Icons.Web
import androidx.compose.material3.icons.M3Icons.AccountCircle
import androidx.compose.material3.icons.M3Icons.Home
import androidx.compose.material3.icons.M3Icons.Menu
import androidx.compose.material3.icons.M3Icons.Search
import androidx.compose.material3.icons.M3Icons.Star
import androidx.compose.material3.icons.M3Icons.Clear
import androidx.compose.material3.icons.M3Icons.Settings
import androidx.compose.material3.icons.M3Icons.SettingsSuggest
import androidx.compose.material3.icons.M3Icons.NightMode
import androidx.compose.material3.icons.M3Icons.LightMode
import androidx.compose.material3.icons.M3Icons.ArrowForward
import androidx.compose.material3.icons.M3Icons.StarOutline
import androidx.compose.material3.icons.M3Icons.StarHalf
import androidx.compose.material3.internal.capitalize

import java.text.SimpleDateFormat
import java.util.*

class BlogActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val controller = SettingsController() // Initialize your controller here

            BlogScreen(controller = controller)
        }
    }
}

@Composable
fun BlogScreen(controller: SettingsController) {
    val items = listOf("Blogs", "Contact us", "Our Communities", "Explore")

    val scaffoldState = rememberScaffoldState()

    val formattedDate: (Date) -> String = {
        SimpleDateFormat("EEEE, d MMM y", Locale.getDefault()).format(it)
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = "Peterson Talks") },
                backgroundColor = Color.Black
            )
        },
        endDrawer = {
            EndDrawer(
                modifier = Modifier.fillMaxHeight(),
                backgroundColor = Color.Black
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items.forEach { item ->
                        Text(
                            text = item,
                            style = TextStyle(
                                color = Color.White,
                                fontWeight = FontWeight.W500,
                                fontSize = 30.sp
                            ),
                            textAlign = TextAlign.Center
                        )
                    }

                    Spacer(modifier = Modifier.height(150.dp))

                    val isDarkTheme = isSystemInDarkTheme()
                    val toggleThemeState = remember { mutableStateOf(isDarkTheme) }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(text = "Dark Mode", style = TextStyle(color = Color.White))
                        Switch(
                            checked = toggleThemeState.value,
                            onCheckedChange = { toggleThemeState.value = it }
                        )
                    }

                    IconButton(
                        onClick = { /* Close Drawer */ },
                        modifier = Modifier
                            .padding(top = 32.dp)
                            .size(40.dp)
                    ) {
                        Icon(imageVector = Icons.Filled.Clear, contentDescription = null)
                    }
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BlogList(controller = controller, formattedDate = formattedDate)
        }
    }
}

@Composable
fun BlogList(controller: SettingsController, formattedDate: (Date) -> String) {
    val blogList = listOf(/* Your list of Blog objects */)

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 32.dp)
    ) {
        items(blogList) { blog ->
            BlogContent(blog = blog, formattedDate = formattedDate)
        }
    }
}

@Composable
fun BlogContent(blog: Blog, formattedDate: (Date) -> String) {
    Column(
        modifier = Modifier.padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(35.dp))
        Image(
            painter = painterResource(id = R.drawable.your_image_resource_here),
            contentDescription = null,
            modifier = Modifier.size(width = 250.dp, height = 250.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = formattedDate(blog.date),
            style = TextStyle(fontSize = 16.sp, color = Color(0xFF696541))
        )
        Spacer(modifier = Modifier.height(20.dp))
        TitleText(text = blog.title, addArrow = true)
        Spacer(modifier = Modifier.height(25.dp))
        DescText(text = blog.desc)
        Spacer(modifier = Modifier.height(25.dp))
        BlogChipRow(additions = blog.additions)
    }
}

@Composable
fun TitleText(text: String, addArrow: Boolean = false) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = if (addArrow) 25.sp else 30.sp,
                color = Color.White,
                fontWeight = FontWeight.W500
            ),
            textAlign = TextAlign.Left
        )
        if (addArrow) {
            Icon(
                imageVector = Icons.Outlined.ArrowForward,
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}

@Composable
fun DescText(text: String) {
    Text(
        text = text,
        style = TextStyle(fontSize = 16.sp, color = Color(0xFFC0C4D0))
    )
}

@Composable
fun BlogChipRow(additions: List<TextChips>) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        additions.forEach { addition ->
            BlogChip(
                text = addition.text,
                textColor = addition.textColor,
                bgColor = addition.bgColor
            )
        }
    }
}

@Composable
fun BlogChip(text: String, textColor: Color?, bgColor: Color?) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(bgColor ?: Color.Blue, RoundedCornerShape(20.dp))
            .padding(horizontal = 8.dp, vertical = 1.5.dp)
    ) {
        Text(
            text = text,
            style = TextStyle(fontSize = 16.sp, color = textColor ?: Color.White)
        )
    }
}

@Composable
fun Image(img: String) {
    // Assuming you have a way to load images in Compose, use that method here
    // Example: CoilImage(data = img, contentDescription = null)
}

@Composable
fun Spacer(modifier: Modifier = Modifier) {
    androidx.compose.foundation.layout.Spacer(modifier = modifier)
}

@Composable
fun Padding(
    top: Dp = 0.dp,
    bottom: Dp = 0.dp,
    start: Dp = 0.dp,
    end: Dp = 0.dp,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(top = top, bottom = bottom, start = start, end = end)
            .fillMaxSize()
    ) {
        content()
    }
}
