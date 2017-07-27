package com.piduqu.radar.entity.mongo;

/**
 * 语言
 * Created by jiangwei on 2016/4/25 0025.
 */
public class Language {

    private String language_name;//语言名称
    private String language_ability;//语言能力
    private String language_type;//语言类型

    public String getLanguage_name() {
        return language_name;
    }

    public void setLanguage_name(String language_name) {
        this.language_name = language_name;
    }

    public String getLanguage_ability() {
        return language_ability;
    }

    public void setLanguage_ability(String language_ability) {
        this.language_ability = language_ability;
    }

    public String getLanguage_type() {
        return language_type;
    }

    public void setLanguage_type(String language_type) {
        this.language_type = language_type;
    }
}
