package com.example.aloha.servicesimpl;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.aloha.models.Admin;
import com.example.aloha.models.Client;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "586E3272357538782F413F4428472B4B6250655368566B597033733676397924";

    @Autowired
    private ClientServiceImpl clientService;

    @Autowired
    private AdminServiceImpl adminService;

    public String getToken(UserDetails user) {

        HashMap<String, Object> claims = new HashMap<>();

        Optional<Client> client = clientService.getClientByEmail(user.getUsername());

        if (!client.isPresent()) {
            Optional<Admin> admin = adminService.getAdminByEmail(user.getUsername());
            claims.put("id", admin.get().getId());
            claims.put("email", admin.get().getEmail());
            claims.put("name", admin.get().getName());
            claims.put("role", admin.get().getRole());
        } else {
            claims.put("id", client.get().getId());
            claims.put("email", client.get().getEmail());
            claims.put("name", client.get().getName());
            claims.put("surname", client.get().getSurname());
            claims.put("role", client.get().getRole());
            claims.put("phone", client.get().getPhone());
        }

        return getToken(claims, user);
    }

    private String getToken(Map<String, Object> extraClaims, UserDetails user) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private Claims getAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Date getExpiration(String token) {
        return getClaim(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date());
    }

}