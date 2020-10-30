package tutorial.guice;

import com.github.racc.tscg.TypesafeConfigModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import tutorial.guice.config.MainConfig;

public class ClientApplication {

  public static void main(String[] args) {
    System.out.println("About to trigger injector");
    System.out.println("CONFIG_FORCE_service_port: " + System.getenv("CONFIG_FORCE_service_port"));
    Config config = ConfigFactory.load();
    System.out.println("service.eabled: " + config.getBoolean("service.enabled"));
    System.out.println("service.port: " + config.getInt("service.port"));
    System.out.println("service.name: " + config.getString("service.name"));
    // Injector injector = Guice.createInjector(TypesafeConfigModule.fromConfigWithPackage(
    //        config, ClientApplication.class.getPackageName()), new MainConfig());
    Injector injector = Guice.createInjector(new MainConfig());
    System.out.println("Triggered injector");
    MyApplication app = injector.getInstance(MyApplication.class);
    app.sendMessage("Hi Test", "test@abc.com");
    app = injector.getInstance(MyApplication.class);
    app.sendMessage("Hi Test 2", "test@abc.com");
  }
}
