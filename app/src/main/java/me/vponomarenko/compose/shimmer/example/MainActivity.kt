package me.vponomarenko.compose.shimmer.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import me.vponomarenko.compose.shimmer.shimmer

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Body()
        }
    }

    @Composable
    private fun Body() {
        Scaffold {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 16.dp)
                    .shimmer()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .background(
                            color = Color(0xFFF3F3F3),
                            shape = RoundedCornerShape(4.dp)
                        )
                )

                repeat(2) {

                    Spacer(modifier = Modifier.height(24.dp))

                    Header()

                    repeat(4) {
                        Item()
                    }
                }
            }
        }
    }

    @Composable
    private fun Rectangle() {

    }

    @Composable
    private fun Header() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .size(104.dp, 16.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(
                        color = Color(0xFFF3F3F3),
                        shape = RoundedCornerShape(4.dp)
                    )
            )
            Box(
                modifier = Modifier
                    .size(44.dp, 16.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(
                        color = Color(0xFFF3F3F3),
                        shape = RoundedCornerShape(4.dp)
                    )
            )
        }
    }

    @Composable
    private fun Item() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .background(
                        color = Color(0xFFF3F3F3),
                        shape = RoundedCornerShape(4.dp)
                    )
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(136.dp, 18.dp)
                        .background(
                            color = Color(0xFFF3F3F3),
                            shape = RoundedCornerShape(4.dp)
                        )
                )

                Box(
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .size(80.dp, 18.dp)
                        .background(
                            color = Color(0xFFF3F3F3),
                            shape = RoundedCornerShape(4.dp)
                        )
                )
            }
        }
    }
}