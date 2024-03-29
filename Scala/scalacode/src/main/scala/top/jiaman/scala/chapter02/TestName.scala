package top.jiaman.scala.chapter02

/**
 * @Author Jiaman
 * @Date 2020/11/3 17:21
 * @Desc
 * （1）以字母或者下划线开头，后接字母、数字、下划线
 * （2）以操作符开头，且只包含操作符（+ - * / # !等）
 * （3）用反引号`....`包括的任意字符串，即使是Scala关键字（39个）也可以
 */

object TestName {
  def main(args: Array[String]): Unit = {
    // （1）以字母或者下划线开头，后接字母、数字、下划线
    var hello: String = "" // ok
    var Hello12: String = "" // ok
    //        var 1hello: String = "" // error 数字不能开头
    
    //        var h-b: String = "" // error   不能用-
    //        var x h: String = "" // error   不能有空格
    //        var h_4: String = "" // ok
    //        var _ab: String = "" // ok
    var Int: String = "" // ok 因为在Scala中Int是预定义的字符,不是关键字，但不推荐
    
    var _: String = "hello" // ok 单独一个下划线不可以作为标识符，因为_被认为是一个方法
    //        println(_)
    
    //（2）以操作符开头，且只包含操作符（+ - * / # !等）
    var +*-/#! : String = "" // ok
    //        var +*-/#!1 : String = "" // error 以操作符开头，必须都是操作符
    
    //（3）用反引号`....`包括的任意字符串，即使是Scala关键字（39个）也可以
    //        var if : String = "" // error 不能用关键字
    var `if`: String = "" // ok 用反引号`....`包括的任意字符串,包括关键字
    
  }
  
}
