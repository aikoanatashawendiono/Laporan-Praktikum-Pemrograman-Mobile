package com.example.mlacharacters

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(navController: NavHostController) {
    val characters = listOf(
        Character("Crocell", "Mage, Order: Light Equipment", R.drawable.crocell, "Role: Mage\nType: Order - Light Equipment\n\nSaya menyukai hero ini karena tampilannya yang sangat cantik dan positif dan voicenya yang ceria, menarik serta lucu. Saya paling menyukai voice line ketika menang, 'Horay, we won!'. Ultimate Crocell juga berguna untuk team fight dan efek ultimatenya terang dan bagus, seperti bintang yang jatuh di langit dengan sukacita.", "https://mla.fandom.com/wiki/Crocell"),
        Character("Astraia Sipra", "Support, Hybrid, Light - Tech: Light Equipment", R.drawable.sipra, "Role: Support\nType: Hybrid (Light - Tech) - Light Equipment\n\nDikenal dengan panggilan Sipra. Hero ini juga termasuk dalam favorit saya karena ultimatenya yang sangat berguna untuk war. Bahkan Sipra B4 bisa mengimbangi war hero yang sudah awakened. Ultimatenya adalah meng-summon hero secara acak.", "https://mla.fandom.com/wiki/Astraia_Sipra"),
        Character("Nana", "Spirit, Martial: Light Equipment", R.drawable.nana, "Role: Spirit\nType: Martial - Light Equipment\n\nNana di Mobile Legends Bang Bang dengan Mobile Legends Adventure sangat berbeda. Jujur ketika saya pertama kali memakai hero ini, skill nya sangat berbeda dengan yang versi moba nya. Skill 2 disini adalah memberi heal pada tim dan ultimatenya membangkitkan hero yang sudah mati, atau me-respawn hero secara langsung ketika ultimatenya siap.", "https://mla.fandom.com/wiki/Nana"),
        Character("Mecha Layla", "Marksman, Hybrid (Light - Tech): Light Equipment", R.drawable.mechalayla, "Role: Marksman\nType: Hybrid (Light - Tech) - Light Equipment\n\nLayla di MLA ada 2 versi, yang pertama adalah Layla dan yang kedua adalah Mecha Layla. Hero menurut saya juga cukup meta karena memiliki kemampuan heal kepada tim, dan pasifnya yang tidak dapat diserang oleh lawan (invisible). Jadi, Mecha Layla akan memberi damage dan heal secara terus-menerus tanpa tereteksi oleh musuh. Namun, ketika semua hero di tim telah lenyap, maka Mecha Layla juga ikut lenyap", "https://mla.fandom.com/wiki/Mecha_Layla"),
        Character("Natsu", "Fighter, Hybrid (Dark - Martial): Medium Equipment", R.drawable.natsu, "Role: Fighter\nType:Hybrid (Dark - Martial) - Medium Equipment\n\nNatsu, hero kolaborasi dengan anime Fairy Tail. Natsu dan Lucy dengan status card SSR, dan Erza dengan status card UR. Saya mendapatkan card Natsu secara gratis melalui event, hanya cukup menjalankan quest saya bisa mendapatkan Natsu dengan B5 merah (belum awakened). Yang saya sukai dari hero ini adalah ketika posisi back line diserang, Natsu dengan cepat menghampiri dan menyerang serta ultimatenya yang mendorong semua musuh ke kanan, dimana ini sangat menguntungkan tim terutama jika dikombo dengan Alice atau hero tipe AoE. Entah ini kebetulan atau bukan, tapi saya juga seringkali melihat ketika Natsu mengeluarkan ultimate pada HP di bawah 15%, HP dia akan terisi secara penuh kembali (kekebalan tubuh)", "https://mla.fandom.com/wiki/Natsu"),
        Character("Naiad Rafaela", "Hybrid (Light - Elemental): Light Equipment", R.drawable.rafaela, "Role:Support\nType: Hybrid (Light - Elemental) - Light Equipment\n\nVersi lain dari hero Rafaela. Saya tidak memperhatikan skill-skillnya apakah berguna untuk war atau tidak. Namun, ketika saya pertama kali melihat hero SSR ini, saya langsung menyukainya karena desainnya yang begitu cantik, anggun, elegan, dan sangat nature (menyatu dengan alam). ", "https://mla.fandom.com/wiki/Naiad_Rafaela"),
        Character("Shah Torre", "Mage, Chaos: Light Equipment", R.drawable.torre, "Role: Mage\nType: Chaos - Light Equipment\n\nShah Torre, hero yang sangat menyebalkan jika menjadi musuh. Ultimate hero ini menyerap bar energi, dimana ketika bar energi sudah penuh, maka hero akan mengeluarkan ultimate mereka. Namun, dengan ultimate Torre ini maka ultimate hero lawan akan tertunda karena ia menyerap bar energi pada semua hero.", "https://mla.fandom.com/wiki/Shah_Torre"),
        Character("Forseti", "Marksman, Order: Light Equipment", R.drawable.forseti, "Role: Marksman\nType: Order - Light Equipment\n\nSaya baru tahu ada hero ini ketika Tower of Babel khusus hero Order dibuka. Awalnya saya tidak menaruh harapan yang tinggi kepada hero ini, namun ketika melihat ia MVP di hampir semua match, saya memperhatikan skill-skillnya. Yang menarik dari hero ini adalah ultimatenya, ketika Forseti mengeluarkan ultimate maka ia akan mati. Jadi, hero ini kurang cocok jika tidak ada hero lain yang bisa me-respawn hero tim, seperti Nana atau Singularity Lunox.", "https://mla.fandom.com/wiki/Forseti"),

    )
    val charMap = characters.associateBy { it.name }

    NavHost(navController, startDestination = "list") {
        composable("list") {
            CharacterListScreen(characters = characters, navController = navController)
        }
        composable("detail/{name}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name")
            val character = charMap[name]
            character?.let {
                CharacterDetailScreen(character = it, navController = navController)
            }
        }
    }
}

