package com.atguigu.java.chapter02;

/**
 * @author lppppp
 * @create 2021-04-03 10:11
 * 获取ClassLoader的途径
 */
public class ClassLoaderTest2 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1. 通过 Class.forName("java.lang.String").getClassLoader()
        System.out.println(Class.forName("java.lang.String").getClassLoader());
        System.out.println(Class.forName("com.atguigu.java.chapter02.ClassLoaderTest2").getClassLoader());

    //    2.通过 获取当前线程上下文的ClassLoader：Thread.currentThread().getContextClassLoader()
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);

        //3.获取系统的ClassLoader：ClassLoader.getSystemClassLoader()
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        System.out.println("获取系统的ClassLoader：ClassLoader.getSystemClassLoader() "+systemClassLoader);
        System.out.println("获取系统的ClassLoader父类：systemClassLoader.getParent() "+systemClassLoader.getParent());
    }
}
