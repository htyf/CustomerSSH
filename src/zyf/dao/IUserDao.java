package zyf.dao;

import java.sql.Connection;
import java.util.List;

import zyf.entity.User;

public interface IUserDao {
	
	/**
	 * 添加数据到数据库
	 * @param user
	 * @return
	 * @throws Exception
	 */
	int save(Connection conn,User user) throws Exception;
	
	/**
	 * 更新数据库中数据
	 * @param user
	 * @return
	 * @throws Exception
	 */
	int update(Connection conn,User user) throws Exception;
	
	/**
	 * 删除数据库中数据
	 * @param user
	 * @return
	 * @throws Exception
	 */
	int delete(Connection conn,User user) throws Exception;
	
	/**
	 * 根据id查询数据库中的记录
	 * @param user
	 * @return
	 * @throws Exception
	 */
	User queryById(User user) throws Exception;
	
	/**
	 * 根据id查询数据库中的记录
	 * @param user
	 * @return
	 * @throws Exception
	 */
	User queryByName(User user) throws Exception;
	
	/**
	 * 查询数据库中所有的记录
	 * @return
	 * @throws Exception
	 */
	List<User> query() throws Exception;
	
	

}
