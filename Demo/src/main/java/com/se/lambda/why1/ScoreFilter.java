package com.se.lambda.why1;

import com.se.lambda.why.Student;

/**
 * @Author: PeiYiDing
 * @Date: 2021/1/1
 * @Description: com.java.se.lambda.why1
 */
public class ScoreFilter implements StudentFilter{
    @Override
    public boolean compare(Student student) {
        return student.getScore() > 60;
    }
}
