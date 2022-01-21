1. 为什么禁止使用 count( 列名 ) 或 count( 常量 )来替代 count(*) ？
- count(*)会统计值为 NULL 的行，而 count(列名)不会统计此列为 NULL 值的行。
## 总结
```text
    在 InnoDB 中 COUNT(*) 和 COUNT(1) 实现上没有区别，而且效率一样，
但是COUNT( 字段 ) 需要进行字段的非 NULL 判断，所以效率会低一些。
    因为 COUNT(*) 是 SQL92 定义的标准统计行数的语法，并且效率高，
所以请直接使用 COUNT(*) 查询表的行数！
```