visibility = false;


const list = document.getElementById("list");
var filtered = [];
var res = [];

function do_register() {
    var title = document.getElementById("title");
    var message = document.getElementById("message");
    var author = document.getElementById("author");
    const login = document.getElementById("credential").value;
    const passcode = document.getElementById("passcode").value;
    var credential = login + ":" + passcode;

    fetch('http://localhost:8080/msgs', {
        method: 'POST',
        headers: {
            'Accept': '*/*',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            title: title.value,
            msg: message.value,
            author: author.value,
            credentials: credential
        })
    });
    if (title.value.trim() || "" && msg.value.trim() || "" && author.value.trim() != "" || "" && login.trim() != "" || "" && passcode.trim() != "") {

        update({
            title: title.value,
            msg: message.value,
            author: author.value
        })
    } else {

        alert("All fields are required!")
    }
    resetForm();
}

function resetForm(title, message, author) {

    document.getElementById("title").value = "";
    document.getElementById("message").value = "";
    document.getElementById("author").value = "";
    document.getElementById("id_to_delete").value = "";
    document.getElementById("filter").value = "";
}

function update(msg) {


    res.unshift
        (msg);
    listing(res);

}
fetch('http://localhost:8080/msgs').then(response => response.json()).then(keepPromisse);

function listing(response) {

    response.sort(comparator)

    messages = response.map(msg => '<ul class="card-javan" style="background-color: #444444;"' + ` >#ID${msg.id} ${msg.frontend}
    </br>
    <div style="color: #FFFFFF;padding: 0px 10px;"> <h4 style="font: italic bold 25px, sans-serif;">${msg.title}</div>
    <div style="color: #FFFFFF;padding: 0px 20px;"> <h4 style=""><xmp>${msg.msg}</xmp></div>
    <div style="color: #FFFFFF; padding: 0px 10px;"> <h5  style="font: italic bold 25px, sans-serif;">Por: ${msg.author}</div></br></ul>`).join(" ");
    watch();
    list.innerHTML = messages;

}

function keepPromisse(promisse) {

    res = promisse;
    listing(promisse);

}

function filtering(value) {

    filtered = res.filter(msg => verifyText(msg.author, value) || verificaTexto(msg.title, value) || verificaTexto(msg.msg, value) || msg.id == value || msg.frontend == value);
    if (filtered.length == 0) {

        list.innerHTML = "<h2 style='position: relative; text-align: center; color: #FFFFFF'> Results not found! </h2>"
    } else {

        listing(filtered)
    }
}

function verifyText(text, value) {

    const temp = text.split(" ");

    let fils = temp.filter(element => element.toLowerCase() == value.toLowerCase());

    if (fils.length != 0) return true;

    return false;
}

function watch() {

    flag = document.getElementById("filter").value.trim();

    setInterval(function () {

        let field = document.getElementById("filter").value.trim();
        if (field != "" && field != flag) {
            filtering(field);
            flag = field;

        } else if (field == "" && flag != "") {
            flag = "";
            listing(res);
        }

    }, 300)


}

function do_delete() {

    const idd = document.getElementById("id_to_delete");
    const login = document.getElementById("credential").value;
    const passcode = document.getElementById("passcode").value;
    var credential = login + ":" + passcode;

    fetch('http://localhost:8080/msgs/' + idd.value, {
        method: 'DELETE',
        headers: {
            'Accept': '*/*',
            'Content-Type': 'application/json'
        },
    });

    if (login.trim() == "" || "" && passcode.trim() == "") {

        alert("Need to fill in the credential and password before deleting a message!")

    } else {

        const index = res.map(msg => msg.id).indexOf(idd.value)

        res.splice(index, 1);

        listing(res);
    }
    resetForm();
}

function comparator(val1, val2) {

    if (val1.created_at > val2.created_at) {

        return -1;
    } else if (val1.created_at < val2.created_at) {

        return 1;

    } else {

        return 0;
    }

}

function showForm() {

    let form = document.getElementById('form');

    visibility = !visibility;

    if (visibility === true) {
        form.style.display = 'block';
    } else {
        form.style.display = 'none';
    }
}

