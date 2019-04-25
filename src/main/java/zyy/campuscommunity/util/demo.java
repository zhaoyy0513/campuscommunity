package zyy.campuscommunity.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import zyy.campuscommunity.entity.User;
import zyy.campuscommunity.service.UserService;


public class demo {
    public static void main(String args[]){
        String replyContent = "@吹不散眉弯 哈哈哈哈哈";
        String[] arr = replyContent.split(" ");
        System.out.println(arr[0]);
        String[] replyName = arr[0].split("@");
        String name = replyName[1];
        System.out.println(name);
    }
}