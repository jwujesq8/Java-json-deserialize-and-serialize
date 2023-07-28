import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class jsonDeserializeAndSerialize {
    static String userDirectory = System.getProperty("user.dir");
    static String link = "https://api.gios.gov.pl/pjp-api/rest/station/findAll";
    static Location[] location = null;
    public static void deserialize(ObjectMapper mapper, String data){
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        if(data==null){
            try {
                location = mapper.readValue(new File(userDirectory + "\\all.json"), Location[].class);
            } catch (JsonGenerationException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else{
            try {
                location = mapper.readValue(data, Location[].class);
            } catch (JsonGenerationException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String [] args) throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.registerModule(new JodaModule());
        jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
        Scanner scanner = new Scanner(System.in);

        ProcessQ processQ = new ProcessQ(new HttpQueryClass());
        String dataLinkResult= processQ.process("", link);

        if(dataLinkResult!=null){
            File rawJSONData = new File(userDirectory + "\\all.json");
            BufferedWriter writer = new BufferedWriter(new FileWriter(rawJSONData));
            writer.write(String.valueOf(dataLinkResult));
            writer.close();
        }
        deserialize(jsonMapper, dataLinkResult);

        //available stations and id
        System.out.println("list of stations with there id:");
        for(Location loc : location){
            System.out.println("STATION_ID: "+loc.getId() + ", STATION_NAME: "+loc.getStationName());
        }

        //display available cities
        System.out.print("Do you want to see the list of available cities? (yes/no): ");
        String display_available_cities;
        do{
            display_available_cities = scanner.nextLine();
        } while(!(display_available_cities.equals("yes") || display_available_cities.equals("no")));
        if(display_available_cities.equals("yes")){
            List<String> citiesList = Arrays.stream(location)
                    .map(Location::getCity)
                    .map(City::getName)
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());
            citiesList.forEach(System.out::println);
        }

        //display available ids by the given city name
        System.out.print("Do you want to see available ids of the given city? (yes/no): ");
        String displayIdsOfTheGivenCity;
        do{
            displayIdsOfTheGivenCity = scanner.nextLine();
        } while (!(displayIdsOfTheGivenCity.equals("yes") || displayIdsOfTheGivenCity.equals("no")));
        if(displayIdsOfTheGivenCity.equals("yes")){
            Map<Integer, String> queueOfId = new HashMap<>();
            System.out.print("enter the city: ");
            String cityName=scanner.next();
            for(Location loc: location){
                if(loc.getCity().getName().equals(cityName)){
                    queueOfId.put(loc.getId(), loc.getAddressStreet());
                }
            }
            System.out.println("\n\t" + queueOfId);
        }

        System.out.print("enter the id of the station: ");
        int stationId = scanner.nextInt();
        String idInfoLink = "https://api.gios.gov.pl/pjp-api/rest/aqindex/getIndex/" + stationId;

        ProcessQ processQStationId = new ProcessQ(new HttpQueryClass());
        String stationIdLinkResult = processQStationId.process("", idInfoLink);

        if (stationIdLinkResult != null) {
            InfID stationIdInfo;
            stationIdInfo = jsonMapper.readValue(stationIdLinkResult, InfID.class);

            System.out.print("Which format of the data will you prefer? (enter number):\n\t1.JSON\n\t2.XML\n\t3.PDF\nanswer: ");
            int dataFormat;
            do{
                dataFormat = scanner.nextInt();
            } while (!(dataFormat==1 || dataFormat==2 || dataFormat==3));

            //into JSON
            if(dataFormat==1){
                try {
                    jsonMapper.writeValue(new File(userDirectory + "\\" + stationId + ".json"),
                            stationIdInfo);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                System.out.println("the JSON file is saved and located in: " + userDirectory + "\\" + stationId + ".json");
            }

            //into XML
            else if(dataFormat==2){
                try {
                    ObjectMapper xmlMapper = new XmlMapper();
                    xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
                    xmlMapper.writeValue(new File(userDirectory + "\\" + stationId + ".xml"), stationIdInfo);
                } catch (Exception e){
                    throw new RuntimeException(e);
                }
                System.out.println("the XML file is saved and located in: " + userDirectory + "\\" + stationId + ".xml");
            }

            //into PDF
            else{
                System.out.println("not prepared yet");
            }

        }
    }
}
