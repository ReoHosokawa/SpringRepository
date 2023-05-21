
/**
 * 初回読み込み時に実行される関数
 */
const appInit = () => {
	/** @type {HTMLInputElement} */
	const $price = document.getElementById("price");
	/** @type {HTMLInputElement} */
	const $taxRate = document.getElementById("taxRate");
	/** @type {HTMLInputElement} */
	const $priceWithTax = document.getElementById("priceWithTax");
	
	$taxRate.addEventListener("change", () => {
		const priceWithTax = CommonProcessing.calculatePriceWithTax($price, $taxRate);
		$priceWithTax.value = priceWithTax;
	});
	$price.addEventListener("change", () => {
		const priceWithTax = CommonProcessing.calculatePriceWithTax($price, $taxRate);
		$priceWithTax.value = priceWithTax;
	});
	
	$price.dispatchEvent(new Event("change"));
}


window.onload = appInit;
