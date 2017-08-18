package com.moflying.playground;

import com.moflying.playground.entities.animals.AnimalWithInitValue;
import com.moflying.playground.utils.JsonUtil;

public class ObjectPlayground {
    /**
     * 为其字段带有默认值的类初始化对象，初始化出的对象的相应字段带有默认值
     */
    private static void playNewObjectWithInitValues() {
        AnimalWithInitValue animalWithInitValue = new AnimalWithInitValue();
        System.out.println(JsonUtil.write(animalWithInitValue));
    }

    public static void main(String[] args) {
        playNewObjectWithInitValues();
    }
}
