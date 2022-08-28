package com.stars.kit.lego.adapter.core;

/**
 * Created by asherchen on 2018/12/5.
 */
public interface ContextDataSet {

    <T> T getContextData(String key);

}
