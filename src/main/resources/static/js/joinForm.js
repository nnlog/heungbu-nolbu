function formCheck(){
    let form = document.joinForm;
    // 유효성 검사
    if(form.userName.value == ""){
        alert('이름을 입력하세요.');
        form.userName.focus();
        return;
    }
    if(form.userEmail.value == ""){
        alert('이메일을 입력하세요.');
        form.userEmail.focus();
        return;
    }
    if(form.userPw.value == ""){
        alert('비밀번호를 입력하세요.');
        form.userPw.focus();
        return;
    }
    if(form.userPw.value.length<10 || form.userPw.value.length>16){
        alert('비밀번호는 10~16자 사이로 입력하세요.');
        form.userPw.focus();
        return;
    }
    if(form.pwdCheck.value == ""){
        alert('비밀번호 확인을 입력하세요.');
        form.pwdCheck.focus();
        return;
    }
    if(form.userPw.value != form.pwdCheck.value){
        alert('비밀번호를 일치시켜 주세요.');
        form.pwdCheck.focus();
        return;
    }
    if(form.userPhone.value == ""){
        alert('휴대폰 번호를 입력하세요.');
        form.userPhone.focus();
        return;
    }
    if(form.userAdress.value == ""){
        alert('주소를 입력하세요.');
        form.userAdress.focus();
        return;
    }
    if(form.userJob.value == ""){
        alert('직업을 입력하세요.');
        form.userJob.focus();
        return;
    }
    if(confirm('입력하신 내용이 맞습니까?')){
        alert('회원가입이 성공하였습니다!')
        form.submit();
    }

}
