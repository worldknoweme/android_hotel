package com.chengxusheji.domain;

import java.sql.Timestamp;
public class MoneyRecord {
    /*记录编号*/
    private int recordId;
    public int getRecordId() {
        return recordId;
    }
    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    /*充值的用户*/
    private UserInfo userObj;
    public UserInfo getUserObj() {
        return userObj;
    }
    public void setUserObj(UserInfo userObj) {
        this.userObj = userObj;
    }

    /*充值金额*/
    private float moneyValue;
    public float getMoneyValue() {
        return moneyValue;
    }
    public void setMoneyValue(float moneyValue) {
        this.moneyValue = moneyValue;
    }

    /*附加信息*/
    private String memo;
    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /*充值时间*/
    private String happenTime;
    public String getHappenTime() {
        return happenTime;
    }
    public void setHappenTime(String happenTime) {
        this.happenTime = happenTime;
    }

}