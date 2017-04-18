package zyf.dao;

import java.util.List;

import org.hibernate.Session;

import zyf.entity.LinkMan;

public interface ILinkManDao {
	String save(Session session,LinkMan linkman) throws Exception;
	void update(Session session,LinkMan linkman) throws Exception;
	void delete(Session session,LinkMan linkman) throws Exception;
	List<LinkMan> query(Session session) throws Exception;
	LinkMan queryById(Session session,LinkMan linkman) throws Exception;
	List<LinkMan> queryByName(Session session,LinkMan linkman) throws Exception;
	LinkMan queryById(Session session,String linkId) throws Exception;
	List<LinkMan> queryByName(Session session,String linkName) throws Exception;
	LinkMan queryByCustId(Session session,LinkMan linkman) throws Exception;
	LinkMan queryByCustId(Session session,String linkName) throws Exception;
	
	

}
