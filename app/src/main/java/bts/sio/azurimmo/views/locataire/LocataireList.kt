package bts.sio.azurimmo.views.locataire

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import bts.sio.azurimmo.views.appartement.AppartementCard
import bts.sio.azurimmo.viewsmodel.contrat.ContratViewModel
import bts.sio.azurimmo.viewsmodel.locataire.LocataireViewModel

@Composable
fun LocataireList(
    viewModel: LocataireViewModel = viewModel(),
    contratId: Int,
    onLocataireClick: (Int) -> Unit,
    onAddLocataireClick: () -> Unit
) {
    val viewModelCon: ContratViewModel = viewModel()
    val locataires = viewModel.locataires.value
    val contrat = viewModelCon.contrat.value
    val isLoading = viewModel.isLoading.value
    val errorMessage = viewModel.errorMessage.value

    LaunchedEffect(contratId) {
        viewModel.getLocatairesByContratId(contratId)
        viewModelCon.getContrat(contratId)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            errorMessage != null -> {
                Text(
                    text = errorMessage,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(16.dp),
                    color = MaterialTheme.colorScheme.error
                )
            }

            else -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 80.dp) // espace pour ne pas cacher le bouton
                ) {
                    if (contrat != null) {
                        item {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
                                    .padding(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Informations sur le contrat",
                                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "Date d'Entrée : ${contrat.dateEntree}",
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = "Date de Sortie : ${contrat.dateSortie}",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = "Montant du Loyer : ${contrat.montantLoyer}",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = "Montant des Charges : ${contrat.montantCharges}",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = "Statut : ${contrat.statut}",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }

                        if (locataires.isNotEmpty()) {
                            item {
                                Text(
                                    text = "Liste des locataires",
                                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 1.dp)
                                        .padding(16.dp),
                                    textAlign = TextAlign.Center,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }

                            items(locataires) { locataire ->
                                LocataireCard(locataire = locataire,
                                    onLocataireClick)
                            }
                        } else {
                            item {
                                Text(
                                    text = "Il n'y a pas de locataire pour ce contrat !",
                                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp),
                                    textAlign = TextAlign.Center,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
