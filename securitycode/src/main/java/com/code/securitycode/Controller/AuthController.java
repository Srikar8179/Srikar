package com.code.securitycode.Controller;
	import com.example.jwt.dto.JwtRequest;
	import com.example.jwt.dto.JwtResponse;
	import com.example.jwt.service.JwtTokenUtil;
	import com.example.jwt.service.JwtUserDetailsService;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.security.authentication.AuthenticationManager;
	import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
	import org.springframework.security.core.userdetails.UserDetails;
	import org.springframework.security.core.userdetails.UsernameNotFoundException;
	import org.springframework.web.bind.annotation.*;

	@RestController
	public class AuthController {

	    @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private JwtTokenUtil jwtTokenUtil;

	    @Autowired
	    private JwtUserDetailsService userDetailsService;

	    @PostMapping("/authenticate")
	    public JwtResponse createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

	        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

	        final UserDetails userDetails = userDetailsService
	                .loadUserByUsername(authenticationRequest.getUsername());

	        final String token = jwtTokenUtil.generateToken(userDetails);

	        return new JwtResponse(token);
	    }

	    private void authenticate(String username, String password) throws Exception {
	        try {
	            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	        } catch (UsernameNotFoundException e) {
	            throw new Exception("USER_NOT_FOUND", e);
	        }
	    }
	}

}
