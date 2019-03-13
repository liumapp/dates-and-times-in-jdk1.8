# dates-and-times-in-jdk1.8
在jdk1.8中使用最新的时间方法

> 从jdk1.8开始，Oracle重写了日期与时间的实现。虽然我们仍然可以使用过去的方法来实现，但是掌握最新的方法可以更高效的解决时间日期相关的问题。


## 时区

首先我们要知道一个GMT时区(Greenwich Mean Time)，这玩意就是所谓的time zone zero，考虑时区偏移量zoneOffset的时候要跟他进行加减操作。

然后我们还要知道一个UTC时区（Coordinated Universal Time，没错，我也很好奇为啥Coo..U..Time的简写是UTC，谷歌后发现UTC是混杂了英文跟法文的缩写，所以UTC实际上并不是任何一个单词的缩写，仅仅用来代表Coo...U...Time），这玩意就是所谓的time zone standard，我们可以在这行代码里面看到它：

````java
long secondNumber = localDateTime.toEpochSecond(ZoneOffset.UTC);
````








