package com.stars.kit.lego.adapter.bridge;

/**
 * Created by asherchen on 2018/11/21.
 * Item通信实体
 */
public interface BridgeEntity {
    void onBridge(Object sender,String event,Object args);
}
