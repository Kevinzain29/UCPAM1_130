package com.example.latihanlayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun latihan(modifier: Modifier = Modifier) {
    var kota1 by remember { mutableStateOf("") }
    var kota2 by remember { mutableStateOf("") }
    var tanggal1 by remember { mutableStateOf("") }
    var tanggal2 by remember { mutableStateOf("") }
    var kelas by remember { mutableStateOf("") }

    var dataKelas = listOf("Ekonomi", "Business")

    var ConfKota1 by remember { mutableStateOf("") }
    var ConfKota2 by remember { mutableStateOf("") }
    var Conftanggal1 by remember { mutableStateOf("") }
    var Conftanggal2 by remember { mutableStateOf("") }
    var ConfKelas by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Column(
            modifier = Modifier.padding(top = 16.dp, bottom = 24.dp)
        ) {
            Text(text = "Good Afternoon,", color = Color.Gray)
            Text(text = "Ahmad Kevin Zain", color = Color.Black)
        }
        Text(text = "Pemesanan")
        TextField(
            value = kota1,
            onValueChange = { kota1 = it },
            label = { Text(text = "BANDUNG") },
            placeholder = { Text(text = "Isi kota keberangkatan Anda") },
            modifier = Modifier
                .fillMaxWidth()
        )
        TextField(
            value = kota2,
            onValueChange = { kota2 = it },
            label = { Text(text = "YOGYAKARTA") },
            placeholder = { Text(text = "Isi kota tujuan Anda") },
            modifier = Modifier
                .fillMaxWidth()
        )
        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            TextField(
                value = tanggal1,
                onValueChange = { tanggal1 = it },
                label = { Text(text = "17 JULI 2024") },
                placeholder = { Text(text = "Isi tanggal keberangkatan Anda") },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            TextField(
                value = tanggal2,
                onValueChange = { tanggal2 = it },
                label = { Text(text = "18 JULI 2024") },
                placeholder = { Text(text = "Isi tanggal tiba Anda") },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 5.dp)
        ) {
            dataKelas.forEach { selectedKelas ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = kelas == selectedKelas,
                        onClick = { kelas = selectedKelas }
                    )
                    Text(
                        text = selectedKelas,
                        modifier = Modifier.padding(start = 4.dp),
                        color = Color.Black
                    )
                }
            }
        }

        // Submit Button
        Button(
            onClick = {
                ConfKota1 = kota1
                ConfKota2 = kota2
                Conftanggal1 = tanggal1
                Conftanggal2 = tanggal2
                ConfKelas = kelas
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text(text = "Submit")
        }

        Column(
            modifier = Modifier.padding(top = 16.dp, bottom = 24.dp)
        ) {
            Text(text = "Detail Data")
        }

        Box(
            modifier = Modifier
                .background(Color.DarkGray, shape = RoundedCornerShape(15.dp))
                .padding(16.dp)
        ) {
            Column {
                pendaftaran("Keberangkatan", ConfKota1)
                pendaftaran("Kedatangan", ConfKota2)
                pendaftaran("Tanggal Berangkat", Conftanggal1)
                pendaftaran("Tanggal Tiba", Conftanggal2)
                pendaftaran("Class", ConfKelas)
            }
            Image(painter = painterResource(id = R.drawable.kereta),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 180.dp)
                    .size(size = 90.dp))
        }
    }
}

@Composable
fun pendaftaran(para: String, arg: String) {
    Column(modifier = Modifier.padding(8.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = para, color = Color.White)
            Text(text = ":", color = Color.White, modifier = Modifier.weight(0.1f))
            Text(text = arg, color = Color.White)
        }
    }
}
