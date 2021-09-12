package com.hospital_management.hospital.Web;

import com.hospital_management.hospital.Security.JwtAuthenticationEntryPoint;
import com.hospital_management.hospital.Security.JwtFilter;
import com.hospital_management.hospital.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private DiseaseService diseaseService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Bean
    public JwtFilter jwtFilter(){
        return new JwtFilter();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.cors();
        http.csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler);
        http.authorizeRequests()
                .antMatchers("/user/create","/user/login")
                .permitAll().anyRequest().authenticated().and().formLogin().permitAll();

        http.addFilterBefore(jwtFilter(),UsernamePasswordAuthenticationFilter.class);


    }

}