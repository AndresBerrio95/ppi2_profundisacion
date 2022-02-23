package co.com.poli.bookingsservice.client;

import co.com.poli.bookingsservice.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserClient {
     @GetMapping("/ppi/v2/users/{id}")
     Response findById(@PathVariable("id") Long id);
}
