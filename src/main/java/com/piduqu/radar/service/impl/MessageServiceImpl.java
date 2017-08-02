package com.piduqu.radar.service.impl;

import com.piduqu.radar.common.JsonResult;
import com.piduqu.radar.service.IMessageService;
import org.springframework.stereotype.Service;

/**
 * Created by liu_zhangyun on 2017/7/28.
 * Cell:15884457479
 * Email:zhangyun.liu@hirebigdata.cn
 * Description:
 * <p/>
 * Functions:
 * 1.
 */
@Service
public class MessageServiceImpl implements IMessageService {
    @Override
    public JsonResult sendMsg(String msg) {
        return JsonResult.success();
    }
}
