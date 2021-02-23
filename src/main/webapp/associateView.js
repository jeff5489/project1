let formSubmit = document.getElementById("formSubmit")
formSubmit.addEventListener("click", submitForm)

function submitForm(){

    console.log("submitForm js file reached")
    let employeeId = document.getElementById("employeeId").value
    let firstName = document.getElementById("firstName").value
    let lastName = document.getElementById("lastName").value

    let courseTypeRadios = document.querySelectorAll('input[name="courseType"]');
    let courseType;
            for (const rb of courseTypeRadios) {
                if (rb.checked) {
                    courseType = rb.value;
                    break;
                }
            }     
    // type of course radio buttons
    let locationState = document.getElementById("locationState").value
    let locationCity = document.getElementById("locationCity").value
    let description = document.getElementById("description").value
    let justification = document.getElementById("justification").value
    let startDate = document.getElementById("startDate").value
    let endDate = document.getElementById("endDate").value
    let cost = document.getElementById("cost").value
    // grading format radio buttons
    
    let gradingFormatRadios = document.querySelectorAll('input[name="gradingFormat"]');
    let gradingFormat;
            for (const rb of gradingFormatRadios) {
                if (rb.checked) {
                    gradingFormat = rb.value;
                    break;
                }
            }  
    let passingGrade = document.getElementById("passingGrade").value   

    let formInfo = {
        "employeeId" : employeeId,
        "firstName" : firstName,
        "lastName" : lastName,
        "courseType": courseType,
        "locationState" : locationState,
        "locationCity" : locationCity,
        "description" : description,
        "justification" : justification,
        "startDate" : startDate,
        "endDate" : endDate,
        "cost" : cost,
        "gradingFormat": gradingFormat,
        "passingGrade" : passingGrade
    }

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            //Step 4.5 - This will execute with a successfully completed request.

            // let response = JSON.parse(this.responseText)
            console.log("response: " + this.responseText);
        }
    }

    let url = "http://localhost:8080/project1-3/FormController"
    //Step 3
    xhttp.open("POST", url, true);
    xhttp.setRequestHeader('Content-Type','application/json');

    //Step 4
    xhttp.send(JSON.stringify(formInfo));

    // console.log(JSON.stringify(formInfo))
}

let fundsButton = document.getElementById("checkFundsSubmit")
fundsButton.addEventListener("click", checkFunds)

function checkFunds(){
    let employeeId = document.getElementById("fundsId").value

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            response = this.responseText
            console.log(response)

            let fundAmountHere = document.getElementById("fundAmountHere")
            fundAmountHere.innerHTML = response
        }
    }
    let url = "http://localhost:8080/project1-3/FundController?employeeId=" + employeeId
    xhttp.open("GET", url, true);
    xhttp.send();
}

