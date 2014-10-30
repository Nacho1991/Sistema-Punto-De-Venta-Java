/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

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

    public EmpleadoD(AccesoDatosMySql pCnx) {
        this.conexion = pCnx;
        this.error = false;
        this.errorMsg = "";
    }

    public List<Empleado> consultarRegistro() {

        ArrayList registros = new ArrayList();
        ResultSet rs = this.conexion.ejecutarConsultaSQL("SELECT * FROM LogIn");

        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        } else {
            try {
                while (rs.next()) {

                    Empleado oEmpleado = new Empleado(
                            rs.getString("Id_Cedula"),
                            rs.getString("Nombre"),
                            rs.getString("Apellidos"),
                            rs.getString("Fecha_Nacimiento"),
                            rs.getString("Telefono"),
                            rs.getString("Celular"),
                            rs.getString("Edad"),
                            rs.getString("Sexo"),
                            rs.getString("Nombre_Usuario"),
                            rs.getString("Contrasenna"),
                            rs.getString("Dir_Foto_Perfil"),
                            rs.getString("Email"),
                            rs.getString("Fecha_Creacion"),
                            rs.getString("Fecha_Modificacion"),
                            rs.getString("Creado_Por"),
                            rs.getString("Modificado_Por"),
                            rs.getString("Deártamento_Id_Departamento")
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

    public List<Empleado> iniciarSesion(String pNombreUsuario, String pContrasenna) {

        ArrayList registros = new ArrayList();
        ResultSet rs = this.conexion.ejecutarConsultaSQL("SELECT * FROM LogIn WHERE Nombre_Usuario='" + pNombreUsuario + "' AND Contrasenna ='" + pContrasenna + "'");

        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        } else {
            try {
                while (rs.next()) {

                    Empleado oEmpleado = new Empleado(
                            rs.getString("Id_Cedula"),
                            rs.getString("Nombre"),
                            rs.getString("Apellidos"),
                            rs.getString("Fecha_Nacimiento"),
                            rs.getString("Telefono"),
                            rs.getString("Celular"),
                            rs.getString("Edad"),
                            rs.getString("Sexo"),
                            rs.getString("Nombre_Usuario"),
                            rs.getString("Contrasenna"),
                            rs.getString("Dir_Foto_Perfil"),
                            rs.getString("Email"),
                            rs.getString("Fecha_Creacion"),
                            rs.getString("Fecha_Modificacion"),
                            rs.getString("Creado_Por"),
                            rs.getString("Modificado_Por"),
                            rs.getString("Deártamento_Id_Departamento")
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
