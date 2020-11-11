package com.chaos.thread;

import com.chaos.TestDomain;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: thread-demo
 * * @description:
 * * @author: liaopeng
 * * @create: 2020-08-13 10:52
 **/
public class WeakTest extends WeakReference<TestDomain> {

    public WeakTest(TestDomain referent) {
        super(referent);
    }

    @Override
    public String toString() {
        return "WeakTest{}";
    }

    Map<WeakTest,Object> weakTestMap = new HashMap<>();

}
