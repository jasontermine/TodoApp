import { useLoaderData } from "react-router-dom";
import { getPublicContent } from "../functions/getContent";

export async function loader() {
  const data = await getPublicContent();
  return { data };
}

/**
 * Beinhaltet einen Easter Egg ;)
 * @returns {JSX.Element} Die öffentliche Seite.
 */
export default function Public() {
  const { data } = useLoaderData();

  return (
    <>
      <h1>Public</h1>
      <h2>Hier sind die Serverdaten:</h2>
      <h3>{ data }</h3>
    </>
  );
}
