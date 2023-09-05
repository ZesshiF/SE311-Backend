package se311.lab.rest.service;

import se311.lab.rest.entity.Organizer;

import java.util.List;

public interface OrganizerService {
    Integer getOrganizeSize();
    List<Organizer> getOrganizers(Integer pageSize, Integer page);
    Organizer getOrganize(Long id);

}
