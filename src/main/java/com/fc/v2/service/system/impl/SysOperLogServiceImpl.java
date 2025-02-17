package com.fc.v2.service.system.impl;

import com.fc.v2.common.support.ConvertUtil;
import com.fc.v2.mapper.auto.TsysOperLogMapper;
import com.fc.v2.model.auto.TsysOperLog;
import com.fc.v2.model.auto.TsysOperLogExample;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.service.system.SysOperLogService;
import com.fc.v2.util.SnowflakeIdWorker;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysOperLogServiceImpl implements SysOperLogService {

    @Autowired
    private TsysOperLogMapper tsysOperLogMapper;

    /**
     * 分页查询
     *
     * @return PageInfo<TsysOperLog>
     */
	@Override
    public PageInfo<TsysOperLog> list(Tablepar tablepar, String searchText) {
        TsysOperLogExample testExample = new TsysOperLogExample();
        testExample.setOrderByClause("id+0 DESC");
        if (searchText != null && !"".equals(searchText)) {
            testExample.createCriteria().andTitleLike("%" + searchText + "%");
        }

        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
        List<TsysOperLog> list = tsysOperLogMapper.selectByExample(testExample);
        return new PageInfo<>(list);
    }


    /**
     * 获取最新10条日志
     *
     * @return List<TsysOperLog>
     */
    @Override
    public List<TsysOperLog> getNEW() {
        TsysOperLogExample testExample = new TsysOperLogExample();
        testExample.setOrderByClause("id DESC");
        PageHelper.startPage(1, 10);
        return tsysOperLogMapper.selectByExample(testExample);
    }


    @Override
    public int deleteByPrimaryKey(String ids) {
        List<String> lista = ConvertUtil.toListStrArray(ids);
        TsysOperLogExample example = new TsysOperLogExample();
        example.createCriteria().andIdIn(lista);
        return tsysOperLogMapper.deleteByExample(example);
    }


    @Override
    public TsysOperLog selectByPrimaryKey(String id) {

        return tsysOperLogMapper.selectByPrimaryKey(id);
    }


    @Override
    public int updateByPrimaryKeySelective(TsysOperLog record) {
        return tsysOperLogMapper.updateByPrimaryKeySelective(record);
    }


    @Override
    public int updateByExampleSelective(TsysOperLog record, TsysOperLogExample example) {

        return tsysOperLogMapper.updateByExampleSelective(record, example);
    }


    @Override
    public int updateByExample(TsysOperLog record, TsysOperLogExample example) {

        return tsysOperLogMapper.updateByExample(record, example);
    }

    @Override
    public List<TsysOperLog> selectByExample(TsysOperLogExample example) {

        return tsysOperLogMapper.selectByExample(example);
    }


    @Override
    public long countByExample(TsysOperLogExample example) {

        return tsysOperLogMapper.countByExample(example);
    }


    @Override
    public int deleteByExample(TsysOperLogExample example) {

        return tsysOperLogMapper.deleteByExample(example);
    }


    @Override
    public int insertSelective(TsysOperLog record) {
        record.setId(SnowflakeIdWorker.getUUID());
        return tsysOperLogMapper.insertSelective(record);
    }


}
