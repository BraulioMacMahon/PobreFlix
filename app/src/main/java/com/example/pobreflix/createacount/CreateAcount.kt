package com.example.pobreflix.createacount

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pobreflix.R
import com.example.pobreflix.GreetingTextAcount
import com.example.pobreflix.data.AppDatabase
import com.example.pobreflix.data.UserRepository
import com.example.pobreflix.data.UserViewModel
import com.example.pobreflix.data.UserViewModelFactory

@Composable
fun CreateUserAcount(
    login: () -> Unit,
    onSignUpSuccess: () -> Unit,
) {
    val context = LocalContext.current
    val userDao = remember { AppDatabase.getDatabase(context).userDao() }
    val userRepository = remember { UserRepository(userDao) }
    val factory = remember { UserViewModelFactory(userRepository) }
    val viewModel: UserViewModel = viewModel(factory = factory)

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val signUpState by viewModel.signUpSuccess.collectAsState()
    var passwordVisibility by remember { mutableStateOf(false) }

    val icon = if (passwordVisibility) painterResource(R.drawable.visibility_off) else painterResource(R.drawable.visibility_on)


        Surface() {

            val snackbarHostState = remember { SnackbarHostState() }

            val myColor = Color.DarkGray

            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFFFFFFF)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Column (
                    modifier = Modifier
                        .padding(top = 70.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Column (horizontalAlignment = Alignment.CenterHorizontally){
                        Image(
                            painter = painterResource(R.drawable.pobreflix_tipo_),
                            contentDescription = null,
                            Modifier
                                .blur(0.dp)
                                .size(100.dp)
                                .alpha(3000f)
                        )

                    }


                    Spacer(modifier = Modifier.size(100.dp))


                    Card(
                        modifier = Modifier
                            .clip(RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp))
                            .fillMaxWidth()
                            .height(550.dp),
                        colors = CardDefaults.cardColors(Color(0xFFDFE9F5)),
                        elevation = CardDefaults.cardElevation(10.dp)
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(25.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            GreetingTextAcount(
                                title = stringResource(R.string.create_acount)
                            )

                            Spacer(modifier = Modifier.size(30.dp))

                            TextField(
                                value = username,
                                onValueChange = { username = it },
                                label = {
                                    Text(text = "User Name",
                                        color = Color.LightGray)

                                },
                                maxLines = 1,
                                textStyle = TextStyle(color = Color.DarkGray),
                                modifier = Modifier.size(300.dp, 55.dp),
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Rounded.Email,
                                        contentDescription = stringResource(R.string.email_icon),
                                        tint = Color(0xff01356d),
                                        modifier = Modifier.size(20.dp)
                                    )
                                },

                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = Color.Transparent,
                                    unfocusedContainerColor = Color.Transparent,
                                    focusedLabelColor = com.example.pobreflix.myColor,
                                    unfocusedLabelColor = com.example.pobreflix.myColor,
                                    unfocusedTextColor = com.example.pobreflix.myColor,
                                    cursorColor = com.example.pobreflix.myColor,
                                    unfocusedIndicatorColor = com.example.pobreflix.myColor,
                                    focusedIndicatorColor = com.example.pobreflix.myColor


                                ),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                                trailingIcon = {
                                    IconButton(
                                        onClick = {
                                            username = ""
                                        }
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Clear,
                                            contentDescription = null,
                                            modifier = Modifier.size(20.dp),
                                            tint = Color(0xff01356d)
                                        )
                                    }
                                }
                            )

                            Spacer(modifier = Modifier.size(30.dp))

                            TextField(
                                value = email,
                                onValueChange = { email = it },
                                label = {
                                    Text(text = "Email",
                                        color = Color.LightGray)

                                },
                                maxLines = 1,
                                textStyle = TextStyle(color = Color.DarkGray),
                                modifier = Modifier.size(300.dp, 55.dp),
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Rounded.Email,
                                        contentDescription = stringResource(R.string.email_icon),
                                        tint = Color(0xff01356d),
                                        modifier = Modifier.size(20.dp)
                                    )
                                },

                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = Color.Transparent,
                                    unfocusedContainerColor = Color.Transparent,
                                    focusedLabelColor = com.example.pobreflix.myColor,
                                    unfocusedLabelColor = com.example.pobreflix.myColor,
                                    unfocusedTextColor = com.example.pobreflix.myColor,
                                    cursorColor = com.example.pobreflix.myColor,
                                    unfocusedIndicatorColor = com.example.pobreflix.myColor,
                                    focusedIndicatorColor = com.example.pobreflix.myColor


                                ),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                                trailingIcon = {
                                    IconButton(
                                        onClick = {
                                            email = ""
                                        }
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Clear,
                                            contentDescription = null,
                                            modifier = Modifier.size(20.dp),
                                            tint = Color(0xff01356d)
                                        )
                                    }
                                }
                            )

                            Spacer(modifier = Modifier.size(30.dp))

                            TextField(
                                value = password,
                                onValueChange = { password = it },
                                label = {
                                    Text(text = "Enter Your Password",
                                        color = Color.LightGray)

                                },
                                maxLines = 1,
                                textStyle = TextStyle(color = Color.DarkGray),
                                modifier = Modifier.size(300.dp, 55.dp),
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Rounded.Lock,
                                        contentDescription = stringResource(R.string.icon_password),
                                        tint = Color(0xff01356d),
                                        modifier = Modifier.size(20.dp)
                                    )
                                },
                                trailingIcon = {
                                    IconButton(
                                        onClick = {passwordVisibility = !passwordVisibility}
                                    ) {
                                        Icon(
                                            painter = icon,
                                            contentDescription = null,
                                            tint = Color.Unspecified,
                                            modifier = Modifier.size(23.dp)
                                        )
                                    }
                                },
                                visualTransformation = if (passwordVisibility)
                                    VisualTransformation.None
                                else
                                    PasswordVisualTransformation()
                                ,

                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = Color.Transparent,
                                    unfocusedContainerColor = Color.Transparent,
                                    focusedLabelColor = com.example.pobreflix.myColor,
                                    unfocusedLabelColor = com.example.pobreflix.myColor,
                                    unfocusedTextColor = com.example.pobreflix.myColor,
                                    cursorColor = com.example.pobreflix.myColor,
                                    unfocusedIndicatorColor = com.example.pobreflix.myColor,
                                    focusedIndicatorColor = com.example.pobreflix.myColor


                                )
                            )

                            Spacer(modifier = Modifier.size(60.dp))

                            var cantoBtn = Shapes(small = RoundedCornerShape(15.dp))

                            Button(
                                onClick = {viewModel.signUp(username, password)},
                                modifier = Modifier
                                    .size(150.dp, 50.dp)
                                    .clip(RoundedCornerShape(1f)),
                                colors = ButtonDefaults.buttonColors(Color(0xff01356d)),
                                shape = cantoBtn.small
                            ) {
                                Text(
                                    stringResource(R.string.create_acount),
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFffffff)
                                )
                            }
                            Row (verticalAlignment = Alignment.CenterVertically){
                                Text(
                                    stringResource(R.string.i_have_an_account),
                                    color = Color.DarkGray
                                )
                                TextButton(
                                    onClick = {
                                        login()
                                    },
                                    modifier = Modifier.padding(0.dp)

                                ) {
                                    Text(
                                        stringResource(R.string.login),
                                        color = Color(0xff01356d)
                                    )
                                }
                            }

                        }
                    }

                }
                SnackbarHost(hostState = snackbarHostState, Modifier.width(300.dp))
            }

            LaunchedEffect(signUpState) {
                signUpState?.let {
                    val message = if (it) "Registrado com sucesso!" else "Erro de registro"
                    if(it){
                        snackbarHostState.showSnackbar(message, duration = SnackbarDuration.Short)
                        viewModel.clearSignUpState()
                        onSignUpSuccess()
                    }
                    snackbarHostState.showSnackbar(message, duration = SnackbarDuration.Short)
                    viewModel.clearSignUpState()
                }
            }
        }
    }
