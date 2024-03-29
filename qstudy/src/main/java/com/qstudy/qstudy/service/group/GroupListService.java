package com.qstudy.qstudy.service.group;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qstudy.qstudy.dto.calendar.Calendar;
import com.qstudy.qstudy.dto.group.GroupAttendList;
import com.qstudy.qstudy.dto.group.GroupList;
import com.qstudy.qstudy.dto.group.GroupMember;
import com.qstudy.qstudy.dto.login.User;
import com.qstudy.qstudy.mapper.group.GroupListMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GroupListService {
	@Autowired
	private GroupListMapper groupListMapper;

	public GroupListService(GroupListMapper groupListMapper) {
		this.groupListMapper = groupListMapper;
	}
	
	public List<GroupList> getAllGroupList(String id) {
		return groupListMapper.getAllGroupList(id);
	}
	
	public List<GroupAttendList> getAttendGroupList(String id) {
		return groupListMapper.getAttendGroupList(id);
	}
	public void insertAttendGroup(HashMap<String, Object> requestBody) {
		GroupAttendList ga = new GroupAttendList();
		String group_id = (String)requestBody.get("group_id");
		String user_id = (String)requestBody.get("user_id");
		String color = (String)requestBody.get("color");
		
		ga.setGroup_id(group_id);
		ga.setUser_id(user_id);
		ga.setColor(color);
		groupListMapper.insertAttendGroup(ga);
	}
	public List<GroupList> getMyGroupList(String id){
		return groupListMapper.getMyGroupList(id);
	}
	
	public void insertNewGroup(HashMap<String, Object> requestBody) {
		GroupList gl = new GroupList();
		String group_id = (String)requestBody.get("group_id");
		String writer = (String)requestBody.get("writer");
		String title = (String)requestBody.get("title");
		String memo = (String)requestBody.get("memo");
		String color = (String)requestBody.get("color");
		
		gl.setGroup_id(group_id);
		gl.setWriter(writer);
		gl.setTitle(title);
		gl.setMemo(memo);
		gl.setColor(color);
		groupListMapper.insertNewGroup(gl);
		groupListMapper.insertNewGroupAttend(gl);
	}
	
	public List<GroupMember> getGroupMember(String id){
		return groupListMapper.getGroupMember(id);
	}
	
	// 스터디원 삭제
	public void deleteGroupMember(HashMap<String, Object> requestBody) {
		GroupAttendList ga = new GroupAttendList();
		String group_id = (String)requestBody.get("group_id");
		String user_id = String.valueOf(requestBody.get("user_id"));
		
		ga.setGroup_id(group_id);
		ga.setUser_id(user_id);
		groupListMapper.deleteGroupMember(ga);
		
	}
	
	// 스터디원 삭제시, 일정도 삭제
	public void deleteEvent(HashMap<String, Object> requestBody) {
		Calendar ca = new Calendar();
		String group_id = (String)requestBody.get("group_id");
		String user_id = String.valueOf(requestBody.get("user_id"));
		
		ca.setGroup_id(group_id);
		ca.setUser_id(user_id);
		groupListMapper.deleteEvent(ca);
		
	}
	
	// 스터디 삭제
	public void deleteGroup(HashMap<String, Object> requestBody) {
		GroupList gl = new GroupList();
		String group_id = (String)requestBody.get("group_id");
		gl.setGroup_id(group_id);
		
		groupListMapper.deleteGroup(gl);
		
	}
	public void deleteGroupAttend(HashMap<String, Object> requestBody) {
		GroupAttendList ga = new GroupAttendList();
		String group_id = (String)requestBody.get("group_id");
		ga.setGroup_id(group_id);
		
		groupListMapper.deleteGroupAttend(ga);
	}
	public void deleteCalendar(HashMap<String, Object> requestBody) {
		Calendar ca = new Calendar();
		String group_id = (String)requestBody.get("group_id");
		ca.setGroup_id(group_id);
		
		groupListMapper.deleteCalendar(ca);
	}

}
