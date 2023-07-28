//import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.*;
import org.joda.time.DateTime;

/*import java.text.SimpleDateFormat;
import java.util.Date;*/

/**
 * {
 * "id":944,
 * "stCalcDate":"2022-11-16 13:22:08",
 * "stIndexLevel":
 *      {
 *      "id":0,
 *      "indexLevelName":"Bardzo dobry"
 *      },
 * "stSourceDataDate":"2022-11-16 13:00:00",
 * "so2CalcDate":"2022-11-16 13:22:08",
 * "so2IndexLevel":
 *      {
 *      "id":0,
 *      "indexLevelName":"Bardzo dobry"
 *      },
 * "so2SourceDataDate":"2022-11-16 13:00:00",
 * "no2CalcDate":"2022-11-16 13:22:08",
 * "no2IndexLevel":
 *      {
 *      "id":0,
 *      "indexLevelName":"Bardzo dobry"
 *      },
 * "no2SourceDataDate":"2022-11-16 13:00:00",
 * "pm10CalcDate":"2022-11-16 13:22:08",
 * "pm10IndexLevel":
 *      {
 *      "id":0,
 *      "indexLevelName":"Bardzo dobry"
 *      },
 * "pm10SourceDataDate":"2022-11-16 13:00:00",
 * "pm25CalcDate":"2022-11-16 13:22:08",
 * "pm25IndexLevel":
 *      {
 *      "id":0,
 *      "indexLevelName":"Bardzo dobry"
 *      },
 * "pm25SourceDataDate":"2022-11-16 13:00:00",
 * "o3CalcDate":"2022-11-16 13:22:08",
 * "o3IndexLevel":
 *      {
 *      "id":0,
 *      "indexLevelName":"Bardzo dobry"
 *      },
 * "o3SourceDataDate":"2022-11-16 13:00:00",
 * "stIndexStatus":true,
 * "stIndexCrParam":"PYL"
 * }
 *
 */

public class InfID {


    public int id;
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    DateTime stCalcDate;
    public stIndexLevel stIndexLevel;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    public DateTime stSourceDataDate;
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    public DateTime so2CalcDate;
    public stIndexLevel so2IndexLevel;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    public DateTime so2SourceDataDate;
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    public DateTime no2CalcDate;
    public stIndexLevel no2IndexLevel;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    public DateTime no2SourceDataDate;
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    public DateTime pm10CalcDate;
    public stIndexLevel pm10IndexLevel;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    public DateTime pm10SourceDataDate;
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    public DateTime pm25CalcDate;
    public stIndexLevel pm25IndexLevel;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    public DateTime pm25SourceDataDate;
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    public DateTime o3CalcDate;
    public stIndexLevel o3IndexLevel;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    public DateTime o3SourceDataDate;
    public boolean stIndexStatus;
    public String stIndexCrParam;







}
