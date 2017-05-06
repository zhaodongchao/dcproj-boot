package org.dongchao.core.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by zhaodongchao on 2017/5/5.
 */
@Component
@ConfigurationProperties(prefix = "author")
public class AuthorInfo {
    private String name ;
    private String createTime ;
    private String telphone ;
    private String email;
    private String company ;
    private String description ;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AuthorInfo{");
        sb.append("name='").append(name).append('\'');
        sb.append(", createTime='").append(createTime).append('\'');
        sb.append(", telphone='").append(telphone).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", company='").append(company).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
