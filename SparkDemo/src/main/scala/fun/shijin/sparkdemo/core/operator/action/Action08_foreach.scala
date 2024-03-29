package fun.shijin.sparkdemo.core.operator.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author shijin
 * @Date 2021/8/5 11:24
 * @Desc
 */

object Action08_foreach {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
  
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
  
    //3具体业务逻辑
    //3.1 创建第一个RDD
    // val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4),2)
    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4))
  
    //3.2 收集后打印
    rdd.map(num=>num).collect().foreach(println)
  
    println("****************")
    //3.3 分布式打印
    rdd.foreach(println)
  
    //4.关闭连接
    sc.stop()
  
  }
}
