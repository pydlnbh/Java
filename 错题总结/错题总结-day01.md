1. 假设有一个Java源程序文件，它只定义了一个具有public属性的类Hello，那么解释执行该类的命令是“java Hello.class”。（ 错 ）

- javac Hello.java 编译，**java Hello执行，执行时不要带class后缀**

2. Java的跨平台原理，和C语言跨平台原理的不同之处？

-        <img src="C:\Users\user\Desktop\错题总结\images\java和C跨平台原理.png" alt="java和C跨平台原理" style="zoom: 80%;" />

3. 什么是JVM？什么是JDK？ 什么是JRE？

-     <img src="C:\Users\user\Desktop\错题总结\images\Java.png" alt="Java" style="zoom:50%;" />

4. Java的优点？

- 跨平台，简单的，安全的，完全面向对象的，健壮的

5. 注释有什么作用?

- 注释就是程序员为读者作的说明，是提高程序可读性的一种手段

6. Java语言的执行过程？

- 编写好的.java文件    通过javac命令编译成class字节码文件    在JVM虚拟机中运行

7. 环境变量path和classpath的作用？

- path：提供windows命令中java指令的可执行文件的路径，当我们在命令行中键入命令时，提供环境变量中的path值，找到对应的指令可执行文件进行执行
- classpath：JVM通过classpath知道一个java文件对应的编译好的class字节码文件的存放路径

8. 十进制转16进制，十进制除以16，然后得到余数，再拿商除以16，直到最后一位，a,b,c,d,e,f分别代表10,11,12,13,14,15

9. ```java
   int i = 1; 
   int j;
   j = i++; // j = 1, i = 2
   解析：i++代表先赋值后自增，所以i=1先赋值给j，然后i自增变为2,所以i=2,j=1
   ```

10. ```java
    float f1 = 1.12; // error 需要强制类型转换或在数字后面加f或F
    float f2 = 1.12f; // correct 
    float f2 = (float)1.12; // correct
    double d1 = 3.1E1; // correct 科学计数法表示
    double d2 = 32.1D; // correct 可以带后缀d或D表示double类型
    总结：float需要带上f/F后缀, 不能使用科学计数法，double比较随意，可以直接赋值，也可以使用科学计数法，也可以使用D/d后缀
    ```

11. 三目运算符又叫条件运算符，除了赋值符以外优先级最低

12. ```java
    public static short method(byte x, double y) {
        return (short) x / y * 2;	// error 只是限制类型转换了x,没有转换全部
    }
    
    public static short method(byte x, double y) {
        return (short) ((short)x / y * 2);	// correct
    }
    
    public static double method1(byte x, double y) {
        return (short) x / y * 2;	// correct
    }
    ```

13. ```java
    short s1 = 1; // correct
    s1 = s1 + 1; // error 不兼容的类型: 从int转换到short可能会有损失
    s1 += 1; // correct “+=”这个运算符在Java中是一个运算符，而不是两个，程序在执行“+=”时，会自动向高精度进行数据类型转换
    ```

14. 浮点型常量默认是double 类型的

15. Java语言中不同数据类型的长度是固定的，不随机器硬件不同而改变

16. switch只能支持byte, short, chra, int, 1.7之后加入String

17. 随机生成[30, 60]的语句`(int)(Math.random() * 31) + 30`

18. ```java
    boolean flag = false;
    if (flag = false) { // 这里是一个等号表示赋值, 所以条件判断为false
    }s
    ```

19. switch语句中，case x : 判断以后没有写break，会一直往下进行，不会跳出循环

20. ```java
    int a = 0;
    int c = 0;
    do {
        --c;
        a = a - 1;
       
    } while (a > 0);
    System.out.println("a = " + a + ", b = " + b); // dowhile在这执行了一次才跳出循环的，光想着跳出循环了，没想到打印在外面
    ```

21. ```java
    for(int i = 1; i <= 10; i++) {
    	if (i < 5) {
    		continue;
    	}
    	System.out.println(1); // 打印了6个1，1 2 3 4 5 6 7 8 9 10 跳过前面4个，剩下6个打印
    }
    ```

22. switch多分枝判断100以内分数的等级，判断条件可以分数除以10就变成5个case了

