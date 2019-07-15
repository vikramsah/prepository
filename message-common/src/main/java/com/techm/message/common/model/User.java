package com.techm.message.common.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5034185671577973180L;
	private String userName;
	private String id;
	private String gender;
	private String contact;
}
