package simple

import java.util

import scala.collection.mutable

object PredictNextWord extends App{
  val dict = createModel(Array("this is me","that is test","like it this","like it this","like it me"))
  println(dict)
  println(predict(dict,"this is"))
  println(predict(dict,"like it"))
  val s = Set("test1","taa")


  def predict(dic :util.HashMap[String,Map[String,Int]],word:String):String={
    val arr=word.split(" ")
    val key = arr(0)+" "+arr(1)
    val m: Map[String,Int] =dic.get(key)
    val finalA1 = m.toSeq.sortWith(_._2>_._2)
    finalA1(0)._1
  }



  def createModel(arr:Array[String]): util.HashMap[String,Map[String,Int]]={
    val m = new util.HashMap[String,Map[String,Int]]
    for (str<-arr){
      val arr = str.split(" ")
      val key = arr(0)+" "+arr(1)
      if (m.containsKey(key)){
        var keyMap = m.get(key)
        val nextWord =arr(2)
         if (keyMap.contains(nextWord)){
           val countOfword : Int = (keyMap.get(nextWord)).get+1

           keyMap += nextWord->countOfword
         } else{
           keyMap += nextWord->1
         }
        m.put(key,keyMap)
      } else {
        var v =  Map[String,Int]()
        v += arr(2)->1
        m.put(key,v)
      }
    }
    m
  }

}
