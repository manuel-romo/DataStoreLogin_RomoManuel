package romo.manuel.datastorelogin_romomanuel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import romo.manuel.datastorelogin_romomanuel.data.DataStoreManager
import romo.manuel.datastorelogin_romomanuel.ui.screens.MainScreen
import romo.manuel.datastorelogin_romomanuel.ui.theme.DataStoreLogin_RomoManuelTheme
import romo.manuel.datastorelogin_romomanuel.viewmodel.AuthViewModel

/**
 * Manuel Romo López
 * ID: 00000253080
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DataStoreLogin_RomoManuelTheme {
                // En este caso, "this" es el context.
                MainScreen(viewModel = AuthViewModel(DataStoreManager(this)))
            }
        }
    }
}
