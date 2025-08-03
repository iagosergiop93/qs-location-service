package com.booking.qs_location_service.schedulers;

import com.booking.qs_location_service.dtos.tasks.CreateApptSlots;
import com.booking.qs_location_service.messages.producers.TimeslotProducer;
import com.booking.qs_location_service.repositories.LocationRepository;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class QsTaskScheduler {

    @Autowired
    private LocationRepository locationRepo;

    @Autowired
    private TimeslotProducer timeslotProducer;

    @Scheduled(cron = "0 0 0 ? * MON")
//    @Scheduled(cron = "0 */1 * * * *")
    @SchedulerLock(name = "weeklyCreateTimeslots", lockAtLeastFor = "PT5M", lockAtMostFor = "PT10M")
    public void createNewTimeslots() {
        var today = LocalDate.now();
        var startDate = today.plusDays(7);
        var endDate = today.plusDays(14);

        var offset = 0;
        var limit = 10;
        var allLocationsProcessed = false;
        while(!allLocationsProcessed) {
            var locationList = locationRepo.findAllDto(limit, offset);
            if (locationList != null && !locationList.isEmpty()) {
                locationList.forEach(location -> {
                    var cas = new CreateApptSlots();
                    cas.setStartDate(startDate);
                    cas.setEndDate(endDate);
                    cas.setOrgId(location.getOrgId());
                    cas.setLocationId(location.getLocationId());
                    cas.setSlotDurationMinutes(30);
                    timeslotProducer.createTimeslots(cas);
                });
                offset += limit;
            }
            else {
                allLocationsProcessed = true;
            }
        }
    }

}
