package com.example.demo.domain;

/**
 * ベンダーマスタクラス
 * @author User
 *
 */
public class MasterVendor {
	
	/**
	 * ベンダー ID
	 */
	private Long id;
	
	/**
	 * ベンダー名
	 */
	private String name;
	
	/**
	 * ベンダー ID を取得する
	 * @return ベンダー ID
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * ベンダー ID をプロパティに設定する
	 * @param id 設定するベンダー ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * ベンダー名を取得する
	 * @return ベンダー名
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * ベンダー名をプロパティに設定する
	 * @param name 設定するベンダー名
	 */
	public void setName(String name) {
		this.name = name;
	}
}
