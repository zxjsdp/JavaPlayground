package com.moflying.playground.entities;

public class ArgCarrier {
    /**
     * 类型
     */
    private Class aClass;

    /**
     * 值
     */
    private Object obj;

    public ArgCarrier() {}

    public ArgCarrier(Class aClass, Object obj) {
        this.aClass = aClass;
        this.obj = obj;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
