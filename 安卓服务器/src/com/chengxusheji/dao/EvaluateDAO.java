package com.chengxusheji.dao;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.chengxusheji.domain.RoomInfo;
import com.chengxusheji.domain.UserInfo;
import com.chengxusheji.domain.Evaluate;

@Service @Transactional
public class EvaluateDAO {

	@Resource SessionFactory factory;
    /*每页显示记录数目*/
    private final int PAGE_SIZE = 10;

    /*保存查询后总的页数*/
    private int totalPage;
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public int getTotalPage() {
        return totalPage;
    }

    /*保存查询到的总记录数*/
    private int recordNumber;
    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }
    public int getRecordNumber() {
        return recordNumber;
    }

    /*添加图书信息*/
    public void AddEvaluate(Evaluate evaluate) throws Exception {
    	Session s = factory.getCurrentSession();
     s.save(evaluate);
    }

    @Transactional(propagation=Propagation.NOT_SUPPORTED)
    public ArrayList<Evaluate> QueryEvaluateInfo(RoomInfo roomObj,UserInfo userObj,String evaluateTime,int currentPage) { 
    	Session s = factory.getCurrentSession();
    	String hql = "From Evaluate evaluate where 1=1";
    	if(null != roomObj && !roomObj.getRoomNumber().equals("")) hql += " and evaluate.roomObj.roomNumber='" + roomObj.getRoomNumber() + "'";
    	if(null != userObj && !userObj.getUser_name().equals("")) hql += " and evaluate.userObj.user_name='" + userObj.getUser_name() + "'";
    	if(!evaluateTime.equals("")) hql = hql + " and evaluate.evaluateTime like '%" + evaluateTime + "%'";
    	Query q = s.createQuery(hql);
    	/*计算当前显示页码的开始记录*/
    	int startIndex = (currentPage-1) * this.PAGE_SIZE;
    	q.setFirstResult(startIndex);
    	q.setMaxResults(this.PAGE_SIZE);
    	List evaluateList = q.list();
    	return (ArrayList<Evaluate>) evaluateList;
    }

    @Transactional(propagation=Propagation.NOT_SUPPORTED)
    public ArrayList<Evaluate> QueryEvaluateInfo(RoomInfo roomObj,UserInfo userObj,String evaluateTime) { 
    	Session s = factory.getCurrentSession();
    	String hql = "From Evaluate evaluate where 1=1";
    	if(null != roomObj && !roomObj.getRoomNumber().equals("")) hql += " and evaluate.roomObj.roomNumber='" + roomObj.getRoomNumber() + "'";
    	if(null != userObj && !userObj.getUser_name().equals("")) hql += " and evaluate.userObj.user_name='" + userObj.getUser_name() + "'";
    	if(!evaluateTime.equals("")) hql = hql + " and evaluate.evaluateTime like '%" + evaluateTime + "%'";
    	Query q = s.createQuery(hql);
    	List evaluateList = q.list();
    	return (ArrayList<Evaluate>) evaluateList;
    }

    @Transactional(propagation=Propagation.NOT_SUPPORTED)
    public ArrayList<Evaluate> QueryAllEvaluateInfo() {
        Session s = factory.getCurrentSession(); 
        String hql = "From Evaluate";
        Query q = s.createQuery(hql);
        List evaluateList = q.list();
        return (ArrayList<Evaluate>) evaluateList;
    }

    /*计算总的页数和记录数*/
    @Transactional(propagation=Propagation.NOT_SUPPORTED)
    public void CalculateTotalPageAndRecordNumber(RoomInfo roomObj,UserInfo userObj,String evaluateTime) {
        Session s = factory.getCurrentSession();
        String hql = "From Evaluate evaluate where 1=1";
        if(null != roomObj && !roomObj.getRoomNumber().equals("")) hql += " and evaluate.roomObj.roomNumber='" + roomObj.getRoomNumber() + "'";
        if(null != userObj && !userObj.getUser_name().equals("")) hql += " and evaluate.userObj.user_name='" + userObj.getUser_name() + "'";
        if(!evaluateTime.equals("")) hql = hql + " and evaluate.evaluateTime like '%" + evaluateTime + "%'";
        Query q = s.createQuery(hql);
        List evaluateList = q.list();
        recordNumber = evaluateList.size();
        int mod = recordNumber % this.PAGE_SIZE;
        totalPage = recordNumber / this.PAGE_SIZE;
        if(mod != 0) totalPage++;
    }

    /*根据主键获取对象*/
    @Transactional(propagation=Propagation.NOT_SUPPORTED)
    public Evaluate GetEvaluateByEvaluateId(int evaluateId) {
        Session s = factory.getCurrentSession();
        Evaluate evaluate = (Evaluate)s.get(Evaluate.class, evaluateId);
        return evaluate;
    }

    /*更新Evaluate信息*/
    public void UpdateEvaluate(Evaluate evaluate) throws Exception {
        Session s = factory.getCurrentSession();
        s.update(evaluate);
    }

    /*删除Evaluate信息*/
    public void DeleteEvaluate (int evaluateId) throws Exception {
        Session s = factory.getCurrentSession();
        Object evaluate = s.load(Evaluate.class, evaluateId);
        s.delete(evaluate);
    }

}
