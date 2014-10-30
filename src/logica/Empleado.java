/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author ignacio
 */
public class Empleado {

    private String cedula;
    private String Nombre;
    private String Apellidos;
    private String fechaNacimiento;
    private String telefono;
    private String celular;
    private String edad;
    private String sexo;
    private String nombreUsuario;
    private String contrasenna;
    private String dirFotoPerfil;
    private String email;
    private String fechaCreacion;
    private String fechaModific;
    private String creadoPor;
    private String modificadoPor;
    private String departamento;

    public Empleado(String cedula, String Nombre, String Apellidos, String fechaNacimiento, String telefono, String celular, String edad, String sexo, String nombreUsuario, String contrasenna, String dirFotoPerfil, String email, String fechaCreacion, String fechaModific, String creadoPor, String modificadoPor, String departamento) {
        this.cedula = cedula;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.celular = celular;
        this.edad = edad;
        this.sexo = sexo;
        this.nombreUsuario = nombreUsuario;
        this.contrasenna = contrasenna;
        this.dirFotoPerfil = dirFotoPerfil;
        this.email = email;
        this.fechaCreacion = fechaCreacion;
        this.fechaModific = fechaModific;
        this.creadoPor = creadoPor;
        this.modificadoPor = modificadoPor;
        this.departamento = departamento;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public String getDirFotoPerfil() {
        return dirFotoPerfil;
    }

    public void setDirFotoPerfil(String dirFotoPerfil) {
        this.dirFotoPerfil = dirFotoPerfil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaModific() {
        return fechaModific;
    }

    public void setFechaModific(String fechaModific) {
        this.fechaModific = fechaModific;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

}
