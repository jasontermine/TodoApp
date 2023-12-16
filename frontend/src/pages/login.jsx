import { useState } from "react";
import { useNavigate } from "react-router-dom";
import AuthService from "../functions/auth.service";

export default function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault(); // verhindert das standardmässige Absenden des Formulars

    AuthService.login(username, password) // AJAX call ans Backend
      .then(() => {
        // Erfolg
        navigate("/private");
      })
      .catch((error) => {
        console.log(error.response.data.message);
      });
  };

  // for Username
  const onChangeUsername = (e) => { setUsername(e.target.value); };

  // for password
  const onChangePassword = (e) => { setPassword(e.target.value); };

  return (
    <form onSubmit={handleSubmit} method="post">
      <label>
        Username:
        <input
          value={username}
          onChange={onChangeUsername}
          name="username"
          type="text"
        />
      </label>
      <br />
      <label>
        Password:
        <input
          value={password}
          onChange={onChangePassword}
          name="password"
          type="password"
        />
      </label>
      <br />
      <button type="submit">Login</button>
    </form>
  );
}
