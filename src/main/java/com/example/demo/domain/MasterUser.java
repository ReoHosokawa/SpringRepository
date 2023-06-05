package com.example.demo.domain;

import javax.validation.constraints.NotBlank;

/**
 * ユーザマスタクラス
 * @author User
 *
 */
public class MasterUser {

	/**
	 * ユーザ ID
	 */
	@NotBlank(message = "ユーザID を入力してください。")
	private String id;
	
	/**
	 * ユーザ名
	 */
	private String name;
	
	/**
	 * パスワード
	 */
	@NotBlank(message = "パスワードを入力してください。")
	private String password;
	
	/**
	 * ユーザ ID を取得する
	 * @return ユーザ ID
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * ユーザ ID を設定する
	 * @param id 設定するユーザ ID
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * ユーザ名を取得する
	 * @return ユーザ名
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * ユーザ名を設定する
	 * @param name 設定するユーザ名
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * パスワードを取得する
	 * @return パスワード
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * パスワードを設定する
	 * @param password 設定するパスワード
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
