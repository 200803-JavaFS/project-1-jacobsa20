// Alli
const url = "http://localhost:8080/project1/"

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
    let resp = await fetch(url + "login", {
        method: 'POST',
        body: JSON.stringify(user),
        credentials: "include"
    });
    console.log(status);

    if (resp.status === 200) {
        console.log(resp);
        document.getElementById("login-row").innerText = "Login Successful.";
        redirectPage();

    } else {
        document.getElementById("login-row").innerText = "Login Failed.";
    }
}
async function redirectPage() {

    let resp = await fetch(url + "success", {
        method: 'GET',
        credentials: "include"
    });
    console.log(resp.status);
    if (resp.status === 200) {
        console.log(resp);
        let data = await resp.json();
        console.log(data);
        console.log(data.id);
        let idUser = data.id;
        sessionStorage.setItem("idUser", idUser);
        console.log(data.User_Role.role);
        let role = data.User_Role.role;

        if (role == "Employee") {
            window.location.href = "employeeSuccess.html";
        } else if (role== "Manager") {
            window.location.href = "managerSuccess.html";
        }
        
    } else {
        document.getElementById("login-row").innerText = "Login failed!";
    }
}