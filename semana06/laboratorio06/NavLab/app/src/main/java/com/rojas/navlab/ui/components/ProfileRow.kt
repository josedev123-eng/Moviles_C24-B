package com.rojas.navlab.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rojas.navlab.ui.theme.CardGray
import com.rojas.navlab.ui.theme.TextDark
import com.rojas.navlab.ui.theme.TextGray

@Composable
fun ProfileRow(
    icon: ImageVector,
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .background(CardGray, shape = RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = TextGray,
                modifier = Modifier.size(18.dp)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = label,
                fontSize = 11.sp,
                color = TextGray
            )
            Text(
                text = value,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = TextDark
            )
        }
    }
}
