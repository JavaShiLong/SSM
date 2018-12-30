package junit.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.shilong.beans.Lock;
import com.shilong.dao.LockMapper;

public class AssociationTest {
	private InputStream inputStream;
	private SqlSessionFactory sqlSessionFactory;
	// sqlSession这个属性不是线程安全的货，建议不要弄为局部变量
	private SqlSession sqlSession;
	private LockMapper mapper;
	
	
	@Before
	public void init() throws IOException{
			//1. 读取配置文件
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			//2. 根据配置文件创建一个工厂
		    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		    //3.通过工厂创建对应连接
		    sqlSession = sqlSessionFactory.openSession();
		    //4. 根据该配置文件获取对数据库的操作资格
		    mapper = sqlSession.getMapper(LockMapper.class);
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
	public void selectById(){
		Lock lock = mapper.getLockById(2);
		System.out.println(lock.getLockName());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(lock);
	}

}
