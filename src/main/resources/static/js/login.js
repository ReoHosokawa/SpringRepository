
/**
 * 初回読み込み時に実行される関数
 */
const appInit = () => {
    /** @type {HTMLSpanElement} */
    const $buttonEye = document.getElementById("buttonEye");

    $buttonEye.addEventListener("click", () => {
        /** @type {HTMLInputElement} */
        const $password = document.getElementById("password");
        const isPassword = $password.type === "password";
        $password.type = isPassword ? "text" : "password";
        $buttonEye.className = isPassword ? "fa fa-eye-slash" : "fa fa-eye";
    });
}


window.onload = appInit;