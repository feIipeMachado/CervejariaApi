package cerveja.integration.response;

import lombok.Data;

@Data
public class WeatherResponse {

    private LocationResponse location;
    private CurrentResponse current;


}
