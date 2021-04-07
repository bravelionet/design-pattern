package com.bravelionet;

import java.util.*;
import java.util.concurrent.*;

public class CaseTest {

    public static void main(String[] args) {
        TreeMap<String, Object> objectObjectTreeMap = new TreeMap<>();
     /*   ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        objectObjectTreeMap.put("test", "张三");
        objectObjectTreeMap.put("name", "lisi");
        objectObjectTreeMap.put("age", 1);
        objectObjectTreeMap.put("addr", null);
        objectObjectTreeMap.put("preiId", list);
        String b = transform(objectObjectTreeMap, false);
        System.out.println("b = " + b);
        String s = md5(b);
        System.out.println("s = " + s);

        String sss = transform(objectObjectTreeMap, true);
        System.out.println("sss = " + sss);
        assemblyBuild("dfjasdlkfajlksdfkjlsa");*/
        /**
         将参数转换成 TreeMap
         进行 md5 值转换 secret key
         提取 ASCII 值累加,拼接 secret key后
         将元数据进行剔除 null 值
         将 元数据转成JSON
         将json于secret key md5
         */
    }
    public static String sa(){


    }

    /**
     * @param treeMap 参数进行自然排序
     * @param flag    : Boolean.ture 剔除 null 元素
     * @return
     * @author : Lionet
     * @date : 2021/3/29  14:07
     */
    public static String transform(TreeMap<String, Object> treeMap, Boolean flag) {
        Set set = treeMap.keySet();
        Iterator iterator = set.iterator();
        StringBuffer stringBuffer = new StringBuffer();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            Object value = treeMap.get(next);
            if (flag && Objects.isNull(value)) {
                continue;
            }
            stringBuffer.append(next).append("=").append(value).append("&");
        }
        String keyValue = stringBuffer.toString();
        keyValue = stringBuffer.deleteCharAt(keyValue.length() - 1).toString();
        System.out.println("keyValue = " + keyValue);
        return keyValue;
    }


    /**
     * <p> md5 值转换 </p>
     *
     * @param str
     * @return
     * @author : Lionet
     * @date : 2021/3/29  14:06
     */
    public static String md5(String str) {
        String hash = Md5Utils.hash(str);
        System.out.println("hash = " + hash);
        return hash;
    }

    /**
     * <p> ASCII值转换 </p>
     *
     * @param str
     * @return
     * @author : Lionet
     * @date : 2021/3/29  14:04
     */
    public static Integer assemblyBuild(String str) {
        if (str.length() < 8) {
            throw new RuntimeException("T he length of the target (length < 8) ")
        }
        System.out.println("转换前 = " + str);
        // 截取倒数第二到第六位
        String substring = str.substring(str.length() - 6, str.length() - 1);
        System.out.println("转换后 = " + substring);
        char[] chars = substring.toCharArray();
        int length = chars.length;
        int num = 0;
        for (int i = 0; i < length; i++) {
            int num_i = (int) chars[i];
            System.out.println("num_i = " + num_i);
            num += num_i;
        }
        System.out.println("num = " + num);
        return num;
    }

}
