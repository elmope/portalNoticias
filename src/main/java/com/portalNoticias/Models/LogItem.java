package com.portalNoticias.Models;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Document
public class LogItem {

    private String consumedResource;
    private Date date;

    public LogItem(String consumedResource, Date date) {
        this.consumedResource = consumedResource;
        this.date = date;
    }

    public String getConsumedResource() {
        return consumedResource;
    }

    public void setConsumedResource(String consumedResource) {
        this.consumedResource = consumedResource;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
