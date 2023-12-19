import { useNavigate } from "react-router-dom";
import { createContent, deleteContent } from "../functions/alterContent";
import {
  MDBCard,
  MDBCardBody,
  MDBCardText,
  MDBCardTitle,
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

/* export async function loader() {
  const createContent = await createContent();
  const deleteContent = await deleteContent();
  return { data };
} */

// Gibt eine Bildschrim Komponente zurück
export default function Admin() {
  const [name, setName] = useState("");
  const [message, setMessage] = useState("");
  const [id, setStatusId] = useState();

  const navigate = useNavigate();

  const [basicModal, setBasicModal] = useState(false);
  const [basicModal2, setBasicModal2] = useState(false);

  const handleSubmitCreate = (e) => {
    e.preventDefault(); // verhindert das standardmässige Absenden des Formulars

    createContent(name, message, id) // AJAX call ans Backend
      .then(() => {
        // Erfolg
        navigate("/private");
      });
  };

  const handleSubmitDelete = (e) => {
    e.preventDefault(); // verhindert das standardmässige Absenden des Formulars

    deleteContent(id) // AJAX call ans Backend
      .then(() => {
        // Erfolg
        navigate("/private");
      });
  };

  // for name
  const onChangeName = (e) => {
    setName(e.target.value);
  };

  // for message
  const onChangeMessage = (e) => {
    setMessage(e.target.value);
  };

  // for status
  const onChangeStatusId = (e) => {
    setStatusId(e.target.value);
  };

  const toggleOpen = () => setBasicModal(!basicModal);
  const toggleOpen2 = () => setBasicModal2(!basicModal2);
  // const { data } = useLoaderData();

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
                  label="Id (1 = Offen, 2 = In Bearbeitung, 3 = Abgeschlossen)"
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
