package com.example.hoabhjetpack.component

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arvind.jetcomposeloginui.R
import com.arvind.jetcomposeloginui.ui.theme.BgColor
import com.arvind.jetcomposeloginui.ui.theme.Primary
import com.arvind.jetcomposeloginui.utils.Constants
import com.example.hoabhjetpack.utils.DataUtil
import com.example.hoabhjetpack.utils.DatetimeUtil

@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .wrapContentSize(),
        style = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ), color = colorResource(id = R.color.base_color),
        textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier,
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ), color = colorResource(id = R.color.base_color),
        textAlign = TextAlign.Start,
        fontFamily = FontFamily(
            Font(R.font.hindsiliguriregular, FontWeight.Normal),
        )
    )
}

@Composable
fun H1TextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 16.sp,
            fontStyle = FontStyle.Normal
        ), color = colorResource(id = R.color.color_text_h1),
        textAlign = TextAlign.Start,
        fontFamily = FontFamily(
            Font(R.font.hindsiliguriregular, FontWeight.Normal),
        )
    )
}

@Composable
fun MyAvatar(res: Int) {
    Box() {
        Image(
            painter = painterResource(id = res), contentDescription = null, modifier = Modifier
                .width(60.dp)
                .height(60.dp)
        )
    }
}

@Composable
fun MyTextFieldComponent(
    labelValue: String, painterResource: Painter,
    errorStatus: Boolean = false
) {

    val textValue = remember {
        mutableStateOf("")
    }
    val localFocusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp),),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
            backgroundColor = BgColor
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine = true,
        maxLines = 1,
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        },
        isError = !errorStatus
    )
}


@Composable
fun PasswordTextFieldComponent(
    labelValue: String, painterResource: Painter,
    errorStatus: Boolean = false
) {

    val localFocusManager = LocalFocusManager.current
    val password = remember {
        mutableStateOf("")
    }

    val passwordVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp)),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
            backgroundColor = BgColor
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        singleLine = true,
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        },
        maxLines = 1,
        value = password.value,
        onValueChange = {
            password.value = it
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        },
        trailingIcon = {

            val iconImage = if (passwordVisible.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }

            val description = if (passwordVisible.value) {
                stringResource(id = R.string.hide_password)
            } else {
                stringResource(id = R.string.show_password)
            }

            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = description)
            }

        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        isError = !errorStatus
    )
}

@Composable
fun CheckboxComponent(
    value: String,
    onTextSelected: (String) -> Unit,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        val checkedState = remember {
            mutableStateOf(false)
        }

        Checkbox(checked = checkedState.value,
            onCheckedChange = {
                checkedState.value = !checkedState.value
                onCheckedChange.invoke(it)
            })

        ClickableTextComponent(value = value, onTextSelected)
    }
}

@Composable
fun ClickableTextComponent(value: String, onTextSelected: (String) -> Unit) {
    val initialText = "By continuing you accept our "
    val privacyPolicyText = "Privacy Policy"
    val andText = " and "
    val termsAndConditionsText = "Term of Use"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = termsAndConditionsText, annotation = termsAndConditionsText)
            append(termsAndConditionsText)
        }
    }

    ClickableText(text = annotatedString, onClick = { offset ->

        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { span ->
                Log.d("ClickableTextComponent", "{${span.item}}")

                if ((span.item == termsAndConditionsText) || (span.item == privacyPolicyText)) {
                    onTextSelected(span.item)
                }
            }

    })
}

@Composable
fun ButtonComponent(value: String, onButtonClicked: () -> Unit, isEnabled: Boolean = true) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        onClick = {
            onButtonClicked.invoke()
        },
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        shape = RoundedCornerShape(50.dp),
        enabled = isEnabled
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    color = colorResource(id = R.color.base_color),
                    shape = RoundedCornerShape(30.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value,
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

        }

    }
}

@Composable
fun DividerTextComponent() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = colorResource(id = R.color.color_hint),
            thickness = 1.dp
        )

        Text(
            modifier = Modifier.padding(8.dp),
            text = stringResource(R.string.or_with),
            fontSize = 18.sp,
            color = colorResource(id = R.color.color_hint)
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = colorResource(id = R.color.color_hint),
            thickness = 1.dp
        )
    }
}


@Composable
fun ClickableLoginTextComponent(tryingToLogin: Boolean = true, onTextSelected: (String) -> Unit) {
    val initialText =
        if (tryingToLogin) "Already have an account? " else "Don’t have an account yet? "
    val loginText = if (tryingToLogin) "Login" else "Sign Up"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }
    }

    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatedString,
        onClick = { offset ->

            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.also { span ->
                    Log.d("ClickableTextComponent", "{${span.item}}")

                    if (span.item == loginText) {
                        onTextSelected(span.item)
                    }
                }

        },
    )
}

