import React, { useState } from 'react';
import AuthService from "../functions/auth.service"
import {
  MDBContainer,
  MDBNavbar,
  MDBNavbarBrand,
  MDBNavbarToggler,
  MDBNavbarNav,
  MDBNavbarItem,
  MDBNavbarLink,
  MDBCollapse,
  MDBIcon
} from 'mdb-react-ui-kit';

/**
 * Komponente für die Navigationsleiste der Anwendung.
 * 
 * @returns {JSX.Element} Die JSX-Elemente für die Navigationsleiste.
 */
export default function App() {
  const [openNav, setOpenNav] = useState(false);

  return (
    <MDBNavbar className='position-absolute w-100' style={{top: "0"}} expand='lg' light bgColor='light'>
      <MDBContainer fluid>
        <MDBNavbarBrand >TodoApp</MDBNavbarBrand>
        <MDBNavbarToggler
          type='button'
          aria-expanded='false'
          aria-label='Toggle navigation'
          onClick={() => setOpenNav(!openNav)}
        >
          <MDBIcon icon='bars' fas />
        </MDBNavbarToggler>
        <MDBCollapse navbar open={openNav}>
          <MDBNavbarNav>
            {/* Zeigt den 'Login' Link, wenn im localStorage kein 'user' gibt, ansonsten 'Logout' zum abmelden.  */}
            { localStorage.getItem("user") === null ? 
            <>
              <MDBNavbarItem>
                <MDBNavbarLink aria-current='page' href='/'>
                  Login
                </MDBNavbarLink>
              </MDBNavbarItem>
              <MDBNavbarItem>
                <MDBNavbarLink aria-current='page' href='/signup'>
                  Signup
                </MDBNavbarLink>
                {/* Zeigt je nach rolle nur 'private' oder 'private' UND 'admin' */}
              </MDBNavbarItem>
              </>
               : 
              JSON.parse(localStorage.getItem("user"))?.roles?.find(role => role === "ROLE_ADMIN") ? 
              <>
              <MDBNavbarItem>
                <MDBNavbarLink onClick={AuthService.logout} aria-current='page' href='/'>
                  Logout
                </MDBNavbarLink>
              </MDBNavbarItem>
              <MDBNavbarItem>
                <MDBNavbarLink href='/private'>Private</MDBNavbarLink>
              </MDBNavbarItem>
              <MDBNavbarItem>
                <MDBNavbarLink href='/admin'>Admin</MDBNavbarLink>
              </MDBNavbarItem>
            </>
            : 
            <>
            <MDBNavbarLink onClick={AuthService.logout} aria-current='page' href='/'>
            Logout
          </MDBNavbarLink>
            <MDBNavbarItem>
            <MDBNavbarLink href='/private'>Private</MDBNavbarLink>
          </MDBNavbarItem>
          </> }
            <MDBNavbarItem>
            </MDBNavbarItem>
          </MDBNavbarNav>
        </MDBCollapse>
      </MDBContainer>
    </MDBNavbar>
  );
}