package com.niit.frstbackendproject;

import org.junit.BeforeClass;

import static org.junit.Assert.assertTrue;

import org.junit.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.*;
import com.niit.model.Supplier;

public class SupplierTest 
{
	@Autowired
	
	static SupplierDao supplierDao;
	
	@BeforeClass
	public static void executeFirst1()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	    
	    context.scan("com.niit");
	    context.refresh();
	    
	    supplierDao=(SupplierDao) context.getBean("supplierDao");
	}
	@Ignore
	@Test
	public void addSupplyTest()
	{
	Supplier s=new Supplier();
	s.setSupplierName("prasanna");

	s.setSupplierAddress("hyd");
		assertTrue("Problem in adding the supply",supplierDao.addSupplier(s));
	}
	@Ignore
	@Test
	public void deleteSupplyTest()
	{
Supplier supply=supplierDao.getSupplierById(1);
		
		assertTrue("Problem in deleting supply",supplierDao.deleteSupplier(supply));
	}
	@Ignore
	@Test
	public void updateSuplyTest()
	{
		Supplier s1=supplierDao.getSupplierById(2 );
		s1.setSupplierAddress("dresses");
		
		assertTrue("Problem in updating supply",supplierDao.updateSupplier(s1));
	}
}
 
	
	