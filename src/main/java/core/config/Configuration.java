package core.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties", "classpath:browser.properties","classpath:api.properties"})
public interface Configuration extends Config {

    @Key("browser")
    String browser();

    @Key("headless")
    boolean headless();

    @Key("timeout")
    int timeout();

    @Key("base.url")
    String baseUrl();

    @Key("api.url")
    String apiUrl();
}
