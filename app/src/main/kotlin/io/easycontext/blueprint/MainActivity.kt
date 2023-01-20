package io.easycontext.blueprint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import io.easycontext.blueprint.ui.common.BlueprintNavHost
import io.easycontext.blueprint.ui.common.theme.BlueprintTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { BlueprintTheme { BlueprintNavHost() } }
    }
}
