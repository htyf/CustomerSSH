package zyf.service;

import java.util.List;

import zyf.entity.LinkMan;

public interface ILinkManService {
	LinkMan addLinkMan(LinkMan linkman) throws Exception;
	int updateLinkMan(LinkMan linkman) throws Exception;
	int deleteLinkMan(LinkMan linkman) throws Exception;
	List<LinkMan> queryLinkMan() throws Exception;
	List<LinkMan> queryLinkManByName(String linkname) throws Exception;
	LinkMan queryLinkManById(String linkId) throws Exception;
}
