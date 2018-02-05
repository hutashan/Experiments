package simple.Stack


object ScalaPractise extends App{

  // Fold
  val list = List(1,2,3,4,5)
  val sum=list.fold(0)(_+_)
  println(s"sum = $sum")

  val listString = List("this","is","bag")
   val conString = listString.fold("test")(_+_)
  println(conString)
  println(listString.foldRight("test")(_+_))
  println(listString.foldLeft("test")(_+_))




}

object caseClass extends App {
  case class MyTestCaseClass(name:String,add:String){
    var tName =name+add
  }
  case class MyTestCaseClass1(name:String,add:String){
    var tName =name+add
  }
  val t1 =MyTestCaseClass("hutashan","chandrakar")
  val t2 =MyTestCaseClass("hutashan","chandrakar")
  println(t1==t2)
  println(t1.name)
  t1.tName="my new"
  println(t1.tName)

}
