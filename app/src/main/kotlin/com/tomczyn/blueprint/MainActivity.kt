package com.tomczyn.blueprint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.tomczyn.blueprint.ui.common.BlueprintNavHost
import com.tomczyn.blueprint.ui.common.theme.BlueprintTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent { BlueprintTheme { BlueprintNavHost() } }
    }
}
