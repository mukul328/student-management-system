const API_URL = "http://localhost:8080/student";

window.onload = () => {
    loadStudents();
};

async function loadStudents() {

    const response = await fetch(API_URL);
    const students = await response.json();

    let rows = "";

    students.forEach(student => {

        rows += `
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>${student.age}</td>

            <td>

                <button
                    class="btn btn-warning btn-sm"
                    onclick="editStudent(${student.id})">
                    Edit
                </button>

                <button
                    class="btn btn-danger btn-sm"
                    onclick="deleteStudent(${student.id})">
                    Delete
                </button>

            </td>
        </tr>
        `;
    });

    document.getElementById("studentTableBody").innerHTML = rows;
}

document
.getElementById("studentForm")
.addEventListener("submit", async function(e){

    e.preventDefault();

    const id = document.getElementById("studentId").value;

    const student = {

        name: document.getElementById("name").value,

        email: document.getElementById("email").value,

        age: parseInt(
            document.getElementById("age").value
        )
    };

    if(id){

        await fetch(`${API_URL}/${id}`,{
            method:"PUT",
            headers:{
                "Content-Type":"application/json"
            },
            body:JSON.stringify(student)
        });

    } else {

        await fetch(API_URL,{
            method:"POST",
            headers:{
                "Content-Type":"application/json"
            },
            body:JSON.stringify(student)
        });
    }

    resetForm();
    loadStudents();
});

async function editStudent(id){

    const response =
        await fetch(`${API_URL}/${id}`);

    const student =
        await response.json();

    document.getElementById("studentId").value =
        student.id;

    document.getElementById("name").value =
        student.name;

    document.getElementById("email").value =
        student.email;

    document.getElementById("age").value =
        student.age;
}

async function deleteStudent(id){

    if(!confirm("Delete Student ?"))
        return;

    await fetch(`${API_URL}/${id}`,{
        method:"DELETE"
    });

    loadStudents();
}

function resetForm(){

    document.getElementById("studentForm")
            .reset();

    document.getElementById("studentId")
            .value = "";
}