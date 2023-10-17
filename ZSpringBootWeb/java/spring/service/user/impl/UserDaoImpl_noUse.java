package spring.service.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import spring.domain.Search;
import spring.domain.User;
import spring.service.user.UserDao;

/* 
 * FileName : UserDaoImpl14.java  ( Data Access Object ) 
 * �� �����ͺ��̽��� �������� ����� ����ϴ� �۽ý��Ͻ� ������ ����� UserDao �������̽� ���� 
*/ 
//@Repository("userDao")
public class UserDaoImpl_noUse implements UserDao{

	///Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("::"+getClass()+".setSqlSession()  Call.....");
		this.sqlSession = sqlSession;
	}

	///Constructor
	public UserDaoImpl_noUse() {
		System.out.println("::"+getClass()+" default Constructor Call.....");
	}
	
	///Method
	//==> ȸ������ ::  INSERT ( ȸ������ )
	public int addUser(User user) throws Exception{
		return sqlSession.insert("UserMapper10.addUser",user);
	}//end of method
	
	//==> ȸ������ ::  SELECT  ( ȸ�������� �˻� ) 
	public User getUser(String userId) throws Exception {
		 return (User)sqlSession.selectOne("UserMapper10.getUser",userId);
	}//end of method

	//==> ȸ������ ::  UPDATE  ( ȸ������ ����  )
	public int updateUser(User user) throws Exception {
		return sqlSession.update("UserMapper10.updateUser",user);
	}//end of method
	
	//==> ȸ������ ::  DELETE  ( ȸ������ ���� )
	public int removeUser(String userId) throws Exception{
		return sqlSession.delete("UserMapper10.removeUser", userId );
	}
	
	//==> ȸ������ ::  SELECT  ( ��� ȸ�� ���� �˻� )
	public List<User> getUserList(Search search) throws Exception {
		return sqlSession.selectList("UserMapper10.getUserList",search);	
	}//end of Method
	
}//end of class