package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InMemoryTimeEntryRepository implements TimeEntryRepository{
    Map<Long, TimeEntry> timeEntryMap = new HashMap<Long, TimeEntry>();
    long count = 0;
    public TimeEntry create(TimeEntry timeEntry) {
        count = count +1;
        TimeEntry timeEntryNew =  new TimeEntry(count , timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        timeEntryMap.put(count, timeEntryNew);
        return timeEntryNew;

    }

    public TimeEntry find(long id) {

        TimeEntry timeEntry = timeEntryMap.get(id);
        return timeEntry;
    }

    public TimeEntry update(long l, TimeEntry timeEntry) {
        TimeEntry timeEntryNew= timeEntryMap.get(l);
        if(timeEntryNew!=null){
            timeEntry.setId(l);
            timeEntryMap.put(l,timeEntry);
        }
        return timeEntryMap.get(l);



    }

    public void delete(long id) {
        timeEntryMap.remove(id);
    }

    public List<TimeEntry> list() {
        List<TimeEntry> tm = new ArrayList<>();
        tm.addAll(timeEntryMap.values());
        return tm;
    }
}