@Composable
fun UnderLinedTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth(),
        style = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.base_color),
        textAlign = TextAlign.End,
    )

}

@Composable
fun AnotherOptionsLogin() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.facebook),
            contentDescription = null,
            modifier = Modifier
                .size(30.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Image(
            painter = painterResource(id = R.drawable.facebook),
            contentDescription = null,
            modifier = Modifier
                .size(30.dp)
        )
    }
}



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StaggeredGridView() {
    val staggeredGridItems = DataUtil.generateList()

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        content = {
            items(staggeredGridItems.size) { index ->
                StaggeredGridItemCard(staggeredGridItems[index], index)
            }
        },
        modifier = Modifier.wrapContentSize()
    )

}

@Composable
fun StaggeredGridItemCard(item: StaggeredGridItem, position: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(item.height.dp)
            .padding(8.dp)
        ,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(item.height.dp)
                .background(
                    shape = RoundedCornerShape(16.dp),
                    brush = item.brush
                )
                .padding(top = 16.dp, start = 16.dp),
        ) {

            Column(

            ) {
                if (position % 2 == 0) {
                    Image(
                        painter = painterResource(id = item.icon),
                        contentDescription = null,
                    )
                } else {
                    Image(
                        painter = painterResource(id = item.icon),
                        contentDescription = null,
                        modifier = androidx.compose.ui.Modifier
                            .width(item.widthIcon)
                            .height(item.heightIcon)
                    )
                }


                Text(
                    text = item.title, style = TextStyle(
                        color = item.colorText,
                        fontSize = 16.sp,
                        fontStyle = FontStyle.Normal,
                    )
                )

                Text(
                    text = item.content, style = TextStyle(
                        color = item.colorText,
                        fontSize = 12.sp,
                        fontStyle = FontStyle.Normal,
                    )
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .width(15.dp)
                    .height(15.dp)
            ) {
                if (position % 2 != 0) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_right_white),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_right_blue),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

        }
    }

}


@Composable
fun ItemCard(item: TodoItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(
                color = colorResource(id = R.color.color_box_tag),
                shape = RoundedCornerShape(8.dp)
            )
            .clip(MaterialTheme.shapes.medium),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(){
                Box(
                    modifier = Modifier
                        .width(2.dp)
                        .height(50.dp)
                        .background(
                            color = colorResource(
                                id = Constants.getColorFromStatus(item.status)
                            )

                        ),
                ) {

                }
                Spacer(modifier = Modifier.width(16.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = item.title, color = colorResource(id = R.color.base_color_text),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal
                        ),
                        fontFamily = FontFamily(
                            Font(R.font.hindsiliguriregular, FontWeight.Normal),
                        )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "${
                            DatetimeUtil.getTimeFromMillisecond(
                                item.startTime,
                                "hh:mm"
                            )
                        } - ${DatetimeUtil.getTimeFromMillisecond(item.endTime, "hh:mm")}",
                        color = colorResource(id = R.color.color_hint),
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal
                        ),
                    )
                }
                Image(painter = painterResource(id = R.drawable.ic_more), contentDescription = null, modifier = Modifier
                    .width(15.dp)
                    .height(15.dp))
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row() {
                Spacer(modifier = Modifier.width(16.dp))
                Box(
                    modifier = Modifier
                        .background(
                            color = colorResource(id = R.color.color_hint),
                            shape = RoundedCornerShape(4.dp)
                        )
                        .padding(horizontal = 8.dp)
                ) {
                    Text(
                        text = item.type, style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal,
                            color = colorResource(id = R.color.base_color)
                        ),
                        fontFamily = FontFamily(
                            Font(R.font.hindsiliguriregular, FontWeight.Normal),
                        )
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))

                Box(
                    modifier = Modifier
                        .background(
                            color = colorResource(id = R.color.color_hint),
                            shape = RoundedCornerShape(4.dp)
                        )
                        .padding(horizontal = 8.dp)
                ) {
                    Text(
                        text = item.tag, style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal,
                            color = colorResource(id = R.color.base_color)
                        ),
                        fontFamily = FontFamily(
                            Font(R.font.hindsiliguriregular, FontWeight.Normal),
                        )
                    )
                }
            }
        }
    }
}



@Composable
fun TodoItemList() {
    val items = DataUtil.generateTodoList()
    LazyColumn(
        modifier = Modifier.wrapContentSize()
    ) {
        items(items) { item ->
            ItemCard(item = item)
        }
    }
}