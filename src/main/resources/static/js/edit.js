
/**
 * 初回読み込み時に実行される関数
 */
const appInit = () => {
	/** @type {HTMLInputElement} */
	const $price = document.getElementById("price");
	/** @type {HTMLInputElement} */
	const $taxRate = document.getElementById("tax-rate");
	/** @type {HTMLInputElement} */
	const $priceWithTax = document.getElementById("price-with-tax");
	
	$taxRate.addEventListener("change", () => {
		if ($taxRate.value === "") {
			// 要素が空のままだとエラーになるので、空の場合は 0 をセットする
			$taxRate.value = 0;
		}
		
		const priceWithTax = CommonProcessing.calculatePriceWithTax($price, $taxRate);
		$priceWithTax.value = priceWithTax;
	});
	$price.addEventListener("change", () => {
		if ($price.value === "") {
			// 要素が空のままだとエラーになるので、空の場合は 0 をセットする
			$price.value = 0;
		}
		
		const priceWithTax = CommonProcessing.calculatePriceWithTax($price, $taxRate);
		$priceWithTax.value = priceWithTax;
	});
	
	$price.dispatchEvent(new Event("change"));
}


window.onload = appInit;
