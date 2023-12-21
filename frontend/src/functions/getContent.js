import axios from "axios";

const client = axios.create({
  baseURL: "http://localhost:8080",
});

/**
 * Ruft öffentliche Inhalte ab.
 * @returns {Promise<Array>} Ein Array mit den abgerufenen Daten.
 */
export async function getPublicContent() {
  let data = [];
  await client.get("/public", { mode: "cors" }).then((response) => {
    data = response.data;
  });
  return data;
}

/**
 * Ruft private Inhalte ab.
 * @returns {Promise<Array>} Ein Array mit den abgerufenen Daten.
 */
export async function getPrivateContent() {
  let data = [];

  const token = JSON.parse(localStorage.getItem("user")).accessToken;

  await client.get("/private/todos", { headers: {"Authorization": `Bearer ${token}`, mode: "cors" } }).then((response) => {
    data = response.data;
  });
  return data;
}

/**
 * Ruft admin Inhalte ab.
 * @returns {Promise<Array>} Ein Array mit den abgerufenen Daten.
 */
export async function getAdminContent() {
  let data = [];

  const token = JSON.parse(localStorage.getItem("user")).accessToken;

  await client.get("/admin/todos", { headers: {"Authorization": `Bearer ${token}`, mode: "cors" } }).then((response) => {
    data = response.data;
  });
  return data;
}
