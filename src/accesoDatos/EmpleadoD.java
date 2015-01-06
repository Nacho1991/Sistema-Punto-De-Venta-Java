/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import Utilidades.Utilidades;
import java.sql.ResultSet;
import java.util.*;
import logica.*;

/**
 *
 * @author ignacio
 */
public class EmpleadoD {

    private AccesoDatosMySql conexion;
    private boolean error;
    private String errorMsg;
    private Utilidades oUtilities;

    public EmpleadoD(AccesoDatosMySql pCnx) {
        this.conexion = pCnx;
        this.error = false;
        this.errorMsg = "";
        oUtilities = new Utilidades();
    }

    public List<Empleado> obtenerDatosAcceso(String pCedula) {
        ArrayList registros = new ArrayList();
        ResultSet rs = this.conexion.ejecutarConsultaSQL("SELECT * FROM ACCESO_SISTEMA WHERE Cedula_Empleado_FK = '" + pCedula + "'");
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        } else {
            try {
                while (rs.next()) {
                    Empleado oEmpleado = new Empleado();
                    oEmpleado.obtenerDatosAccesoSistema(
                            rs.getInt("Id"),
                            rs.getString("Cedula_Empleado_FK"),
                            rs.getString("Nombre_Usuario"),
                            rs.getString("Contrasenna")
                    );
                    registros.add(oEmpleado);
                }
                rs.close();
            } catch (Exception e) {
                this.error = true;
                this.errorMsg = e.getMessage();
            }
        }
        return registros;
    }

    public void actualizarAccesoSistema(Empleado pEmpleado) {
        limpiarError();
        //Parte de actualizacion de registros propios del acceso al sistema
        String sqlAcceso = "UPDATE ACCESO_SISTEMA SET Nombre_Usuario = ?, "
                + "Contrasenna = ? WHERE Cedula_Empleado_FK = ?";
        Parametro[] oAcceso = new Parametro[3];
        oAcceso[0] = new Parametro(Parametro.STRING, pEmpleado.getNombreUsuario());
        oAcceso[1] = new Parametro(Parametro.STRING, pEmpleado.getContrasenna());
        oAcceso[2] = new Parametro(Parametro.STRING, pEmpleado.getCedula());
        this.conexion.ejecutarSQL(sqlAcceso, oAcceso);
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
    }

    public void actualizarEmpleado(Empleado pEmpleado, int pCodigoEmpleado) {
        limpiarError();
        //Parte de actualizacion de registros propias del empleado
        String sqlEmpleado = "UPDATE EMPLEADO SET Cedula = ?, Nombre = ?, Direccion = ?, Telefono = ?, Celular = ?, "
                + "Fecha_Nacimiento = ?, Nombre_Departamento_FK = ?, Edad = ?, Sexo = ?, Email = ?, Fecha_Creacion = ?,"
                + "Fecha_Modificacion = ?, Creado_Por = ?, Modificado_Por = ? WHERE Id = ?";
        Parametro[] oEmpleado = new Parametro[15];
        oEmpleado[0] = new Parametro(Parametro.STRING, pEmpleado.getCedula());
        oEmpleado[1] = new Parametro(Parametro.STRING, pEmpleado.getNombre());
        oEmpleado[2] = new Parametro(Parametro.STRING, pEmpleado.getDireccion());
        oEmpleado[3] = new Parametro(Parametro.STRING, pEmpleado.getTelefono());
        oEmpleado[4] = new Parametro(Parametro.STRING, pEmpleado.getCelular());
        oEmpleado[5] = new Parametro(Parametro.STRING, pEmpleado.getFechaNacimiento());
        oEmpleado[6] = new Parametro(Parametro.STRING, pEmpleado.getDepartamento());
        oEmpleado[7] = new Parametro(Parametro.STRING, pEmpleado.getEdad());
        oEmpleado[8] = new Parametro(Parametro.STRING, pEmpleado.getSexo());
        oEmpleado[9] = new Parametro(Parametro.STRING, pEmpleado.getEmail());
        oEmpleado[10] = new Parametro(Parametro.STRING, pEmpleado.getFechaCreacion());
        oEmpleado[11] = new Parametro(Parametro.STRING, pEmpleado.getFechaModificion());
        oEmpleado[12] = new Parametro(Parametro.STRING, pEmpleado.getCreadoPor());
        oEmpleado[13] = new Parametro(Parametro.STRING, pEmpleado.getModificadoPor());
        oEmpleado[14] = new Parametro(Parametro.INT, pCodigoEmpleado);
        this.conexion.ejecutarSQL(sqlEmpleado, oEmpleado);
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
        //Parte de actualizacion de registros propias de los privilegios
        String sqlPrivilegios = "UPDATE PRIVILEGIOS SET Administracion_Clientes = ?, "
                + "Administracion_Cajas = ?, Administracion_Empleados = ?, Administracion_Facturas = ?,"
                + "Administracion_Inventario = ? WHERE Cedula_Empleado_FK = ?";
        Parametro[] oPrivilegios = new Parametro[6];
        oPrivilegios[0] = new Parametro(Parametro.STRING, pEmpleado.getAdminClientes());
        oPrivilegios[1] = new Parametro(Parametro.STRING, pEmpleado.getAdminCajas());
        oPrivilegios[2] = new Parametro(Parametro.STRING, pEmpleado.getAdminEmpleados());
        oPrivilegios[3] = new Parametro(Parametro.STRING, pEmpleado.getAdminFacturas());
        oPrivilegios[4] = new Parametro(Parametro.STRING, pEmpleado.getAdminInventario());
        oPrivilegios[5] = new Parametro(Parametro.STRING, pEmpleado.getCedula());
        this.conexion.ejecutarSQL(sqlPrivilegios, oPrivilegios);
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
        //Parte de actualizacion de registros propios del acceso al sistema
        String sqlAcceso = "UPDATE ACCESO_SISTEMA SET Nombre_Usuario = ?, "
                + "Contrasenna = ? WHERE Cedula_Empleado_FK = ?";
        Parametro[] oAcceso = new Parametro[3];
        oAcceso[0] = new Parametro(Parametro.STRING, pEmpleado.getNombreUsuario());
        oAcceso[1] = new Parametro(Parametro.STRING, pEmpleado.getContrasenna());
        oAcceso[2] = new Parametro(Parametro.STRING, pEmpleado.getCedula());
        this.conexion.ejecutarSQL(sqlAcceso, oAcceso);
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
    }

    public List<Empleado> obtenerPrivilegios(String pCedula) {
        ArrayList registros = new ArrayList();
        ResultSet rs = this.conexion.ejecutarConsultaSQL("SELECT * FROM PRIVILEGIOS WHERE Cedula_Empleado_FK = '" + pCedula + "'");
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        } else {
            try {
                while (rs.next()) {
                    Empleado oEmpleado = new Empleado();
                    oEmpleado.obtenerPrivilegios(
                            rs.getInt("Id"),
                            rs.getString("Cedula_Empleado_FK"),
                            rs.getString("Administracion_Clientes"),
                            rs.getString("Administracion_Cajas"),
                            rs.getString("Administracion_Empleados"),
                            rs.getString("Administracion_Facturas"),
                            rs.getString("Administracion_Inventario")
                    );
                    registros.add(oEmpleado);
                }
                rs.close();
            } catch (Exception e) {
                this.error = true;
                this.errorMsg = e.getMessage();
            }
        }
        return registros;
    }

    public List<Empleado> filtrarDatos(String pFiltro, String pOpcion) {
        ArrayList registros = new ArrayList();
        ResultSet rs = this.conexion.ejecutarConsultaSQL("SELECT * FROM EMPLEADO WHERE " + pOpcion + " like '%" + pFiltro + "%'");
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        } else {
            try {
                while (rs.next()) {
                    Empleado oEmpleado = new Empleado(
                            rs.getInt("Id"),
                            rs.getString("Cedula"),
                            rs.getString("Nombre"),
                            rs.getString("Direccion"),
                            rs.getString("Telefono"),
                            rs.getString("Celular"),
                            rs.getString("Fecha_Nacimiento"),
                            rs.getString("Nombre_Departamento_FK"),
                            rs.getString("Edad"),
                            rs.getString("Sexo"),
                            rs.getString("Email"),
                            rs.getString("Fecha_Creacion"),
                            rs.getString("Fecha_Modificacion"),
                            rs.getString("Creado_Por"),
                            rs.getString("Modificado_Por"), "", ""
                    );
                    registros.add(oEmpleado);
                }
                rs.close();
            } catch (Exception e) {
                this.error = true;
                this.errorMsg = e.getMessage();
            }
        }
        return registros;
    }

    public List<Empleado> consultarRegistro() {
        ArrayList registros = new ArrayList();
        ResultSet rs = this.conexion.ejecutarConsultaSQL("SELECT * FROM EMPLEADO");
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        } else {
            try {
                while (rs.next()) {
                    Empleado oEmpleado = new Empleado(
                            rs.getInt("Id"),
                            rs.getString("Cedula"),
                            rs.getString("Nombre"),
                            rs.getString("Direccion"),
                            rs.getString("Telefono"),
                            rs.getString("Celular"),
                            rs.getString("Fecha_Nacimiento"),
                            rs.getString("Nombre_Departamento_FK"),
                            rs.getString("Edad"),
                            rs.getString("Sexo"),
                            rs.getString("Email"),
                            rs.getString("Fecha_Creacion"),
                            rs.getString("Fecha_Modificacion"),
                            rs.getString("Creado_Por"),
                            rs.getString("Modificado_Por"), "", ""
                    );
                    registros.add(oEmpleado);
                }
                rs.close();
            } catch (Exception e) {
                this.error = true;
                this.errorMsg = e.getMessage();
            }
        }
        return registros;
    }

    public void registrarPrivilegios(Empleado pEmpleado) {
//Encargado de registrar los privilegios al sistema asociados al empleado
        String sqlPrivilegios
                = "INSERT INTO PRIVILEGIOS (Cedula_Empleado_FK,Administracion_Clientes, Administracion_Cajas, "
                + "Administracion_Empleados, Administracion_Facturas, Administracion_Inventario) "
                + "VALUES (?,?,?,?,?,?)";
        Parametro[] oPrivilegios = new Parametro[6];
        oPrivilegios[0] = new Parametro(Parametro.STRING, pEmpleado.getCedula());
        oPrivilegios[1] = new Parametro(Parametro.STRING, pEmpleado.getAdminClientes());
        oPrivilegios[2] = new Parametro(Parametro.STRING, pEmpleado.getAdminCajas());
        oPrivilegios[3] = new Parametro(Parametro.STRING, pEmpleado.getAdminEmpleados());
        oPrivilegios[4] = new Parametro(Parametro.STRING, pEmpleado.getAdminFacturas());
        oPrivilegios[5] = new Parametro(Parametro.STRING, pEmpleado.getAdminInventario());
        this.conexion.ejecutarSQL(sqlPrivilegios, oPrivilegios);

        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
    }

    public void registrarAccesoSistema(Empleado pEmpleado) {
        limpiarError();
        //Encargado de registrar los datos de acceso al sistema
        String sqlAcceso
                = "INSERT INTO ACCESO_SISTEMA (Cedula_Empleado_FK,Nombre_Usuario, Contrasenna) "
                + "VALUES (?,?,?)";
        Parametro[] oAcceso = new Parametro[3];
        oAcceso[0] = new Parametro(Parametro.STRING, pEmpleado.getCedula());
        oAcceso[1] = new Parametro(Parametro.STRING, pEmpleado.getNombreUsuario());
        oAcceso[2] = new Parametro(Parametro.STRING, pEmpleado.getContrasenna());
        this.conexion.ejecutarSQL(sqlAcceso, oAcceso);
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
    }

    public void registrarEmpleado(Empleado pEmpleado) {
        limpiarError();

        //Encargado de registrar los datos propios del empleado
        String sql
                = "INSERT INTO EMPLEADO (Cedula,Nombre, Direccion, Telefono, "
                + "Celular, Fecha_Nacimiento, Nombre_Departamento_FK, Edad, "
                + "Sexo, Email, Fecha_Creacion, Fecha_Modificacion, Creado_Por, "
                + "Modificado_Por) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Parametro[] oP = new Parametro[14];
        oP[0] = new Parametro(Parametro.STRING, pEmpleado.getCedula());
        oP[1] = new Parametro(Parametro.STRING, pEmpleado.getNombre());
        oP[2] = new Parametro(Parametro.STRING, pEmpleado.getDireccion());
        oP[3] = new Parametro(Parametro.STRING, pEmpleado.getTelefono());
        oP[4] = new Parametro(Parametro.STRING, pEmpleado.getCelular());
        oP[5] = new Parametro(Parametro.STRING, pEmpleado.getFechaNacimiento());
        oP[6] = new Parametro(Parametro.STRING, pEmpleado.getDepartamento());
        oP[7] = new Parametro(Parametro.STRING, pEmpleado.getEdad());
        oP[8] = new Parametro(Parametro.STRING, pEmpleado.getSexo());
        oP[9] = new Parametro(Parametro.STRING, pEmpleado.getEmail());
        oP[10] = new Parametro(Parametro.STRING, pEmpleado.getFechaCreacion());
        oP[11] = new Parametro(Parametro.STRING, pEmpleado.getFechaModificion());
        oP[12] = new Parametro(Parametro.STRING, pEmpleado.getCreadoPor());
        oP[13] = new Parametro(Parametro.STRING, pEmpleado.getModificadoPor());
        this.conexion.ejecutarSQL(sql, oP);
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
        //Encargado de registrar los datos de acceso al sistema
        String sqlAcceso
                = "INSERT INTO ACCESO_SISTEMA (Cedula_Empleado_FK,Nombre_Usuario, Contrasenna) "
                + "VALUES (?,?,?)";
        Parametro[] oAcceso = new Parametro[3];
        oAcceso[0] = new Parametro(Parametro.STRING, pEmpleado.getCedula());
        oAcceso[1] = new Parametro(Parametro.STRING, pEmpleado.getNombreUsuario());
        oAcceso[2] = new Parametro(Parametro.STRING, pEmpleado.getContrasenna());
        this.conexion.ejecutarSQL(sqlAcceso, oAcceso);
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
        //Encargado de registrar los privilegios al sistema asociados al empleado
        String sqlPrivilegios
                = "INSERT INTO PRIVILEGIOS (Cedula_Empleado_FK,Administracion_Clientes, Administracion_Cajas, "
                + "Administracion_Empleados, Administracion_Facturas, Administracion_Inventario) "
                + "VALUES (?,?,?,?,?,?)";
        Parametro[] oPrivilegios = new Parametro[6];
        oPrivilegios[0] = new Parametro(Parametro.STRING, pEmpleado.getCedula());
        oPrivilegios[1] = new Parametro(Parametro.STRING, pEmpleado.getAdminClientes());
        oPrivilegios[2] = new Parametro(Parametro.STRING, pEmpleado.getAdminCajas());
        oPrivilegios[3] = new Parametro(Parametro.STRING, pEmpleado.getAdminEmpleados());
        oPrivilegios[4] = new Parametro(Parametro.STRING, pEmpleado.getAdminFacturas());
        oPrivilegios[5] = new Parametro(Parametro.STRING, pEmpleado.getAdminInventario());
        this.conexion.ejecutarSQL(sqlPrivilegios, oPrivilegios);

        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
    }

    public List<Empleado> iniciarSesion(String pNombreUsuario, String pContrasenna) {

        ArrayList registros = new ArrayList();
        ResultSet rs = this.conexion.ejecutarConsultaSQL(
                "SELECT Cedula,Nombre,Nombre_Departamento_FK,Nombre_Usuario,Contrasenna FROM EMPLEADO LEFT JOIN ACCESO_SISTEMA ON ACCESO_SISTEMA.Cedula_Empleado_FK = EMPLEADO.Cedula"
                + " WHERE ACCESO_SISTEMA.Nombre_Usuario='" + pNombreUsuario + "' AND ACCESO_SISTEMA.Contrasenna='" + pContrasenna + "'"
        );
//WHERE Nombre_Usuario='" + pNombreUsuario + "' AND Contrasenna ='" + pContrasenna + "'"
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        } else {
            try {
                while (rs.next()) {
                    Empleado oEmpleado = new Empleado();
                    oEmpleado.obtenerInicioSession(
                            rs.getString("Cedula"),
                            rs.getString("Nombre"),
                            rs.getString("Nombre_Departamento_FK"),
                            rs.getString("Nombre_Usuario"),
                            rs.getString("Contrasenna")
                    );
                    registros.add(oEmpleado);
                }
                rs.close();
            } catch (Exception e) {
                this.error = true;
                this.errorMsg = e.getMessage();
            }
        }
        return registros;
    }

    private void limpiarError() {
        this.error = false;
        this.errorMsg = "";
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
