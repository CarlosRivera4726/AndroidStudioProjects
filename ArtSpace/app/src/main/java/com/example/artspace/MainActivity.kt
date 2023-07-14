package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                    border = BorderStroke(10.dp)
                ) {
                    imagesArtSpacePrev()

                }
            }
        }
    }
}

@Composable
fun imagesArtSpace(modifier: Modifier = Modifier){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var result by remember { mutableStateOf(1) }

        val imageResource = when(result){
            1 -> R.drawable.gato_1
            2 -> R.drawable.gato_2
            3 -> R.drawable.gato_3
            4 -> R.drawable.gato_4
            5 -> R.drawable.gato_5
            6 -> R.drawable.gato_6
            else -> R.drawable.gato_7
        }

        val gatoResource = when(result){
            1 -> R.string.gato_1
            2 -> R.string.gato_2
            3 -> R.string.gato_3
            4 -> R.string.gato_4
            5 -> R.string.gato_5
            6 -> R.string.gato_6
            else -> R.string.gato_7
        }

        val autorResource = when(result){
            1 -> R.string.autor_1
            2 -> R.string.autor_2
            3 -> R.string.autor_3
            4 -> R.string.autor_4
            5 -> R.string.autor_5
            6 -> R.string.autor_6
            else -> R.string.autor_7
        }

        Image(
            painter = painterResource(id = imageResource),
            contentDescription = "Gatos :D",
        )
        // cont imagenes
        Text(text = "Imagen: " + result.toString() + " / 7")
        Spacer(modifier = Modifier.padding(15.dp))
        Text(
            text = stringResource(id = gatoResource),
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Text(
            text = "Autor: " + stringResource(id = autorResource),
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.padding(15.dp))
        Row() {
            Button(
                onClick = {
                    if(result > 1){
                        result--
                    }
                          },

                ) {
                Text(text = "Previo")
            }
            Spacer(modifier = Modifier.padding(6.dp))
            Button(
                onClick = {
                    if(result < 7){
                        result++;
                    }
                          },

                ) {
                Text(text = "Siguiente")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun imagesArtSpacePrev() {
    ArtSpaceTheme {
        imagesArtSpace(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
        )
    }
}