package com.stars.kit.lego.adapter.bean;

import android.content.Context;

import com.stars.kit.lego.adapter.core.BaseItem;
import com.stars.kit.lego.adapter.core.BaseViewHolder;

import androidx.annotation.NonNull;

/**
 * Created by asherchen on 2018/11/15.
 * 游戏平台部
 */
public abstract class BaseBeanItem<T> extends BaseItem{

    protected T bean;

    public BaseBeanItem(Context context,T bean) {
        super(context);
        this.bean = bean;
    }


    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder viewHolder, int position) {

    }




}
