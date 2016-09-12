package com.example.application.client.service;

import com.example.application.client.service.model.TrackingDTO;

public interface TrackingService {

    TrackingDTO getTracking(TrackingDTO tracking);

    void updateTracking(Long bookId, Long userId);

    void addTracking(Long bookId, Long userId);
}
