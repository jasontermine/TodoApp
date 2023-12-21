import { useNavigate } from "react-router-dom";
import { createContent, deleteContent } from "../functions/alterContent";
import { getAdminContent } from "../functions/getContent";
import {
  MDBBtn,
  MDBModal,
  MDBModalDialog,
  MDBModalContent,
  MDBModalHeader,
  MDBModalTitle,
  MDBModalBody,
  MDBModalFooter,
  MDBRow,
  MDBInput,
} from "mdb-react-ui-kit";
import { useState } from "react";

/**
 * Lädt den privaten Inhalt und gibt ihn als Datenobjekt zurück.
 * @returns {Promise<{ data: Array }>} Das Datenobjekt mit dem privaten Inhalt.
 */
export async function loader() {
  const data = await getAdminContent();
  return { data };
}

/**
 * Komponente für die Admin-Seite.
 * Diese Komponente ermöglicht das Erstellen und Löschen von Todos.
 */
export default function Admin() {
  // Zustandsvariablen
  const [name, setName] = useState("");
  const [message, setMessage] = useState("");
  const [id, setStatusId] = useState();

  const navigate = useNavigate();

  const [basicModal, setBasicModal] = useState(false);
  const [basicModal2, setBasicModal2] = useState(false);

  /**
   * Funktion zum Erstellen eines Todos.
   * @param {Event} e - Das Formular-Ereignis.
   */
  const handleSubmitCreate = (e) => {
    e.preventDefault(); // verhindert das standardmässige Absenden des Formulars

    createContent(name, message, id) // AJAX call ans Backend
      .then(() => {
        // Erfolg
        navigate("/private");
      });
  };

  /**
   * Funktion zum Löschen eines Todos.
   * @param {Event} e - Das Formular-Ereignis.
   */
  const handleSubmitDelete = (e) => {
    e.preventDefault(); // verhindert das standardmässige Absenden des Formulars

    deleteContent(id) // AJAX call ans Backend
      .then(() => {
        // Erfolg
        navigate("/private");
      });
  };

  /**
   * Funktion zum Aktualisieren des Namens.
   * @param {Event} e - Das Änderungsereignis.
   */
  const onChangeName = (e) => {
    setName(e.target.value);
  };

  /**
   * Funktion zum Aktualisieren der Nachricht.
   * @param {Event} e - Das Änderungsereignis.
   */
  const onChangeMessage = (e) => {
    setMessage(e.target.value);
  };

  /**
   * Funktion zum Aktualisieren der Status-ID.
   * @param {Event} e - Das Änderungsereignis.
   */
  const onChangeStatusId = (e) => {
    setStatusId(e.target.value);
  };

  /**
   * Funktion zum Öffnen/Schliessen des Modals zum Erstellen eines Todos.
   */
  const toggleOpen = () => setBasicModal(!basicModal);

  /**
   * Funktion zum Öffnen/Schliessen des Modals zum Löschen eines Todos.
   */
  const toggleOpen2 = () => setBasicModal2(!basicModal2);

  return (
    <>
      <div className="position-absolute start-50 top-50" style={{ marginLeft: "-12rem", marginTop: "-13rem"}}>
        <MDBBtn onClick={toggleOpen}>Todo Erstellen</MDBBtn>
        <MDBBtn className="ms-3" onClick={toggleOpen2}>Todo löschen</MDBBtn>
      </div>

      {/* Modal 1 For POST */}
      <MDBModal open={basicModal} setOpen={setBasicModal} tabIndex="-1">
        <MDBModalDialog>
          <MDBModalContent>
            <MDBModalHeader>
              <MDBModalTitle>Todo Erstellen</MDBModalTitle>
            </MDBModalHeader>
            <MDBModalBody>
              <MDBRow
                tag="form"
                className="form-control "
                noValidate
                onSubmit={handleSubmitCreate}
              >
                <MDBInput
                  label="Name"
                  className="form-control mt-4 mb-5"
                  onChange={onChangeName}
                  value={name}
                  required
                />
                <MDBInput
                  label="Message"
                  className="form-control  mb-5"
                  onChange={onChangeMessage}
                  value={message}
                  required
                />
                <MDBInput
                  label="Status (1 = Offen, 2 = In Bearbeitung, 3 = Abgeschlossen)"
                  className="form-control mb-4"
                  onChange={onChangeStatusId}
                  value={id}
                  required
                />
              </MDBRow>
            </MDBModalBody>
            <MDBModalFooter>
              <MDBBtn color="secondary" onClick={toggleOpen}>
                Close
              </MDBBtn>
              <MDBBtn onClick={handleSubmitCreate}>Erstellen</MDBBtn>
            </MDBModalFooter>
          </MDBModalContent>
        </MDBModalDialog>
      </MDBModal>

      {/* Modal 2 For DELETE */}
      <MDBModal open={basicModal2} setOpen={setBasicModal2} tabIndex="-2">
        <MDBModalDialog>
          <MDBModalContent>
            <MDBModalHeader>
              <MDBModalTitle>Todo Löschen</MDBModalTitle>
            </MDBModalHeader>
            <MDBModalBody>
              <MDBRow
                tag="form"
                className="form-control"
                noValidate
                onSubmit={handleSubmitDelete}
              >
                <MDBInput
                  label="Id"
                  onChange={onChangeStatusId}
                  className="mb-4 mt-4"
                  value={id}
                  required
                />
              </MDBRow>
            </MDBModalBody>
            <MDBModalFooter>
              <MDBBtn color="secondary" onClick={toggleOpen2}>
                Close
              </MDBBtn>
              <MDBBtn onClick={handleSubmitDelete}>Löschen</MDBBtn>
            </MDBModalFooter>
          </MDBModalContent>
        </MDBModalDialog>
      </MDBModal>
    </>
  );
}
