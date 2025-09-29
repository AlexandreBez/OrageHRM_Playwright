package orangeHRM.Config;

import java.util.HashMap;
import java.util.Map;

import com.microsoft.playwright.options.Geolocation;

public final class GeolocationManager {
	
    // --- Static map of locations ---
    private static final Map<String, Geolocation> GEO_MAP = new HashMap<>();

    static {
        GEO_MAP.put("brazil_sao_paulo", new Geolocation( -23.5505, -46.6333 ));
        GEO_MAP.put("brazil_brasilia",  new Geolocation( -15.8267, -47.9218 ));
        GEO_MAP.put("usa_new_york",     new Geolocation(  40.7128, -74.0060 ));
        GEO_MAP.put("japan_tokyo",      new Geolocation(  35.6895, 139.6917 ));
    }

    /**
     * Returns a Geolocation object for a given key.
     *
     * @param key location name (e.g. "brazil_sao_paulo")
     * @return Geolocation or null if not found
     */
    public static Geolocation get(String key) {
        return GEO_MAP.get(key.toLowerCase());
    }

}
