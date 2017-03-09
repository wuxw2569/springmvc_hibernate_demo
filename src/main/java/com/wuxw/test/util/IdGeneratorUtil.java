package com.wuxw.test.util;

import java.io.Serializable;
import java.util.Properties;
import java.util.UUID;

import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.type.Type;

import com.wuxw.test.entity.AcctUser;
 
 
 
public class IdGeneratorUtil implements Configurable,IdentifierGenerator {  
 
 
   public String dataCenterID;  
   public String idLength;  
 
 
   public void configure(Type type, Properties params, Dialect d) {  
       this.dataCenterID = params.getProperty("dataCenterID");  
       this.idLength = params.getProperty("idLength");  
   }  
 
 
   public Serializable generate(SessionImplementor session, Object obj) {  
	   String uuid ="";
	   if(obj instanceof AcctUser){
		   long time = System.currentTimeMillis();
		   System.out.println("AACU"+time);
		   return uuid;
	   }else{
		   uuid = dataCenterID + idLength;
	   }
	   
       return uuid;  
   }  
 
 
}  