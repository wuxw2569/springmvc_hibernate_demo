package com.wuxw.test.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiberUtil {
	private static SessionFactory sessionFactory;  
    private HiberUtil(){  
          
    }  
    static{  
        //根据默认位置的hibernate配置文件的配置信息，创建一个Configuration实例  
        Configuration configuration = new Configuration();  
        configuration.configure();  
        sessionFactory=configuration.buildSessionFactory();  
    }   
    public static Session getSession(){  
        return sessionFactory.openSession();  
    }
}
