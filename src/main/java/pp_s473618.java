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


public class pp_s473618 {
    public static Location[] deserialize(ObjectMapper mapper) throws IOException {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Location[] location = null;
        try {
            location = mapper.readValue(new File("E:\\Рабочий стол\\unik\\3sem\\pp\\pp_s473618\\all.json"), Location[].class);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return(location);
    }

    public static void main(String [] args) throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.registerModule(new JodaModule());
        jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Alena Zhukouskaya, s473618");

        String link = "https://api.gios.gov.pl/pjp-api/rest/station/findAll";


        ProcessQ processQ = new ProcessQ(new HttpQueryClass());

        File ze_strony_json = new File("E:\\Рабочий стол\\unik\\3sem\\pp\\pp_s473618\\all.json");
        BufferedWriter writer = new BufferedWriter(new FileWriter(ze_strony_json));
        String result= processQ.process("", link);
        writer.write(String.valueOf(result));
        writer.close();


        Location[] location=deserialize(jsonMapper);

        //available stations and id
        System.out.println("SPIS STACJI I ID");
        for(Location loc : location){
            System.out.println("STATION_ID: "+loc.getId() + ", STATION_NAME: "+loc.getStationName());
        }

        //choice to see available cities
        System.out.print("Chcesz zobaczyc liste dostepnych miast? (tak/nie): ");
        String watch_the_list_of_cities=scanner.next();
        if(watch_the_list_of_cities.equals("tak")){
            List<String> listCities = Arrays.stream(location)
                    .map(Location::getCity)
                    .map(City::getName)
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());
            listCities.forEach(System.out::println);
        }

        //choice to see available id by city's name
        Map<Integer, String> queueOfId = new HashMap<>();
        System.out.print("Czy chcesz znalezc dostepne id podanego przez ciebie miasta? (tak/nie): ");
        String choiceWatchTheIdByCity= scanner.next();
        if(choiceWatchTheIdByCity.equals("tak")){
            System.out.print("Podaj nazwe miasta: ");
            String cityName=scanner.next();
            for(Location entry : location){
                if(entry.getCity().getName().equals(cityName)){
                    queueOfId.put(entry.getId(), entry.getAddressStreet());
                }
            }
            System.out.println("id=adress:\n\t" + queueOfId);
        }

        System.out.print("Wybierz id stacji: ");
        int uid = scanner.nextInt();
        String link_o_id = "https://api.gios.gov.pl/pjp-api/rest/aqindex/getIndex/" + uid;


        ProcessQ processQOID = new ProcessQ(new HttpQueryClass());
        String result_o_id = processQOID.process("", link_o_id);


            if (result_o_id != null) {

                File uid_ze_strony = new File("E:\\Рабочий стол\\unik\\3sem\\pp\\pp_s473618\\zerotype_" + uid + ".json");
                BufferedWriter writer_o_id = new BufferedWriter(new FileWriter(uid_ze_strony));
                writer_o_id.write(String.valueOf(result_o_id));
                writer_o_id.close();
                InfID inf_uid;
                inf_uid = jsonMapper.readValue(new File("E:\\Рабочий стол\\unik\\3sem\\pp\\pp_s473618\\zerotype_" + uid + ".json"), InfID.class);


                System.out.print("W jakim pliku chcesz zapisac informacje(wpisz numer odpowiedzi)?:\n\t1.JSON\n\t2.XML\nnOdpowiedz: ");
                int type_of_file = scanner.nextInt();

                //as JSON
                if(type_of_file==1){
                    try {
                        jsonMapper.writeValue(new File("E:\\Рабочий стол\\unik\\3sem\\pp\\pp_s473618\\" + uid + ".json"),
                                inf_uid);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Plik JSON jest gotowy i znajduje sie w: E:\\Рабочий стол\\unik\\3sem\\pp\\pp_s473618");
                }
                //as XML
                else if(type_of_file==2){
                    try {
                        ObjectMapper xmlMapper = new XmlMapper();
                        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
                        xmlMapper.writeValue(new File("E:\\Рабочий стол\\unik\\3sem\\pp\\pp_s473618\\" + uid + ".xml"), inf_uid);
                    } catch (Exception e){
                        throw new RuntimeException(e);
                    }
                    System.out.println("Plik XML jest gotowy i znajduje sie w: E:\\Рабочий стол\\unik\\3sem\\pp\\pp_s473618");
                }
                //as PDF
                /*else if(type_of_file==3){ }

                else System.out.println("Nie ma takiej opcji..");*/

            }


    }
}
