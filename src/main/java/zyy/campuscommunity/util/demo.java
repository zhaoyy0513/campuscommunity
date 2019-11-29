package zyy.campuscommunity.util;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import static zyy.campuscommunity.controller.PostController.checkPostContent;


public class demo {
    public static void main(String args[]) throws UnsupportedEncodingException {
        Map<String,Object> checkMap= checkPostContent("胡锦涛");
        int spam = (int)checkMap.get("spam");
        if(spam!=0){ //是否违禁标识(0表示非违禁，1表示违禁，2表示建议人工复审
            int disObeyNum = Integer.valueOf(String.valueOf(checkMap.get("disObeyType")));
            String msg = disObeyMap.getTypeByDisObeyNum(disObeyNum);
            System.out.println("发布失败,帖子包含["+msg+"]内容");
        }
    }
}