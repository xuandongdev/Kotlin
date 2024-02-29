//khoi tao va khai bao bien
/*
khoi tao bien: gan gia tri
khai bao bien: khong gan gia tri
 */
fun main(args: Array<String>) {
    //khoi tao bien
    var a:Int = 65
    var b:Short = 5

    println("Gia tri cua a la: " + a)
    println("Gia tri cua b la: $b")

    //khai bao bien
    //kieu du lieu
    var a_1:Double = 9.5    //khai bao tuong minh
    var b_1 = 10.3          //khai bao tat, tu hieu la double
    var a_3:Float = 7.5f    //khai bao float
    var a_4:Long = 9999L    //Khai bao kieu long bat buoc phai co L neu khong se la kieu Int
    var char_1:Char = '1'   //char chi co 1 ky tu
    var string1:String = "Kotlin"
    var string2:String = "a"
    var string3 = "kieu du lieu"
    var string4 = """
        doc lap
        tu do
        hanh phuc
    """.trimIndent()
    var arr:FloatArray = floatArrayOf(0.10f, 5.6f, 31.8f)
    var chararr:CharArray = charArrayOf('1', 'd', 'a')


    //check kieu du lieu
    println("Kieu du lieu cua b_1 la: " + (b_1::class.java.typeName))
    println("Kieu du lieu cua b la: " + (b::class.java.typeName))
    println("Kieu du lieu cua a la: " + (a::class.java.typeName))
    println("Kieu du lieu cua string4 la: " + (string4::class.java.typeName))
    println("Kieu du lieu cua arr la: " + (arr::class.java.typeName))
    println("Kieu du lieu cua chararr la: " + (chararr::class.java.typeName))
}