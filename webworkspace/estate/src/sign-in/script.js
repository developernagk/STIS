const ID = 'userIdentity';
const PASSWORD = 'p!ssw0rd';

function onSignInButtonClickHandler (event) {
    const id = document.getElementById('id').value;
    const password = document.getElementById('password').value;

    const signInMessageElement = document.getElementById('sign-in-message');
    if (id === ID && password === PASSWORD) {
        alert('로그인 성공!')
        signInMessageElement.textContent = '';
    } else {
        signInMessageElement.textContent = '로그인 정보가 일치하지 않습니다.'
    }
}

function onSignUpLinkClickHandler (event) {
    window.location.href = '../sign-up';
}
const signUpLinkElement = documet.getElementById('sign-up-link');
// 콜백함수로 전달된 것으로 'click' 시 호출됨
signUpLinkElement.addEventListner('click', onSignUpLinkClickHandler);