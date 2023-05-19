package com.fc.v2.service.message.impl;

import com.fc.v2.mapper.message.UserMessageHistoryMapper;
import com.fc.v2.model.message.UserMessageHistory;
import com.fc.v2.service.message.UserMessageHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserMessageHistoryServiceImpl implements UserMessageHistoryService {
	@Autowired
	private UserMessageHistoryMapper userMessageHistoryMapper;


	@Override
	public List<UserMessageHistory> getByUserId(Long userId) {
		return userMessageHistoryMapper.getByUserId(userId);
	}

	@Override
	public Long save(UserMessageHistory userMessageHistory) {
		return userMessageHistoryMapper.insert(userMessageHistory);
	}
}
