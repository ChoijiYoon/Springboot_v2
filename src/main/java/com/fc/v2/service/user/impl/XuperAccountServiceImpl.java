package com.fc.v2.service.user.impl;

import com.fc.v2.mapper.custom.XuperAccountDao;
import com.fc.v2.mapper.message.UserMessageHistoryMapper;
import com.fc.v2.model.message.UserMessageHistory;
import com.fc.v2.model.xuper.XuperAccount;
import com.fc.v2.service.message.UserMessageHistoryService;
import com.fc.v2.service.user.XuperAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XuperAccountServiceImpl implements XuperAccountService {
	@Autowired
	private XuperAccountDao xuperAccountDao;


	@Override
	public XuperAccount getByUserId(Long userId) {
		return xuperAccountDao.getByUserId(userId);
	}

	@Override
	public Long save(XuperAccount xuperAccount) {
		return xuperAccountDao.insert(xuperAccount);
	}
}
