package com.fc.v2.service.system;

import com.fc.v2.model.auto.SysQuartzJob;
import com.fc.v2.model.auto.SysQuartzJobExample;
import com.fc.v2.model.auto.TSysDictType;
import com.fc.v2.model.auto.TSysDictTypeExample;
import com.fc.v2.model.custom.Tablepar;
import com.github.pagehelper.PageInfo;
import org.quartz.SchedulerException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 部门：
 *
 * @author cgy
 * @version 1.0
 * @date 2023/5/18 18:05
 */
public interface SysQuartzJobService {

    /**
     * 分页查询
     *
     * @param tablepar
     * @param name
     * @return
     */
    PageInfo<SysQuartzJob> list(Tablepar tablepar, String name);

    int deleteByPrimaryKey(String ids);

    SysQuartzJob selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysQuartzJob record);

    int insertSelective(SysQuartzJob record);

    int updateByExampleSelective(SysQuartzJob record, SysQuartzJobExample example);

    int updateByExample(SysQuartzJob record, SysQuartzJobExample example);

    List<SysQuartzJob> selectByExample(SysQuartzJobExample example);

    long countByExample(SysQuartzJobExample example);

    int deleteByExample(SysQuartzJobExample example);

    /**
     * 检查name
     *
     * @param sysDepartment
     * @return
     */
    int checkNameUnique(SysQuartzJob sysDepartment);

    /**
     * 恢复任务
     *
     * @param job 调度信息
     */
    int resumeJob(SysQuartzJob job) throws SchedulerException;

    /**
     * 暂停任务
     *
     * @param job 调度信息
     */
    public int pauseJob(SysQuartzJob job) throws SchedulerException;

    /**
     * 任务调度状态修改
     *
     * @param job 调度信息
     */
    int changeStatus(SysQuartzJob job) throws SchedulerException;

    /**
     * 立即运行任务
     *
     * @param job 调度信息
     */
    void run(SysQuartzJob job) throws SchedulerException;
}
