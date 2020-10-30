package tutorial.guice;

import javax.inject.Singleton;

@Singleton
public class FacebookService implements MessageService {

  public FacebookService() {
    System.out.println("Instantiated FacebookService");
  }

  public boolean sendMessage(String msg, String receipient) {
    //some complex code to send Facebook message
    System.out.println("Message sent to Facebook user "+receipient+" with message="+msg);
    return true;
  }
}
