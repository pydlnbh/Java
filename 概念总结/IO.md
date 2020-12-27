1. File类常用API

```java
public File(String pathname) // File类的构造方法
public boolean createNewFile() throws IOException // 创建文件
public String getName() // 获取文件的名称
public String getAbsolutePath() // 获取文件的绝对路径, 无论当前文件是否存在, 只要给具体的路径, 都可以返回相应的路径名称
public boolean isDirectory() // 判断文件是否是目录
public boolean isFile() // 判断文件是否是文件
public String getParent() // 获取文件的父路径名称, 如果文件的路径只包含文件名称 则显示空
public boolean exists() // 判断当前文件是否存在
public String getCanonicalPath() throws IOException // 返回文件绝对路劲的规范格式
public String[] list() // 返回元素中命名文件和目录的字符串数组
public File[] listFiles() // 返回元素中命名文件和目录的File数组
public static File[] listRoots() // 返回当前文件系统的所有盘符
public boolean mkdir()  // 创建单击目录
public boolean mkdirs() // 创建多级目录
File.separator // File类的静态属性, 返回操作系统的文件分隔符
// 判断文件的属性, 都会返回boolean类型的值
public boolean canExecute()
public boolean canRead()
public boolean canWrite()
```

2. 递归实现循环遍历某个文件夹中所有文件的绝对路径

```java
public static void printFiles(File file) {
    // 如果是目录, 转换为文件数组
    if (file.isDirectory) {
        File[] files = file.isListFile();
        // 使用增强for循环, 遍历目录下的子文件
        for (File f : files) {
            // 递归调用
            printFiles(f);
        }
        // 如果不是目录, 打印文件绝对路径
    } else {
        System.out.println(file.getAbsolutePath());
    }
}
// 文件在遍历的时候, 如果系统受保护, 某些文件没有访问权限, 此时会出现空指针异常
```

3. IO流的原理和概念

   - 按流向划分, 以程序作为参照物:

   - 从一个文件中读取数据到程序叫做输入流, read读输入流
   - 从程序输出数据到另一个文件叫做输出流, write写输出流
4. 按处理单元划分, 纯文本的是否可以用16位Unicode字符流Reader或Writer; 图片和视频等必须用8位通用字节流InputStream和OutputStream
5. 当编写IO流的程序的时候一定要注意关闭流
   - 选择合适的IO流对象
   - 创建对象
   - 传输数据
   - 关闭流对象, 不关闭会一直占用系统资源
6. 什么时候需要flush, 什么时候不加flush?
   - 当某一个输出流对象中带有缓冲区的时候, 就需要进行flush, 在输出流关闭之前每次都flush

7. 流的分类?

   - 功能不同
     - 节点流: 可以字节从数据源或目的地读写数据
     - 处理流(包装流): 不直接连接到数据源或目的地, 是其他流进行封装, 目的主要是简化操作和提高性能

   - 节点流和处理流的关系
     - 节点流处于IO操作的第一线, 所有操作必须通过他们进行
     - 处理流可以对其他流进行处理(提高效率或操作灵活性)

8. 处理流的使用

```java
FileInputStream fileInputStream = new FileInptStream("abc.txt"); // 节点流
InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream); // 处理流
InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "utf-8"); // 处理流, 可以自定义字符编码
```

9. 节点流缓冲区和循环代码

```java
FileInputStream inputStream = new FileInputStream();
byte[] buffer = new byte[];
while((inputStream.read(buffer) != -1) { // read / writer 不等于-1就是读取整个数据循环条件
    new String(buffer);
}
```

