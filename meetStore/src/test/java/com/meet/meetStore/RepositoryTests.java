package com.meet.meetStore;

import com.meet.meetStore.domain.entity.Client;
import com.meet.meetStore.domain.entity.Room;
import com.meet.meetStore.domain.entity.RoomDate;
import com.meet.meetStore.domain.repository.ClientRepository;
import com.meet.meetStore.domain.repository.RoomRepository;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Set;

@SpringBootTest
class RepositoryTests {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private RoomRepository roomRepository;

    @Test
    void saveClient() {
        Client client = Client.builder().login("test").build();
        Client saved = clientRepository.save(client);
        Assert.notNull(saved, () -> "saved is null");
        Assert.notNull(saved.getId(), () -> "saved id is null");
    }

    @Test
    void saveClient2() {
        Client client = Client.builder().login("test").build();

        Client saved = clientRepository.save(client);
        Room room = Room.builder().name("testt").build();
		room=roomRepository.save(room);
        RoomDate roomDate = RoomDate.builder().client(saved).room(room).build();
        Set<RoomDate> s = Sets.newHashSet(saved.getRoomDates());
        s.add(roomDate);
        saved.setRoomDates(s);
        saved = clientRepository.save(client);
        Assert.notNull(saved, () -> "saved is null");
        Assert.notNull(saved.getId(), () -> "saved id is null");
    }
}
