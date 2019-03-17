# dates-and-times-in-jdk1.8
在jdk1.8中使用最新的时间方法

> 从jdk1.8开始，Oracle重写了日期与时间的实现。虽然我们仍然可以使用过去的方法来实现，但是掌握最新的方法可以更高效的解决时间日期相关的问题。

* [1. 如何运行案例代码](#1-如何运行案例代码)
    * [1.1 编译](#11-编译)
    * [1.2 直接启动案例demo](#12-直接启动案例demo)
    * [1.3 导入IDEA启动](#13-导入IDEA启动)
* [2. Instant获取UTC标准时间](#2-Instant获取UTC标准时间)    
* [3. LocalDate与LocalTime与ZonedDateTime的创建与使用](#3-LocalDate与LocalTime与ZonedDateTime的创建与使用)
* [4. 对ZonedDateTime对象进行时间的修改](#4-对ZonedDateTime对象进行时间的修改)
* [5. Period的使用案例](#5-Period的使用案例)
* [6. Duration的使用案例](#6-Duration的使用案例)
* [7. ChronoUnit的使用案例](#7-ChronoUnit的使用案例)
* [8. TemporalAdjusters的使用案例](#8-TemporalAdjusters的使用案例)
* [9. Clock的使用案例](#9-Clock的使用案例)
* [10. 对日期进行格式化输出](#10-对日期进行格式化输出)
* [11. 各种类型转ZonedDateTime](#11-各种类型转ZonedDateTime)
* [12. 理解时区的概念](#12-理解时区的概念)
* [参考资料](#参考资料)

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
   
   如果对于什么是时区，什么是UTC，什么是GMT的概念还不太理解，可以先看第12节的内容

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

Period一般是用来修改日、周、月、年级别的日期，所以它一般与LocalDate、LocalDateTime、ZonedDateTime配套使用，但不能跟LocalTime搭配

比如

````java
Period everyYear = Period.ofYears(1);
Period everyThreeMonths = Period.ofMonths(3);
Period everyThreeWeeks = Period.ofWeeks(3);
Period everyTwoDays = Period.ofDays(2);
Period everyYearAndOneWeek = Period.of(1, 0, 7);
LocalDate localDate = LocalDate.now();
Console.textIO.getTextTerminal().println("当前时间：" + localDate);
Console.textIO.getTextTerminal().println("1年后的时间：" + localDate.plus(everyYear));
Console.textIO.getTextTerminal().println("3个月后的时间：" + localDate.plus(everyThreeMonths));
Console.textIO.getTextTerminal().println("3周后的时间：" + localDate.plus(everyThreeWeeks));
Console.textIO.getTextTerminal().println("2天后的时间：" + localDate.plus(everyTwoDays));
Console.textIO.getTextTerminal().println("1年零1个礼拜后的时间：" + localDate.plus(everyYearAndOneWeek));
````

更具体的案例可以在UsingPeriodsTutorials中查看

## 6. Duration的使用案例

Durations跟Period相对应，它是用来修改时、分、秒级别的时间

比如

````java
Console.textIO.getTextTerminal().println("demo3演示了创建duration的不同方式");
Duration everyTwoHour = Duration.ofHours(2);
Duration everyThirtyMins = Duration.ofMinutes(30);
Duration everyThirtySeconds = Duration.ofSeconds(30);
LocalDateTime localDateTime = LocalDateTime.now();
Console.textIO.getTextTerminal().println("当前时间: " + localDateTime);
Console.textIO.getTextTerminal().println("2个小时后的时间：" + localDateTime.plus(everyTwoHour));
Console.textIO.getTextTerminal().println("30分钟后的时间：" + localDateTime.plus(everyThirtyMins));
Console.textIO.getTextTerminal().println("30秒后的时间：" + localDateTime.plus(everyThirtySeconds));
````

更详细的案例可以在UsingDurationsTutorials中查看

## 7. ChronoUnit的使用案例

ChronoUnit可以帮助我们用不同的时间单位衡量两个日期之间的间距

比如

````java
Console.textIO.getTextTerminal().println("demo1演示用不同的时间单位，来衡量1978年3月2号0时0分距离此时此刻的间距");
LocalDateTime old = LocalDateTime.of(1978, Month.MARCH, 2, 0, 0);
LocalDateTime now = LocalDateTime.now();
long years = ChronoUnit.YEARS.between(old, now);
long months = ChronoUnit.MONTHS.between(old, now);
long days = ChronoUnit.DAYS.between(old, now);
long hours = ChronoUnit.HOURS.between(old, now);
long mins = ChronoUnit.MINUTES.between(old, now);
//你也可以用秒、微妙、纳秒这些单位
Console.textIO.getTextTerminal().println("1978年3月2号0时0分距离现在" + now + "\n" +
        "隔了:" + years + "年\n或者" + months + "月\n或者" + days + "天\n或者" + hours + "小时\n或者" + mins + "分钟\n");
````

更加详细的案例可以在UsingChronoUnit中查看
	
## 8. TemporalAdjusters的使用案例

TemporalAdjusters翻译过来叫临时调节器，跟ChronoUnit做对比的话，他可以帮助我们使用指定个数的时间单位获取未来或者过去的时间点

比如

````java
Console.textIO.getTextTerminal().println("demo1演示了通过当前时间点，获取指定个日、月的时间点");
LocalDate localDate = LocalDate.now();
LocalDate firstDayOfThisMonth = localDate.with(TemporalAdjusters.firstDayOfMonth());
LocalDate lastDayOfTHisMonth = localDate.with(TemporalAdjusters.lastDayOfMonth());
LocalDate nextMonday = localDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
LocalDate firstDayOfNextMonth = localDate.with(TemporalAdjusters.firstDayOfNextMonth());
Console.textIO.getTextTerminal().println("这个月的第一个天：" + firstDayOfThisMonth + "\n" +
    "这个月的最后一天：" + lastDayOfTHisMonth + "\n" +
    "下一个星期一：" + nextMonday + "\n" +
    "下个月的第一天：" + firstDayOfNextMonth);
````

不过一般而言，自定义的TemporalAdjuster更有实用性

比如定义：每一年的第12个月的第25天，就可以获取到下一个圣诞节
   
详情见UsingTemporalAdjustersTutorials

## 9. Clock的使用案例

Clock类是带有时区信息的时间处理类，用他可以获取不同时区的时间，也可以配合Duration，对时间进行时、分、秒级别的修改

比如：

````java
 Console.textIO.getTextTerminal().println("demo1演示了clock的一些简单方法");
Clock clock = Clock.systemDefaultZone();
Instant instant = clock.instant();
Clock clock1 = Clock.systemUTC();
ZonedDateTime time1 = clock1.instant().atZone(clock1.getZone());
Clock clock2 = Clock.system(ZoneId.of("GMT+2"));
ZonedDateTime time2 = clock2.instant().atZone(clock2.getZone());
Clock clock3 = Clock.system(ZoneId.of("Asia/Shanghai"));
ZonedDateTime time3 = clock3.instant().atZone(clock3.getZone());

Console.textIO.getTextTerminal().println("通过clock获取系统时间戳： " + instant);
Console.textIO.getTextTerminal().println("通过clock获取系统时间戳的第二种方式（UTC）：" + time1);
Console.textIO.getTextTerminal().println("通过clock获取东二时区的时间：" + time2);
Console.textIO.getTextTerminal().println("通过clock获取上海时间：" + time3);
Console.textIO.getTextTerminal().println("通过clock获取本地系统的时区：" + clock + "，clock的源码中也是通过ZoneId.systemDefault()来获取本地系统的时区，所以我们直接使用ZoneId.systemDefault()也是可以的");
Console.textIO.getTextTerminal().println("通过clock获取系统当前时间戳的微妙数，虽然我们平时更喜欢用System.currentTimeInMillis()，但使用clock.millis()更高效，当前时间戳的微秒数为：" + clock.millis());
Console.textIO.getTextTerminal().println("注意，我们不能直接通过clock的instant来获取本地时区的时间，因为无论怎样设置，clock的instant都会是英国伦敦时间，即GMT标准时间/UTC世界标准时间");
````
    
详情见UsingClockTutorials

## 10. 对日期进行格式化输出

在jdk1.8中使用DateTimeFormatter来设置时间日期的格式

比如

````java
Console.textIO.getTextTerminal().println("demo1是DateTimeFormatter改变日期格式的最简演示");
LocalDate date = LocalDate.now();
LocalTime time = LocalTime.now();
LocalDateTime dateTime = LocalDateTime.now();
Console.textIO.getTextTerminal().println("下面打印出来的日期格式都是jdk1.8中的标准日期格式（以ISO开头）：");
Console.textIO.getTextTerminal().println("format of date is : " + date.format(DateTimeFormatter.ISO_LOCAL_DATE));
Console.textIO.getTextTerminal().println("format of time is : " + time.format(DateTimeFormatter.ISO_LOCAL_TIME));
Console.textIO.getTextTerminal().println("format of date time is : " + dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

Console.textIO.getTextTerminal().println("当然也会有其他jdk自带的日期格式:");
DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
DateTimeFormatter mediumDateTime = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);//这种形式是最常用的
Console.textIO.getTextTerminal().println("short format style : " + shortDateTime.format(dateTime));
Console.textIO.getTextTerminal().println("medium format style : " + mediumDateTime.format(dateTime));
````

当然，也可以创建自定义的日期格式，详情见FormattingDatesAndTimesTutorials

## 11. 各种类型转ZonedDateTime

一般来说，传统的时间戳由于并不一定会带有时区信息，所以我们不会直接拿时间戳转换为ZonedDateTime类型，而是先转换为LocalDate类型，并默认是使用的本地时区

如果使用的是老版本的Date类，那么在Date类的实例也不一定会带有时区信息，所以我们转换为ZonedDateTime之前，一般是先将Date转换为UTC标准时间戳的Instant，再之后指定跟UTC的偏移量来获取本地时区的ZonedDateTime

比如：

````java
Console.textIO.getTextTerminal().println("demo3演示了将老版本的date对象转ZonedDateTime");
Date date = new Date();
Instant instant = date.toInstant();
ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("GMT+8"));
Console.textIO.getTextTerminal().println("最终得到的时间为：" + zonedDateTime);
````

具体代码请见ParsingDatesAndTimesTutorials

## 12. 理解时区的概念

各种能够直接百度到的内容这里不多写，只记录关键性的东西：

* 格林尼治天文台的标准时间: 首先我们要知道一个GMT(Greenwich Mean Time)，这玩意就是所谓的time zone zero，考虑时区偏移量zoneOffset的时候要跟他进行加减操作。

* 世界标准时间：然后我们还要知道一个UTC（Coordinated Universal Time，其实这货跟GMT一样，没错，我也很好奇为啥Coo..U..Time的简写是UTC，谷歌后发现UTC是混杂了英文跟法文的缩写，所以UTC实际上并不是任何一个单词的缩写，仅仅用来代表Coo...U...Time），这玩意就是所谓的time zone standard

全球一个24个时区，分为东1-12时区，西1-12时区，每个时区间隔1个小时，不过在代码里我们不用管这些，一般都是用UTC偏移量来表示。

英国伦敦为标准的GMT/UTC时间，英国伦敦往西，每隔一个时区就是GMT-1/UTC-1

英国伦敦往东，每隔一个时区就是GMT+1/UTC+1

我国的北京时间因为是东8时区，所以就是GMT+8/UTC+8

美国华盛顿因为是西5时区，所以就是GMT-5/UTC-5

具体在代码来使用就是：

````java
Console.textIO.getTextTerminal().println("demo3演示了如何通过GMT/UTC的偏移量来获取不同时区的时间");
Console.textIO.getTextTerminal().println("如果要通过GMT偏移量获取北京当前时间的话，因为北京时间是东8时区，所以要用GMT+8，得到的时间为：");
OffsetDateTime offsetDateTime = OffsetDateTime.now(ZoneId.of("GMT+8"));
Console.textIO.getTextTerminal().println(offsetDateTime + "\n");
Console.textIO.getTextTerminal().println("如果输出的时间是类似这种的：'2019-03-14T21:44:49.468+08:00'.\n" +
        "那么表示的意思是：我们本地时区当前的时间是2019-03-14T21:44:49.468，+08:00的意思是：\n" +
        "本地时区的时间与GMT/UTC的标准时间提前了8个小时\n" +
        "也就是说，此时此刻，GMT/UTC的标准时间，或者说英国伦敦的时间是2019-03-14T13:44:49.468\n");
Console.textIO.getTextTerminal().println("那么如何通过GMT的偏移量获取指定时区的时间呢？\n" +
        "我们这里以日本东京为例，因为东京是在东9时区，所以他的UTC/GMT偏移量为+9\n" +
        "那么他的时间将会比我们晚一个小时");

OffsetDateTime offsetDateTimeOfTokyo = OffsetDateTime.now(ZoneId.of("GMT+9"));
OffsetDateTime offsetDateTimeOfTokyo2 = OffsetDateTime.now(ZoneId.of("UTC+09:00"));
OffsetDateTime offsetDateTimeOfTokyo3 = OffsetDateTime.now(ZoneId.of("Etc/GMT-9"));
Console.textIO.getTextTerminal().println("它的offsetDateTime表现形式为" + offsetDateTimeOfTokyo + "\n" +
        "具体日期为：" + offsetDateTimeOfTokyo.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "\n" +
        "或者" + offsetDateTimeOfTokyo2.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "\n" +
        "或者" + offsetDateTimeOfTokyo3.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "\n" +
        "那么同理，我们可以用OffsetDateTime.now(ZoneId.of(\"GMT+9\"))或者 OffsetDateTime.now(ZoneId.of(\"UTC+09:00\"))\n" +
        "之类的形式，来获取世界上任意一个时区的时间，如果是东2时区，那么GMT+2，如果是西2时区，那么GMT-2，如果像周边小国，只跟我们\n" +
        "隔了半个小时，那么UTC+08:30或者UTC+07:30即可");
````

更具体的案例代码可以在TimeZonetutorials中查看

## 参考资料

* https://docs.oracle.com/javase/tutorial/datetime/iso/timezones.html

* https://www.boraji.com/java-8-offsetdatetime-example

* https://www.mkyong.com/java8/java-8-period-and-duration-examples/

* https://www.baeldung.com/java-period-duration

* https://www.mkyong.com/java8/java-8-temporaladjusters-examples/

* https://www.baeldung.com/java-clock










