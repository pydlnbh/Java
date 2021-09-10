package com.se.lambda.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author pyd
 */
public class TestLambdaDemo {
    public static void main(String[] args) {

        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(new UserInfo("小明", 18, "m", 80));
        userInfoList.add(new UserInfo("小红", 16, "f", 81));
        userInfoList.add(new UserInfo("小刚", 12, "m", 79));
        userInfoList.add(new UserInfo("小熊", 11, "f", 94));
        userInfoList.add(new UserInfo("小二", 10, "m", 68));
        userInfoList.add(new UserInfo("小四", 18, "f", 60));
        userInfoList.add(new UserInfo("小五", 19, "m", 98));
        userInfoList.add(new UserInfo("小二砸", 10, "m", 74));
        userInfoList.add(new UserInfo("小四砸", 18, "f", 84));
        userInfoList.add(new UserInfo("小五砸", 19, "m", 96));


//        1.最高得分（score）是多少？
        Integer score = userInfoList.stream().map(UserInfo::getScore).distinct().max(Integer::compareTo).get();
        userInfoList.stream().map(UserInfo::getScore).max(Integer::compareTo).get();
        userInfoList.stream().mapToInt(UserInfo::getScore).max().getAsInt();
        userInfoList.stream().map(userInfo -> userInfo.getScore()).sorted(Comparator.reverseOrder()).limit(1).forEach(System.out::println);
        System.out.println(score);

//        2.前两名的分数（score）相加等于多少？
        userInfoList.stream().sorted(Comparator.comparing(UserInfo::getScore, Comparator.reverseOrder())).mapToInt(UserInfo::getScore).limit(2).sum();
        userInfoList.stream().sorted(Comparator.comparing(UserInfo::getScore, Comparator.reverseOrder())).limit(2).mapToInt(UserInfo::getScore).sum();
        List<Integer> list = userInfoList.stream().map(userInfo -> userInfo.getScore()).sorted(Comparator.reverseOrder()).limit(2).collect(Collectors.toList());
        Optional<Integer> sum = list.stream().reduce((x, y) -> x + y);

//        3.请根据性别（sex）分组。
        Map<String, List<UserInfo>> map = userInfoList.stream().collect(Collectors.groupingBy(UserInfo::getSex));

//        4.计算出男生分数（score）的平均值？
        userInfoList.stream().filter(a -> Objects.equals("m", a.getSex())).mapToInt(UserInfo::getScore).average().getAsDouble();
        userInfoList.stream().filter(v -> v.getSex().equals("m")).collect(Collectors.toList()).stream().mapToInt(UserInfo::getScore).average().getAsDouble();

//        5.请将得分（score）大于等于80、年龄（age）大于15的男生姓名用逗号拼接起来；
        userInfoList.stream().filter(a -> a.getScore() >= 80 && a.getAge() > 15 && a.getSex().equals("m")).map(UserInfo::getName).collect(Collectors.joining(","));

//        6.请输出姓名中出现的汉字（不能重复），并且每个汉字用逗号分隔。例如 "小明" 和 "小熊"， 输出 "小,明,熊"
        userInfoList.stream().map(UserInfo::getName).flatMap(a -> Arrays.stream(a.split(""))).distinct().collect(Collectors.joining(","));

//        7.请根据性别分组并输出每组分数最大的人类信息
        userInfoList.stream().collect(Collectors.groupingBy(UserInfo::getSex, Collectors.collectingAndThen(Collectors.reducing((c1, c2) -> c1.getScore() > c2.getScore() ? c1 : c2), Optional::get)));
        Map<String, List<UserInfo>> resMap = userInfoList.stream().collect(Collectors.groupingBy(UserInfo::getSex));
        for (Map.Entry<String, List<UserInfo>> m : resMap.entrySet()) {
            Optional<UserInfo> max = m.getValue().stream().max(Comparator.comparing(userInfo -> userInfo.getScore()));
            System.out.println(max.get());
        }

    }
}
