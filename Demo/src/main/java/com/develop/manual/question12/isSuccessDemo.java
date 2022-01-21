package com.develop.manual.question12;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.StringJoiner;

public class isSuccessDemo {

    public static void main(String[] args) {
        Model model = new Model();
        model.setSuccess(true);

        // 使用fastjson序列化model成字符串并输出
        System.out.println("Serializable Result With fastjson: " + JSON.toJSONString(model));

        // 使用Gson序列化model成字符串并输出
        System.out.println("Serializable Result With Gson: " + new Gson().toJson(model));
        /**
         * 使用 fastjson 进行序列化，再使用 Gson 反序列化
         *
         * (因为 JSON 框架通过扫描所有的 getter后发现有一个 isSuccess 方法，
         * 然后根据 JavaBeans 的规范，解析出变量名为success，把 model 对象序列化城字符串后内容为 {"success":true}。
         * 根据 {"success":true} 这个 json 串，Gson 框架在通过解析后，通过反射寻找 Model 类中的 success 属性，
         * 但是 Model 类中只有 isSuccess 属性，所以最终反序列化后的 Model 类的对象中，isSuccess 则会使用默认值 false。)
         */
        System.out.println(new Gson().fromJson(JSON.toJSONString(model), Model.class));

        // 使用jackson序列化model成字符串并输出
        try {
            System.out.println("Serializable Result With jackson: " + new ObjectMapper().writeValueAsString(model));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

class Model implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean isSuccess;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Model.class.getSimpleName() + "[", "]").add("isSuccess = " + isSuccess).toString();
    }

    //    public String getStr() {
//        return "test";
//    }
}
