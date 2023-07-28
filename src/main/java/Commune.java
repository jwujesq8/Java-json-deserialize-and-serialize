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

public class Commune {
    public String communeName;
    public String districtName;
    public String provinceName;

    public String getCommuneName() {
        return communeName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setCommuneName(String communeName) {
        this.communeName = communeName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Commune() { }
}
