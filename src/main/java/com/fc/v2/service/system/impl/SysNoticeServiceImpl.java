package com.fc.v2.service.system.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fc.v2.service.system.SysNoticeService;
import com.fc.v2.service.system.SysNoticeUserService;
import com.fc.v2.service.system.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fc.v2.common.support.ConvertUtil;
import com.fc.v2.mapper.auto.SysNoticeMapper;
import com.fc.v2.mapper.auto.SysNoticeUserMapper;
import com.fc.v2.model.auto.SysNotice;
import com.fc.v2.model.auto.SysNoticeExample;
import com.fc.v2.model.auto.SysNoticeUser;
import com.fc.v2.model.auto.SysNoticeUserExample;
import com.fc.v2.model.auto.SysNoticeUserExample.Criteria;
import com.fc.v2.model.auto.TsysUser;
import com.fc.v2.model.auto.TsysUserExample;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.satoken.SaTokenUtil;
import com.fc.v2.util.SnowflakeIdWorker;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 公告 SysNoticeService
 *
 * @author fuce_自动生成
 * @Title: SysNoticeService.javaSysNoticeUserService
 * @Package com.fc.v2.service
 * @email 115889198@qq.com
 * @date 2019-09-08 01:38:44
 **/
@Service
public class SysNoticeServiceImpl implements SysNoticeService {
    @Autowired
    private SysNoticeMapper sysNoticeMapper;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysNoticeUserService sysNoticeUserService;
    @Autowired
    private SysNoticeUserMapper sysNoticeUserMapper;

    /**
     * 分页查询
     *
     * @param tablepar
     * @param name
     * @return
     */
    @Override
    public PageInfo<SysNotice> list(Tablepar tablepar, String name) {
        SysNoticeExample testExample = new SysNoticeExample();
        testExample.setOrderByClause("id ASC");
        if (name != null && !"".equals(name)) {
            testExample.createCriteria().andTitleLike("%" + name + "%");
        }

        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
        List<SysNotice> list = sysNoticeMapper.selectByExample(testExample);
        PageInfo<SysNotice> pageInfo = new PageInfo<SysNotice>(list);
        return pageInfo;
    }


    /**
     * 对应用户的所有公告信息
     *
     * @param tsysUser
     * @param tablepar
     * @param name
     * @return com.github.pagehelper.PageInfo<com.fc.v2.model.auto.SysNotice>
     * @Author cgy
     * @Date 10:01 2023/5/19
     * @Param
     **/
    @Override
    public PageInfo<SysNotice> list(TsysUser tsysUser, Tablepar tablepar, String name) {
        //查询未阅读的公告用户外键
        SysNoticeUserExample sysNoticeUserExample = new SysNoticeUserExample();
        Criteria criteria = sysNoticeUserExample.createCriteria();
        criteria.andUserIdEqualTo(tsysUser.getId());
        List<SysNoticeUser> noticeUsers = sysNoticeUserMapper.selectByExample(sysNoticeUserExample);
        if (noticeUsers != null && noticeUsers.size() > 0) {
            //查询对应的公告列表
            List<String> ids = new ArrayList<String>();
            for (SysNoticeUser sysNoticeUser : noticeUsers) {
                ids.add(sysNoticeUser.getNoticeId());
            }

            //分页查询对应用户的所有公告信息
            SysNoticeExample testExample = new SysNoticeExample();
            testExample.setOrderByClause("id desc");
            com.fc.v2.model.auto.SysNoticeExample.Criteria criteria1 = testExample.createCriteria();
            if (name != null && !"".equals(name)) {
                criteria1.andTitleLike("%" + name + "%");
            }

            criteria1.andIdIn(ids);
            PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
            List<SysNotice> list = sysNoticeMapper.selectByExample(testExample);

            PageInfo<SysNotice> pageInfo = new PageInfo<SysNotice>(list);

            return pageInfo;
        }

        return new PageInfo<SysNotice>();


    }


    @Override
    public int deleteByPrimaryKey(String ids) {
        List<String> lista = ConvertUtil.toListStrArray(ids);
        SysNoticeExample example = new SysNoticeExample();
        example.createCriteria().andIdIn(lista);
        return sysNoticeMapper.deleteByExample(example);
    }


    @Override
    public SysNotice selectByPrimaryKey(String id) {

        return sysNoticeMapper.selectByPrimaryKey(id);
    }


