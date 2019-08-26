package com.niit.frstbackendproject;

import static org.junit.Assert.*;
import org.junit.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;

import com.niit.dao.CategoryDao;
import com.niit.model.Category;
public class CategoryUnitTest {
@Autowired
	static CategoryDao categoryDao;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	    
	    context.scan("com.niit");
	    context.refresh();
	    
	    categoryDao=(CategoryDao) context.getBean("categoryDao");
	}
	@Ignore
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryName("women Dresses");
		category.setCategoryDesc("ethnic wear");
		
		assertTrue("Problem in adding the category",categoryDao.addCategory(category));
	}
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDao.getCategory(1);
		
		assertTrue("Problem in deleting category",categoryDao.deleteCategory(category));
	}
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDao.getCategory(2 );
		category.setCategoryDesc("Western Wear");
		
		assertTrue("Problem in updating category",categoryDao.updateCategory(category));
	}
}
