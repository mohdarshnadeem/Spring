package com.bharath.springcloud.security.config;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.PasswordLookup;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.web.SecurityFilterChain;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

//🛠 What is This Code Doing in Simple Terms?
//
//    Loads a keystore file (.p12 or .pfx) that contains cryptographic keys.
//    Extracts the private key from the keystore.
//    Registers the key so that Spring Authorization Server can use it.
//    Creates a JWT Decoder to verify and decode JWT tokens using the key.
//    Ensures all JWTs are signed and validated properly before allowing access to secure APIs.
//
// Why is This Needed?
//
//✅ Security → Ensures that JWTs are signed with a trusted key.
//✅ Authorization Server → Helps in issuing signed JWTs for OAuth2 authentication.
//✅ Token Verification → Ensures incoming tokens are valid before granting access.

@Configuration
public class AuthorizationServiceConfiguration {

    @Autowired
    private UserDetailsService userDetailsService;

    @Value("${keyFile}")
    private String keyFile;

    @Value("${password}")
    private String password;

    @Value("${alias}")
    private String alias;
    @Value("${providerUrl}")
    private String providerUrl;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SecurityFilterChain authServersecurityFilterChain(HttpSecurity http) throws Exception {
        // Equivalent to applyDefaultSecurity(http)
        http
                .securityMatcher("/oauth2/**")  // Applies security to OAuth2 endpoints
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.ignoringRequestMatchers("/oauth2/**"))  // Disable CSRF for OAuth2 endpoints
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));  // Enable JWT-based authentication

        return http.userDetailsService(userDetailsService).formLogin(Customizer.withDefaults()).build();
    }

    @Bean
    public JwtDecoder jwtDecoder(JWKSource<SecurityContext> jwkSource){
        return OAuth2AuthorizationServerConfiguration.jwtDecoder(jwkSource);
    }

    @Bean
    public JWKSource<SecurityContext> jwkSource() throws CertificateException, KeyStoreException, IOException, NoSuchAlgorithmException {
        JWKSet jwkSet = buildJWKSet();
        return ((jwkSelector, securityContext) -> jwkSelector.select(jwkSet));
    }

    private JWKSet buildJWKSet() throws KeyStoreException, CertificateException, IOException, NoSuchAlgorithmException {
        KeyStore keyStore = KeyStore.getInstance("pkcs12");
       try(InputStream fis = this.getClass().getClassLoader().getResourceAsStream(keyFile);){
        keyStore.load(fis,alias.toCharArray());

        return JWKSet.load(keyStore, new PasswordLookup() {
            @Override
            public char[] lookupPassword(String name) {
                return password.toCharArray();
            }
        });
        }
    }

//     Why Is This Needed?
//✅ Ensures Tokens Are Trusted
//    The issuer (iss) claim in JWTs allows clients to verify where the token came from.
//✅ OAuth2 Compliance
//    OAuth2 clients (like a frontend app) use this URL to fetch authorization details.
//✅ Flexibility
//    You can change the providerUrl dynamically based on the environment (dev, prod, etc.).
    @Bean
    AuthorizationServerSettings authorizationServerSettings(){
        return AuthorizationServerSettings.builder().issuer(providerUrl).build();
    }
    @Bean
    public RegisteredClientRepository registeredClientRepository(){
        RegisteredClient registeredClient = RegisteredClient.withId("couponservice")
                .clientId("couponclientapp")
                .clientSecret(passwordEncoder.encode("9090"))
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_POST)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                .redirectUri("https://oidcdebugger.com/debug")
                .scope("read")
                .scope("write")
                .build();
        return new InMemoryRegisteredClientRepository(registeredClient);
    }
}
