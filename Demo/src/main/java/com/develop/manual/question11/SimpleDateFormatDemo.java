package com.develop.manual.question11;

import cn.hutool.core.date.DateUtil;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.aspectj.weaver.ast.Var;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.*;
import java.util.concurrent.*;

public class SimpleDateFormatDemo {

    /**
     * 使用guava提供的ThreadFactoryBuilder创建线程池执行器创建新线程时使用的工厂
     */
    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();

    /**
     * ThreadPoolExecutor创建线程池
     */
    private static ExecutorService pool = new ThreadPoolExecutor(5, 200, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    /**
     * 定义一个CountDownLatch, 保证所有子线程执行完之后主线程再执行
     */
    private static CountDownLatch countDownLatch = new CountDownLatch(100);

    /**
     * 定义一个静态的simpleDateFormat对象
     */
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 使用ThreadLocal定义一个全局的simpleDateFormat
     */
    private static ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    /**
     * 定义一个DateTimeFormatter
     */
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        // 使用SimpleDateForamt格式化当前时间
        String dateStr = simpleDateFormat.format(new Date());
        System.out.println(dateStr);

        // 调整时区，打印纽约时间
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        System.out.println(simpleDateFormat.format(Calendar.getInstance().getTime()));
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        System.out.println(simpleDateFormat.format(Calendar.getInstance().getTime()));

        System.out.println("=========================================");

        // 定义一个线程安全的HashSet
        Set<String> dates = Collections.synchronizedSet(new HashSet<String>());

        // 正常情况输出应该是100, 但是实际执行结果是一个小于100的数字
//        simpleDateFormatSynTest(dates);

        // 解决SimpleDateFormat线程不安全问题, 使用局部变量
//        solveSimpleDateFormatSyn(dates);

        // 解决SimpleDateFormat线程不安全问题, 加同步锁
//        synSimpleDateFormat(dates);

        // 解决SimpleDateFormat线程不安全问题, 使用ThreadLocal
//        threadLocalSimpleDateFormat(dates);

        // 解决SimpleDateFormat线程不安全问题, 使用DateTimeFormatter
//        dateTimeFormatterTest(dates);

        // 解决SimpleDateFormat线程不安全问题, 使用DateUtils
        dateUtilTest(dates);
    }

    private static void dateUtilTest(Set<String> dates) {
        for (int i = 0; i < 100; i++) {
            // 获取当前时间
            Calendar calendar = Calendar.getInstance();
            int finalI = i;
            pool.execute(() -> {
                // 时间增加
                calendar.add(Calendar.DATE, finalI);
                // 通过SimpleDateFormat把时间转换成字符串
                String dateString = DateUtil.format(calendar.getTime(), "yyyy-MM-dd HH:mm:ss");
                // 把字符串放入Set中
                dates.add(dateString);
                // countDown
                countDownLatch.countDown();
            });
        }
        // 阻塞, 知道countDown数量为0
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 输出去重后的时间个数
        System.out.println(dates.size());
    }

    private static void dateTimeFormatterTest(Set<String> dates) {
        for (int i = 0; i < 100; i++) {
            // 获取当前时间
            LocalDateTime now = LocalDateTime.now();
            long finalI = i;
            pool.execute(() -> {
                // 时间增加
                LocalDateTime localDateTime = now.plusSeconds(finalI);
                // 通过dateTimeFormat把时间转换成字符串
                String dateString = localDateTime.format(dateTimeFormatter);
                // 把字符串放入Set中
                dates.add(dateString);
                // countDown
                countDownLatch.countDown();
            });
        }
        // 阻塞, 知道countDown数量为0
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 输出去重后的时间个数
        System.out.println(dates.size());
    }

    private static void threadLocalSimpleDateFormat(Set<String> dates) {
        for (int i = 0; i < 100; i++) {
            // 获取当前时间
            Calendar calendar = Calendar.getInstance();
            int finalI = i;
            pool.execute(() -> {
                // 时间增加
                calendar.add(Calendar.DATE, finalI);
                // 通过SimpleDateFormat把时间转换成字符串
                String dateString = simpleDateFormatThreadLocal.get().format(calendar.getTime());
                // 把字符串放入Set中
                dates.add(dateString);
                // countDown
                countDownLatch.countDown();
            });
        }
        // 阻塞, 知道countDown数量为0
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 输出去重后的时间个数
        System.out.println(dates.size());
    }

    private static void synSimpleDateFormat(Set<String> dates) {
        for (int i = 0; i < 100; i++) {
            // 获取当前时间
            Calendar calendar = Calendar.getInstance();
            int finalI = i;
            pool.execute(() -> {
                String dateString;
                // 时间增加
                calendar.add(Calendar.DATE, finalI);
                // 通过SimpleDateFormat把时间转换成字符串
                synchronized (simpleDateFormat) {
                    dateString = simpleDateFormat.format(calendar.getTime());
                }
                // 把字符串放入Set中
                dates.add(dateString);
                // countDown
                countDownLatch.countDown();
            });
        }
        // 阻塞, 知道countDown数量为0
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 输出去重后的时间个数
        System.out.println(dates.size());
    }

    private static void solveSimpleDateFormatSyn(Set<String> dates) {
        for (int i = 0; i < 100; i++) {
            // 获取当前时间
            Calendar calendar = Calendar.getInstance();
            int finalI = i;
            pool.execute(() -> {
                // SimpleDateFormat声明局部变量
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                // 时间增加
                calendar.add(Calendar.DATE, finalI);
                // 通过SimpleDateFormat把时间转换成字符串
                String dateString = simpleDateFormat.format(calendar.getTime());
                // 把字符串放入Set中
                dates.add(dateString);
                // countDown
                countDownLatch.countDown();
            });
        }
        // 阻塞, 知道countDown数量为0
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 输出去重后的时间个数
        System.out.println(dates.size());
    }

    private static void simpleDateFormatSynTest(Set<String> dates) {
        for (int i = 0; i < 100; i++) {
            // 获取当前时间
            Calendar calendar = Calendar.getInstance();
            int finalI = i;
            pool.execute(() -> {
                // 时间增加
                calendar.add(Calendar.DATE, finalI);
                // 通过SimpleDateFormat把时间转换成字符串
                String dateString = simpleDateFormat.format(calendar.getTime());
                // 把字符串放入Set中
                dates.add(dateString);
                // countDown
                countDownLatch.countDown();
            });
        }
        // 阻塞, 知道countDown数量为0
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 输出去重后的时间个数
        System.out.println(dates.size());
    }
}
