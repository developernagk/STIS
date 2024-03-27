// https://developers.kakao.com/
function onKakaoSingUpClickHandler (event) {
  window.location.href = 'https://developers.kakao.com/';
}
const kakaoSingUpLinkElement = document.getElementById('kakao-sign-in-link');
kakaoSingUpLinkElement.addEventListener('click', onKakaoSingUpClickHandler);

// https://developers.naver.com/main/
function onNaverSingUpClickHandler (event) {
  window.location.href = 'https://developers.naver.com/main/';
}
const naverSingUpLinkElement = document.getElementById('naver-sign-in-link');
naverSingUpLinkElement.addEventListener('click', onNaverSingUpClickHandler);