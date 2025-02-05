package com.mdgn.autoMakler.service;

import com.mdgn.autoMakler.dto.AuthRequest;
import com.mdgn.autoMakler.dto.AuthResponse;
import com.mdgn.autoMakler.dto.DtoUser;
import com.mdgn.autoMakler.dto.RefreshTokenRequest;

public interface IAuthenticationService {

	
	public DtoUser register(AuthRequest input);
	
	public AuthResponse authenticate(AuthRequest input);
	
	public AuthResponse refreshToken(RefreshTokenRequest input);
	
}
