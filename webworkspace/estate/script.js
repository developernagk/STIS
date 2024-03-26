const ID = 'userIdentity';
const PASSWORD = 'p!ssw0rd';

function onSignInButtonClickHandler (event) {
    const id = document.getElementById('id').value;
    const password = document.getElementById('password').value;

    if (id === ID && password === PASSWORD) {
        alert('로그인 성공!')
    } else {
        const signInMessageElement = document.getElementById('sign-in-message');
        signInMessageElement.textContent = '로그인 정보가 일치하지 않습니다.'
    }
}

function onSignUpLinkClickHandler (event) {
    window.location.href = 'https://google.com';
}

const signUpLinkElement = documet.getElementById('sign-up-link');
// 콜백함수로 전달된 것으로 'click' 시 호출됨
signUpLinkElement.addEventListner('click', onSignUpLinkClickHandler);

// https://developers.kakao.com/
function onKakaoSingUpClickHandler (event) {
    window.location.href = 'https://developers.kakao.com/';
}

const kakaoSingUpLinkElement = document.getElementById('kakao-sign-up-link');
kakaoSingUpLinkElement.addEventListener('click', onKakaoSingUpClickHandler);

// https://developers.naver.com/main/
function onNaverSingUpClickHandler (event) {
    window.location.href = 'https://developers.naver.com/main/';
}

const naverSingUpLinkElement = document.getElementById('naver-sign-up-link');
naverSingUpLinkElement.addEventListener('click', onNaverSingUpClickHandler);