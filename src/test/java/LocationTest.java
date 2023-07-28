import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationTest {

    Location location1ForTest = new Location();
    Location location2ForTest = new Location();
    Location location3ForTest = new Location();
    List<Location> listLocationForTest = new ArrayList<>();

    @Before
    public void fillInLocationForTest() {

        //1th location
        Commune commune1ForTest = new Commune();
        commune1ForTest.setCommuneName("Lalala");
        commune1ForTest.setDistrictName("Lala");
        commune1ForTest.setProvinceName("Lal");
        City city1ForTest = new City();
        city1ForTest.setId(110);
        city1ForTest.setName("Lalala");
        city1ForTest.setCommune(commune1ForTest);
        location1ForTest.setId(111);
        location1ForTest.setStationName("Lalala, ul. Blabla");
        location1ForTest.setGegrLat((float) 87.123241);
        location1ForTest.setGegrLon((float) 96.127454);
        location1ForTest.setCity(city1ForTest);
        location1ForTest.setAddressStreet("ul. Blabla");

        //2th location
        Commune commune2ForTest = new Commune();
        commune2ForTest.setCommuneName("Slakfow");
        commune2ForTest.setDistrictName("Slakfow");
        commune2ForTest.setProvinceName("Slak");
        City city2ForTest = new City();
        city2ForTest.setId(210);
        city2ForTest.setName("Slakfow");
        city2ForTest.setCommune(commune2ForTest);
        location2ForTest.setId(211);
        location2ForTest.setStationName("Slakfow, ul. Pewna");
        location2ForTest.setGegrLat((float) 153.123241);
        location2ForTest.setGegrLon((float) 15.127454);
        location2ForTest.setCity(city2ForTest);
        location2ForTest.setAddressStreet("ul. Pewna");

        //3th location
        Commune commune3ForTest = new Commune();
        commune3ForTest.setCommuneName("Flenty");
        commune3ForTest.setDistrictName("Flenty");
        commune3ForTest.setProvinceName("Flen");
        City city3ForTest = new City();
        city3ForTest.setId(310);
        city3ForTest.setName("Flenty");
        city3ForTest.setCommune(commune3ForTest);
        location3ForTest.setId(311);
        location3ForTest.setStationName("Flenty, ul. Jasna");
        location3ForTest.setGegrLat((float) 97.123241);
        location3ForTest.setGegrLon((float) 36.127454);
        location3ForTest.setCity(city3ForTest);
        location3ForTest.setAddressStreet("ul. Jasna");

        listLocationForTest.add(location1ForTest);
        listLocationForTest.add(location2ForTest);
        listLocationForTest.add(location3ForTest);
    }
    @Test
    public void IdIsNotNull() {

        assertThat(location1ForTest).extracting(Location::getId)
                .isNotNull();

        assertThat(location2ForTest).extracting(Location::getId)
                .isNotNull();

    }

    @Test
    public void FilterContainInstance() {

        assertThat(listLocationForTest).filteredOn(location -> location.getCity().getName().contains("f"))
                .containsOnly(location2ForTest);

    }

    /*@Test void podobne(){
        assertThat(listLocationForTest).filteredOn(location -> location.getCity().getName().contains("a"))
                .containsOnly(location1ForTest,location2ForTest)
                .extracting(Location::getCity)
                .contains(Name.Lalala, Name.Slakfow);

    }*/
}
enum Name{
    Lalala,
    Slakfow,
    Flenty

}