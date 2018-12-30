package junit.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.shilong.beans.Student;
import com.shilong.dao.StudentMapper;

public class StuTest {
	
	private InputStream inputStream;
	private SqlSessionFactory sqlSessionFactory;
	// sqlSession这个属性不是线程安全的货，建议不要弄为局部变量
	private SqlSession sqlSession;
	private StudentMapper mapper;
	
	
	@Before
	public void init() throws IOException{
			//1. 读取配置文件
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			//2. 根据配置文件创建一个工厂
		    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		    //3.通过工厂创建对应连接
		    sqlSession = sqlSessionFactory.openSession();
		    //4. 根据该配置文件获取对数据库的操作资格
		    mapper = sqlSession.getMapper(StudentMapper.class);
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
	public void updateTest(){
		mapper.updateStu(new Student(1, "li", 80.0, null, 23));
	}

	@Test
	public void getByAge() {
		
		List<Student> list = mapper.getStuByAge(new Student(null, "li", 80.0, null, 23));
		for (Student student : list) {
			System.out.println(student);
		}
	}

}
