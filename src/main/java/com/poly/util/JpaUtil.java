package com.poly.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	

		static EntityManagerFactory factory = null;
		
		public static EntityManagerFactory getFactory() {
			//1. Load persistence => EntityMnagerFactory
			if(factory == null || factory.isOpen()) {
				factory = Persistence.createEntityManagerFactory("asmJAVA04_2023");
			}
			return factory;
		}

		public static void shutDown() {
			if(factory != null && factory.isOpen()){
				factory.close();
			}
			factory = null;
		}

	

}
