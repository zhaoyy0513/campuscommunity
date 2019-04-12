package zyy.campuscommunity.util;

public class demo {
    public static void main(String args[]){
        String str = "ab,cd,efg";
        String arr[] = str.split(",");
        String str2 = str.substring(1,str.length()-1);
        for (String s : arr) {
            System.out.println(s);
        }
        System.out.println("--------------");
        System.out.println(str2);
    }
}