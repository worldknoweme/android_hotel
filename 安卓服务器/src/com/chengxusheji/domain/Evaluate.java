package com.chengxusheji.domain;

import java.sql.Timestamp;
public class Evaluate {
    /*记录编号*/
    private int evaluateId;
    public int getEvaluateId() {
        return evaluateId;
    }
    public void setEvaluateId(int evaluateId) {
        this.evaluateId = evaluateId;
    }

    /*评价的房间*/
    private RoomInfo roomObj;
    public RoomInfo getRoomObj() {
        return roomObj;
    }
    public void setRoomObj(RoomInfo roomObj) {
        this.roomObj = roomObj;
    }

    /*评价的用户*/
    private UserInfo userObj;
    public UserInfo getUserObj() {
        return userObj;
    }
    public void setUserObj(UserInfo userObj) {
        this.userObj = userObj;
    }

    /*评分(5分制)*/
    private int evalueScore;
    public int getEvalueScore() {
        return evalueScore;
    }
    public void setEvalueScore(int evalueScore) {
        this.evalueScore = evalueScore;
    }

    /*评价内容*/
    private String evaluateContent;
    public String getEvaluateContent() {
        return evaluateContent;
    }
    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }

    /*评价时间*/
    private String evaluateTime;
    public String getEvaluateTime() {
        return evaluateTime;
    }
    public void setEvaluateTime(String evaluateTime) {
        this.evaluateTime = evaluateTime;
    }

}