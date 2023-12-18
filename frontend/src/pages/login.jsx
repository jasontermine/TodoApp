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
  const onChangeUsername = (e) => {
    setUsername(e.target.value);
  };

  // for password
  const onChangePassword = (e) => {
    setPassword(e.target.value);
  };

  return (
    <>
    <h1 style={{ top: "0", position: "absolute", marginLeft: "-6rem"}} className="start-50">Login</h1>
      <MDBValidation
        onSubmit={handleSubmit}
        className="w-75 h-75 position-absolute top-50 start-50 translate-middle"
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
              onChange={onChangePassword}
              id="validationCustom02"
              required
              label="Password"
            />
          </MDBValidationItem>
          <div
            className="position-absolute start-50"
            style={{ marginLeft: "-11rem" }}
          >
            <MDBBtn className="" type="submit" onClick={handleSubmit}>
              Submit form
            </MDBBtn>
            <MDBBtn className="ms-5" type="reset">
              Reset form
            </MDBBtn>
          </div>
        </div>
      </MDBValidation>
    </>
  );

  /* return (
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
  ); */
}
