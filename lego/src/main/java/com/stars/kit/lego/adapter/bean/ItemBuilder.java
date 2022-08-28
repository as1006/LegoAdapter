package com.stars.kit.lego.adapter.bean;

import android.content.Context;

import com.stars.kit.lego.adapter.core.BaseItem;

/**
 * Created by asherchen on 2018/11/27.
 * Bean到Item的转化器，需要在app或者module初始化的时候，往
 */
public interface ItemBuilder<T>{
    BaseItem build(Context context, T bean);
}