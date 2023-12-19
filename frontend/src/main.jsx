import * as React from "react";
import * as ReactDOM from "react-dom/client";
import 'mdb-react-ui-kit/dist/css/mdb.min.css';
import "@fortawesome/fontawesome-free/css/all.min.css";
import Public, { loader as public_loader} from "./pages/public";
import Private, { loader as private_loader} from "./pages/private";
import Admin from "./pages/admin";
import Login from "./pages/login";
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import "./index.css";
import Layout from "./components/Layout";

/**
 * Hauptdatei der Anwendung.
 * Hier werden die Routen definiert und die Anwendung gerendert.
 */
const router = createBrowserRouter([
  {
    path: "/",
    element: <Layout><Login /></Layout>
  },
  {
    path: "/public",
    loader: public_loader,
    element: <Layout><Public /></Layout>
  },
  {
    path: "/private",
    loader: private_loader,
    element: <Layout><Private /></Layout>
  },
  {
    path: "/admin",
    loader: private_loader,
    element: <Layout><Admin /></Layout>
  },
]);

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);