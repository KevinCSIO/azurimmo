package bts.sio.azurimmo.views.app

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import bts.sio.azurimmo.model.Locataire
import bts.sio.azurimmo.views.appartement.AppartementAdd
import bts.sio.azurimmo.views.appartement.AppartementList
import bts.sio.azurimmo.views.batiment.BatimentAdd
import bts.sio.azurimmo.views.batiment.BatimentList
import bts.sio.azurimmo.views.accueil.AccueilScreen
import bts.sio.azurimmo.views.contrat.ContratAdd
import bts.sio.azurimmo.views.contrat.ContratList
import bts.sio.azurimmo.views.locataire.LocataireDetailScreen


@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {
        composable("home") {
            AccueilScreen(navController)
        }

        composable("batiment_list") {
            BatimentList(
                onBatimentClick = { batimentId ->
                    navController.navigate("batiment_appartements_list/$batimentId")
                },
                onAddBatimentClick = {
                    navController.navigate("add_batiment")
                }
            )
        }

        composable(
            route = "batiment_appartements_list/{batimentId}",
            arguments = listOf(navArgument("batimentId") { type = NavType.IntType })
        ) { backStackEntry ->
            val batimentId = backStackEntry.arguments?.getInt("batimentId")
            if (batimentId != null) {
                AppartementList(batimentId = batimentId,
                    onAppartementClick = { appartementId ->
                        navController.navigate("appartement_contrats_list/$appartementId")
                    },
                    onAddAppartementClick = {
                        navController.navigate("add_appartement/$batimentId")
                    })
            } else {
                Text("Erreur : Identifiant de bâtiment manquant")
            }
        }

        composable("add_batiment") {
            BatimentAdd(onBatimentAdd = {
                navController.popBackStack() // La navigation est gérée ici
            })
        }

        // Route pour ajouter un appartement
        composable(
            "add_appartement/{batimentId}",
            arguments = listOf(navArgument("batimentId") { type = NavType.IntType })
        )
        { backStackEntry ->
            val batimentId = backStackEntry.arguments?.getInt("batimentId")
            println("Ouverture de add_appartement avec batimentId = $batimentId")
            if (batimentId != null) {
                AppartementAdd(
                    onAddAppartement = { navController.popBackStack() },
                    batimentId = batimentId
                )
            } else {
                Text("Erreur : Identifiant de bâtiment manquant")
            }
        }

        composable(
            route = "appartement_contrats_list/{appartementId}",
            arguments = listOf(navArgument("appartementId") { type = NavType.IntType })
        ) { backStackEntry ->
            val appartementId = backStackEntry.arguments?.getInt("appartementId")
            if (appartementId != null) {
                ContratList(
                    appartementId = appartementId,
                    onContratClick = { contratId ->
                        navController.navigate("contrat_locataire/$contratId")
                    },
                    onAddContratClick = {
                        navController.navigate("add_contrat/$appartementId")
                    }
                )
            } else {
                Text("Erreur : Identifiant d'appartement manquant")
            }
        }

        composable(
            "add_contrat/{appartementId}",
            arguments = listOf(navArgument("appartementId") { type = NavType.IntType })
        )
        { backStackEntry ->
            val appartementId = backStackEntry.arguments?.getInt("appartementId")
            println("Ouverture de add_contrat avec appartementId = $appartementId")
            if (appartementId != null) {
                ContratAdd(
                    onAddContrat = { navController.popBackStack() },
                    appartementId = appartementId
                )
            } else {
                Text("Erreur : Identifiant d'appartement manquant")
            }
        }

        composable(
            "contrat_locataire/{contratId}",
            arguments = listOf(navArgument("contratId") { type = NavType.IntType })
        ) { backStackEntry ->
            val contratId = backStackEntry.arguments?.getInt("contratId")
            if (contratId != null) {
                LocataireDetailScreen(contratId = contratId)
            } else {
                Text("Erreur : contratId manquant")
            }
        }
    }
}
