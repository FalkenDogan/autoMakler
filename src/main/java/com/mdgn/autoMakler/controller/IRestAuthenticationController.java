package com.mdgn.autoMakler.controller;

import com.mdgn.autoMakler.dto.AuthRequest;
import com.mdgn.autoMakler.dto.AuthResponse;
import com.mdgn.autoMakler.dto.DtoUser;
import com.mdgn.autoMakler.dto.RefreshTokenRequest;

public interface IRestAuthenticationController {
	public RootEntity<DtoUser> register(AuthRequest input);
	
	public RootEntity<AuthResponse> authenticate(AuthRequest input);
	
	public RootEntity<AuthResponse> refreshToken(RefreshTokenRequest input);
	
}
