package works.weave.socks.wishlist;

import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnablePrometheusEndpoint
public class WishlistApplication {
    public static void main(String[] args) {
        SpringApplication.run(WishlistApplication.class, args);
    }
}
