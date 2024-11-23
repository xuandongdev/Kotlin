import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lab5.R

fun thongTinPhong(loaiP: String): Int{
    return when(loaiP){
        "A" -> R.drawable.aaaa
        "B" -> R.drawable.bbbb
        else -> R.drawable.cccc
    }

}

@Composable
fun DanhSachPhong(navController: NavController, viewModel: BookingViewModel){
    LazyColumn(){
        items(viewModel.sanCo.value){ phong ->
            val hinhAnh = thongTinPhong(phong.loai)
            Card(modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .clickable() {
                    viewModel.chonPhong(phong)
                    navController.navigate(BookingApp.ChiTietPhong.route) }
            ) {
                Row(modifier = Modifier
                    .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(painter = painterResource(id = hinhAnh), contentDescription = "Hinh Anh")
                    Column(modifier = Modifier.padding(6.dp)) {
                        Text(text = "Gia: \$${phong.gia}")
                        Text(text = "Phong con lai: ${phong.phongTrong}")
                    }
                }
            }
        }
    }
}