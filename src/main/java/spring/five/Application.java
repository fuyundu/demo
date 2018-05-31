package spring.five;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

// spring5.0新操作可以不用appliaction.xml，可以纯注解了。牛

@Configuration
@ComponentScan
public class Application {

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
              return "Hello World!";
            }
        };
    }

  public static void main(String[] args) {
      ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
      MessagePrinter printer = context.getBean(MessagePrinter.class);
      printer.printMessage();
  }
}