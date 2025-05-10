package com.example.mlacharacters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import android.content.Intent
import android.net.Uri
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterListScreen(characters: List<Character>, navController: NavController) {
    LazyColumn(

        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),

        contentPadding = PaddingValues(top = 60.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)

    ) {
        items(characters) { character ->
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF2B2B2B)),
                elevation = CardDefaults.cardElevation(4.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(modifier = Modifier.padding(12.dp)) {
                    Image(
                        painter = painterResource(id = character.imageRes),
                        contentDescription = character.name,
                        contentScale = ContentScale.Crop,

                        modifier = Modifier
                            .width(90.dp)
                            .height(140.dp)
                            .padding(end = 12.dp)

                    )

                    Column(modifier = Modifier.weight(1f)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = character.name,
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "2016",
                                style = MaterialTheme.typography.labelMedium,
                                color = Color.LightGray
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.Top
                        ) {
                            Text(
                                text = "Deskripsi: ",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.bodyMedium
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = character.description,
                                color = Color.White,
                                style = MaterialTheme.typography.bodySmall,
                                modifier = Modifier.weight(1f)
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            val context = LocalContext.current

                            Button(
                                onClick = {
                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(character.wikiUrl))
                                    context.startActivity(intent)
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9BB1EB)),
                                modifier = Modifier.weight(1f)
                            ) {
                                Text("Detail Hero", color = Color.White)
                            }

                            Button(
                                onClick = {
                                    navController.navigate("detail/${character.name}")
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9BB1EB)),
                                modifier = Modifier.weight(1f)
                            ) {
                                Text("Deskripsi", color = Color.White)
                            }
                        }
                    }
                }
            }
        }
    }
}
