package com.qstudy.qstudy.mapper.login;

import org.apache.ibatis.annotations.Mapper;

import com.qstudy.qstudy.dto.login.User;

@Mapper
public interface GoogleLoginMapper {
	void saveGoogle(User user);
}
 