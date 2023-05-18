package com.fc.v2.service;

import com.fc.v2.controller.request.ChatRequest;
import com.fc.v2.controller.response.ChatResponse;
import com.fc.v2.model.auto.TSysDictData;
import com.fc.v2.model.auto.TSysDictType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;

/**
 * 描述：
 *
 * @author https:www.unfbx.com
 * @date 2023-04-08
 */
public interface DictService {
    /**
     * 根据字典类型查询字典数据信息
     *
     * @param dictType 字典类型
     * @return 参数键值
     */
    List<TSysDictData> getType(String dictType);

    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType
     *            字典类型
     * @param dictValue
     *            字典键值
     * @return 字典标签
     */
    String getLabel(String dictType, String dictValue);

    /**
     * 根字典类型查询字典
     * @param dictType
     * @return
     */
    TSysDictType getSysDictType(String dictType);
}
