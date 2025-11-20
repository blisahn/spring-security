package com.devblo.springsection6.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

//mentioning to say spring boot this is the authentication provider to use
@Component
@RequiredArgsConstructor
@Profile("!prod")
public class BllBankUsernamePwdAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    /**
     * @param authentication the authentication request object.
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
       /* SINCE IT'S A DEV ENVIRONMENT THERE IS NO NEED TO PWD CHECK
        if (passwordEncoder.matches(pwd, userDetails.getPassword())) {
            Fetch the age details and perform validation if age > 18
        } else {throw new BadCredentialsException("Invalid password");}
        */
        return new UsernamePasswordAuthenticationToken(username, pwd, userDetails.getAuthorities());

    }

    /**
     * @param authentication
     * @return
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
