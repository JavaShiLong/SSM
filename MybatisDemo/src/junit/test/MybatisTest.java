package junit.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.shilong.beans.Person;
import com.shilong.dao.PersonMapper;

public class MybatisTest {
	
	private InputStream inputStream;
	private SqlSessionFactory sqlSessionFactory;
	// sqlSession这个属性不是线程安全的货，建议不要弄为局部变量
	private SqlSession sqlSession;
	private PersonMapper mapper;
	
	
	@Before
	public void init() throws IOException{
			//1. 读取配置文件
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			//2. 根据配置文件创建一个工厂
		    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		    //3.通过工厂创建对应连接
		    sqlSession = sqlSessionFactory.openSession();
		    //4. 根据该配置文件获取对数据库的操作资格
		    mapper = sqlSession.getMapper(PersonMapper.class);
	}
	
	@After
	public void after(){
		   //5. 提交本次操作
		    sqlSession.commit();
		    if(sqlSession != null)
		    //6. 关闭连接
		    sqlSession.close();
	}
	
	@Test
	public void getAll(){
		List<Person> persons = mapper.getAllPerson();
		for (Person person : persons) {
			System.out.println(person);
		}
	}
	
	@Test
	public void selectById(){
		Person person = mapper.getPersonById(1);
		System.out.println(person);
	}
	
	@Test
	public void update(){
		 Person person = new Person();
		    person.setAge(77);
		    person.setBirth(new Date());
		    person.setId(1);
		    person.setName("li5");
		    person.setRegisterTime(new Date());
		    person.setSalary(9500.55);

		    mapper.update(person);
	}
	
	@Test
	public void delete(){
		mapper.delete(2);
	}

	@Test
	public void insert(){
		   
		    Person person = new Person();
		    person.setAge(22);
		    person.setBirth(new Date());
		    person.setName("z10");
		    person.setRegisterTime(new Date());
		    person.setSalary(4500.55);
		    
		    mapper.add(person);
	}

}
