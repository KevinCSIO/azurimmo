package bts.sio.azurimmo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import bts.sio.azurimmo.views.batiment.BatimentList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BatimentList()
        }
    }
}
// Fonction pour prévisualiser l'interface
@Preview(showBackground = true)
@Composable
fun PreviewBatimentList() {
    BatimentList()
}