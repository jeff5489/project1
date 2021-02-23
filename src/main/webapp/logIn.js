
let logInButton = document.getElementById("logIn")
logInButton.addEventListener("click", () => {
    //console.log("event listener reached")
    logIn()
})

function logIn(){
    console.log("logIn function reached")

    let username = document.getElementById("username").value
    let password = document.getElementById("password").value

    let xhttp = new XMLHttpRequest();

    let logInObject = {
        "username": username,
        "password": password
    }

    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            //Step 4.5 - This will execute with a successfully completed request.

            let response = JSON.parse(this.responseText)
            // console.log("this.responseText: " + this.responseText);
            // console.log("this.responseText: " + response);
            console.log("this.response.positionTitle: " + response.positionTitle);
            // console.log("this.response[\"positionTitle\"]: " + response["positionTitle"]);

            if(response.positionTitle == "Associate"){
                window.location = "//localhost:8080/project1-3/associateView.html";
            } else {
                window.location = "//localhost:8080/project1-3/approverView.html";
            }

            // if(this.responseText == "true"){
            //     window.location = "//localhost:8080/project1-2/employeePage.html";
            // }
        }
    }
    // let url2 = "http://localhost:8080/project1-2/LogInController?username=john&password=pass"
    let url = "http://localhost:8080/project1-3/LogInController?username=" + username + "&password=" + password
    //Step 3
    xhttp.open("POST", url, true);
    xhttp.setRequestHeader('Content-Type','application/json');

    //Step 4
    xhttp.send(JSON.stringify(logInObject));
    // ;salkdfja;ldjf;lkasdj
}