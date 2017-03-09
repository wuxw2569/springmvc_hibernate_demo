package com.wuxw.test;

import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wuxw.test.entity.AcctRole;
import com.wuxw.test.entity.AcctUser;
import com.wuxw.test.util.HiberUtil;

public class Many2OneTest {
	/** 
     * @param args 
     */  
    public static void main(String[] args) {  
       
    	 Session s =null;  
         Transaction t = null;  
         s=HiberUtil.getSession();  
         t=s.beginTransaction();   
         AcctUser acctUser = (AcctUser)s.load(AcctUser.class, "6e5afb1d-50e1-45fe-b6fe-b9e399415387");          
        
         Collection<AcctRole> addset=acctUser.getAcctRoles();  
         Iterator it=addset.iterator();
         while(it.hasNext()){
        	 AcctRole tempRole=(AcctRole)it.next();
    	 	System.out.println(tempRole.getName());
         }
         
         
         t.commit();  
         s.close();  
    	
    	
    }  
    /** 
     * 添加一个acctUser 和AcctRole 以及它们之间的关联 
     */  
    static void add(){  
        Session s =null;  
        Transaction t = null;  
        s=HiberUtil.getSession();  
        t=s.beginTransaction();  
          
        AcctUser accUser = new AcctUser(); 
        accUser.setId(UUID.randomUUID().toString());
        accUser.setNickName("人事部");  
          
        AcctRole acctRole = new AcctRole();  
        accUser.setId(UUID.randomUUID().toString());
        acctRole.setName("steve");  
          
        s.save(accUser);  
        s.save(acctRole);  
              
        t.commit();  
        s.close();  
    }  
    /** 
     * 使用load方法测试 懒加载的相关问题 
     * @return 
     */  
    static AcctUser query(){  
        Session s =null;  
        Transaction t = null;  
        s=HiberUtil.getSession();  
        t=s.beginTransaction();   
        AcctUser employee = (AcctUser)s.load(AcctUser.class, "6e5afb1d-50e1-45fe-b6fe-b9e399415387");          
        t.commit();  
        s.close();  
        return employee;  
    }
}
