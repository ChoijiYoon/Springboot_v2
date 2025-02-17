package com.fc.v2.service.system.impl;

import java.util.Date;
import java.util.List;

import com.fc.v2.service.system.SysDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.v2.common.support.ConvertUtil;
import com.fc.v2.mapper.auto.TSysDictDataMapper;
import com.fc.v2.mapper.auto.TSysDictTypeMapper;
import com.fc.v2.model.auto.TSysDictData;
import com.fc.v2.model.auto.TSysDictDataExample;
import com.fc.v2.model.auto.TSysDictType;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.satoken.SaTokenUtil;
import com.fc.v2.util.SnowflakeIdWorker;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 字典数据表Service
 *
 * @author 一休
 * @Title: TSysDictDataService.java
 * @Package com.fc.v2.service
 * @email 438081243@qq.com
 * @date 2019-09-08 00:10:43
 */
@Service
public class SysDictDataServiceImpl implements SysDictDataService {
    @Autowired
    private TSysDictDataMapper tSysDictDataMapper;
    @Autowired
    private TSysDictTypeMapper tSysDictTypeMapper;

    /**
     * 分页查询
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<TSysDictData> list(Tablepar tablepar, String name, String dictId) {
        TSysDictDataExample testExample = new TSysDictDataExample();
        testExample.setOrderByClause("dict_sort ASC");
        if (dictId != null && !"".equals(dictId)) {
            TSysDictType dictType = tSysDictTypeMapper.selectByPrimaryKey(dictId);
            if (dictType != null) {
                testExample.createCriteria().andDictTypeEqualTo(dictType.getDictType());
            }
        }
        if (name != null && !"".equals(name)) {
            testExample.createCriteria().andDictValueLike("%" + name + "%");
        }

        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
        List<TSysDictData> list = tSysDictDataMapper.selectByExample(testExample);
        PageInfo<TSysDictData> pageInfo = new PageInfo<TSysDictData>(list);
        return pageInfo;
    }


    @Override
    public int deleteByPrimaryKey(String ids) {
        List<String> lista = ConvertUtil.toListStrArray(ids);
        TSysDictDataExample example = new TSysDictDataExample();
        example.createCriteria().andIdIn(lista);
        return tSysDictDataMapper.deleteByExample(example);
    }

    /**
     * 添加
     */
    @Override
    public int insertSelective(TSysDictData record) {
        //添加雪花主键id
        record.setId(SnowflakeIdWorker.getUUID());
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        record.setCreateBy(SaTokenUtil.getUser().getUsername());
        return tSysDictDataMapper.insertSelective(record);
    }

    @Override
    public TSysDictData selectByPrimaryKey(String id) {
        return tSysDictDataMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TSysDictData record) {
        record.setUpdateTime(new Date());
        record.setUpdateBy(SaTokenUtil.getUser().getUsername());
        return tSysDictDataMapper.updateByPrimaryKeySelective(record);
    }


    @Override
    public int updateByExampleSelective(TSysDictData record, TSysDictDataExample example) {

        return tSysDictDataMapper.updateByExampleSelective(record, example);
    }


    @Override
    public int updateByExample(TSysDictData record, TSysDictDataExample example) {

        return tSysDictDataMapper.updateByExample(record, example);
    }

    @Override
    public List<TSysDictData> selectByExample(TSysDictDataExample example) {

        return tSysDictDataMapper.selectByExample(example);
    }


    @Override
    public long countByExample(TSysDictDataExample example) {

        return tSysDictDataMapper.countByExample(example);
    }


    @Override
    public int deleteByExample(TSysDictDataExample example) {

        return tSysDictDataMapper.deleteByExample(example);
    }

    /**
     * 检查name
     *
     * @param tSysDictData
     * @return
     */
    @Override
    public int checkNameUnique(TSysDictData tSysDictData) {
        TSysDictDataExample example = new TSysDictDataExample();
        example.createCriteria().andDictValueEqualTo(tSysDictData.getDictValue());
        List<TSysDictData> list = tSysDictDataMapper.selectByExample(example);
        return list.size();
    }

    /**
     * 批量删除
     *
     * @param dictIds
     * @author fuce
     * @Date 2019年9月9日 上午12:40:52
     */
    @Override
    public void deleteByPrimaryDictIds(List<String> dictIds) {
        TSysDictDataExample example = new TSysDictDataExample();
        example.createCriteria().andIdIn(dictIds);
        tSysDictDataMapper.deleteByExample(example);
    }
}
