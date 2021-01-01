1. Lambda表达式的应用场景: 任何有函数式接口的地方都可以使用
2. 只有一个抽象方法(Object类中的方法除外)的接口是函数式接口
3. Lambda表达式概念
   - lambda表达式可以替代只有一个抽象函数的接口实现，告别匿名内部类，代码看起来更简洁易懂
   - lambda表达式同时还提升了对集合、框架的迭代、遍历、过滤数据的操作
   - lambda可以极大的减少代码冗余，同时代码的可读性要好过冗长的内部类，匿名类
4. lambda表达式的语法

    - LambdaParameters -> LambdaBody
    - args->expr或者（object ... args）->{函数式接口抽象方法实现逻辑}
    - （）参数的个数，根据函数式接口里面抽象的参数个数来决定，当参数只有一个的时候，（）可以省略
    - 当expr逻辑非常简单的时候，{}和return可以省略
5. 表达式案例

```java
()->{}
()->{System.out.println(1);}
()->System.out.println(1)
()->{return 100;}
()->100
()->null
(int x)->{return x+1;}
(int x)->x+1
(x)->x+1
x->x+1
```

6. lambda表达式是在函数时接口的方法体内部运行的, 需要注意方法的返回值和形参去灵活使用
7. 函数式接口

```java
Supplier // 代表一个输出

ConSunmer // 代表一个输入
BiConsumer // 代表两个输入

Function // 代表一个输入, 一个输出(一般输入和输出是不同类型的)
UnaryOperator // 代表一个输入, 一个输出(输入和输出是相同类型的)
    
BiFunction // 代表两个输入, 一个输出(一般输入和输出是不同类型的)
BinaryOperator // 代表两个输入, 一个输出(输入和输出是相同类型的)
```

