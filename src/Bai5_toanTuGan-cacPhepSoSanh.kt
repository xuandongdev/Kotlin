fun main(args: Array<String>) {
    var a = 8
    println(a::class.java.typeName)
    a = a + 5
    println(a)
    a *= 5
    println(a)
    a %= 2
    println(a)

    /*
    Cac phuong thuc so sanh
    a.equals(b): a == b tra ve true
    !a.equals(b): a != b tra ve true
    a.compareTo(b)>0: 1 > 2 false   (a<b khi compare tra ve so am)
    a.compareTo(b)<0: 2 < 1 false
    a.compareTo(b)>=0: 2 >= 1 true
    a.compareTo(b)<=0: 2<=2 true
     */
    println("\nCac phep so sanh bang")
    var soA = 1
    var soB = 3
    println(soA == soB)
    println(soA != soB)
    println(soA > soB)
    println(soA < soB)
    println(soA <= soB)
    println(soA >= soB)
    println("\nCac phep so sanh phuong thuc")
    println(soA.equals(soB))
    println("Khi dung compareTo khi so 'a < b = -1' | 'a == b = 0' | 'a > b = > 0'")
    println(soA.compareTo(soB))
    println(soA.compareTo(soB - 5))
    println(soA.compareTo(soB - 2))

    //bai tap
    println("\nBai tap")
    var n = 6
    n += 3
    println(n)
    n -= 5
    println(n)
    n *= 2
    println(n)
    n %= 5
    println(n)
    var m = 2
    var kq = n - (m + 7)
    println(kq)
}