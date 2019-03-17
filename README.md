# dates-and-times-in-jdk1.8
在jdk1.8中使用最新的时间方法

> 从jdk1.8开始，Oracle重写了日期与时间的实现。虽然我们仍然可以使用过去的方法来实现，但是掌握最新的方法可以更高效的解决时间日期相关的问题。

* [1. 如何运行案例代码](#1.-如何运行案例代码)
    * [1.1 编译](#1.1-编译)
    * [1.2 直接启动案例demo](#1.2-直接启动案例demo)
    * [1.3 导入IDEA启动](#1.3-导入IDEA启动)
* [2. Instant获取UTC标准时间](#2.-Instant获取UTC标准时间)    
* [3. LocalDate与LocalTime与ZonedDateTime的创建与使用](#3.-LocalDate与LocalTime与ZonedDateTime的创建与使用)
* [4. 对ZonedDateTime对象进行时间的修改](#4.-对ZonedDateTime对象进行时间的修改)
* [5. Period的使用案例](#5.-Period的使用案例)
* [6. Duration的使用案例](#6.-Duration的使用案例)
* [7. ChronoUnit的使用案例](#7.-ChronoUnit的使用案例)
* [8. TemporalAdjusters的使用案例](#8.-TemporalAdjusters的使用案例)
* [9. Clock的使用案例](#9.-Clock的使用案例)
* [10. 对日期进行格式化输出](#10.-对日期进行格式化输出)
* [11. 各种类型转ZonedDateTime](#11.-各种类型转ZonedDateTime)
* [12. 理解时区的概念](#12.-理解时区的概念)

## 1. 如何运行案例代码

### 1.1 编译

直接在项目根目录下使用gradle执行编译命令：

````shell
gradle build
````

编译成功后会在build/libs/目录下生成可执行jar包

### 1.2 直接启动案例demo

这个案例项目同时支持纯命令行界面与java swing风格的界面，前者通过命令行启动，后者直接在文件夹中双击jar包即可。

* 通过shell命令行启动
    
    ````shell
    java -jar ./build/libs/dates-and-times-in-jdk1.8-v1.0.0.jar
    ````
    
    ![showpic.gif](https://github.com/liumapp/dates-and-times-in-jdk1.8/blob/master/data/showpic.gif?raw=true)

* 直接在文件夹中双击./build/libs/dates-and-times-in-jdk1.8-v1.0.0.jar运行

案例中的运行效果，都是取自com.liumapp.tutorials.time.tutorials包下的代码

### 1.3 导入IDEA启动

项目导入IDEA后，启动Console类的main方法即可

## 2. Instant获取UTC标准时间

带有时区信息的时间戳，常见的表现形式分两种：

* 年月日时分秒

    ````java
        Instant instant = Instant.now();
    ````
    
   直接打印instant便可以获得这种形式的时间戳，但是千万注意，直接使用这段代码打印出来的时间戳，并不是我们本地时区的时间戳！
   
   进入Instant.now()的源码，我们可以看到
   
   ````java
       public static Clock systemUTC() {
           return new SystemClock(ZoneOffset.UTC);
       }
   ````
   
   它所采用的时区为UTC标准时区的时间，也就是英国伦敦的时间，所以直接Instant.now()获取到的时间并不是我们北京时间，这一点跟new date()后默认是本地时间有很大区别
   
   如果对于什么是时区，什么是UTC，什么是GMT的概念还不太理解，可以先看最后一节的内容

* 秒数，距离1970-01-01有多少秒

    ````java
        Instant instant = Instant.now();
        long seconds = instant.getEpochSecond();
    ````
    
    seconds的值便是这种形式的时间戳     
        
具体代码可以见案例中的UsingInstantTutorials

## 3. LocalDate与LocalTime与ZonedDateTime的创建与使用

jdk1.8中，新引入的时间处理类中，个人感觉以下四个应该会是使用频率最高的四个：

* LocalDate包含年月日的信息

    比如
    
    ````java
          LocalDate.now();//2019-03-17 
    ````
    
* LocalTime包含时分秒的信息

    比如
    
    ````java
          LocalTime.now();//19:52:35.918，最后三位是微秒
    ````

* LocalDateTime包含年月日时分秒的信息

    比如
    
    ````java
          LocalDateTime.now();//2019-03-17T19:52:35.929，中间那个T是用来分隔日期与当日时间的
    ````

* ZonedDateTime包含年月日时分秒+时区的信息

    比如
    
    ````java
          ZonedDateTime.now();//2019-03-17T19:52:35.929+08:00[Asia/Shanghai]
    ````
    
    ZonedDateTime因为包含了时区信息，所以它的结尾会是 "+8:00[Asia/Shanghai]"，+8:00代表UTC/GMT偏移量为东8个时区，如果是-2，那么就代表UTC/GMT偏移量为西2个时区
    
    [Asia/Shanghai]则是用城市名来简单代表所在的时区，一般而言，推荐使用UTC/GMT偏移量来表示时区   

这四个类的使用方法在案例的CreatingDatesAndTimesTutorials中有详细介绍

## 4. 对ZonedDateTime对象进行时间的修改

在jdk1.8中，如果要修改时间的话，一般要借助Period与Duration，但是纯粹使用ZonedDateTime的本身方法也是可以在一定程度上修改时间的

比如

````java
Console.textIO.getTextTerminal().println("demo1演示jdk1.8版本的在已有的日期上添加秒、分、时、日、周、月、年等信息：");
ZonedDateTime date = ZonedDateTime.now();
Console.textIO.getTextTerminal().println("当前日期为：ZonedDateTime.now() = " + date);
Console.textIO.getTextTerminal().println("增加20秒的方法：date.plusSeconds(20) = " + date.plusSeconds(20));
Console.textIO.getTextTerminal().println("增加10分钟的方法：date.plusMinutes(10) = " + date.plusMinutes(10));
Console.textIO.getTextTerminal().println("增加3小时的方法：date.plusHours(3) = " + date.plusHours(3));
Console.textIO.getTextTerminal().println("增加一天的方法： date.plusDays(1) = " + date.plusDays(1));
Console.textIO.getTextTerminal().println("增加一周的方法： date.plusWeeks(1) = " + date.plusWeeks(1));
Console.textIO.getTextTerminal().println("增加一个月的方法：date.plusMonths(1) = " + date.plusMonths(1));
Console.textIO.getTextTerminal().println("增加一年的方法：date.plusYears(1) = s" + date.plusYears(1));
````

详细的代码在ManipulatingDatesAndTimesTutorials类中

## 5. Period的使用案例



## 6. Duration的使用案例

## 7. ChronoUnit的使用案例
	
## 8. TemporalAdjusters的使用案例

## 9. Clock的使用案例

## 10. 对日期进行格式化输出

## 11. 各种类型转ZonedDateTime

## 12. 理解时区的概念


## jdk1.8中新增的时间相关类

* Instant



* LocalDate&LocalTime&LocalDateTime&ZonedDateTime

   

* OffsetDateTime

    以当前时间和GMT/UTC时间的偏差来计算新的时区时间
    
    详情见TimeZoneTutorials    

* DateTimeFormatter

    更改日期格式
    
    详情见FormattingDatesAndTimesTutorials

* Period&Durations

    Period用来修改日、周、月、年级别的日期
    
    比如我可以获取距离今天13个月，2周，3天后的新日期
    
    详情见UsingPeriodsTutorials
    
    Durations则是用来修改时、分、秒级别的时间，详情见UsingDurationsTutorials
    
* ChronoUnit

   翻译过来叫做计时单位，意思是这个类可以用不同的计时单位，来衡量两个时间点的关系，详情见UsingChronoUnitTutorials

* TemporalAdjusters

   翻译过来叫临时调节器，意思是给定一个具体日期，我们可以通过定义调节器的temporal参数，来获取下一个日期。
   
   比如定义：每一年的第12个月的第25天，就可以获取到下一个圣诞节
   
   详情见UsingTemporalAdjustersTutorials

* Clock

    Clock类是带有时区信息的时间处理类，用他可以获取不同时区的时间，也可以配合Duration，对时间进行时、分、秒级别的修改
    
    详情见UsingClockTutorials        
    

## 如何使用案例代码

       
## 时区

格林尼治天文台的标准时间: 首先我们要知道一个GMT(Greenwich Mean Time)，这玩意就是所谓的time zone zero，考虑时区偏移量zoneOffset的时候要跟他进行加减操作。

世界标准时间：然后我们还要知道一个UTC（Coordinated Universal Time，没错，我也很好奇为啥Coo..U..Time的简写是UTC，谷歌后发现UTC是混杂了英文跟法文的缩写，所以UTC实际上并不是任何一个单词的缩写，仅仅用来代表Coo...U...Time），这玩意就是所谓的time zone standard，我们可以在这行代码里面看到它：

全球一个24个时区，分为东1-12时区，西1-12时区，每个时区间隔1个小时，不过在代码里我们不用管这些，一般都是用UTC偏移量来表示。

英国伦敦为标准的GMT/UTC时间，英国伦敦往西，每隔一个时区就是GMT-1/UTC-1

英国伦敦往东，每隔一个时区就是GMT+1/UTC+1

我国的北京时间因为是东8时区，所以就是GMT+8/UTC+8

美国华盛顿因为是西5时区，所以就是GMT-5/UTC-5

具体用代码来获取时间就是：



````java
long secondNumber = localDateTime.toEpochSecond(ZoneOffset.UTC);
````

当然，这行代码是什么意思我们先不管他，但要知道一点，UTC跟GMT其实一样，都是time zone zero

也就是说，下面这三种偏移量都代表提前两个小时：

* +02:00

* GMT+2

* UTC+2

没错，+N代表提前N个小时，-N代表增加N个小时...

再具体一点：

## 参考资料：

* https://docs.oracle.com/javase/tutorial/datetime/iso/timezones.html

* https://www.boraji.com/java-8-offsetdatetime-example

* https://www.mkyong.com/java8/java-8-period-and-duration-examples/

* https://www.baeldung.com/java-period-duration

* https://www.mkyong.com/java8/java-8-temporaladjusters-examples/

* https://www.baeldung.com/java-clock










