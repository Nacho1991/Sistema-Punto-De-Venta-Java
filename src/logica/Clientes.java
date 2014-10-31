package logica;

public class Clientes {

    private int codCliente;
    private int cedula;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String celular;
    private String direccion;
    private String email;
    private String fax;
    private String observacion;
    private double limiteCredito;
    private double montoActual;

    public Clientes(int pCodCliente, int pCedula, String pNombre, String pApellidos, String pTelefono, String pCelular,
            String pDireccion, String pEmail, String pFax, String pObservacion, double pLimiteCredito,
            double pMontoActual) {
        codCliente = pCodCliente;
        cedula = pCedula;
        nombre = pNombre;
        apellidos = pApellidos;
        telefono = pTelefono;
        celular = pCelular;
        direccion = pDireccion;
        email = pEmail;
        fax = pFax;
        observacion = pObservacion;
        limiteCredito = pLimiteCredito;
        montoActual = pMontoActual;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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
