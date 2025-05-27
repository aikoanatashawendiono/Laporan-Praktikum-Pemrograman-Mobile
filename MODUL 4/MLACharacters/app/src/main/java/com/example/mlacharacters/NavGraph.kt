package com.example.mlacharacters

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mlacharacters.ui.CharacterViewModel
import com.example.mlacharacters.ui.theme.CharacterDetailScreen

@Composable
fun NavGraph(navController: NavHostController, viewModel: CharacterViewModel) {
    val characters = listOf(
        Character(
            "Crocell", "Mage, Order: Light Equipment", R.drawable.crocell,
            "Role: Mage\nType: Order - Light Equipment\n\nSaya menyukai hero ini karena tampilannya yang sangat cantik dan positif dan voicenya yang ceria, menarik serta lucu. Saya paling menyukai voice line ketika menang, 'Horay, we won!'. Ultimate Crocell juga berguna untuk team fight dan efek ultimatenya terang dan bagus, seperti bintang yang jatuh di langit dengan sukacita.",
            "https://mla.fandom.com/wiki/Crocell"
        ),
        Character(
            "Astraia Sipra", "Support, Hybrid, Light - Tech: Light Equipment", R.drawable.sipra,
            "Role: Support\nType: Hybrid (Light - Tech) - Light Equipment\n\nDikenal dengan panggilan Sipra. Hero ini juga termasuk dalam favorit saya karena ultimatenya yang sangat berguna untuk war. Bahkan Sipra B4 bisa mengimbangi war hero yang sudah awakened. Ultimatenya adalah meng-summon hero secara acak.",
            "https://mla.fandom.com/wiki/Astraia_Sipra"
        ),
        Character(
            "Nana", "Spirit, Martial: Light Equipment", R.drawable.nana,
            "Role: Spirit\nType: Martial - Light Equipment\n\nNana di Mobile Legends Bang Bang dengan Mobile Legends Adventure sangat berbeda. Jujur ketika saya pertama kali memakai hero ini, skill nya sangat berbeda dengan yang versi moba nya. Skill 2 disini adalah memberi heal pada tim dan ultinya membangkitkan hero yang sudah mati.",
            "https://mla.fandom.com/wiki/Nana"
        ),
        Character(
            "Mecha Layla", "Marksman, Hybrid (Light - Tech): Light Equipment", R.drawable.mechalayla,
            "Role: Marksman\nType: Hybrid (Light - Tech) - Light Equipment\n\nLayla di MLA ada 2 versi. Mecha Layla memberi heal dan damage secara terus-menerus. Tapi jika semua hero tim mati, Mecha Layla juga ikut lenyap.",
            "https://mla.fandom.com/wiki/Mecha_Layla"
        ),
        Character(
            "Natsu", "Fighter, Hybrid (Dark - Martial): Medium Equipment", R.drawable.natsu,
            "Role: Fighter\nType:Hybrid (Dark - Martial) - Medium Equipment\n\nNatsu hero kolaborasi Fairy Tail. Punya skill dorong musuh ke kanan. Menurut saya sangat berguna saat team fight, apalagi jika dikombo dengan AoE seperti Alice.",
            "https://mla.fandom.com/wiki/Natsu"
        ),
        Character(
            "Naiad Rafaela", "Hybrid (Light - Elemental): Light Equipment", R.drawable.rafaela,
            "Role:Support\nType: Hybrid (Light - Elemental) - Light Equipment\n\nDesain sangat anggun dan menyatu dengan alam. Hero ini saya sukai karena estetikanya meskipun belum terlalu dipakai untuk war.",
            "https://mla.fandom.com/wiki/Naiad_Rafaela"
        ),
        Character(
            "Shah Torre", "Mage, Chaos: Light Equipment", R.drawable.torre,
            "Role: Mage\nType: Chaos - Light Equipment\n\nShah Torre menyerap bar energi musuh, sehingga bisa menunda ultimate lawan. Sangat menyebalkan jika menjadi musuh.",
            "https://mla.fandom.com/wiki/Shah_Torre"
        ),
        Character(
            "Forseti", "Marksman, Order: Light Equipment", R.drawable.forseti,
            "Role: Marksman\nType: Order - Light Equipment\n\nUltimatenya membuat Forseti langsung mati. Butuh support respawn seperti Nana atau Lunox. Saya baru sadar potensi hero ini setelah lihat performanya di Tower of Babel.",
            "https://mla.fandom.com/wiki/Forseti"
        ),
    )

    viewModel.setCharacterList(characters)

    val charMap = characters.associateBy { it.name }

    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            CharacterListScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable("detail/{name}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name")
            val character = charMap[name]
            character?.let {
                viewModel.logNavigateDetail(it)
                CharacterDetailScreen(character = it, navController = navController)
            }
        }
    }
}
