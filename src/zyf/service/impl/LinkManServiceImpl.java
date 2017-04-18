package zyf.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import zyf.dao.ILinkManDao;
import zyf.dao.impl.Hb_LinkManDaoImpl;
import zyf.entity.LinkMan;
import zyf.service.ILinkManService;
import zyf.utils.Hb_Connection;

@Transactional
public class LinkManServiceImpl implements ILinkManService {
	ILinkManDao ilm = new Hb_LinkManDaoImpl();
	Session session = Hb_Connection.getConnection();

	@Override
	public LinkMan addLinkMan(LinkMan linkman) throws Exception {
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			String save = ilm.save(session, linkman);
			System.out.println(save);
			LinkMan lman = ilm.queryById(session, save);
			transaction.commit();
			return lman;
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int updateLinkMan(LinkMan linkman) throws Exception {
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			ilm.update(session, linkman);
			transaction.commit();
			return 1;
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int deleteLinkMan(LinkMan linkman) throws Exception {
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			ilm.delete(session, linkman);
			transaction.commit();
			return 1;
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<LinkMan> queryLinkMan() throws Exception {
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			List<LinkMan> list = ilm.query(session);
			transaction.commit();
			return list;
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public LinkMan queryLinkManById(String linkId) throws Exception {
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			LinkMan man = ilm.queryById(session, linkId);
			transaction.commit();
			return man;
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<LinkMan> queryLinkManByName(String linkname) throws Exception {
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			List<LinkMan> linkmans = ilm.queryByName(session, linkname);
			transaction.commit();
			return linkmans;
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
			return null;
		}
	}}
