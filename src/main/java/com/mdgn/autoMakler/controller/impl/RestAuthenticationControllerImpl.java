package com.mdgn.autoMakler.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mdgn.autoMakler.controller.IRestAuthenticationController;
import com.mdgn.autoMakler.controller.RestBaseController;
import com.mdgn.autoMakler.controller.RootEntity;
import com.mdgn.autoMakler.dto.AuthRequest;
import com.mdgn.autoMakler.dto.AuthResponse;
import com.mdgn.autoMakler.dto.DtoUser;
import com.mdgn.autoMakler.dto.RefreshTokenRequest;
import com.mdgn.autoMakler.service.IAuthenticationService;

import jakarta.validation.Valid;

@RestController
public class RestAuthenticationControllerImpl extends RestBaseController implements IRestAuthenticationController {

	@Autowired
	private IAuthenticationService authenticationService;

	@PostMapping("/register")
	@Override
	public RootEntity<DtoUser> register(@Valid @RequestBody AuthRequest input) {

		return ok(authenticationService.register(input));
	}

	@PostMapping("authenticate")
	@Override
	public RootEntity<AuthResponse> authenticate(@Valid @RequestBody AuthRequest input) {

		return ok(authenticationService.authenticate(input));	
		
	}

	@PostMapping("/refreshToken")
	@Override
	public RootEntity<AuthResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest input) {
		
		return ok(authenticationService.refreshToken(input));
	}

}