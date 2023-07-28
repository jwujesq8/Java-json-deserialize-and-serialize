//{"id":291,
// "stationName":"Gajew, Ujęcie Wody",
// "gegrLat":"52.143250",
// "gegrLon":"19.233225",
// "city":{
//      "id":209,
//      "name":"Gajew",
//      "commune":{
//          "communeName":"Witonia",
//          "districtName":"łęczycki",
//          "provinceName":"ŁÓDZKIE"
//          }
//      },
//  "addressStreet":"Ujęcie wody"
//  }

public class Location {
    public int id;
    public String stationName;
    public float gegrLat;
    public float gegrLon;
    City city;
    public String addressStreet;

    public int getId() {
        return id;
    }

    public String getStationName() {
        return stationName;
    }

    public float getGegrLat() {
        return gegrLat;
    }

    public float getGegrLon() {
        return gegrLon;
    }

    public City getCity() {
        return city;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public void setGegrLat(float gegrLat) {
        this.gegrLat = gegrLat;
    }

    public void setGegrLon(float gegrLon) {
        this.gegrLon = gegrLon;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public Location() { }
}
