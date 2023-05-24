package com.fc.v2.service.message.impl;

import com.fc.v2.mapper.message.UserMessageHistoryMapper;
import com.fc.v2.mapper.message.UserMessageTrainRecordMapper;
import com.fc.v2.model.message.UserMessageHistory;
import com.fc.v2.model.message.UserMessageTrainRecord;
import com.fc.v2.service.message.UserMessageHistoryService;
import com.fc.v2.service.message.UserMessageTrainRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author saber
 */
@Service
public class UserMessageTrainRecordServiceImpl implements UserMessageTrainRecordService {
	@Autowired
	private UserMessageTrainRecordMapper userMessageTrainRecordMapper;


	@Override
	public UserMessageTrainRecord getByUserId(Long userId) {
		return userMessageTrainRecordMapper.getByUserId(userId);
	}

	@Override
	public Long save(UserMessageTrainRecord userMessageTrainRecord) {
		return userMessageTrainRecordMapper.insert(userMessageTrainRecord);
	}
}
