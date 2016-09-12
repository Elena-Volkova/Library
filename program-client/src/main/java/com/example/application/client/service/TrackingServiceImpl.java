package com.example.application.client.service;

import com.example.application.client.endpoint.ServiceWSClient;
import com.example.application.client.service.model.BookSearchDTO;
import com.example.application.client.service.model.TrackingDTO;
import com.example.application.client.service.model.UserSearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackingServiceImpl implements TrackingService {

    private ServiceWSClient serviceWSClient;

    @Autowired
    public TrackingServiceImpl(ServiceWSClient serviceWSClient) {
        this.serviceWSClient = serviceWSClient;
    }

    @Override
    public TrackingDTO getTracking(TrackingDTO tracking) {
        return serviceWSClient.getTracking(tracking).getTracking();
    }

    @Override
    public void updateTracking(Long bookId, Long userId) {
        serviceWSClient.updateTracking(bookId, userId);
    }

    @Override
    public void addTracking(Long bookId, Long userId) {
        serviceWSClient.addTracking(bookId, userId);
    }
}
