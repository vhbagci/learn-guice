package tutorial.guice;

import com.github.racc.tscg.TypesafeConfig;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
public class MyApplication {

  private FacebookService facebookService;

  @Inject
  public MyApplication(FacebookService facebookService,
//      @TypesafeConfig("service.port") int port,
//      @TypesafeConfig("service.name") String name) {
      @Named("service.enabled") boolean enabled,
      @Named("service.port") int port,
      @Named("service.name") String name) {
    this.facebookService = facebookService;
    System.out.println(String.format("Instantiated MyApplication(enabled=%s) at %d with name: %s.", enabled, port, name));
  }

  public boolean sendMessage(String msg, String rec){
    //some business logic here
    return this.facebookService.sendMessage(msg, rec);
  }
}
