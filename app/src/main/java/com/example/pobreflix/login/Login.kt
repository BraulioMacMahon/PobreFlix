package com.example.pobreflix.login


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pobreflix.R
import com.example.pobreflix.GreetingTextEntrar
import com.example.pobreflix.MyAlertDialog
import com.example.pobreflix.data.AppDatabase
import com.example.pobreflix.data.UserDao
import com.example.pobreflix.data.UserEntity
import com.example.pobreflix.data.UserRepository
import com.example.pobreflix.data.UserViewModel
import com.example.pobreflix.data.UserViewModelFactory
import com.example.pobreflix.myColor
import java.util.Timer


@Composable
fun Login(
    enterWithEnvited: () -> Unit,
    onLoginSuccess: () -> Unit,
    onNavigateToSignUp: () -> Unit,
) {


    val context = LocalContext.current
    val userDao = remember { AppDatabase.getDatabase(context).userDao() }
    val userRepository = remember { UserRepository(userDao) }
    val factory = remember { UserViewModelFactory(userRepository) }
    val viewModel: UserViewModel = viewModel(factory = factory)

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val loginState by viewModel.loginSuccess.collectAsState()
    var passwordVisibility by remember { mutableStateOf(false) }
    val icon = if (passwordVisibility) painterResource(R.drawable.visibility_off) else painterResource(R.drawable.visibility_on)

    val snackbarHostState = remember { SnackbarHostState() }


        Surface() {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Image(
                    painter = painterResource(R.drawable.pobreflix_logotipo_),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .alpha(0.8f)
                )

                Spacer(modifier = Modifier.height(50.dp)) // Reduzindo espaçamento

                Card(
                    modifier = Modifier
                        .clip(RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp))
                        .fillMaxWidth()
                        .height(450.dp),
                    colors = CardDefaults.cardColors(Color(0xFFDFE9F5)),
                    elevation = CardDefaults.cardElevation(10.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(25.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(20.dp))

                        GreetingTextEntrar(title = stringResource(R.string.login))

                        Spacer(modifier = Modifier.height(20.dp))

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
                                focusedLabelColor = myColor,
                                unfocusedLabelColor = myColor,
                                unfocusedTextColor = myColor,
                                cursorColor = myColor,
                                unfocusedIndicatorColor = myColor,
                                focusedIndicatorColor = myColor


                            ),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
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

                        Spacer(modifier = Modifier.height(20.dp))

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

                        Spacer(modifier = Modifier.height(40.dp))

                        Button(

                            onClick = {

                                    viewModel.login(username, password)

                            },
                            colors = ButtonDefaults.buttonColors(Color(0xff01356d)),
                            modifier = Modifier.size(width = 300.dp, height = 50.dp),
                            shape = RoundedCornerShape(20)
                        ) {
                            Text(
                                text = stringResource(R.string.login),
                                fontSize = 18.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        TextButton(onClick = { onNavigateToSignUp() }) {
                            Text(
                                stringResource(R.string.create_acount),
                                color = Color(0xff01356d)
                            )
                        }

                        TextButton(onClick = { enterWithEnvited() }) {
                            Text(
                                text = stringResource(R.string.enter_with_envited),
                                color = Color(0xff01356d)
                            )
                        }
                    }
                }
                SnackbarHost(hostState = snackbarHostState)
            }
            LaunchedEffect(loginState) {
                loginState?.let {
                    val message = if (it) "Login realizado com sucesso!" else "Usuário ou senha incorretos"
                    if(it){

                        snackbarHostState.showSnackbar(message, duration = SnackbarDuration.Short)
                        viewModel.clearLoginState()
                        onLoginSuccess()
                    }
                    snackbarHostState.showSnackbar(message, duration = SnackbarDuration.Short)
                    viewModel.clearLoginState()
                }
            }

        }
    }

