package tutorial.guice.config;

import com.github.racc.tscg.TypesafeConfig;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import java.util.Properties;
import javax.inject.Named;
import tutorial.guice.FacebookService;
import tutorial.guice.MessageService;
import tutorial.guice.MyApplication;

public class MainConfig extends AbstractModule {

  public static Config config = ConfigFactory.load();
  private Properties properties = new Properties();

  public MainConfig() {
    // Works 1
    config.entrySet().forEach((entry) -> {
      properties.put(entry.getKey(), entry.getValue().unwrapped().toString());
    });
  }

  @Override
  protected void configure() {
    // Works 2
//    bindConstant().annotatedWith(Names.named("service.port")).to(config.getInt("service.port"));
//    bindConstant().annotatedWith(Names.named("service.enabled")).to(config.getBoolean("service.enabled"));
//    bindConstant().annotatedWith(Names.named("service.name")).to(config.getString("service.name"));


//    properties.put("service.port", config.getString("service.port"));
//    properties.put("service.enabled", config.getString("service.enabled"));
//    properties.put("service.name", config.getString("service.name"));
    Names.bindProperties(binder(), properties);

    //bind the service to implementation class
    //bind(MessageService.class).to(EmailService.class);

    //bind MessageService to Facebook Message implementation
    bind(FacebookService.class);
    System.out.println("Binded FacebookService");
//      Thread.sleep(500);
    bind(MyApplication.class);
    System.out.println("Binded MyApplication");
//      Thread.sleep(500);
  }
}
