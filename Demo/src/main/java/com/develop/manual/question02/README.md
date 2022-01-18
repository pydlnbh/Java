1. 为什么要求日期格式化时必须有使用 y 表示年，而不能用 Y ？
- 在规定中，y 表示 year，而 Y 表示 Week Year ！
![avatar](https://static01.imgkr.com/temp/7abf155039e24bb1ba7c9ba51be2f98b.png)
2. SimpleDateFormat线程安全问题？
- Instant 代替 Date，LocalDateTime 代替 Calendar，DateTimeFormatter 代替 SimpleDateFormat。