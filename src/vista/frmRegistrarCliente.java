/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author Ignacio
 */
public class frmRegistrarCliente extends javax.swing.JDialog {

    /**
     * Creates new form frmRegistrarCliente
     * @param parent
     * @param modal
     */
    public frmRegistrarCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDatosCliente = new javax.swing.JPanel();
        lblCedula = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblEstadoCliente = new javax.swing.JLabel();
        lblTipoCliente = new javax.swing.JLabel();
        lblCelular = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        cmbEstadoCliente = new javax.swing.JComboBox();
        cmbTipoCliente = new javax.swing.JComboBox();
        pnlAsignacionCredito = new javax.swing.JPanel();
        lblMontoCredito = new javax.swing.JLabel();
        lblMontoActual = new javax.swing.JLabel();
        lblPeriodoPago = new javax.swing.JLabel();
        lblObservacion = new javax.swing.JLabel();
        numMontoCredito = new javax.swing.JSpinner();
        numMontoActual = new javax.swing.JSpinner();
        numPeriodoPago = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacion = new javax.swing.JTextArea();
        lblFechaGiro = new javax.swing.JLabel();
        dtpFechaGiro = new com.toedter.calendar.JDateChooser();
        pnlDatosResponsable = new javax.swing.JPanel();
        lblNombreResponsable = new javax.swing.JLabel();
        lblCedulaResponsable = new javax.swing.JLabel();
        txtCedulaResponsable = new javax.swing.JTextField();
        txtNombreResponsable = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar cliente");
        setResizable(false);

        pnlDatosCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del cliente"));

        lblCedula.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblCedula.setText("Cédula:");

        lblNombre.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblNombre.setText("Nombre:");

        lblTelefono.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblTelefono.setText("Telefono:");

        lblDireccion.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblDireccion.setText("Dirección:");

        lblEstadoCliente.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblEstadoCliente.setText("Estado del cliente:");

        lblTipoCliente.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblTipoCliente.setText("Tipo de cliente:");

        lblCelular.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblCelular.setText("Celular:");

        txtCedula.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N

        txtNombre.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N

        txtTelefono.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N

        txtDireccion.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N

        txtCelular.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N

        cmbEstadoCliente.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        cmbEstadoCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activo", "Moroso", "Suspendido" }));

        cmbTipoCliente.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        cmbTipoCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Contado", "Crédito" }));

        pnlAsignacionCredito.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Asignación de crédito", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP));

        lblMontoCredito.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblMontoCredito.setText("Monto del crédito:");

        lblMontoActual.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblMontoActual.setText("Monto actual:");

        lblPeriodoPago.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblPeriodoPago.setText("Preiodos de pago:");

        lblObservacion.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblObservacion.setText("Observación:");

        numMontoCredito.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        numMontoCredito.setModel(new javax.swing.SpinnerNumberModel(0, 0, 500000, 1));

