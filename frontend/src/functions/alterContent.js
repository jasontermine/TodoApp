import axios from "axios";

const client = axios.create({
  baseURL: "http://localhost:8080",
});

export async function deleteContent(id) {
  let data = [];

  const token = JSON.parse(localStorage.getItem("user")).accessToken;

  await client
    .post(`/admin/todos/delete/${id}`, {
      headers: { Authorization: `Bearer ${token}`, mode: "cors" },
    })
    .then((response) => {
      data = response.data;
    })
    .catch((error) => {
      console.log("Ein Fehler ist aufgetreten: " + error);
    });
  return data;
}

export async function createContent(name, message, id) {

  const token = JSON.parse(localStorage.getItem("user")).accessToken;

  const body = {
    "name": name,
    "message": message,
    "status": {
      "id": id
    }
  }

  await client
    .post("/admin/todos/create", body, {
      headers: { Authorization: `Bearer ${token}`, mode: "cors" }
    })
    .catch((error) => {
      console.log("Ein Fehler ist aufgetreten: " + error);
    });
}
