package com.xincubate.lego.sample.utils;

import com.xincubate.lego.adapter.core.BaseItem;
import com.xincubate.lego.generate.LegoRegisterItems;
import com.xincubate.lego.layoutcenter.LayoutCenter;

public class LegoUtils {

    public static void init(){

        for (Object item : new LegoRegisterItems().items){
            if (item instanceof Class<?>){
                Class<?> itemClass = (Class<?>)item;
                if (subOfBaseItem(itemClass)){
                    LayoutCenter.getInstance().registerViewType((Class<? extends BaseItem>) itemClass);
                }
            }
        }

    }

    private static boolean subOfBaseItem(Class<?> clazz){
        Class<?> superClass = clazz.getSuperclass();
        if (superClass.equals(BaseItem.class)){
            return true;
        }else {
            if (superClass.equals(Object.class)){
                return false;
            }else {
                return subOfBaseItem(superClass);
            }
        }
    }
}
