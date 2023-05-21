package com.example.demo.common;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 共通処理クラス
 * @author User
 *
 */
public class CommonProcessing {

	/**
	 * 任意の数値を指定桁数で四捨五入する
	 * @param value 四捨五入する値
	 * @param length 四捨五入する桁数
	 * @return 四捨五入された値
	 */
	public static double round(final double value, final int length) {
		final String valueString = Double.toString(value);
		final BigDecimal bd = new BigDecimal(valueString);
		return bd.setScale(length, RoundingMode.HALF_UP).doubleValue();
	}
	
	/**
	 * 任意の数値を指定桁数で切り上げる
	 * @param value 切り上げ対象の値
	 * @param length 切り上げする桁数
	 * @return 切り上げ後の値
	 */
	public static double roundUp(final double value, final int length) {
		final String valueString = Double.toString(value);
		final BigDecimal bd = new BigDecimal(valueString);
		return bd.setScale(length, RoundingMode.UP).doubleValue();
	}
	
	/**
	 * 任意の数値を指定桁数で切り捨てる
	 * @param value 切り捨て対象の値
	 * @param length　切り捨てる桁数
	 * @return　切り捨て後の値
	 */
	public static double roundDown(final double value, final int length) {
		final String valueString = Double.toString(value);
		final BigDecimal bd = new BigDecimal(valueString);
		return bd.setScale(length, RoundingMode.DOWN).doubleValue();
	}
}
