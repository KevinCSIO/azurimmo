package bts.sio.azurimmo.views.locataire

import androidx.compose.foundation.background
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import bts.sio.azurimmo.viewsmodel.locataire.LocataireViewModel
import bts.sio.azurimmo.api.RetrofitInstance
import kotlinx.coroutines.launch
import androidx.compose.ui.unit.dp
import bts.sio.azurimmo.model.Locataire

@Composable
fun LocataireDetailScreen(contratId: Int) {
    var locataire by remember { mutableStateOf<Locataire?>(null) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(contratId) {
        coroutineScope.launch {
            try {
                val response = RetrofitInstance.api.getLocataireByContratId(contratId)
                locataire = response
            } catch (e: Exception) {
                println("Erreur lors du chargement du locataire : ${e.message}")
            }
        }
    }

    locataire?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Informations sur le locataire",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
                    .padding(16.dp),
            ) {
                Row {
                    Text(
                        text = "Nom : ",
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                    )
                    Text(
                        text = it.nom,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                Row {
                    Text(
                        text = "Prénom : ",
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                    )
                    Text(
                        text = it.prenom,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                Row {
                    Text(
                        text = "Date de Naissance : ",
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                    )
                    Text(
                        text = it.dateN,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                Row {
                    Text(
                        text = "Lieu de Naissance : ",
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                    )
                    Text(
                        text = it.lieuN,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

