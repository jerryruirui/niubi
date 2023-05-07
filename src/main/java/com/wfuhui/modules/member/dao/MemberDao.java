package com.wfuhui.modules.member.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wfuhui.modules.member.entity.MemberEntity;
import com.wfuhui.modules.sys.dao.BaseDao;


/**
 * 会员
 * 
 * @author lzl
 * @email 2803180149@qq.com
 */
@Mapper
public interface MemberDao extends BaseDao<MemberEntity> {

	MemberEntity queryByLoginName(String loginName);

	void updatePwd(@Param("id")Long id, @Param("password")String password);
}
