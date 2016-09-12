package com.example.application.client.service.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "tracking"
})@XmlRootElement(name = "getTrackingRequest")
public class GetTrackingRequest {

    @XmlElement(required = true)
    protected TrackingDTO tracking;

    public TrackingDTO getTracking() {
        return tracking;
    }

    public void setTracking(TrackingDTO tracking) {
        this.tracking = tracking;
    }
}
