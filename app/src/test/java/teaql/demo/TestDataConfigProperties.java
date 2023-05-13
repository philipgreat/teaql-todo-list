package teaql.demo;

import io.teaql.data.DataConfigProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class TestDataConfigProperties extends DataConfigProperties {


}
