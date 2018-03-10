package com.hubei.web.admin;

import com.hubei.base.util.MD5Util;

public class Test {
    public static void main(String[] args) {

        System.out.println(MD5Util.md5(MD5Util.md5("12345")+"123"));
    }
}
