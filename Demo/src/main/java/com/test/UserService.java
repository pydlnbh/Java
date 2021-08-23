package com.test;

import lombok.Data;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class UserService {
    @Data
    static class UserInfo {
        //@TableId(value = "id", type = IdType.AUTO)
        private Integer id;
        //@ApiModelProperty(value = "用户id")
        private String userId;
        //@ApiModelProperty(value = "用户昵称")
        private String userName;
        //@ApiModelProperty(value = "正式使用的图片，数组格式")
        private String img;
        //@ApiModelProperty(value = "1-男 2-女")
        private Integer gender;
        //@ApiModelProperty(value = "生日")
        private LocalDate birthday;
        //@ApiModelProperty(value = "身高-cm")
        private Integer height;
        //@ApiModelProperty(value = "家乡，如：浙江省-杭州市-西湖区")
        private String hometown;
    }

    /**
     * 组装参数，返回
     */
    public static UserInfo buildUserInfo(Map userInfoMap) {
        UserInfo userInfo = new UserInfo();
        /** 请补充代码，将userInfoMap传入的参数，转化为userInfo*/
        /** 注意：此处传入的参数可能为任意的其中一个，非固定为birthday哦，
         * 原则上前端每次只会传入一个用户信息参数，但若传入多个，后端也只会保存其中一个参数*/

        userInfo.setId((Integer) userInfoMap.get("id"));
        userInfo.setUserId((String) userInfoMap.get("userId"));
        userInfo.setUserName((String) userInfoMap.get("userName"));
        userInfo.setGender((Integer) userInfoMap.get("gender"));
        userInfo.setHeight((Integer) userInfoMap.get("height"));
        userInfo.setBirthday(LocalDate.parse((String) userInfoMap.get("birthday")));
        userInfo.setHometown((String) userInfoMap.get("hometown"));
        userInfo.setImg((String) userInfoMap.get("img"));

        return userInfo;
    }

    public static void main(String[] args) throws Exception {
        Map userInfoMap = new HashMap();
        userInfoMap.put("birthday", "1999-01-01");
        userInfoMap.put("userName","用户名XXX");
        System.out.println(buildUserInfo(userInfoMap));
    }
}