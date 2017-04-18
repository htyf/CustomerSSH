package zyf.service.impl;

import org.springframework.transaction.annotation.Transactional;

import zyf.dao.IUserDao;
import zyf.dao.impl.Hb_UserDaoImpl;
import zyf.entity.User;
import zyf.service.IUserService;

@Transactional
public class UserServiceImpl implements IUserService{
	IUserDao iud = new Hb_UserDaoImpl();

	@Override
	public User login(User user) throws Exception {
		if(user==null){
			return null;
		}
		User u = iud.queryByName(user);
		if(u==null){
			return null;
		}else{
			return u;
		}
	}

}
