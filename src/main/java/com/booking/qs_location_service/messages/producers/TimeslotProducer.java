package com.booking.qs_location_service.messages.producers;

import com.booking.qs_location_service.dtos.tasks.CreateApptSlots;
import com.booking.qs_location_service.messages.BaseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Component
public class TimeslotProducer {

    @Autowired
    private StreamBridge streamBridge;

    public Boolean createTimeslots(CreateApptSlots cas) {
        var baseMessage = new BaseMessage<>(cas);
        var message = new GenericMessage<>(baseMessage);
        return this.streamBridge.send("create-timeslots-requested",message);
    }

}
