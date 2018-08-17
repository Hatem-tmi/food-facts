package com.toumi.foodfacts.common.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
public class ClassUtils {

    @SuppressWarnings("unchecked")
    public static <T> Class<T> getTypeParameterClass(Class<?> clz, int argsIndex) {
        Type type = clz.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) type;
        return (Class<T>) paramType.getActualTypeArguments()[argsIndex];
    }
}
