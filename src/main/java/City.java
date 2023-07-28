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


public class City {
    public int id;
    public String name;
    Commune commune;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }
     public City() { };
}
