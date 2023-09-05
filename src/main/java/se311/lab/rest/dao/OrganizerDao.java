package se311.lab.rest.dao;


import se311.lab.rest.entity.Organizer;

import java.util.List;

public interface OrganizerDao {
    Integer getOrganizeSize();
    List<Organizer> getOrganizers(Integer pageSize, Integer page);
    Organizer getOrganize(Long id);

}
