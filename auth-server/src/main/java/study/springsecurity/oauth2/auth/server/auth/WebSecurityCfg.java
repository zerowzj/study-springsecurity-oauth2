package study.springsecurity.oauth2.auth.server.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class WebSecurityCfg extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * （★）HTTP请求安全
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/oauth/**")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//        ;
//        http.requestMatchers()
//                .anyRequest()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/oauth/**")
//                .permitAll();
    }

    /**
     * （★）WEB安全
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
    }

    /**
     * （★）认证管理器
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance()) //密码编码器
        ;
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        AuthenticationManager manager = super.authenticationManager();
        return manager;
    }
}
