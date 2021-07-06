package aldora.spring.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class SpringConfigClientApplication {
    @Value("${token.secret}")
    private String secret;

    public static void main(String[] args) {
        SpringApplication.run(SpringConfigClientApplication.class, args);
    }

    @RequestMapping(value = "/config", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String config() {
        return String.format("Token secret is '%s'.\n", secret);
    }

}
