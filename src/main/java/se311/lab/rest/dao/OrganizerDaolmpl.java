package se311.lab.rest.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import se311.lab.rest.entity.Organizer;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizerDaolmpl implements OrganizerDao {

    List<Organizer> organizerList;

    @PostConstruct
    public void init(){
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(123L)
                .location("Meow Town")
                .organizer("Kat Laydee")
                .build());

        organizerList.add(Organizer.builder()
                .id(456L)
                .location("Flora City")
                .organizer("Fern Pollin")
                .build());

        organizerList.add(Organizer.builder()
                .id(789L)
                .location("Playa Del Carmen")
                .organizer("Carey Wales")
                .build());

        organizerList.add(Organizer.builder()
                .id(1001L)
                .location("Woof Town")
                .organizer("Dawg Dahd")
                .build());

        organizerList.add(Organizer.builder()
                .id(1002L)
                .location("Tin City")
                .organizer("Kahn Opiner")
                .build());

        organizerList.add(Organizer.builder()
                .id(1003L)
                .location("Highway 50")
                .organizer("Brody Kill")
                .build());
    }
    @Override
    public Integer getOrganizeSize() {
        return organizerList.size();
    }

    @Override
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null?1 : page;
        int firstIndex = (page-1) * pageSize;
        return organizerList.subList(firstIndex,firstIndex+pageSize);
    }

    @Override
    public Organizer getOrganize(Long id) {
        return organizerList.stream().filter(event -> event.getId().equals(id)).findFirst().orElse(null);
    }
}