        numMontoActual.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        numMontoActual.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 1.0E55d, 1.0d));
        numMontoActual.setEnabled(false);

        numPeriodoPago.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        numPeriodoPago.setModel(new javax.swing.SpinnerNumberModel(1, 1, 30, 1));

        txtObservacion.setColumns(10);
        txtObservacion.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        txtObservacion.setRows(5);
        jScrollPane1.setViewportView(txtObservacion);

        lblFechaGiro.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblFechaGiro.setText("Fecha de giro:");

        javax.swing.GroupLayout pnlAsignacionCreditoLayout = new javax.swing.GroupLayout(pnlAsignacionCredito);
        pnlAsignacionCredito.setLayout(pnlAsignacionCreditoLayout);
        pnlAsignacionCreditoLayout.setHorizontalGroup(
            pnlAsignacionCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAsignacionCreditoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAsignacionCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFechaGiro)
                    .addComponent(lblObservacion)
                    .addComponent(lblPeriodoPago)
                    .addComponent(lblMontoActual)
                    .addComponent(lblMontoCredito))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAsignacionCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(numMontoActual, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numMontoCredito)
                    .addComponent(numPeriodoPago)
                    .addComponent(jScrollPane1)
                    .addComponent(dtpFechaGiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlAsignacionCreditoLayout.setVerticalGroup(
            pnlAsignacionCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAsignacionCreditoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAsignacionCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMontoCredito)
                    .addComponent(numMontoCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAsignacionCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMontoActual)
                    .addComponent(numMontoActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAsignacionCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPeriodoPago)
                    .addComponent(numPeriodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAsignacionCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFechaGiro)
                    .addComponent(dtpFechaGiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAsignacionCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblObservacion)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pnlDatosResponsable.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del responsable", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP));

        lblNombreResponsable.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblNombreResponsable.setText("Nombre:");

        lblCedulaResponsable.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblCedulaResponsable.setText("Cédula:");

        txtCedulaResponsable.setEditable(false);
        txtCedulaResponsable.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N

        txtNombreResponsable.setEditable(false);
        txtNombreResponsable.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N

        javax.swing.GroupLayout pnlDatosResponsableLayout = new javax.swing.GroupLayout(pnlDatosResponsable);
        pnlDatosResponsable.setLayout(pnlDatosResponsableLayout);
        pnlDatosResponsableLayout.setHorizontalGroup(
            pnlDatosResponsableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosResponsableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosResponsableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNombreResponsable)
                    .addComponent(lblCedulaResponsable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosResponsableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreResponsable)
                    .addComponent(txtCedulaResponsable))
                .addContainerGap())
        );
        pnlDatosResponsableLayout.setVerticalGroup(
            pnlDatosResponsableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosResponsableLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlDatosResponsableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedulaResponsable)
                    .addComponent(txtCedulaResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosResponsableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreResponsable)
                    .addComponent(txtNombreResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRegistrar.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        btnRegistrar.setText("Registrar");

        btnCancelar.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDatosClienteLayout = new javax.swing.GroupLayout(pnlDatosCliente);
        pnlDatosCliente.setLayout(pnlDatosClienteLayout);
        pnlDatosClienteLayout.setHorizontalGroup(
            pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNombre)
                    .addComponent(lblCedula)
                    .addComponent(lblTelefono)
                    .addComponent(lblDireccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                        .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTelefono)
                            .addComponent(txtCedula, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstadoCliente)
                            .addComponent(lblTipoCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCelular, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmbEstadoCliente, 0, 233, Short.MAX_VALUE)
                            .addComponent(cmbTipoCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCelular)))
                    .addComponent(txtDireccion))
                .addContainerGap())
            .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                .addComponent(pnlAsignacionCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDatosResponsable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        pnlDatosClienteLayout.setVerticalGroup(
            pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula)
                    .addComponent(lblEstadoCliente)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEstadoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(lblTipoCliente)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(lblCelular)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccion)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAsignacionCredito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                        .addComponent(pnlDatosResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar)
                            .addComponent(btnCancelar))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDatosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDatosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox cmbEstadoCliente;
    private javax.swing.JComboBox cmbTipoCliente;
    private com.toedter.calendar.JDateChooser dtpFechaGiro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCedulaResponsable;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEstadoCliente;
    private javax.swing.JLabel lblFechaGiro;
    private javax.swing.JLabel lblMontoActual;
    private javax.swing.JLabel lblMontoCredito;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreResponsable;
    private javax.swing.JLabel lblObservacion;
    private javax.swing.JLabel lblPeriodoPago;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipoCliente;
    private javax.swing.JSpinner numMontoActual;
    private javax.swing.JSpinner numMontoCredito;
    private javax.swing.JSpinner numPeriodoPago;
    private javax.swing.JPanel pnlAsignacionCredito;
    private javax.swing.JPanel pnlDatosCliente;
    private javax.swing.JPanel pnlDatosResponsable;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCedulaResponsable;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreResponsable;
    private javax.swing.JTextArea txtObservacion;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
