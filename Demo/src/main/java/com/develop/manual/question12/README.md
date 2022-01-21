1. 为什么禁止开发人员使用 isSuccess 作为变量名？

2. fastjson、Gson、jackson三个序列化工具的方法 
- fastjson 和 jackson 在把对象序列化成 json 字符串的时候，是通过反射遍历出该类中的所有 getter 方法, Gson是通过反射遍历该类中的所有属性