/*
    cac phuong thuc toan tu:
    cong: a.plus(b)
    tru: a.minus(b)
    nhan: a.times(b)
    chia: a.div(b)
    chia lay du: a.rem(b)
     */
fun main(args: Array<String>) {
    var a = 10
    var b = 3
    //check kieu du lieu
    println(a::class.java.typeName)
    println(b::class.java.typeName)

    //phep cong
    println("\nPhep cong:")
    println("Cach 1 a + b = " + (a+b))
    println("Cach 2 a + b = " + a.plus(b))

    //phep tru
    println("\nPhep tru:")
    println("Cach 1 a - b = " + (a-b))
    println("Cach 2 a - b = " + a.minus(b))

    //phep nhan
    println("\nPhep nhan:")
    println("Cach 1 a * b = " + (a*b))
    println("Cach 2 a * b = " + a.plus(b))

    //phep chia khong lay du
    println("\nPhep chia khong lay du:")
    println("Cach 1 a / b = " + (a/b))
    println("Cach 1 a / b = " + a.div(b))

    //ep kieu de khong mat du lieu
    var kq:Float = a.toFloat()/b
    println("a/b = " + kq)

    //phep chia lay du
    println("\nPhep chia lay phan du:")
    println("Cach 1 a % b = " + (a%b))
    println("Cach 2 a % b = " + a.rem(b))

    //toan tu tien to 1 ngoi
    /*
    so duong: unaryPlus() tu dong them dau '+' vao truoc gia tri
    so am: unaryMinus() tu dong them dau '-' vao truoc gia tri
     */
    println("\nToan tu tien to mot ngoi:")
    //tru mot ngoi
    var x:Float = 9.1f
    var y = x.unaryMinus()
    println("x = " + x)
    println("x = " + y)
    //cong mot ngoi
    var z = x.unaryPlus()
    println("x = " + z)
}