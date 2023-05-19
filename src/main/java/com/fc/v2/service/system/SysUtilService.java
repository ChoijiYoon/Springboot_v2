package com.fc.v2.service.system;

import com.fc.v2.model.auto.TSysDictType;
import com.fc.v2.model.auto.TSysDictTypeExample;
import com.fc.v2.model.custom.Tablepar;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * 部门：
 *
 * @author cgy
 * @version 1.0
 * @date 2023/5/18 18:05
 */
public interface SysUtilService {

    /**
     * 执行sql
     * @param sql
     * @return
     * @author fuce
     * @Date 2019年8月31日 下午6:15:08
     */
    int executeSQL(String sql);

    /**
     * 查询sql
     * @param sql
     * @return list<map>
     * @author fuce
     * @Date 2020年4月10日 下午4:55:49
     */
    List<Map<Object,Object>> SelectExecuteSQL(String sql);
}
