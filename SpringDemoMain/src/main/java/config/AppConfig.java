package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.niit.SpringDemoMain.*;
@Configuration
@ComponentScan(basePackages="com.niit")
public class AppConfig {

	@Bean(name="helloworld")
	public HelloWorld getHelloworld()
	{
		return new HelloWorld() {
			
			public String sayHello() {
				// TODO Auto-generated method stub
				return "hello";
			}
		};
	}
}
	

