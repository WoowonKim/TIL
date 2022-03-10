let todolist = localStorage.getItem("kwwtodo");
if (todolist == null) {
  todolist = {
    todos: []
  };
  localStorage.setItem("kwwtodo", JSON.stringify(todolist))
}
else {
  todolist = JSON.parse(todolist)
  makeTable(todolist.todos)
}

let registBtn = document.getElementById("registBtn")
registBtn.addEventListener("click", () => {
  let contentEle = document.getElementById("content")
  if (content.value == ""){
    alert("내용을 입력하세요")
    contentEle.focus()
  }
  else{
    todolist.todos.push({
      todo: contentEle.value
    })
    localStorage.setItem("kwwtodo", JSON.stringify(todolist))
    makeTable(todolist.todos)
  }
  contentEle.value = ""
})

function makeTable (todos) {
  let todoTbody = document.getElementById("todoTbody")
  html = ""
  for (let i = todos.length -1; i >= 0; i--) {
    html += `
    <tr>
    <td><input type="checkbox" ></td>
    <td id="todoIndex${i}">${todos[i].todo}</td>
    <td><button onclick="deletetodo(${i})">삭제</button></td>
    </tr>
    `
  }
  todoTbody.innerHTML = html;
}

function deletetodo(i){
  todolist.todos.splice(i,1)
  localStorage.setItem("kwwtodo", JSON.stringify(todolist))
  makeTable(todolist.todos)
}

