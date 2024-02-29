fun main(args: Array<String>) {
    var soA:Int = 100
    var soB:Long = soA.toLong()
    //kiem tra
    println(soA::class.java.typeName)
    println(soA)
    println(soB::class.java.typeName)
    println(soB)

    //ep kiem hep
    var x:Short = 12133
    var y:Byte = x.toByte()
    println("x = $x")
    println("y = $y")
    //bi mat du lieu khi ep tu short ve byte

    var m:Short = 120
    var n:Byte = m.toByte()
    println("m = $m")
    println("n = $n")

    var diemLTCB:Float = 9.9f
    var diemOOP:Int = diemLTCB.toInt()
    println("diemLTCB = $diemLTCB")
    println("diemOOP = $diemOOP")
}