# Datenbankstruktur

## Tabellen

 <table>
  <tr>
    <th colspan="2">User</th>
  </tr>
  <tr>
    <td>id</td>
    <td>long AUTO_INCREMENT PK</td>
  </tr>
  <tr>
    <td>name</td>
    <td>VARCHAR(100)</td>
  </tr>
  <tr>
    <td>password</td>
    <td>VARCHAR (100)</td>
  </tr>
  <tr>
    <td>user_role</td>
    <td>Role FK </td>
  </tr>
</table> 

<table>
  <tr>
    <th colspan="2">TODO</th>
  </tr>
  <tr>
    <td>id</td>
    <td>long AUTO_INCREMENT PK</td>
  </tr>
  <tr>
    <td>name</td>
    <td>VARCHAR(100)</td>
  </tr>
  <tr>
    <td>message</td>
    <td>TEXT(1000)</td>
  </tr>
  <tr>
    <td>status</td>
    <td>Status FK</td>
  </tr>
</table> 

<table>
  <tr>
    <th colspan="2">Role</th>
  </tr>
  <tr>
    <td>id</td>
    <td>long AUTO_INCREMENT PK</td>
  </tr>
  <tr>
    <td>name</td>
    <td>ENUM('ADMIN', 'USER')</td>
  </tr>
  <tr>
</table> 

<table>
  <tr>
    <th colspan="2">Status</th>
  </tr>
  <tr>
    <td>id</td>
    <td>long AUTO_INCREMENT PK</td>
  </tr>
  <tr>
    <td>name</td>
    <td>ENUM('STATUS_OFFEN', 'STATUS_IN_BEARBEITUNG', 'STATUS_ABGESCHLOSSEN')</td>
  </tr>
  <tr>
</table> 

<table>
  <tr>
    <th colspan="2">status_todo</th>
  </tr>
  <tr>
    <td>user_id</td>
    <td>user_id FK</td>
  </tr>
  <tr>
    <td>status_id</td>
    <td>status_id FK</td>
  </tr>
  <tr>
</table> 

<table>
  <tr>
    <th colspan="2">user_role</th>
  </tr>
  <tr>
    <td>user_id</td>
    <td>user_id FK</td>
  </tr>
  <tr>
    <td>role_id</td>
    <td>role_id FK</td>
  </tr>
  <tr>
</table> 


