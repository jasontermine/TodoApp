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
 * Komponente für die Signup-Seite.
 * Diese Komponente ermöglicht das einloggen.
 */
export default function Signup() {
  /**
   * Für die Auswahl der Rolle im <select>.
   */
  const options = [
    {value: 'user', text: 'User'},
    {value: 'admin', text: 'Admin'}
  ];
  
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [role, setRole] = useState(options[0].value);
  const navigate = useNavigate();


  /**
   * Funktion zum Registrieren.
   * @param {Event} e - Das Formular-Ereignis.
   */
  const handleSubmit = (e) => {
    e.preventDefault(); // verhindert das standardmässige Absenden des Formulars

    AuthService.register(username, password, role) // AJAX call ans Backend
      .then(() => {
        // Erfolg
        navigate("/");
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

  /**
   * Funktion zum Aktualisieren der Rolle.
   * @param {Event} e - Das Änderungsereignis.
   */
  const onChangeRole = (e) => {
    setRole(e.target.value);
  };

  return (
    <>
    <h1 style={{ top: "0", position: "absolute", marginLeft: "-6rem",  marginTop: "7rem"}} className="start-50">Signup  </h1>
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
            <select style={{ paddingLeft: "12px", height: "29px", backgroundColor: "white", color: "#696969", borderRadius: "4px", border: "1px #9FA6B2 solid"}} value={role} onChange={onChangeRole}>
              {options.map(option => (
                <option key={option.value} value={option.value}>
                  {option.text} 
                </option>
              ))}
            </select>
          <div
            className="position-absolute start-50"
            style={{ marginLeft: "-4.5rem" }}
          >
            <MDBBtn className="" type="submit" onClick={handleSubmit}>
              Signup
            </MDBBtn>
          </div>
        </div>
      </MDBValidation>
    </>
  );
}
