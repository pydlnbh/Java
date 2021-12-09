# CMD窗口命令

### 1. dmp文件在下面路径下

```shell
D:\app\Administrator\admin\orcl\dpdump
```

---

### 2. 导入dmp文件:

```sql
impdp test1/test2@orcl dumpfile=test3.dmp remap_schema=test1:test4
```

- impdp (导入关键字)
- test1 (导入的数据库用户名)
- test2 (导入的数据库密码)
- dumpfile = test3.dmp(需要导入的dmp)
- remap_schema = test1(导出用户名):test4(导入用户名)

---

### 3. 导出dmp文件

```sql
expdp test1/test2 dumpfile=test3.dmp
```

- expdp (导出关键字)
- test1 (导出的数据库用户名)
- test2 (导出的数据库密码)
- dumpfile = test3.DMP(需要导出的dmp)
