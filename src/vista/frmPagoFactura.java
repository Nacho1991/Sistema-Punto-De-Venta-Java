/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import ImpresoraD.Factura;
import ImpresoraD.MaestroFactura;
import ImpresoraD.Producto;
import ImpresoraL.Impresion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import org.edisoncor.gui.button.ButtonAction;
import org.edisoncor.gui.textField.TextField;
import org.edisoncor.gui.util.WindowDragger;
import org.edisoncor.gui.util.WindowsUtil;

/**
 *
 * @author Ignacio
 */
public class frmPagoFactura extends javax.swing.JDialog {

    private boolean aceptar;
    private String totalPagar;
    private int pagoCon;
    private int descuento;
    private int cambio;

    public frmPagoFactura(java.awt.Frame parent, boolean modal, String totalPagar, String pNumeroFactura, int pTotalArticulos) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        txtNumeroFacturaContado.setHorizontalAlignment(JTextField.RIGHT);
        txtNumeroFacturaCredito.setHorizontalAlignment(JTextField.RIGHT);
        txtNumeroFacturaContado.setText(pNumeroFactura);
        txtNumeroFacturaCredito.setText(pNumeroFactura);
        lblMontoPagarContado.setText("" + ((int) Math.round(Double.parseDouble(totalPagar))));
        lblMontoPagarCredito.setText("" + ((int) Math.round(Double.parseDouble(totalPagar))));
        lblNumeroArticulos.setText("" + pTotalArticulos);
        WindowsUtil.makeWindowsShape(this, pnlBackground.getShape());
        new WindowDragger(this, pnlBackground);

