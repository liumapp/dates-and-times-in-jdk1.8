# dates-and-times-in-jdk1.8
在jdk1.8中使用最新的时间方法

> 从jdk1.8开始，Oracle重写了日期与时间的实现。虽然我们仍然可以使用过去的方法来实现，但是掌握最新的方法可以更高效的解决时间日期相关的问题。


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















