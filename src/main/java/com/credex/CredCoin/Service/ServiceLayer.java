package com.credex.CredCoin.Service;

import org.json.JSONObject;

@org.springframework.stereotype.Service

public interface ServiceLayer {
	public JSONObject loginapi(String username, String password)  throws Exception;
}
