package com.develop.manual.question01;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.StopWatch;
import org.springframework.cglib.beans.BeanCopier;

import java.util.Date;

/**
 * 拷贝工具类效率比较
 */
public class CopyUtilsCompareDemo {
    public void hutoolTest(PersonDO personDO, int testTimes) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (int i = 0; i < testTimes; i++) {
            PersonDTO personDTO = new PersonDTO();
            BeanUtil.copyProperties(personDO, personDTO);
        }

        stopWatch.stop();
        System.out.println("hutoolUtil cost: " + stopWatch.getTotalTimeMillis() + "ms");
    }

    public void springUtilTest(PersonDO personDO, int testTimes) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (int i = 0; i < testTimes; i++) {
            PersonDTO personDTO = new PersonDTO();
            org.springframework.beans.BeanUtils.copyProperties(personDO, personDTO);
        }

        stopWatch.stop();
        System.out.println("springUtil costs: " + stopWatch.getTotalTimeMillis() + "ms");
    }

    public void cglibTest(PersonDO personDO, int testTimes) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (int i = 0; i < testTimes; i++) {
            PersonDTO personDTO = new PersonDTO();
            BeanCopier beanCopier = BeanCopier.create(PersonDO.class, PersonDTO.class, false);
            beanCopier.copy(personDO, personDTO, null);

        }

        stopWatch.stop();
        System.out.println("cglibTest cost: " + stopWatch.getTotalTimeMillis() + "ms");
    }

    /**
     * 测试类
     */
    public void beginTest() {

        int testTimes = 1000;

        PersonDO personDO = PersonDO
                .builder()
                .id(1)
                .age(18)
                .birthday(new Date())
                .gender(true)
                .name("zs")
                .build();

        System.out.println("test begin");
        System.out.println("=====================");
        System.out.println("1000次");
        cglibTest(personDO, testTimes);
        hutoolTest(personDO, testTimes);
        springUtilTest(personDO, testTimes);
        System.out.println("=====================");

        testTimes = 10000;
        System.out.println("1w次");
        cglibTest(personDO, testTimes);
        hutoolTest(personDO, testTimes);
        springUtilTest(personDO, testTimes);
        System.out.println("=====================");

        testTimes = 100000;
        System.out.println("10w次");
        cglibTest(personDO, testTimes);
        hutoolTest(personDO, testTimes);
        springUtilTest(personDO, testTimes);
        System.out.println("=====================");

        testTimes = 1000000;
        System.out.println("100w次");
        cglibTest(personDO, testTimes);
        hutoolTest(personDO, testTimes);
        springUtilTest(personDO, testTimes);
        System.out.println("=====================");
        System.out.println("test end!");
    }

    public static void main(String[] args) {
        new CopyUtilsCompareDemo().beginTest();
    }
}
