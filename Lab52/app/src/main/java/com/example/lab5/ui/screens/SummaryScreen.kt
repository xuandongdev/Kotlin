import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun TongKet(viewModel: BookingViewModel, navController: NavController){
    val phong = viewModel.daChon.value
    val soLuong = viewModel.soLuong.value
    if(phong != null){
        val tongTien = phong.gia * soLuong
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Ket Qua Dat Phong")
            Text(text = "Loai Phong: ${phong.loai}")
            Text(text = "Gia: \$${phong.gia}")
            Text(text = "So Phong Da Dat: ${soLuong}")
            Text(text = "Tong So Tien: \$${tongTien}")
            Text(text = "Vui long thanh toan hoa don truoc 3 gio")
            Button(onClick = {navController.navigate(BookingApp.DanhSachPhong.route)}) {
                Text(text = "Tro ve danh sach phong")
            }
        }
    }
}