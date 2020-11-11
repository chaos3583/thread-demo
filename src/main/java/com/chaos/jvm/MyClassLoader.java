package com.chaos.jvm;

import com.chaos.TestDomain;

import java.io.InputStream;

/**
 * @program: thread-demo
 * * @description:
 * * @author: liaopeng
 * * @create: 2020-08-14 14:31
 **/
public class MyClassLoader extends ClassLoader{
    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    public MyClassLoader() {
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        return super.findClass(name);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        try {
            String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
            InputStream is = getClass().getResourceAsStream(fileName);
            if (is==null){
                return super.loadClass(name);
            }
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            return defineClass(name,bytes,0,bytes.length);
        }catch (Exception e){
            throw new ClassNotFoundException();
        }
    }

    public static void main(String[] args) {

    }
}
