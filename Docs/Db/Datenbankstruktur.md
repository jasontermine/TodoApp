# Datenbankstruktur

## Tabellen

 <table>
  <tr>
    <th colspan="2">Admin</th>
  </tr>
  <tr>
    <td>AdminID</td>
    <td>long AUTO_INCREMENT PK</td>
  </tr>
  <tr>
    <td>Username</td>
    <td>VARCHAR(100)</td>
  </tr>
  <tr>
    <td>Password</td>
    <td>VARCHAR (100)</td>
  </tr>
  <tr>
    <td>UserRole</td>
    <td>ENUM('Admin', 'Employee') </td>
  </tr>
</table> 

<table>
  <tr>
    <th colspan="2">Employee</th>
  </tr>
  <tr>
    <td>EmployeeID</td>
    <td>long AUTO_INCREMENT PK</td>
  </tr>
  <tr>
    <td>Username</td>
    <td>VARCHAR(100)</td>
  </tr>
  <tr>
    <td>Password</td>
    <td>VARCHAR (100)</td>
  </tr>
  <tr>
  <tr>
    <td>UserRole</td>
    <td>ENUM('1', '2')</td>
  </tr>
</table> 

<table>
  <tr>
    <th colspan="2">TODO</th>
  </tr>
  <tr>
    <td>TodoID</td>
    <td>long AUTO_INCREMENT PK</td>
  </tr>
  <tr>
    <td>Name</td>
    <td>VARCHAR(100)</td>
  </tr>
  <tr>
    <td>Message</td>
    <td>TEXT(1000)</td>
  </tr>
  <tr>
    <td>Status</td>
    <td>ENUM ('Offen', 'In bearbeitung', 'Abgeschlossen')</td>
  </tr>
</table> 
