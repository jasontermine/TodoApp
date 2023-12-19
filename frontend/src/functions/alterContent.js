import axios from "axios";

const client = axios.create({
  baseURL: "http://localhost:8080",
});

/**
 * Löscht ein Todo mit der angegebenen ID.
 * 
 * @param {number} id - Die ID des Inhalts, der gelöscht werden soll.
 * @returns {Promise<void>} - Ein Promise, das keinen Wert zurückgibt.
 */
export async function deleteContent(id) {

  const token = JSON.parse(localStorage.getItem("user")).accessToken;

  await client
    .delete(`/admin/todos/delete/${id}`, {
      headers: { Authorization: `Bearer ${token}`, mode: "cors" },
    })
    .catch((error) => {
      console.log("Ein Fehler ist aufgetreten: " + error);
    });
}

/**
 * Erstellt einen neuen Todo mit dem angegebenen Namen, der Nachricht und der ID.
 * 
 * @param {string} name - Der Name des Inhalts.
 * @param {string} message - Die Nachricht des Inhalts.
 * @param {number} id - Die ID des Status.
 * @returns {Promise<void>} - Ein Promise, das keinen Wert zurückgibt.
 */
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