        brtleBarraTitulo.addCloseAction(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });
        setLocationRelativeTo(null);
    }

    public int getPagoCon() {
        return pagoCon;
    }

    public void setPagoCon(int pagoCon) {
        this.pagoCon = pagoCon;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getCambio() {
        return cambio;
    }

    public void setCambio(int cambio) {
        this.cambio = cambio;
    }

    public boolean isAceptar() {
        return aceptar;
    }

    public String getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(String totalPagar) {
        this.totalPagar = totalPagar;
    }

    public void setAceptar(boolean aceptar) {
        this.aceptar = aceptar;
    }

    public void calculaDescuento() {
        try {
            int monto = (int) Math.round(Double.parseDouble(lblMontoPagarContado.getText()));
            int montoTotal;
            pagoCon = Math.round(Integer.parseInt(numPagonCon.getValue().toString()));
            if (pagoCon >= monto) {
                descuento = (Integer.parseInt(numDescuento.getValue().toString()) * monto) / 100;
                montoTotal = monto - descuento;
                Math.round(cambio = pagoCon - montoTotal);
                lblCambio.setText("" + cambio);
            }else
            {
                aceptar=false;
                JOptionPane.showMessageDialog(null, "Monto insuficiente para cancelar la factura.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception xp) {
            JOptionPane.showMessageDialog(null, "Error inesperado al intentar calcular los montos a facturar. Detalle técnico: " + xp.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new org.edisoncor.gui.panel.PanelNice();
        brtleBarraTitulo = new org.edisoncor.gui.varios.TitleBar();
        pnlOpciones = new org.edisoncor.gui.panel.PanelShadow();
        btnCobrarImprimir = new org.edisoncor.gui.button.ButtonAction();
        btnSoloCobrar = new org.edisoncor.gui.button.ButtonAction();
        btnCancelar = new org.edisoncor.gui.button.ButtonAction();
        lblTotalArticulos = new javax.swing.JLabel();
        lblNumeroArticulos = new javax.swing.JLabel();
        btnBuscarCliente = new org.edisoncor.gui.button.ButtonSeven();
        btnVerDetalles = new org.edisoncor.gui.button.ButtonSeven();
        tabCancelarFactura = new org.edisoncor.gui.tabbedPane.TabbedPaneRound();
        pnlContado = new org.edisoncor.gui.panel.PanelShadow();
        lblTotalPagar = new javax.swing.JLabel();
        lblMontoPagarContado = new javax.swing.JLabel();
        lblPagoCon = new javax.swing.JLabel();
        lblSuCambio = new javax.swing.JLabel();
        numPagonCon = new javax.swing.JSpinner();
        lblCambio = new javax.swing.JLabel();
        txtNumeroFacturaContado = new javax.swing.JTextField();
        lblNumeroFacturaContado = new javax.swing.JLabel();
        lblDescuento = new javax.swing.JLabel();
        numDescuento = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        pnlCredito = new org.edisoncor.gui.panel.PanelShadow();
        lblMontoPagarCredito = new javax.swing.JLabel();
        lblTotalPagarCredito = new javax.swing.JLabel();
        txtNumeroFacturaCredito = new javax.swing.JTextField();
        lblNumeroFacturaCredito = new javax.swing.JLabel();
        lblNombreClienteCredito = new javax.swing.JLabel();
        txtNombreClienteCredito = new javax.swing.JTextField();
        lblCedulaClienteCredito = new javax.swing.JLabel();
        txtCedulaClienteCredito = new javax.swing.JTextField();
        txtLimiteCreditoCliente = new javax.swing.JTextField();
        lblLimiteCredito = new javax.swing.JLabel();
        txtSaldoActualCredito = new javax.swing.JTextField();
        lblSaldoActual = new javax.swing.JLabel();
        panelShadow1 = new org.edisoncor.gui.panel.PanelShadow();
        lblTotaPagarTarjeta = new javax.swing.JLabel();
        lblMontoPagarTarjeta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlBackground.setBackground(new java.awt.Color(124, 119, 119));

        brtleBarraTitulo.setBackground(new java.awt.Color(254, 254, 254));
        brtleBarraTitulo.setForeground(new java.awt.Color(254, 254, 254));
        brtleBarraTitulo.setTitulo("Cancelar factura");
        pnlBackground.add(brtleBarraTitulo, java.awt.BorderLayout.PAGE_START);

        btnCobrarImprimir.setText("F2 - Cobrar e imprimir");
        btnCobrarImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobrarImprimirActionPerformed(evt);
            }
        });

        btnSoloCobrar.setText("F3 - Sólo cobrar");

        btnCancelar.setText("ESC - Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblTotalArticulos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTotalArticulos.setForeground(new java.awt.Color(254, 254, 254));
        lblTotalArticulos.setText("Total de articulos:");

        lblNumeroArticulos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNumeroArticulos.setForeground(new java.awt.Color(254, 254, 254));
        lblNumeroArticulos.setText("0");

        btnBuscarCliente.setText("Buscar cliente");

        btnVerDetalles.setText("Ver detalles");

        javax.swing.GroupLayout pnlOpcionesLayout = new javax.swing.GroupLayout(pnlOpciones);
        pnlOpciones.setLayout(pnlOpcionesLayout);
        pnlOpcionesLayout.setHorizontalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOpcionesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVerDetalles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuscarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSoloCobrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOpcionesLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnCobrarImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlOpcionesLayout.createSequentialGroup()
                        .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(lblTotalArticulos))
                            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(lblNumeroArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlOpcionesLayout.setVerticalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnCobrarImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSoloCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTotalArticulos)
                .addGap(12, 12, 12)
                .addComponent(lblNumeroArticulos)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pnlBackground.add(pnlOpciones, java.awt.BorderLayout.LINE_END);

        tabCancelarFactura.setBackground(new java.awt.Color(207, 240, 240));
        tabCancelarFactura.setColorDeBorde(new java.awt.Color(0, 0, 0));
        tabCancelarFactura.setColorDeSegundoBorde(new java.awt.Color(255, 204, 0));
        tabCancelarFactura.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabCancelarFacturaStateChanged(evt);
            }
        });

        lblTotalPagar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTotalPagar.setForeground(new java.awt.Color(254, 254, 254));
        lblTotalPagar.setText("Total a pagar:");

        lblMontoPagarContado.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblMontoPagarContado.setForeground(new java.awt.Color(254, 254, 254));
        lblMontoPagarContado.setText("0");

        lblPagoCon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPagoCon.setForeground(new java.awt.Color(254, 254, 254));
        lblPagoCon.setText("Pagó con:");

        lblSuCambio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSuCambio.setForeground(new java.awt.Color(254, 254, 254));
        lblSuCambio.setText("Su cambio:");

        numPagonCon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        numPagonCon.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                numPagonConStateChanged(evt);
            }
        });

        lblCambio.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblCambio.setForeground(new java.awt.Color(254, 254, 254));
        lblCambio.setText("0");

        txtNumeroFacturaContado.setEditable(false);
        txtNumeroFacturaContado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNumeroFacturaContado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtNumeroFacturaContado.setText("0");

        lblNumeroFacturaContado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNumeroFacturaContado.setForeground(new java.awt.Color(254, 254, 254));
        lblNumeroFacturaContado.setText("No. Factura:");

        lblDescuento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDescuento.setForeground(new java.awt.Color(254, 254, 254));
        lblDescuento.setText("Descuento:");

        numDescuento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        numDescuento.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                numDescuentoStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("%");

        javax.swing.GroupLayout pnlContadoLayout = new javax.swing.GroupLayout(pnlContado);
        pnlContado.setLayout(pnlContadoLayout);
        pnlContadoLayout.setHorizontalGroup(
            pnlContadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContadoLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(pnlContadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPagoCon)
                    .addComponent(lblNumeroFacturaContado)
                    .addComponent(lblDescuento)
                    .addComponent(lblSuCambio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numPagonCon, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNumeroFacturaContado, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCambio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlContadoLayout.createSequentialGroup()
                        .addGroup(pnlContadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMontoPagarContado)
                            .addComponent(lblTotalPagar))
                        .addGap(0, 64, Short.MAX_VALUE))
                    .addGroup(pnlContadoLayout.createSequentialGroup()
                        .addComponent(numDescuento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18))
        );
        pnlContadoLayout.setVerticalGroup(
            pnlContadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotalPagar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMontoPagarContado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumeroFacturaContado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumeroFacturaContado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPagoCon)
                    .addComponent(numPagonCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescuento)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCambio)
                    .addComponent(lblSuCambio))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        tabCancelarFactura.addTab("Contado", pnlContado);

        lblMontoPagarCredito.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblMontoPagarCredito.setForeground(new java.awt.Color(254, 254, 254));
        lblMontoPagarCredito.setText("0");

        lblTotalPagarCredito.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTotalPagarCredito.setForeground(new java.awt.Color(254, 254, 254));
        lblTotalPagarCredito.setText("Total a pagar:");

        txtNumeroFacturaCredito.setEditable(false);
        txtNumeroFacturaCredito.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNumeroFacturaCredito.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtNumeroFacturaCredito.setText("0");

        lblNumeroFacturaCredito.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNumeroFacturaCredito.setForeground(new java.awt.Color(254, 254, 254));
        lblNumeroFacturaCredito.setText("No. Factura:");

        lblNombreClienteCredito.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNombreClienteCredito.setForeground(new java.awt.Color(254, 254, 254));
        lblNombreClienteCredito.setText("Nombre:");

        txtNombreClienteCredito.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblCedulaClienteCredito.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCedulaClienteCredito.setForeground(new java.awt.Color(254, 254, 254));
        lblCedulaClienteCredito.setText("Cédula:");

        txtCedulaClienteCredito.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtLimiteCreditoCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtLimiteCreditoCliente.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtLimiteCreditoCliente.setText("0");
        txtLimiteCreditoCliente.setCaretPosition(0);

        lblLimiteCredito.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblLimiteCredito.setForeground(new java.awt.Color(254, 254, 254));
        lblLimiteCredito.setText("Límite de crédito:");

        txtSaldoActualCredito.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSaldoActualCredito.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSaldoActualCredito.setText("0");

        lblSaldoActual.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSaldoActual.setForeground(new java.awt.Color(254, 254, 254));
        lblSaldoActual.setText("Saldo actual:");

        javax.swing.GroupLayout pnlCreditoLayout = new javax.swing.GroupLayout(pnlCredito);
        pnlCredito.setLayout(pnlCreditoLayout);
        pnlCreditoLayout.setHorizontalGroup(
            pnlCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCreditoLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(pnlCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreClienteCredito, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNumeroFacturaCredito, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCedulaClienteCredito, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLimiteCredito, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSaldoActual, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtLimiteCreditoCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCedulaClienteCredito, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNombreClienteCredito, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNumeroFacturaCredito, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlCreditoLayout.createSequentialGroup()
                        .addGroup(pnlCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMontoPagarCredito)
                            .addComponent(lblTotalPagarCredito))
                        .addGap(0, 62, Short.MAX_VALUE))
                    .addComponent(txtSaldoActualCredito))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        pnlCreditoLayout.setVerticalGroup(
            pnlCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCreditoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotalPagarCredito)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMontoPagarCredito)
                .addGap(5, 5, 5)
                .addGroup(pnlCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumeroFacturaCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumeroFacturaCredito))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreClienteCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreClienteCredito))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCedulaClienteCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCedulaClienteCredito))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLimiteCreditoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLimiteCredito))
                .addGap(9, 9, 9)
                .addGroup(pnlCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSaldoActualCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSaldoActual))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        tabCancelarFactura.addTab("Crédito", pnlCredito);

        lblTotaPagarTarjeta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTotaPagarTarjeta.setForeground(new java.awt.Color(254, 254, 254));
        lblTotaPagarTarjeta.setText("Total a pagar:");

        lblMontoPagarTarjeta.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblMontoPagarTarjeta.setForeground(new java.awt.Color(254, 254, 254));
        lblMontoPagarTarjeta.setText("0");

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addContainerGap(189, Short.MAX_VALUE)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMontoPagarTarjeta)
                    .addComponent(lblTotaPagarTarjeta))
                .addGap(77, 77, 77))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotaPagarTarjeta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMontoPagarTarjeta)
                .addContainerGap(215, Short.MAX_VALUE))
        );

        tabCancelarFactura.addTab("Tarjeta", panelShadow1);

        pnlBackground.add(tabCancelarFactura, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCobrarImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrarImprimirActionPerformed
        // TODO add your handling code here:
        try {
            aceptar = true;
            calculaDescuento();
            this.setVisible(false);
        } catch (Exception xp) {
            JOptionPane.showMessageDialog(null, "Error inesperado al intentar obtener los calculos por parte del sistema. Detalle técnico: " + xp.getMessage());
        }
    }//GEN-LAST:event_btnCobrarImprimirActionPerformed

    private void tabCancelarFacturaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabCancelarFacturaStateChanged
        // TODO add your handling code here:
        if (tabCancelarFactura.getSelectedIndex() == 1) {
            btnBuscarCliente.setVisible(true);
            btnVerDetalles.setVisible(true);
        } else {
            btnBuscarCliente.setVisible(false);
            btnVerDetalles.setVisible(false);
        }
    }//GEN-LAST:event_tabCancelarFacturaStateChanged

    private void numPagonConStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_numPagonConStateChanged
        // TODO add your handling code here:
        calculaDescuento();
    }//GEN-LAST:event_numPagonConStateChanged

    private void numDescuentoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_numDescuentoStateChanged
        // TODO add your handling code here:
        calculaDescuento();
    }//GEN-LAST:event_numDescuentoStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.varios.TitleBar brtleBarraTitulo;
    private org.edisoncor.gui.button.ButtonSeven btnBuscarCliente;
    private org.edisoncor.gui.button.ButtonAction btnCancelar;
    private org.edisoncor.gui.button.ButtonAction btnCobrarImprimir;
    private org.edisoncor.gui.button.ButtonAction btnSoloCobrar;
    private org.edisoncor.gui.button.ButtonSeven btnVerDetalles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCambio;
    private javax.swing.JLabel lblCedulaClienteCredito;
    private javax.swing.JLabel lblDescuento;
    private javax.swing.JLabel lblLimiteCredito;
    private javax.swing.JLabel lblMontoPagarContado;
    private javax.swing.JLabel lblMontoPagarCredito;
    private javax.swing.JLabel lblMontoPagarTarjeta;
    private javax.swing.JLabel lblNombreClienteCredito;
    private javax.swing.JLabel lblNumeroArticulos;
    private javax.swing.JLabel lblNumeroFacturaContado;
    private javax.swing.JLabel lblNumeroFacturaCredito;
    private javax.swing.JLabel lblPagoCon;
    private javax.swing.JLabel lblSaldoActual;
    private javax.swing.JLabel lblSuCambio;
    private javax.swing.JLabel lblTotaPagarTarjeta;
    private javax.swing.JLabel lblTotalArticulos;
    private javax.swing.JLabel lblTotalPagar;
    private javax.swing.JLabel lblTotalPagarCredito;
    private javax.swing.JSpinner numDescuento;
    private javax.swing.JSpinner numPagonCon;
    private org.edisoncor.gui.panel.PanelShadow panelShadow1;
    private org.edisoncor.gui.panel.PanelNice pnlBackground;
    private org.edisoncor.gui.panel.PanelShadow pnlContado;
    private org.edisoncor.gui.panel.PanelShadow pnlCredito;
    private org.edisoncor.gui.panel.PanelShadow pnlOpciones;
    private org.edisoncor.gui.tabbedPane.TabbedPaneRound tabCancelarFactura;
    private javax.swing.JTextField txtCedulaClienteCredito;
    private javax.swing.JTextField txtLimiteCreditoCliente;
    private javax.swing.JTextField txtNombreClienteCredito;
    private javax.swing.JTextField txtNumeroFacturaContado;
    private javax.swing.JTextField txtNumeroFacturaCredito;
    private javax.swing.JTextField txtSaldoActualCredito;
    // End of variables declaration//GEN-END:variables
}
