1. 为什么不建议在 for 循环中使用“+”进行字符
   串拼接？
- 在 for 循 环 中， 每 次 都 是 new 了一个
  StringBuilder，然后再把 String 转成 StringBuilder，再进行 append。
  而频繁的新建对象当然要耗费很多时间了，不仅仅会耗费时间，频繁的创建对
  象，还会造成内存资源的浪费。
2. 补充 
- 如果不是在循环体中进行字符串拼接的话，直接使用 + 就好了。
- 如果在并发场景中进行字符串拼接的话，要使用 StringBuffer 来代替
   StringBuilder。
3. 五种拼接字符串效率对比

|拼接方式 (for循环5w次)|花费时间| 
|:---|:---|
|+(加号拼接)|8.406s|
|StringBuilder|0.001s|
|StringBuffer|0.002s|
|concat|0.004s|
|StringUtils|0.13s|
