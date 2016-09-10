package com.example.application.server.model.action;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "result"
})
@XmlRootElement(name = "deleteBookResponse")
public class DeleteBookResponse {

    protected boolean result;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean value) {
        this.result = value;
    }

}
