package com.example.application.client.service.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "result"
})
@XmlRootElement(name = "updateBookResponse")
public class UpdateBookResponse {

    protected boolean result;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean value) {
        this.result = value;
    }

}
