
let viewAllRequestsButton = document.getElementById("viewAllRequests")
viewAllRequestsButton.addEventListener("click", getAllRequestsAndEvents)

function getAllRequestsAndEvents(){
    let xhttp = new XMLHttpRequest();

    requestResponse = null
    eventResonse = null
    requestResponseNoParse = []
    eventResonseNoParse = []

    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            requestResponse = JSON.parse(this.responseText)
            requestResponseNoParse = this.responseText
            console.log("requestResponseNoParse: " + requestResponseNoParse)

            // let counter = 0
            // requestResponse.forEach( () => {
            //     createRequestDivs(requestResponse, counter)
            //     counter++
            // });
        }
    }
    let url = "http://localhost:8080/project1-3/RequestController"
    xhttp.open("GET", url, true);
    xhttp.send();

    let xhttp2 = new XMLHttpRequest();

    xhttp2.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            // eventResponse = JSON.parse(this.responseText)
            eventResponseNoParse = this.responseText
            console.log("eventResponseNoParse: "+eventResponseNoParse)
            // console.log("eventResponse: "+eventResponse)

            // createRequestEventDivs(requestResponseNoParse, eventResponseNoParse)
            // a;sldkfja;lkdfjl;askdjfa;lskdjjfjsa
            //;alsdkjf;lasdkjfl;aksdjf
            dumpData(requestResponseNoParse, eventResponseNoParse)
        }
    }
    let url2 = "http://localhost:8080/project1-3/EventController"
    xhttp2.open("GET", url2, true);
    xhttp2.send();
}

function dumpData(requestResponseNoParse, eventResponseNoParse){
    let requestDiv = document.createElement('div')
    requestDiv.innerHTML = requestResponseNoParse
    let eventDiv = document.createElement('div')
    eventDiv.innerHTML = eventResponseNoParse
    let divForRequests = document.getElementById("divForRequests")
    let divForEvents = document.getElementById("divForEvents")
    divForEvents.appendChild(eventDiv)
    divForRequests.appendChild(requestDiv)
    
}

function createRequestEventDivs(requestResponseNoParse, eventResponseNoParse){
    console.log("createRequestEventDivs reached")
    // let number = requestResponse.length
    let div = document.createElement('div')
    let requestDiv = document.createElement('div')
    let eventDiv = document.createElement('div')
    let divForResponse = document.getElementById("divForResponse")

    for(let i = 0; i < requestResponseNoParse.length; i++){
        console.log("requestResponseNoParse[i]: "+requestResponseNoParse[i])
        console.log("eventResponseNoParse[i]: "+eventResponseNoParse[i])
        requestDiv.innerHTML = requestResponseNoParse[i]
        eventDiv.innerHTML = eventResponseNoParse[i]
        div.appendChild(requestDiv)
        div.appendChild(eventDiv)
        divForResponse.appendChild(div)
    }

}

function createRequestDivs(response, requestIndex){
    console.log("createRequestDivs reached")

    let requestDiv = document.createElement('div')
    // div.id = response["id"]
    // div.innerHTML = "response[requestIndex] below"
    requestDiv.innerHTML = JSON.stringify(response[requestIndex])

    let eventDiv = document.createElement('div')
    eventDiv.innerHTML = JSON.stringify(response[requestIndex])

    // let approveButton = document.createElement('button')
    // approveButton.textContent = "Approve"
    // div.appendChild(approveButton)

    // let textArea = document.createElement('textarea')
    // div.appendChild(textArea)

    // let addMessageButton = document.createElement('button')
    // addMessageButton.textContent = "Add Message"
    // div.appendChild(addMessageButton)

    // let denyButton = document.createElement('button')
    // denyButton.textContent = "Deny"
    // div.appendChild(denyButton)

    let hr = document.createElement('hr')
    div.appendChild(hr)

    divForRequests.appendChild(div)
}

let approveButton = document.getElementById("approveSubmit")
approveButton.addEventListener("click", approve)

function approve(){
    console.log("Approved button clicked")
    let requestIdApproved = document.getElementById("requestIdApproved").value
    console.log("requestIdApproved: " + requestIdApproved)

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            let response = JSON.parse(this.responseText)
            console.log(response)
        }
    }
    let url = "http://localhost:8080/project1-3/RequestApprover?requestIdApproved=" + requestIdApproved
    xhttp.open("POST", url, true);
    xhttp.send();
}

let denyButton = document.getElementById("denySubmit")
denyButton.addEventListener("click", deny)

function deny(){
    console.log("Deny button clicked")
    let requestIdDenied = document.getElementById("requestIdDenied").value
    console.log("requestIdDenied: " + requestIdDenied)

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            let response = JSON.parse(this.responseText)
            console.log(response)
        }
    }
    let url = "http://localhost:8080/project1-3/RequestDenier?requestIdDenied=" + requestIdDenied
    xhttp.open("POST", url, true);
    xhttp.send();
}

let messageButton = document.getElementById("messageSubmit")
messageButton.addEventListener("click", addMessage)

function addMessage(){

    console.log("message button clicked")
    let body = document.getElementById("message").value
    let requestId = document.getElementById("requestIdOfMessage").value
    
    console.log("requestId: " + requestId)
    console.log("body: " + body)
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            let response = this.responseText
            console.log(response)
            // erasee me
        }
    }
    // let url = "http://localhost:8080/project1-3/AddMessageController?message=" + message
    let url = "http://localhost:8080/project1-3/AddMessageController?body=" + body +"&requestId=" + requestId
    xhttp.open("POST", url, true);
    // xhttp.setRequestHeader('Content-Type','application/json');
    xhttp.send();
}

let getMessagesButton = document.getElementById("viewAllMessages")
getMessagesButton.addEventListener("click", viewAllMessages)

function viewAllMessages(){
    console.log("view all messages reached")
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            let response = this.responseText
            console.log(response)
            console.log(JSON.parse(this.responseText))

            document.getElementById("messagesHere").innerHTML = this.responseText
        }
    }

    let url = "http://localhost:8080/project1-3/GetMessagesController"
    xhttp.open("GET", url, true);
    xhttp.send();

}