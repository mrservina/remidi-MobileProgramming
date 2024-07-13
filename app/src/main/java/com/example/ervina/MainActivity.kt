package com.example.ervina

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ervina.ui.theme.StudentListAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudentListAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StudentList(
                        students = getStudentList(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun getStudentList(): List<Student> {
        return listOf(
            Student("SSI202203181", "RIAN KURNIAWAN"),
            Student("SSI202203176", "DRIONO PURNOMO"),
            Student("SSI202203170", "SYEFULLOH.S"),
            Student("SSI202203162", "IMAM ARIZAL"),
            Student("SSI202202951", "NUR KHASANAH"),
            Student("SSI202203260", "ERVINA MARESA"),
            Student("SSI202203021", "SUCI RIYANI"),
            Student("SSI202203033", "ARSYAD NUR HIDAYAH"),
            Student("SSI202202992", "MUTIA EKA SEPTIANI"),
            Student("SSI202202867", "YIKI TRIYANI"),
            Student("SSI202203164", "WARSIN")
        )
    }
}

@Composable
fun StudentList(students: List<Student>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(students) { student ->
            val color = when (students.indexOf(student) % 11) {
                0 -> Color.Green
                1 -> Color.Green
                2 -> Color.Green
                3 -> Color.Green
                4 -> Color.Green
                5 -> Color.Blue
                6 -> Color.Red
                7 -> Color.Red
                8 -> Color.Red
                9 -> Color.Red
                10 -> Color.Red
                else -> Color.Cyan
            }
            StudentItem(student, color)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun StudentItem(student: Student, color: Color, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(text = student.name, style = MaterialTheme.typography.headlineSmall, color = color)
        Text(text = student.id, style = MaterialTheme.typography.bodyMedium, color = color)
    }
}

@Preview(showBackground = true)
@Composable
fun StudentListPreview() {
    StudentListAppTheme {
        StudentList(
            students = listOf(
                Student("Sample Name", "Sample ID")
            )
        )
    }
}

data class Student(val id: String, val name: String)
