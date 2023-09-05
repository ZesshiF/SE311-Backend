package se311.lab.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se311.lab.rest.dao.OrganizerDao;
import se311.lab.rest.entity.Organizer;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizerServicelmpl implements OrganizerService {

    final OrganizerDao organizerDao;
    @Override
    public Integer getOrganizeSize() {
        return organizerDao.getOrganizeSize();
    }

    @Override
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        return organizerDao.getOrganizers(pageSize,page);
    }

    @Override
    public Organizer getOrganize(Long id) {
        return organizerDao.getOrganize(id);
    }
}
