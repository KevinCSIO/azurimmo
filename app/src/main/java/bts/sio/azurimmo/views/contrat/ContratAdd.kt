package bts.sio.azurimmo.views.contrat

import ContratViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ContratAdd(onAddContrat: (Contrat) -> Unit, appartementId: Int) {

    val viewModel: ContratViewModel = viewModel()
    var dateEntree by remember { mutableStateOf("") }
    var dateSortie by remember { mutableStateOf("") }
    var montantLoyer by remember { mutableStateOf("") }
    var montantCharges by remember { mutableStateOf("") }
    var statut by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = dateEntree,
            onValueChange = { dateEntree = it },
            label = { Text("Date d'Entrée") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = dateSortie,
            onValueChange = { dateSortie = it },
            label = { Text("Date de Sortie") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = montantLoyer,
            onValueChange = { montantLoyer = it },
            label = { Text("Montant du Loyer") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = montantCharges,
            onValueChange = { montantCharges = it },
            label = { Text("Montant des Charges") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = statut,
            onValueChange = { statut = it },
            label = { Text("Statut") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val appartement = Appartement(id = appartementId, dateEntree = "zouzou", dateSortie = "labas") // seul l’id nous interesse ici

                val appartement = Appartement(
                    id = 0,
                    numero = numero,
                    description = description,
                    surface = surface.toFloat(),
                    nbrePieces = nbrePieces.toInt(),
                    batiment = batiment
                )
                viewModel.addAppartement(appartement)
                onAddAppartement(appartement)
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Ajouter l'appartement ")
        }
    }
}
