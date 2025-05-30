package bts.sio.azurimmo.views.locataire
/*
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
import bts.sio.azurimmo.model.Appartement
import bts.sio.azurimmo.model.Batiment
import bts.sio.azurimmo.model.Contrat
import bts.sio.azurimmo.model.Locataire
import bts.sio.azurimmo.viewsmodel.locataire.LocataireViewModel

@Composable
fun LocataireAdd(onAddLocataire: (Locataire) -> Unit, contratId: Int) {

    val viewModel: LocataireViewModel = viewModel()
    var dateN by remember { mutableStateOf("") }
    var lieuN by remember { mutableStateOf("") }
    var nom by remember { mutableStateOf("") }
    var prenom by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = dateN,
            onValueChange = { dateN = it },
            label = { Text("Date de Naissance") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = lieuN,
            onValueChange = { lieuN = it },
            label = { Text("Lieu de Naissance") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = nom,
            onValueChange = { nom = it },
            label = { Text("Nom") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = prenom,
            onValueChange = { prenom = it },
            label = { Text("Prénom") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val contrat = Contrat(
                    id = contratId,
                    dateEntree = "",
                    dateSortie = "",
                    montantLoyer = 0,
                    montantCharges = 0,
                    statut = "",
                    appartement = Appartement(
                        id = 0,
                        numero = ,
                        surface = ,
                        nbrePieces = ,
                        description = ,
                        batiment = Batiment(
                            id = 0,
                            adresse = "",
                            ville = ""))
                )) // seul l’id nous interesse ici

                val locataire = Locataire(
                    id = 0,
                    dateN = dateN,
                    lieuN = lieuN,
                    nom = nom,
                    prenom = prenom
                )
                viewModel.addLocataire(locataire)
                onAddLocataire(locataire)
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Ajouter le locataire")
        }
    }
}
*/