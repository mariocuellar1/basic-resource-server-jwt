package io.mcore.myapp;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class BasicResourceServerApplication {

    @Autowired
    TokenStore tokenStore;

    @Autowired
    JwtAccessTokenConverter tokenConverter;


	public static void main(String[] args) {
		SpringApplication.run(BasicResourceServerApplication.class, args);
	}
	
	@RequestMapping("/user")
	public Map<String, String> user(Principal user) {
		Map<String, String> result = new HashMap<>();
		result.put("username", user.getName());
		result.put("image", "./mypicture.png"); //...
		return result;
	}

	@RequestMapping("/only_for_admin")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String onlyForAdmin() {
		return "ADMIN data: " + UUID.randomUUID().toString();
	}

	@RequestMapping("/only_scope_write")
	@PreAuthorize("#oauth2.hasScope('write')")
	public String readData2() {
		return "write data:" + UUID.randomUUID().toString();
	}

}
