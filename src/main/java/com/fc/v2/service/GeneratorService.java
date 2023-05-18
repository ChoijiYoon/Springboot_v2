package com.fc.v2.service;

import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.model.custom.TsysTables;
import com.fc.v2.model.custom.autocode.BeanColumn;
import com.github.pagehelper.PageInfo;
import java.util.List;

/**
 * 描述：
 *
 * @author https:www.unfbx.com
 * @date 2023-04-08
 */
public interface GeneratorService {
    /**
     * 分页查询
     * @param tablepar
     * @param searchText
     * @return
     */
    PageInfo<TsysTables> list(Tablepar tablepar, String searchText);

    /**
     * 查询具体某表信息
     * @param tableName
     * @return
     */
    List<TsysTables> queryList(String tableName);

    /**
     * 查询表详情
     * @param tableName
     * @return
     */
    List<BeanColumn> queryColumns2(String tableName);
}
