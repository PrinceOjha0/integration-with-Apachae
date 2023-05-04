package com.credex.CredCoin.Response;

public class Response {
 private String	 _class;
 private String type;
 private String username;
 private String  realm;
public String get_class() {
	return _class;
}
public void set_class(String _class) {
	this._class = _class;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getRealm() {
	return realm;
}
public void setRealm(String realm) {
	this.realm = realm;
}
@Override
public String toString() {
	return "Response [_class=" + _class + ", type=" + type + ", username=" + username + ", realm=" + realm + "]";
}
 
}
