import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class BookingApp(val route: String){
    DanhSachPhong("RoomList"),
    ChiTietPhong("Detail"),
    TongKetDat("Summary")
}

@Composable
fun DatPhongApp(viewModel: BookingViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = BookingApp.DanhSachPhong.route){
        composable(BookingApp.DanhSachPhong.route){
            DanhSachPhong(navController, viewModel)
        }
        composable(BookingApp.ChiTietPhong.route) {
            ChiTietPhong(viewModel, navController)
        }
        composable(BookingApp.TongKetDat.route){
            TongKet(viewModel, navController)
        }
    }
}