import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChiTietPhong(viewModel: BookingViewModel, navController: NavController){
    val phongDaChon = viewModel.daChon.value
    if (phongDaChon != null){
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Phong: ${phongDaChon.loai}")
            Text(text = "Gia: \$${phongDaChon.gia}")
            TextField(value = viewModel.soLuong.value.toString(),
                onValueChange = { value ->
                    value.toIntOrNull()?.let {
                        viewModel.soLuong.value = it
                    }
                },
                label = { Text("So Luong")}
            )
            Button(onClick = {
                viewModel.datPhong()
                navController.navigate(BookingApp.TongKetDat.route)
            }) {
                Text(text = "Dat Phong")
            }
            Button(onClick = {navController.popBackStack()}) {
                Text(text = "Huy Dat")
            }
        }
    }
}