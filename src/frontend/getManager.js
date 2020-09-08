// Alli
let url = "http://localhost:8080/project1/"

document.getElementById("loginbtn").addEventListener("click", login_Function);

async function login_Function() {
    console.log("in login function");
    let userName = document.getElementById("username").value;
    let userPass = document.getElementById("password").value;

    let user = {
        username: userName,
        password: userPass
    }
    console.log(user);
    let user_response = await fetch(url + "login", {
        method: 'POST',
        body: JSON.stringify(user),
        credentials: "include"
    });
    console.log(status);

    if (user_response.status === 200) {
        console.log(user_response);
        document.getElementById("login-row").innerText = "Login Successful.";
        redirect();

    } else {
        document.getElementById("login-row").innerText = "Login Failed.";
    }
}
async function redirect() {

    let user_response = await fetch(url + "success", {
        method: 'GET',
        credentials: "include"
    });
    console.log(user_response.status);
    if (user_response.status === 200) {
        console.log(user_response);
        let data = await user_response.json();
        console.log(data);
        let id_User = data.id;
        sessionStorage.setItem("id_User", id_User);
        console.log(data.userRole.role);
        let role = data.userRole.role;

        if (role == "Employee") {
            window.location.href = "employeeSuccess.html";
        } else if (role== "Manager") {
            window.location.href = "managerSuccess.html";
        }
        
    } else {
        document.getElementById("login-row").innerText = "Login failed!";
    }
}
