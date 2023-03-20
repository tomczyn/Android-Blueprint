package blueprint.ui.greeting

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import blueprint.ui.common.AppScreen
import blueprint.ui.common.theme.BlueprintTheme

@Composable
fun GreetingScreen() {
    AppScreen {
        Greeting("Android")
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", color = MaterialTheme.colorScheme.onBackground)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BlueprintTheme { GreetingScreen() }
}
