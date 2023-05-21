package com.example.demo.domain;

/**
 * 商品名マスタクラス
 * @author User
 *
 */
public class MasterItemName {

	/**
	 * 商品名 ID
	 */
	private Long id;
	
	/**
	 * 商品名
	 */
	private String name;
	
	/**
	 * 商品名 ID を取得する
	 * @return 商品名 ID
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * 商品名 ID をプロパティに設定する
	 * @param id 設定する商品名 ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * 商品名を取得する
	 * @return 商品名
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 商品名をプロパティに設定する
	 * @param name 設定する商品名
	 */
	public void setName(String name) {
		this.name = name;
	}
}
