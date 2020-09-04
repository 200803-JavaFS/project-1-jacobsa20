let url = 'http://localhost:8080/project1/';

document.getElementById("loginbtn").addEventListener("click",login_Function)

async function login_Function() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    console.log(username);
    let user = {
        username : username,
        password : password
    }

    let user_Response = await fetch(url+"login", {
        method: 'POST',
        body: JSON.stringify(user),
        credentials : "include"
    })

    if(user_Response.status===200){
        document.getElementById("info").innerText="Login Complete. Welcome, "+user.username;

    }else{
        document.getElementById("info").innerText="Login Failed.";
    }

}