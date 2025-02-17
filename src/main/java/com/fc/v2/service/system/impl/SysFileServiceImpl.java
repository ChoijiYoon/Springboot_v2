package com.fc.v2.service.system.impl;

import java.util.Date;
import java.util.List;

import com.fc.v2.service.system.SysFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fc.v2.common.support.ConvertUtil;
import com.fc.v2.mapper.auto.SysFileMapper;
import com.fc.v2.model.auto.SysFile;
import com.fc.v2.model.auto.SysFileExample;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.satoken.SaTokenUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SysFileServiceImpl implements SysFileService {
    @Autowired
    private SysFileMapper sysFileMapper;


    /**
     * 分页查询
     *
     * @param tablepar
     * @param name
     * @return
     */
    @Override
    public PageInfo<SysFile> list(Tablepar tablepar, String name) {
        SysFileExample testExample = new SysFileExample();
        testExample.setOrderByClause("id ASC");
        if (name != null && !"".equals(name)) {
            testExample.createCriteria().andFileNameEqualTo("%" + name + "%");
        }
        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
        List<SysFile> list = sysFileMapper.selectByExample(testExample);
        PageInfo<SysFile> pageInfo = new PageInfo<SysFile>(list);
        return pageInfo;
    }


    /**
     * 检查文件名字
     *
     * @param tsysFile
     * @return
     */
    @Override
    public int checkNameUnique(SysFile tsysFile) {
        SysFileExample example = new SysFileExample();
        example.createCriteria().andFileNameEqualTo(tsysFile.getFileName());
        List<SysFile> list = sysFileMapper.selectByExample(example);
        return list.size();
    }



    /**
     * 删除文件信息全部
     *
     * @param ids 文件集合 1,2,3
     */
    @Transactional
    @Override
    public int deleteByPrimaryKey(String ids) {
        List<String> lista = ConvertUtil.toListStrArray(ids);
        SysFileExample example = new SysFileExample();
        example.createCriteria().andIdIn(lista);
        return sysFileMapper.deleteByExample(example);
    }

    @Override
    public int insertSelective(SysFile record) {
        return sysFileMapper.insertSelective(record);
    }

    @Override
    public SysFile selectByPrimaryKey(String id) {
        return sysFileMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysFile record) {
        return sysFileMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByExampleSelective(SysFile record, SysFileExample example) {
        return sysFileMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(SysFile record, SysFileExample example) {
        return sysFileMapper.updateByExample(record, example);
    }

    @Override
    public List<SysFile> selectByExample(SysFileExample example) {
        return sysFileMapper.selectByExample(example);
    }

    @Override
    public SysFile selectByExamplefileName(String filename) {
        SysFileExample example = new SysFileExample();
        example.createCriteria().andFileNameEqualTo(filename);
        List<SysFile> sysFiles = sysFileMapper.selectByExample(example);
        if (sysFiles != null && sysFiles.size() > 0) {
            return sysFiles.get(0);
        }
        return null;
    }

    @Override
    public long countByExample(SysFileExample example) {
        return sysFileMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SysFileExample example) {
        return sysFileMapper.deleteByExample(example);
    }

    /**
     * 修改信息
     *
     * @param record
     * @return
     */
    @Transactional
    @Override
    public int updateByPrimaryKey(SysFile record) {
        //获取旧数据
        SysFile old_data = sysFileMapper.selectByPrimaryKey(record.getId());
        //插入修改人id
        record.setUpdateUserId(SaTokenUtil.getUserId());
        //插入修改人name
        record.setUpdateUserName(SaTokenUtil.getLoginName());
        //插入修改时间
        record.setUpdateTime(new Date());
        return sysFileMapper.updateByPrimaryKey(old_data);
    }
}
