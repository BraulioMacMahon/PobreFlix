package com.example.pobreflix.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.pobreflix.R


@Composable
fun Welcome(
    login: () -> Unit
){
    Surface(Modifier.fillMaxSize()) {

        Column(

            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Box(Modifier.padding(10.dp).fillMaxWidth(), contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(R.drawable.welcome_image),
                    contentDescription = null,
                    Modifier.size(400.dp)
                )
            }
            Text(
                text = stringResource(R.string.seja_bem_vindo),
                textAlign = TextAlign.Justify,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 40.sp,
                color = Color(0xff01356d)
            )


            Box() {
                Text(
                    text = stringResource(R.string.descricao_welcome),
                    textAlign = TextAlign.Justify,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Light,
                    fontSize = 20.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(vertical = 20.dp, horizontal = 50.dp)
                )
            }
            Row(modifier = Modifier.padding(top = 50.dp)) {
                val shape = RoundedCornerShape(20)
                Button(
                    onClick = {
                        login()
                    },
                    colors = ButtonDefaults.buttonColors(Color(0xff01356d)),
                    modifier = Modifier.size(width = 300.dp, height = 50.dp),
                    shape = shape
                ) {
                    Text(
                        text = stringResource(id = R.string.comecar),
                        fontSize = 18.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Row(modifier = Modifier.padding(20.dp)) {

                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(
                            fontSize = 10.sp,
                            color = Color.DarkGray,
                            fontWeight = FontWeight.Light
                        )){
                            append(stringResource(R.string.all_rigths_reserved))
                        }

                        withStyle(style = SpanStyle(
                            fontSize = 6.sp,
                            color = Color.DarkGray,
                            fontWeight = FontWeight.Light,
                            baselineShift = BaselineShift.Superscript
                        )){
                            append("R")
                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview(){
    Welcome(login = {})
}