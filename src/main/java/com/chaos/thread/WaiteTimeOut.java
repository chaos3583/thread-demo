package com.chaos.thread;

/**
 * 等待超时模式
 */
public class WaiteTimeOut {

    /**
     *
     * @param millis 超时时间
     * @return
     */
    public  static synchronized Object getObject(Long millis){
            Object result =null;
            Long future = System.currentTimeMillis()+millis;
            while(result==null || millis>0){

            }

        return result;
    }
}