    @Override
    public int updateByPrimaryKeySelective(SysNotice record) {
        return sysNoticeMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 添加
     */
    @Override
    @Transactional
    public int insertSelective(SysNotice record) {
        //添加雪花主键id
        record.setId(SnowflakeIdWorker.getUUID());
        //添加创建人id
        record.setCreateId(SaTokenUtil.getUserId());
        //添加创建人
        record.setCreateUsername(SaTokenUtil.getLoginName());
        //添加创建时间
        record.setCreateTime(new Date());
        sysNoticeMapper.insertSelective(record);
        //给所有人添加公告状态
        List<TsysUser> list = sysUserService.selectByExample(new TsysUserExample());
        for (TsysUser tsysUser : list) {
            SysNoticeUser noticeUser = new SysNoticeUser(null, record.getId(), tsysUser.getId(), 0);
            sysNoticeUserService.insertSelective(noticeUser);
        }
        return 1;
    }


    @Override
    public int updateByExampleSelective(SysNotice record, SysNoticeExample example) {

        return sysNoticeMapper.updateByExampleSelective(record, example);
    }


    @Override
    public int updateByExample(SysNotice record, SysNoticeExample example) {

        return sysNoticeMapper.updateByExample(record, example);
    }

    @Override
    public List<SysNotice> selectByExample(SysNoticeExample example) {

        return sysNoticeMapper.selectByExample(example);
    }


    @Override
    public long countByExample(SysNoticeExample example) {
        return sysNoticeMapper.countByExample(example);
    }


    @Override
    public int deleteByExample(SysNoticeExample example) {

        return sysNoticeMapper.deleteByExample(example);
    }

    /**
     * 检查name
     *
     * @param sysNotice
     * @return
     */
    @Override
    public int checkNameUnique(SysNotice sysNotice) {
        SysNoticeExample example = new SysNoticeExample();
        example.createCriteria().andTitleEqualTo(sysNotice.getTitle());
        List<SysNotice> list = sysNoticeMapper.selectByExample(example);
        return list.size();
    }

    /**
     * 获取用户未阅读公告
     *
     * @param tsysUser
     * @param state    阅读状态  0未阅读 1 阅读  -1全部
     * @return
     * @author fuce
     * @Date 2019年9月8日 上午3:36:21
     */
    @Override
    public List<SysNotice> getuserNoticeNotRead(TsysUser tsysUser, int state) {
        List<SysNotice> notices = new ArrayList<>();
        //查询未阅读的公告用户外键
        SysNoticeUserExample sysNoticeUserExample = new SysNoticeUserExample();
        Criteria criteria = sysNoticeUserExample.createCriteria();
        criteria.andUserIdEqualTo(tsysUser.getId());
        if (-1 != state) {
            criteria.andStateEqualTo(state);
        }
        List<SysNoticeUser> noticeUsers = sysNoticeUserMapper.selectByExample(sysNoticeUserExample);
        if (noticeUsers != null && noticeUsers.size() > 0) {
            //查询对应的公告列表
            List<String> ids = new ArrayList<String>();
            for (SysNoticeUser sysNoticeUser : noticeUsers) {
                ids.add(sysNoticeUser.getNoticeId());
            }
            SysNoticeExample noticeExample = new SysNoticeExample();
            noticeExample.createCriteria().andIdIn(ids);
            notices = sysNoticeMapper.selectByExample(noticeExample);
        }
        return notices;
    }


    /**
     * 根据公告id把当前用户的公告置为以查看
     *
     * @param noticeid
     * @author fuce
     * @Date 2019年9月8日 下午7:14:19
     */
    @Override
    public void editUserState(String noticeid) {
        //SysNoticeUser
        SysNoticeUserExample sysNoticeUserExample = new SysNoticeUserExample();
        sysNoticeUserExample.createCriteria().andNoticeIdEqualTo(noticeid).andUserIdEqualTo(SaTokenUtil.getUserId());
        List<SysNoticeUser> noticeUsers = sysNoticeUserMapper.selectByExample(sysNoticeUserExample);
        for (SysNoticeUser sysNoticeUser : noticeUsers) {
            sysNoticeUser.setState(1);
            sysNoticeUserMapper.updateByPrimaryKey(sysNoticeUser);
        }
    }

    /**
     * 获取最新8条公告
     *
     * @return
     */
    @Override
    public List<SysNotice> getNEW() {
        SysNoticeExample testExample = new SysNoticeExample();
        testExample.setOrderByClause("id DESC");
        PageHelper.startPage(1, 8);
        List<SysNotice> list = sysNoticeMapper.selectByExample(testExample);
        return list;
    }


}
