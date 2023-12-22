import { useState } from "react";
import { useNavigate } from "react-router-dom";
import {
  MDBValidation,
  MDBValidationItem,
  MDBInput,
  MDBInputGroup,
  MDBBtn,
  MDBCheckbox,
} from "mdb-react-ui-kit";
import AuthService from "../functions/auth.service";

/**
 * Komponente für die Login-Seite.
 * Diese Komponente ermöglicht das einloggen.
 */
export default function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  /**
   * Funktion zum Anmelden.
   * @param {Event} e - Das Formular-Ereignis.
   */
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

  /**
   * Funktion zum Aktualisieren des Usernames.
   * @param {Event} e - Das Änderungsereignis.
   */
  const onChangeUsername = (e) => {
    setUsername(e.target.value);
  };

  /**
   * Funktion zum Aktualisieren des Passworts.
   * @param {Event} e - Das Änderungsereignis.
   */
  const onChangePassword = (e) => {
    setPassword(e.target.value);
  };

  return (
    <>
    <h1 style={{ top: "0", position: "absolute", marginLeft: "-6rem",  marginTop: "7rem"}} className="start-50">Login</h1>
      <MDBValidation
        onSubmit={handleSubmit}
        className="w-75 h-75 position-absolute top-50 start-50 translate-middle"
        style={{ marginTop: "7rem"}}
      >
        <div style={{ marginLeft: "12rem" }}>
          <MDBValidationItem className="col-md-10 mb-4">
            <MDBInput
              value={username}
              name="fname"
              onChange={onChangeUsername}
              id="validationCustom01"
              required
              label="Username"
            />
          </MDBValidationItem>
          <MDBValidationItem className="col-md-10 mb-4">
            <MDBInput
              value={password}
              name="lname"
              type="password"
              onChange={onChangePassword}
              id="validationCustom02"
              required
              label="Password"
            />
          </MDBValidationItem>
          <div
            className="position-absolute start-50"
            style={{ marginLeft: "-4.5rem" }}
          >
            <MDBBtn className="" type="submit" onClick={handleSubmit}>
              Login
            </MDBBtn>
          </div>
        </div>
      </MDBValidation>
    </>
  );
}
