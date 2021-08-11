package fun.shijin.sparkdemo.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}

/**
 * @Author shijin
 * @Date 2021/8/11 17:47
 * @Desc
 */

object TransformWindow {
  def main(args: Array[String]): Unit = {
    //创建SparkConf
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    //创建StreamingContext
    val ssc = new StreamingContext(conf, Seconds(3))
    //设置检查点路径  用于保存状态
    ssc.checkpoint("F:\\Demo\\bigdata\\SparkDemo\\src\\main\\resources\\checkpoint")
    //创建DStream
    val lineDStream: ReceiverInputDStream[String] = ssc.socketTextStream("hadoop201", 7777)
    //扁平映射
    val flatMapDS: DStream[String] = lineDStream.flatMap(_.split(" "))
    //结构转换
    val mapDS: DStream[(String, Int)] = flatMapDS.map((_, 1)).window(Seconds(6), Seconds(3))
    //聚合
    // 注意：DStreasm中reduceByKey只能对当前采集周期（窗口）进行聚合操作，没有状态
    val reduceDS: DStream[(String, Int)] = mapDS.reduceByKey(_+_)
    
    //打印输出
    reduceDS.print()
    //启动
    ssc.start()
    ssc.awaitTermination()
  }
}
