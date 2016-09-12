package com.example.application.client.service.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "tracking"
})
@XmlRootElement(name = "getTrackingResponse")
public class GetTrackingResponse {

    @XmlElement(required = true)
    protected TrackingDTO tracking;

    public TrackingDTO getTracking() {
        if (tracking.getBooks() == null) {
            tracking.setBooks(new ArrayList<>());
        }
        if (tracking.getUserCards() == null) {
            tracking.setUserCards(new ArrayList<>());
        }
        return tracking;
    }

    public void setTracking(TrackingDTO tracking) {
        this.tracking = tracking;
    }
}
