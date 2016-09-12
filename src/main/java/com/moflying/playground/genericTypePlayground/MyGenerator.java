package com.moflying.playground.genericTypePlayground;

interface MyGenerator<T> {
    public Integer index = 0;

    public T next();

    public Boolean hasNext();
}
