package vn.techmaster.simpleauthen.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  // @Override
  // protected void configure(HttpSecurity http) throws Exception {
  // http.httpBasic();
  // http
  // .authorizeRequests()
  // .antMatchers("/api/products").hasAnyRole(Role.USER, Role.OPERATOR,
  // Role.ADMIN)
  // .antMatchers("/api/backoffice").hasAnyRole(Role.OPERATOR, Role.ADMIN)
  // .antMatchers("/api/secret").hasRole(Role.ADMIN)
  // .antMatchers("/**").permitAll();
  // }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers("/api/products").hasAnyRole(Role.USER, Role.OPERATOR, Role.ADMIN)
        .antMatchers("/api/backoffice").hasAnyRole(Role.OPERATOR, Role.ADMIN)
        .antMatchers("/api/secret").hasRole(Role.ADMIN)
        .anyRequest().authenticated() // T???t c??? c??c request kh??c ?????u c???n ph???i x??c th???c m???i ???????c truy c???p
        .and()
        .formLogin() // Cho ph??p ng?????i d??ng x??c th???c b???ng form login
        .defaultSuccessUrl("/api/products")
        .permitAll() // T???t c??? ?????u ???????c truy c???p v??o ?????a ch??? n??y
        .and()
        .logout() // Cho ph??p logout
        .permitAll();
  }

  public static PasswordEncoder delegatePasswordEncoder(String encodingType) {
    Map<String, PasswordEncoder> encoders = new HashMap<>();
    encoders.put("bcrypt", new BCryptPasswordEncoder());
    encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
    encoders.put("scrypt", new SCryptPasswordEncoder());

    return new DelegatingPasswordEncoder(encodingType, encoders);
  }

  @Bean
  public PasswordEncoder encoder() {
    return SecurityConfig.delegatePasswordEncoder("pbkdf2");
  }

  @Bean
  public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
    Collection<UserDetails> users = new ArrayList<>();
    UserBuilder userBuilder = User.builder().passwordEncoder(encoder()::encode);
    var tom = userBuilder.username("tom@gmail.com").password("123").roles(Role.USER).build();
    var bob = userBuilder.username("bob@gmail.com").password("123").roles(Role.USER).build();
    var alice = userBuilder.username("alice@gmail.com").password("123").roles(Role.USER).build();

    var operator = userBuilder.username("operator@gmail.com").password("123").roles(Role.OPERATOR).build();
    var boss = userBuilder.username("boss@gmail.com").password("123").roles(Role.ADMIN, Role.USER).build();

    users.add(tom);
    users.add(bob);
    users.add(alice);
    users.add(operator);
    users.add(boss);

    return new InMemoryUserDetailsManager(users);
  }

}
