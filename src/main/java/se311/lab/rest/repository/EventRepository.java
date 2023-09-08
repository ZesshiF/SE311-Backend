package se311.lab.rest.repository;

import org.springframework.data.repository.CrudRepository;
import se311.lab.rest.entity.Event;

import java.util.List;

public interface EventRepository extends CrudRepository<Event,Long>{
    List<Event> findAll();
}
