/*
 * Cloud Foundry 2012.02.03 Beta
 * Copyright (c) [2009-2012] VMware, Inc. All Rights Reserved.
 *
 * This product is licensed to you under the Apache License, Version 2.0 (the "License").
 * You may not use this product except in compliance with the License.
 *
 * This product includes a number of subcomponents with
 * separate copyright notices and license terms. Your use of these
 * subcomponents is subject to the terms and conditions of the
 * subcomponent's license, as noted in the LICENSE file.
 */

package org.cloudfoundry.identity.uaa.oauth;

import java.util.LinkedHashMap;
import java.util.Map;

import org.cloudfoundry.identity.uaa.authentication.UaaPrincipal;
import org.cloudfoundry.identity.uaa.openid.UserInfo;
import org.springframework.security.core.Authentication;

/**
 * @author Dave Syer
 * 
 */
public class UaaUserTokenConverter implements UserTokenConverter {

	@Override
	public Map<String, ?> convertUserAuthentication(Authentication authentication) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		if (authentication.getPrincipal() instanceof UaaPrincipal) {
			UaaPrincipal principal = (UaaPrincipal) authentication.getPrincipal();
			response.put(UserInfo.USER_ID, principal.getId());
			response.put(UserInfo.USER_NAME, principal.getName());
			response.put(UserInfo.EMAIL, principal.getEmail());
		}
		return response;
	}

}
