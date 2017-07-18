package lab.hibernate;

import java.util.Date;
import java.util.List;

import lab.entity.Course;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class Test {

	public static void main(String[] args) {
		//demo1();//Query HQL no parameter
		//demo2();//Query has Parameter -> mix, max
		//demo3();//Query Paging
		//demo4();//Query Characteristic: using SQLQuery, addEntity class
		//demo5();//Query attributes of entity class
		//demo6();//Query unique result
		//demo7();//Query a entity using load, get, refresh
		//demo8();//Query entity Transaction: insert
		//demo9();//Query entity Transaction: update
		demo10();//Query entity Transaction: delete
	}
	
	/**
	 * Query entity Transaction: delete
	 * */
	private static void demo10() {
		/*Load configuration file*/
		Configuration config = new AnnotationConfiguration().configure("hibernate.cfg.xml");
		
		/*Load session factory file*/
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		
		Course entity = (Course) session.get(Course.class, "ANG");
		
		Transaction t = session.beginTransaction();
		try{
			session.delete(entity);//delete database
			t.commit();
			System.out.println("Delete db using Transaction successfully!");
		}
		catch(Exception e){
			t.rollback();
			System.out.println("Delete db using Transaction failed!");
		}
	}

	/**
	 * Query entity Transaction: update
	 * */
	private static void demo9() {
		/*Load configuration file*/
		Configuration config = new AnnotationConfiguration().configure("hibernate.cfg.xml");
		
		/*Load session factory file*/
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		
		Course entity = (Course) session.get(Course.class, "ANG");
		entity.setSchoolfee(1500000.0);
		entity.setLearnCount(25);
		
		Transaction t = session.beginTransaction();
		try{
			session.update(entity);//update database
			t.commit();
			System.out.println("Update db using Transaction successfully!");
		}
		catch(Exception e){
			t.rollback();
			System.out.println("Update db using Transaction failed!");
		}
	}

	/**
	 * Query entity Transaction: insert
	 * */
	private static void demo8() {
		/*Load configuration file*/
		Configuration config = new AnnotationConfiguration().configure("hibernate.cfg.xml");
		
		/*Load session factory file*/
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		
		Course entity = new Course();
		entity.setId("ANG");
		entity.setName("AngularJS");
		entity.setLearnCount(20);
		entity.setSchoolfee(2000000.0);
		entity.setStartDate(new Date());
		entity.setStatus(false);
		
		Transaction t = session.beginTransaction();
		try{
			session.save(entity);//insert into database
			t.commit();
			System.out.println("Insert db using Transaction successfully!");
		}
		catch(Exception e){
			t.rollback();
			System.out.println("Insert db using Transaction failed!");
		}
	}

	/**
	 * Query a entity using load, get, refresh
	 * */
	private static void demo7() {
		/*Load configuration file*/
		Configuration config = new AnnotationConfiguration().configure("hibernate.cfg.xml");
		
		/*Load session factory file*/
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		
//		Course entity = (Course) session.get(Course.class, "JAV");
//		System.out.println(entity.getName());//work with hasn't exist entity
		
//		Course entity = (Course) session.load(Course.class, "JAV");
//		System.out.println(entity.getName());//work with hasn't exist entity
		
		Course entity = (Course) session.get(Course.class, "JAV");
		entity.setId("JAV");
		session.refresh(entity);//work with existed entity
		System.out.println(entity.getName());
	}

	/**
	 * Query unique result
	 * */
	private static void demo6() {
		/*Load configuration file*/
		Configuration config = new AnnotationConfiguration().configure("hibernate.cfg.xml");
		
		/*Load session factory file*/
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		
//		String hql = "SELECT COUNT(e) FROM Course e";
//		Query query = session.createQuery(hql);
//		Long count = (Long) query.uniqueResult();
//		System.out.println(">Total Courses is: "+count);
		
//		String hql = "SELECT AVG(e.schoolfee) FROM Course e";
//		Query query = session.createQuery(hql);
//		Double fee = (Double) query.uniqueResult();
//		System.out.println(">Avarage fee of all courses is: "+fee);
		
		String hql = "FROM Course WHERE id='MVC'";
		Query query = session.createQuery(hql);
		Course course = (Course) query.uniqueResult();		
		System.out.println(course.getName());
		
	}

	/**
	 * Query attributes of entity class
	 * */
	private static void demo5() {
		/*Load configuration file*/
		Configuration config = new AnnotationConfiguration().configure("hibernate.cfg.xml");
		
		/*Load session factory file*/
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "SELECT name,schoolfee FROM Course";
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		
		for(Object[] c:list){
			System.out.println(">Name: "+c[0]);
			System.out.println(">Schoolfee: "+c[1]);
			System.out.println();
		}
	}

	/**
	 * Query Characteristic: using SQLQuery, addEntity class
	 * */
	private static void demo4() {
		/*Load configuration file*/
		Configuration config = new AnnotationConfiguration().configure("hibernate.cfg.xml");
		
		/*Load session factory file*/
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		
		String sql = "SELECT * FROM Courses ORDER BY StartDate";
		SQLQuery query = session.createSQLQuery(sql).addEntity(Course.class);
		List<Course> list = query.list();
		
		for(Course c:list){
			System.out.println(">Name: "+c.getName());
			System.out.println(">Schoolfee: "+c.getSchoolfee());
			System.out.println();
		}
	}

	/**
	 * Query Paging
	 * */
	private static void demo3() {
		/*Load configuration file*/
		Configuration config = new AnnotationConfiguration().configure("hibernate.cfg.xml");
		
		/*Load session factory file*/
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM Course";
		Query query = session.createQuery(hql);
		query.setFirstResult(1);//start from record 2
		query.setMaxResults(3);//get 3 record from record 2
		List<Course> list = query.list();
		
		for(Course c:list){
			System.out.println(">Name: "+c.getName());
			System.out.println(">Schoolfee: "+c.getSchoolfee());
			System.out.println();
		}
	}

	/**
	 * Query has Parameter -> mix, max
	 * */
	private static void demo2() {
		/*Load configuration file*/
		Configuration config = new AnnotationConfiguration().configure("hibernate.cfg.xml");
		
		/*Load session factory file*/
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM Course WHERE Schoolfee BETWEEN :min AND :max";
		Query query = session.createQuery(hql);
		query.setDouble("min", 2000000);
		query.setDouble("max", 3000000);
		List<Course> list = query.list();		
		
		for(Course c:list){
			System.out.println(">Name: "+c.getName());
			System.out.println(">Schoolfee: "+c.getSchoolfee());
			System.out.println();
		}
	}

	/**
	 * Query HQL no parameter
	 * */
	private static void demo1() {
		/*Load configuration file*/
		Configuration config = new AnnotationConfiguration().configure("hibernate.cfg.xml");
		
		/*Load session factory file*/
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM Course";
		Query query = session.createQuery(hql);
		List<Course> list = query.list();
		
		for(Course c:list){
			System.out.println(">Name: "+c.getName());
			System.out.println(">Schoolfee: "+c.getSchoolfee());
			System.out.println();
		}
	}

}
