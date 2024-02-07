async function view() {
    document.querySelector("#todos").innerHTML = "";
    let li = "";
    let res = await fetch("/api/todos");
    let a = await res.json();
    a.forEach((ele) => {
        if(`${ele.done}` === "true"){
            li += `<li class="completed">${ele.content}</li> <span hidden>${ele.id}</span> <span hidden>${ele.done}</span>`;
        }else li += `<li>${ele.content}</li> <span hidden>${ele.id}</span> <span hidden>${ele.done}</span>`;
    });
    document.querySelector("#todos").innerHTML += li;
}


view();


form.addEventListener("submit", async (e) => {
    e.preventDefault();
    let formData = { "content": input.value, "done": false};
    await fetch("/api/todos", {
        method: `POST`,
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(formData),
    });
    input.value = "";
    view();
});


window.oncontextmenu=function() {
    return false;
}
document.querySelector(".todos").addEventListener('mousedown', async function (event) {
    if (event.target.tagName === 'LI') {
        if (event.button === 2) {
            await fetch(`/api/todos/${event.target.nextElementSibling.innerHTML}`, {
                method: 'DELETE',
            });
        } else if (event.button === 0) {
            await fetch(`/api/todos`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({"id": event.target.nextElementSibling.innerHTML, "content": event.target.innerHTML, "done": !(JSON.parse(event.target.nextElementSibling.nextElementSibling.innerHTML))}),
            });
        }
        view();
    }
});

