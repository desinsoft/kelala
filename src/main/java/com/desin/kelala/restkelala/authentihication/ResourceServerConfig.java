package com.desin.kelala.restkelala.authentihication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Value("${security.jwt.resource-ids}")
    private String resourceIds;

    private final ResourceServerTokenServices tokenServices;

    private final TokenStore tokenStore;

    @Autowired
    public ResourceServerConfig(ResourceServerTokenServices tokenServices, TokenStore tokenStore) {
        this.tokenServices = tokenServices;
        this.tokenStore = tokenStore;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources)
            throws Exception
    {
        resources.resourceId(resourceIds).tokenServices(tokenServices).tokenStore(tokenStore);
    }

    @Override
    public void configure(HttpSecurity http)
            throws Exception
    {
        http.requestMatchers().and().authorizeRequests()
                .antMatchers("/user/**", "/api-docs/**","/oauth/token","/customer/account-register")
                .permitAll()
                .antMatchers("/**")
                .authenticated();
    }

}
