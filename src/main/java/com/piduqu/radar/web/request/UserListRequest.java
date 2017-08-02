package com.piduqu.radar.web.request;


import com.piduqu.radar.common.ValidatorMsg;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by mgf on 2017/5/23.
 */
public class UserListRequest {

    @Min(value = 0,message = ValidatorMsg.NUMBER_ERROR)
    private Integer page = 0;

    @NotNull
    private String user_id;

    public Integer getPage() {
        return page;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

}
