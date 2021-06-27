package com.lizba.currency.p3;

import java.lang.reflect.Field;

/**
 * <p>
 *
 * </p >
 *
 * @Author: Liziba
 * @Date: 2021/6/3 17:19
 */
public class IntegerTest {


    public static void main(String[] args){

        try {
            Class<?>[] declaredClasses = Integer.class.getDeclaredClasses();
            Class<?> integerCache = declaredClasses[0];
            Field f = integerCache.getDeclaredField("cache");
            f.setAccessible(true);
            Integer[] cache = (Integer[]) f.get(integerCache);

            System.out.println(cache[129]);
            System.out.println(cache[130]);
            System.out.println(cache[131]);

            cache[130] = cache[129];
            cache[131] = cache[129];
            Integer a = 1;
            if (a == (Integer) 1 && a == (Integer) 2 && a == (Integer) 3) {
                System.out.println(true);
            }
            if (a == Integer.valueOf(1) && a == Integer.valueOf(2)  && a == Integer.valueOf(3)) {
                System.out.println(true);
            }
            if (a == new Integer(1) && a == new Integer(2) && a == new Integer(3)) {
                System.out.println(true);
            }
            System.out.println(cache[129]);
            System.out.println(cache[130]);
            System.out.println(cache[131]);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}