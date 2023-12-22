import { useLoaderData } from "react-router-dom";
import { getPrivateContent } from "../functions/getContent";
import { deleteContent } from "../functions/alterContent";
import { MDBCard, MDBCardBody, MDBCardText, MDBCardTitle, MDBIcon } from "mdb-react-ui-kit";

/**
 * Lädt den privaten Inhalt und gibt ihn als Datenobjekt zurück.
 * @returns {Promise<{ data: Array }>} Das Datenobjekt mit dem privaten Inhalt.
 */
export async function loader() {
  const data = await getPrivateContent();
  return { data };
}

/**
 * Komponente für die private Seite.
 * @returns {JSX.Element} Die private Seite.
 */
export default function Private() {
  const { data } = useLoaderData();

  return (
    <>  
    <div className="position-absolute" style={{marginTop:"-22rem", marginLeft: "34rem"}}>
      <h1 className="mb-4 ms-5">Hier sind alle Todos:</h1>
      <ul>
        {data.map((item) => (
          <MDBCard key={item.id} className="mb-5 shadow-5-strong">
          <MDBCardBody>
            {
              JSON.parse(localStorage.getItem("user"))?.roles?.find(role => role === "ROLE_ADMIN") ? 
                <div className="float-end" style={{cursor: "pointer"}} onClick={() => deleteContent(item.id).then(() => {window.location.reload()}) }>
                  <MDBIcon  color="danger" fas icon="trash" />
                </div> : null
            }
            <MDBCardTitle>{item.name} - Issue #{item.id}</MDBCardTitle>
            <MDBCardText>
              <strong>Nachricht: </strong>{ item.message }<br/>
              <strong>Status: </strong> { item.status.name == "STATUS_OFFEN" ? "Offen" : item.status.name == "STATUS_IN_BEARBEITUNG" ? "In Bearbeitung" : "Abgeschlossen" }
            </MDBCardText>
          </MDBCardBody>
        </MDBCard>
        ))}
      </ul>
    </div>
    </>
  );
}
