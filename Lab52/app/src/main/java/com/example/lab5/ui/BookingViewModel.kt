import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class BookingViewModel: ViewModel(){
    val sanCo = mutableStateOf(
        listOf(
            Room(1, "A", 150.00,10),
            Room(2, "B", 120.00, 9),
            Room(3, "C", 200.00, 15)
        )
    )

    var daChon = mutableStateOf<Room?>(null)
    var soLuong = mutableStateOf(1) //mac dinh dat 1p
    fun chonPhong(room: Room){
        daChon.value = room
    }
    fun datPhong(){
        val phong = daChon.value
        phong?.let{
            if(soLuong.value <= it.phongTrong){
                it.phongTrong -= soLuong.value
            }
            else{
                println("Khong du so luong phong!")
            }
        }
    }
}