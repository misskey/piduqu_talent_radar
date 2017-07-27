package com.piduqu.radar.entity.mongo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenwei on 2017/5/26.
 */
public class AdditionalMsg {

    private String title;//标题
    private List<String> contentList = new ArrayList<>();//内容

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getContentList() {
        return contentList;
    }

    public void setContentList(List<String> contentList) {
        this.contentList = contentList;
    }
}
