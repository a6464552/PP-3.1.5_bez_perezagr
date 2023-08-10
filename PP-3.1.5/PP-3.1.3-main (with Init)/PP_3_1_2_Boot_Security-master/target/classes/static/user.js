const url = "http://localhost:8080/api/user/"

console.log("")

currentUser = fetch(url).then((response) => response.json())

// Таблица
currentUser.then((user) =>{
    let roles = "";
    user.roles.forEach((name) => {
        roles += " ";
        roles += name.role.replace("ROLE_", "");
    });

    let result = "";
    result += `<tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.age}</td>
                    <td>${roles}</td>
                   </tr>`;
    document.getElementById("user-info-table").innerHTML = result;
})