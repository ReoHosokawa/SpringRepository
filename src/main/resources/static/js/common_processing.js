
/**
 * 共通処理クラス
 */
class CommonProcessing {

    /**
     * 指定された要素に設定されている値から税込価格を算出する
     * @param {HTMLInputElement} $price 対象の価格入力用 input 要素
     * @param {HTMLInputElement} $taxRate 対象の税率入力用 input 要素
     * @returns {number}
     */
    static calculatePriceWithTax($price, $taxRate) {
        if ($taxRate.value === "") {
			return 0;
		}
		if ($price.value === "") {
			return 0;
		}
		
		const price = Number($price.value);
		const taxRate = Number($taxRate.value);
		const tax = CommonProcessing.roundUp(price * (taxRate / 100));
		
		return price + tax;
    }

    /**
     * 指定された値を指定された桁数で四捨五入する
     * @param {number} targetValue 四捨五入する値
     * @param {number} length 四捨五入する桁数
     * @returns {number}
     */
    static round(targetValue, length = 0) {
        const magnification = 10 ** length;
        return Math.round(targetValue * magnification) / magnification;
    }

    /**
     * 指定された値を指定された桁数で切り上げる
     * @param {number} targetValue 切り上げ対象の値
     * @param {number} length 切り上げ位置
     * @returns {number}
     */
    static roundUp(targetValue, length = 0) {
        const magnification = 10 ** length;
        return Math.ceil(targetValue * magnification) / magnification;
    }

    /**
     * 指定された値を指定された桁数で切り捨てる
     * @param {number} targetValue 切り捨て対象の値
     * @param {number} length 切り捨て位置
     * @returns {number}
     */
    static roundDown(targetValue, length = 0) {
        const magnification = 10 ** length;
        return Math.floor(targetValue * magnification) / magnification;
    }
}