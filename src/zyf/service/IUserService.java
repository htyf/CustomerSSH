package zyf.service;

import zyf.entity.User;

public interface IUserService {
	
	/**
	 * 用户登录
	 * @param user
	 * @return
	 * @throws Exception
	 */
	User login(User user) throws Exception;

}
