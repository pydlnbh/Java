1. 使用static修饰的变量称为静态变量，静态变量可以有两种访问方式，分别是**类名.静态变量名**和**对象名.静态变量名**
2. 一个Java类不能没有构造方法
3. this只能在类中的非静态方法中使用，静态方法和静态的代码块中绝对不能出现this；静态方法中不能直接调用非静态方法，必须实例化再调用
4. 类方法就是用static修饰的方法，类方法中不能引用成员变量/非静态方法；不能调用super、this关键字；类方法不能被覆盖
5. System.out.println("Hello Java!")中out式System类的一个静态成员变量
6. 面向对象和面向过程的区别？

- 面向过程就是分析出**解决问题所需要的步骤**，然后用函数把这些步骤一步一步实现，使用的时候一个一个依次调用就可以了。
- 面向对象是**把构成问题事务分解成各个对象**，建立对象的目的不是为了完成一个步骤，而是为了描叙某个事物在整个解决问题的步骤中的行为。

7. 类和对象的关系？

- 对象是类的实例，类是对象的模板

8. 构造方法的作用和特征？

- 作用：对类的实例进行初始化
- 特征：和类名相同的方法名；不含有返回类型；不能使用return和void；类在实例化的时候，系统自动调用

8. this关键字的作用和用法?

- 作用：
- this可以调用本类中的属性，也就是类中的成员变量
- this调用本类中的其它方法
- this调用本类中的其它构造方法，调用时要放在构造方法的首行
- 
- 用法：
- this(paras…); 访问其他的构造方法
- this.xxx; 访问类中的成员变量xxx
- this.yyy(paras…); 访问类中的成员方法yyy
- this; 当前类对象的引用

9. static关键字的用法?

- 用来修饰成员变量，将其变为类的成员，从而实现所有对象对于该成员的共享
- 用来修饰成员方法，将其变为类方法，可以直接使用**“类名.方法名”**的方式调用，常用于工具类
- 静态块用法，将多个类成员放在一起初始化，使得程序更加规整，其中理解对象的初始化过程非常关键
- 静态内部类只可以访问外部类中的静态成员变量与成员方法，而非静态的内部类即可以访问所有的外部类成员方法与成员变量

10. private、默认、protected、public四个权限修饰符的作用?

- private：类内访问
- default：包内访问
- protected：包外子类访问
- public：包外访问

11. 父类的private修饰的方法，子类不能重写

12. 子类需要使用超类的实例变量初始化时，需要在自己的构造方法中加super关键字

13. 实例变量的初始化程序块看起来像静态初始化程序块，但没有`static`关键字：

    ```java
    {
        //我是实例变量/成员变量，初始化所需的任何代码都在这里
    }
    ```

14. Java.lang.Object类中的常用方法？

```java
(1)public boolean equals(java.lang.Object) // 比较对象的地址值是否相等，如果子类重写，则比较对象的内容是否相等；
(2)public native int hashCode() // 获取哈希码
(3)public java.lang.String toString() // 把数据转变成字符串
(4)public final native java.lang.Class getClass() // 获取类结构信息
(5)protected void finalize() throws java.lang.Throwable // 垃圾回收前执行的方法
(6)protected native Object clone() throws // java.lang.CloneNotSupportedException 克隆
(7)public final void wait() throws java.lang.InterruptedException // 多线程中等待功能
(8)public final native void notify() // 多线程中唤醒功能
(9)public final native void notifyAll() // 多线程中唤醒所有等待线程的功能
```

15. == 和 equals的联系和区别？

- **== ：** 该操作符生成的是一个boolean结果，它计算的是**操作数的值之间的关系**
- **equals ：** Object 的 **实例方法**，比较两个对象的**content**是否相同
- **hashCode ：** Object 的 **native方法** , 获取对象的**哈希值**，用于确定该对象在哈希表中的索引位置，它实际上是一个int型整数

16. 重载和重写的区别？

- 重载：在一个类下方法名相同，参数列表不同，返回值类型随意
- 重写：子类对父类的允许的方法实现的过程进行重新编写，参数列表相同，返回值类型相同，异常不能比父类抛的多，访问权限修饰符不能比父类大

17. 使用System的arraycopy方法, System.arraycopy(源数组, 从源数组下标开始, 新数组, 新数组开始下标, 数组结束小标)