package fr.mirabeau.demo.service;

import fr.mirabeau.demo.entity.Location;
import fr.mirabeau.demo.service.internal.dao.LocationDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(LocationService.class)
class LocationServiceTest {

    private final List<Location> db = new ArrayList<>();

    @MockBean
    LocationService locationService;

    @MockBean
    LocationDao locationDao;

    @BeforeEach
    void init() {
        Location invent1 = new Location("1","Paris", "first inventory in France", "01/01/2020");
        Location invent2 = new Location("2","Lyon", "second inventory in France", "01/10/2020");
        Location invent3 = new Location("3","Antony", "best inventory in France", "01/01/2021");
        this.db.add(invent1);
        this.db.add(invent2);
        this.db.add(invent3);
    }

    @Test
    void getInventoryByName() {

    }

    @Test
    void getAllInventories() throws Exception {
        Mockito.when(locationService.getAllLocations())
                .thenReturn(this.db);


    }

    @Test
    void createInventory() throws Exception {
        Location newInvent = new Location("4","Nice", "another inventory in France", "01/02/2021");

        Mockito.when(locationService.createLocation(newInvent))
                .thenReturn(newInvent);

    }

    @Test
    void deleteInventory() {
    }
}