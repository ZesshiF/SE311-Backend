package se311.lab.rest.dao;

import org.springframework.data.domain.Page;
import se311.lab.rest.entity.Event;


public interface EventDao {
    Integer getEventSize();
    Page<Event> getEvents(Integer pageSize, Integer page);
    Event getEvent(Long id);

    Event save(Event event);
}
