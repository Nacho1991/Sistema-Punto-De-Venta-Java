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

    private int id;
    private String cedula;
    private String nombre;
    private String direccion;
    private String telefono;
    private String celular;
    private String fechaNacimiento;
    private String departamento;
    private String edad;
    private String sexo;
    private String email;
    private String fechaCreacion;
    private String fechaModificion;
    private String creadoPor;
    private String modificadoPor;

    private String nombreUsuario;
    private String contrasenna;

    private String adminClientes;
    private String adminInventario;
    private String adminFacturas;
    private String adminEmpleados;
    private String adminCajas;

    public Empleado() {
    }

    public void obtenerDatosAccesoSistema(
            int pId, String pCedula, String pNombreUsuario, String pContrasenna
    ) {
        id = pId;
        cedula = pCedula;
        nombreUsuario = pNombreUsuario;
        contrasenna = pContrasenna;
    }

    public void obtenerInicioSession(
            String pCedula, String pNombre, String pDepartamento,
            String pNombreUsuario, String pContrasenna) {
        cedula = pCedula;
        nombre = pNombre;
        departamento = pDepartamento;
        nombreUsuario = pNombreUsuario;
        contrasenna = pContrasenna;
    }

    public void obtenerPrivilegios(
            int pId, String pCedula,
            String pAdminClientes, String pAdminInventario,
            String pAdminFacturas, String pAdminEmpleados,
            String pAdminCajas) {
        id = pId;
        cedula = pCedula;
        adminCajas = pAdminCajas;
        adminInventario = pAdminInventario;
        adminFacturas = pAdminFacturas;
        adminEmpleados = pAdminEmpleados;
        adminClientes = pAdminClientes;

    }
    public void registrarPrivilegios( String pCedula,
            String pAdminClientes, String pAdminInventario,
            String pAdminFacturas, String pAdminEmpleados,
            String pAdminCajas) {
        cedula = pCedula;
        adminCajas = pAdminCajas;
        adminInventario = pAdminInventario;
        adminFacturas = pAdminFacturas;
        adminEmpleados = pAdminEmpleados;
        adminClientes = pAdminClientes;

    }

    public Empleado(
            int id, String cedula, String nombre, String direccion,
            String telefono, String celular, String fechaNacimiento,
            String departamento, String edad, String sexo, String email,
            String fechaCreacion, String fechaModificion, String creadoPor,
            String modificadoPor, String nombreUsuario, String contrasenna) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        this.fechaNacimiento = fechaNacimiento;
        this.departamento = departamento;
        this.edad = edad;
        this.sexo = sexo;
        this.email = email;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificion = fechaModificion;
        this.creadoPor = creadoPor;
        this.modificadoPor = modificadoPor;
        this.nombreUsuario = nombreUsuario;
        this.contrasenna = contrasenna;
    }

    public Empleado(String pCedula,String pNombreUsuario, String pContrasenna) {
        cedula=pCedula;
        nombreUsuario = pNombreUsuario;
        contrasenna = pContrasenna;
    }

    public Empleado(String cedula, String nombre, String direccion,
            String telefono, String celular, String fechaNacimiento,
            String departamento, String edad, String sexo, String email,
            String fechaCreacion, String fechaModificion, String creadoPor,
            String modificadoPor, String nombreUsuario, String contrasenna,
            String adminClientes, String adminInventario, String adminFacturas,
            String adminEmpleados, String adminCajas) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        this.fechaNacimiento = fechaNacimiento;
        this.departamento = departamento;
        this.edad = edad;
        this.sexo = sexo;
        this.email = email;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificion = fechaModificion;
        this.creadoPor = creadoPor;
        this.modificadoPor = modificadoPor;
        this.nombreUsuario = nombreUsuario;
        this.contrasenna = contrasenna;
        this.adminClientes = adminClientes;
        this.adminInventario = adminInventario;
        this.adminFacturas = adminFacturas;
        this.adminEmpleados = adminEmpleados;
        this.adminCajas = adminCajas;
    }

    public String getCedula() {
        return cedula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
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

    public String getFechaModificion() {
        return fechaModificion;
    }

    public void setFechaModificion(String fechaModificion) {
        this.fechaModificion = fechaModificion;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getAdminClientes() {
        return adminClientes;
    }

    public void setAdminClientes(String adminClientes) {
        this.adminClientes = adminClientes;
    }

    public String getAdminInventario() {
        return adminInventario;
    }

    public void setAdminInventario(String adminInventario) {
        this.adminInventario = adminInventario;
    }

    public String getAdminFacturas() {
        return adminFacturas;
    }

    public void setAdminFacturas(String adminFacturas) {
        this.adminFacturas = adminFacturas;
    }

    public String getAdminEmpleados() {
        return adminEmpleados;
    }

    public void setAdminEmpleados(String adminEmpleados) {
        this.adminEmpleados = adminEmpleados;
    }

    public String getAdminCajas() {
        return adminCajas;
    }

    public void setAdminCajas(String adminCajas) {
        this.adminCajas = adminCajas;
    }

}
