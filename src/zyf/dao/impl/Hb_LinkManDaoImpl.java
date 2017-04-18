package zyf.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import zyf.dao.ILinkManDao;
import zyf.entity.LinkMan;
import zyf.utils.Hb_Connection;

public class Hb_LinkManDaoImpl extends HibernateDaoSupport  implements ILinkManDao{

	@Override
	public String save(Session session, LinkMan linkman) throws Exception {
		// TODO Auto-generated method stub
		return (String) session.save(linkman);
	}

	@Override
	public void update(Session session, LinkMan linkman) throws Exception {
		// TODO Auto-generated method stub
		session.update(linkman);
	}

	@Override
	public void delete(Session session, LinkMan linkman) throws Exception {
		session.delete(linkman);
	}

	@Test
	@Override
	public List<LinkMan> query(Session session) throws Exception {
		Query query = session.createQuery("from LinkMan");
		return query.list();
	}

	@Override
	public LinkMan queryById(Session session, LinkMan linkman) throws Exception {
		Query query = session.createQuery("from LinkMan where lkmId=:linkid");
		query.setString("linkid", linkman.getLkmId());
		List<LinkMan> list = query.list();
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<LinkMan> queryByName(Session session, LinkMan linkman) throws Exception {
		Query query = session.createQuery("from LinkMan where lkmName like:linkname");
		query.setString("linkname", "%"+linkman.getLkmName()+"%");
		return query.list();
	}

	@Override
	public LinkMan queryById(Session session, String linkId) throws Exception {
		Query query = session.createQuery("from LinkMan where lkmId=:linkid");
		query.setString("linkid", linkId);
		List<LinkMan> list = query.list();
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<LinkMan> queryByName(Session session, String linkName) throws Exception {
		Query query = session.createQuery("from LinkMan where lkmName like:linkname");
		query.setString("linkname", "%"+linkName+"%");
		return query.list();
	}

	@Override
	public LinkMan queryByCustId(Session session, LinkMan linkman) throws Exception {
		Criteria criteria = session.createCriteria(LinkMan.class);
//		criteria.add(Restrictions.eq("custId", linkman.getCustId()));
		List<LinkMan> list = criteria.list();
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	@Override
	public LinkMan queryByCustId(Session session, String linkName) throws Exception {
		Criteria criteria = session.createCriteria(LinkMan.class);
		criteria.add(Restrictions.eq("custId", linkName));
		List<LinkMan> list = criteria.list();
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public static void main(String[] args) throws Exception {
		Hb_LinkManDaoImpl impl = new Hb_LinkManDaoImpl();
		Session session = Hb_Connection.getConnection();
		session.beginTransaction();
		List<LinkMan> query = impl.query(session);
		System.out.println(query);
	}
	
}
