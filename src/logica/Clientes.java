package logica;

public class Clientes {

    //Variables para los datos del cliente
    private int codCliente;
    private String cedula;
    private String nombre;
    private String telefono;
    private String direccion;
    private String estado;
    private String tipoCliente;
    private String fechaCreacion;
    private String fechaModificacion;
    private String creadoPor;
    private String modificadoPor;
    //Variables del credito
    private double limiteCredito;
    private double montoActual;

    public Clientes(
            int codCliente, 
            String cedula, 
            String nombre, 
            String telefono, 
            String direccion, 
            String estado, 
            String tipoCliente, 
            String fechaCreacion, 
            String fechaModificacion, 
            String creadoPor, 
            String modificadoPor) {
        this.codCliente = codCliente;
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
        this.tipoCliente = tipoCliente;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.creadoPor = creadoPor;
        this.modificadoPor = modificadoPor;
    }



    public Clientes( 
            int  pId,
            String pCedula, 
            String pNombre, 
            String pTelefono,
            String pDireccion, 
            String pEmail, 
            String pFax, 
            String pObservacion, 
            double pLimiteCredito,
            double pMontoActual) 
    {
        codCliente=pId;
        cedula = pCedula;
        nombre = pNombre;
        telefono = pTelefono;
        direccion = pDireccion;
        limiteCredito = pLimiteCredito;
        montoActual = pMontoActual;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
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

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public double getMontoActual() {
        return montoActual;
    }

    public void setMontoActual(double montoActual) {
        this.montoActual = montoActual;
    }
}
