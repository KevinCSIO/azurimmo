package bts.sio.azurimmo.views.accueil

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun AccueilScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bienvenue sur AzurImmo !",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
        )

        Button(onClick = { navController.navigate("batiment_list") }) {
            Text("Bâtiments")
        }

        /*Button(onClick = { navController.navigate("appartement_list")
        }) {
            Text("Appartements")
        }

        Button(onClick = { navController.navigate("contrat_list")
        }) {
            Text("Contrats")
        }

        Button(onClick = { navController.navigate("locataire_list")
        }) {
            Text("Locataires")
        }*/
    }
}
