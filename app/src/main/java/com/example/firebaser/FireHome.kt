package com.example.firebaser

import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.ContactsContract.CommonDataKinds.Phone
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


@Composable
fun FireHome(){

// Write a message to the database
    val database = Firebase.database
    val myRef = database.getReference()



    var text by remember {mutableStateOf("") }
    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = text,
            onValueChange = {newText -> text = newText},
            label = { Text(text = "Enter da Name")}
        )
        Button(
            onClick = {myRef.setValue(text)},
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Submit")
        }
    }

}

//data class Contact(val email: val Email: String, val phone: String)