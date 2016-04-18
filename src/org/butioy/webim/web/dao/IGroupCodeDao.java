package org.butioy.webim.web.dao;

import org.butioy.webim.web.domain.GroupCode;
import org.springframework.stereotype.Repository;
import org.butioy.framework.base.BaseDao;

import java.util.Map;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-02-13 12:06
 * Since 2015 - 2016
 */
@Repository
public interface IGroupCodeDao extends BaseDao<GroupCode, Integer> {
	
	public Integer insert(GroupCode groupCode);

	public void update(GroupCode groupCode);

	public void deleteById(Integer id);

	public void deleteByIds(String ids);

	public void deleteByParam(Map params);

	public GroupCode findById(Integer id);

	public List<GroupCode> findList(Map params);

}
