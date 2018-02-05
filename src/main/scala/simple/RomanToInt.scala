package simple


object RomanToInt extends App{
  val M = Array ("", "M", "MM", "MMM")
  val C = Array ("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
  val X = Array ("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
  val I = Array ("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")

  println(intToRoman(50))
  println(intToRoman(40))
  println(intToRoman(900))
  println(intToRoman(523))

  def intToRoman(num : Int) : String = {
    (M(num/1000) + C((num%1000)/100) + X((num%100)/10) + I(num%10))
  }
}
