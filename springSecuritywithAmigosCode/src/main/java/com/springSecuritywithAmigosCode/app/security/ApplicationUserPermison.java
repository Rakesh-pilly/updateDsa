package com.springSecuritywithAmigosCode.app.security;

public enum ApplicationUserPermison {
	
	STUDENT_READ("student:read"),
	STUDENT_WRITE("student:write"),
	COURSE_READ("course:read"),
	COURSE_WRITE("course:write");
	
	
	private final String permission;

	ApplicationUserPermison(String string) {
	
		
		this.permission = string;
	}

	public String getPermission() {
		return permission;
	}
}
