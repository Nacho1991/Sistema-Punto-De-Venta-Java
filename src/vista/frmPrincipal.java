/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import TxtL.GestionTxt;
import accesoDatos.*;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logica.Empleado;

/**
 *
 * @author ignacio
 */
public class frmPrincipal extends javax.swing.JFrame {

    private AccesoDatosMySql cnx;

    public frmPrincipal(AccesoDatosMySql pCnx, ArrayList<Empleado> pEmpleadoLogueado) {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        lblDatoNombre.setText(pEmpleadoLogueado.get(0).getNombre());
        lblDatoNombreUsuario.setText(pEmpleadoLogueado.get(0).getNombreUsuario());
        lblDatoDepartamento.setText(pEmpleadoLogueado.get(0).getDepartamento());
        cnx = pCnx;
        setLocationRelativeTo(null);
        asignarDescripcion();
    }

    public void asignarDescripcion() {
        lblAyuda.setDescription("Le brinda ayuda sobre como utilizar nuestro sistema de facturación.");
        lblInformacion.setDescription("Le brinda información sobre nuestro producto y la empresa como tal.");
        lblBuscarActualizaciones.setDescription("Busca actualizaciones recientes para la aplicación.");
        lblActivarProducto.setDescription("Le permite activar el producto con el fin de utilizarlo sin limites.");
        lblAgregarProductos.setDescription("Registra productos en el inventario del sistema.");
        lblEditarProductos.setDescription("Edita los productos registrados en el inventario del sistema.");
        lblControlGeneralProductos.setDescription("Gestiona de forma general los productos registrados en el sistema.");
        lblIniciarFacturacion.setDescription("Inicia el proceso de facturación.");
        lblVerFacturasPendientes.setDescription("Visualiza todas las facturas pendientes a emitir.");
        lblVerFacturasEmitidas.setDescription("Visualiza todas la facturas emitidas.");
        lblRegistrarUsuarios.setDescription("Registra clientes en la base de datos del sistema.");
        lblEditarUsuarios.setDescription("Edita los usuarios ya existentes en el sistema.");
        lblControlGeneralUsuarios.setDescription("Gestiona de forma general los clientes registrados en el sistema.");
        lblAgregarClientes.setDescription("Registra clientes en la base de datos del sistema.");
        lblEditarClientes.setDescription("Edita los clientes ya existentes en el sistema.");
        lblControlGeneralClientes.setDescription("Gestiona de forma general los clientes registrados en el sistema.");
        lblGeneradorCodigoBarras.setDescription("Le brinda una mejor comodidad a la hora de identificar los productos sin codigos de barras.");
    }

    private static Image loadImage(String fileName) {
        try {
            return ImageIO.read(JFrame.class.getResource(fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

//    public void inicializarAvatar() {
//        try {
//            List<Avatar> avatares = new ArrayList<Avatar>();
//            avatares.add(new Avatar("Inventario", loadImage("/resources/Inventario.png")));
//            avatares.add(new Avatar("Empleados", loadImage("/resources/Empleado.png")));
//            avatares.add(new Avatar("Clientes", loadImage("/resources/Cliente.png")));
//            avatares.add(new Avatar("Facturación", loadImage("/resources/Facturacion.png")));
//            pnlAvatar.setAvatars(avatares);
//        } catch (Exception xp) {
//            JOptionPane.showMessageDialog(null, "Error inesperado al intentar cargar los avatars.", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new org.edisoncor.gui.panel.PanelNice();
        pnlBackground = new org.edisoncor.gui.panel.PanelShadow();
        tabPanePrincipal = new org.edisoncor.gui.tabbedPane.TabbedPaneHeader();
        pnlUsuariosTab = new org.edisoncor.gui.panel.PanelNice();
        lblRegistrarUsuarios = new org.edisoncor.gui.label.LabelTask();
        lblEditarUsuarios = new org.edisoncor.gui.label.LabelTask();
        lblControlGeneralUsuarios = new org.edisoncor.gui.label.LabelTask();
        jSeparator6 = new javax.swing.JSeparator();
        pnlInventarioTab = new org.edisoncor.gui.panel.PanelNice();
        pnlInventario = new org.edisoncor.gui.panel.PanelShadow();
        lblAgregarProductos = new org.edisoncor.gui.label.LabelTask();
        lblEditarProductos = new org.edisoncor.gui.label.LabelTask();
        lblControlGeneralProductos = new org.edisoncor.gui.label.LabelTask();
        jSeparator5 = new javax.swing.JSeparator();
        lblGeneradorCodigoBarras = new org.edisoncor.gui.label.LabelTask();
        pnlFacturacionTab = new org.edisoncor.gui.panel.PanelNice();
        pnlFacturacion = new org.edisoncor.gui.panel.PanelShadow();
        lblIniciarFacturacion = new org.edisoncor.gui.label.LabelTask();
        lblVerFacturasPendientes = new org.edisoncor.gui.label.LabelTask();
        lblVerFacturasEmitidas = new org.edisoncor.gui.label.LabelTask();
        jSeparator4 = new javax.swing.JSeparator();
        pnlClientesTab = new org.edisoncor.gui.panel.PanelNice();
        pnlClientes = new org.edisoncor.gui.panel.PanelShadow();
        lblControlGeneralClientes = new org.edisoncor.gui.label.LabelTask();
        lblEditarClientes = new org.edisoncor.gui.label.LabelTask();
        lblAgregarClientes = new org.edisoncor.gui.label.LabelTask();
        jSeparator3 = new javax.swing.JSeparator();
        pnlSistemaTab = new org.edisoncor.gui.panel.PanelNice();
        pnlSistema = new org.edisoncor.gui.panel.PanelShadow();
        lblExportarRespaldo = new org.edisoncor.gui.label.LabelTask();
        lblImportarRespaldo = new org.edisoncor.gui.label.LabelTask();
        lblHistorialInicioSesion = new org.edisoncor.gui.label.LabelTask();
        lblHistorialVentas = new org.edisoncor.gui.label.LabelTask();
        jSeparator2 = new javax.swing.JSeparator();
        pnlInformacionTab = new org.edisoncor.gui.panel.PanelNice();
        pnlInformacion = new org.edisoncor.gui.panel.PanelShadow();
        lblActivarProducto = new org.edisoncor.gui.label.LabelTask();
        lblBuscarActualizaciones = new org.edisoncor.gui.label.LabelTask();
        lblAyuda = new org.edisoncor.gui.label.LabelTask();
        lblInformacion = new org.edisoncor.gui.label.LabelTask();
        jSeparator1 = new javax.swing.JSeparator();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        lblDatoNombreUsuario = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jLabel2 = new javax.swing.JLabel();
        lblDatoNombre = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        jLabel3 = new javax.swing.JLabel();
        lblDatoDepartamento = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana Principal");

        pnlPrincipal.setBackground(new java.awt.Color(240, 240, 240));

        pnlBackground.setBackground(new java.awt.Color(204, 204, 204));

        tabPanePrincipal.setBackground(new java.awt.Color(153, 153, 255));
        tabPanePrincipal.setToolTipText(""); // NOI18N
        tabPanePrincipal.setColorDeBorde(new java.awt.Color(204, 204, 204));
        tabPanePrincipal.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabPanePrincipalStateChanged(evt);
            }
        });

        pnlUsuariosTab.setBackground(new java.awt.Color(153, 153, 255));

        lblRegistrarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Agregar_Cliente.png"))); // NOI18N
        lblRegistrarUsuarios.setText("Registrar usuarios");
        lblRegistrarUsuarios.setToolTipText("Registrar usuarios");
        lblRegistrarUsuarios.setColorDeSegundoBorde(new java.awt.Color(204, 204, 204));
        lblRegistrarUsuarios.setOpaque(true);
        lblRegistrarUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegistrarUsuariosMouseClicked(evt);
            }
        });

        lblEditarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Edit-Male-User.png"))); // NOI18N
        lblEditarUsuarios.setText("Editar usuarios");
        lblEditarUsuarios.setToolTipText("Editar usuario");
        lblEditarUsuarios.setColorDeSegundoBorde(new java.awt.Color(204, 204, 204));
        lblEditarUsuarios.setOpaque(true);
        lblEditarUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEditarUsuariosMouseClicked(evt);
            }
        });

        lblControlGeneralUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Control.png"))); // NOI18N
        lblControlGeneralUsuarios.setText("Control general de usuarios");
        lblControlGeneralUsuarios.setToolTipText("Control general");
        lblControlGeneralUsuarios.setColorDeSegundoBorde(new java.awt.Color(204, 204, 204));
        lblControlGeneralUsuarios.setOpaque(true);
        lblControlGeneralUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblControlGeneralUsuariosMouseClicked(evt);
            }
        });

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout pnlUsuariosTabLayout = new javax.swing.GroupLayout(pnlUsuariosTab);
        pnlUsuariosTab.setLayout(pnlUsuariosTabLayout);
        pnlUsuariosTabLayout.setHorizontalGroup(
            pnlUsuariosTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsuariosTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUsuariosTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEditarUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                    .addComponent(lblRegistrarUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblControlGeneralUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(507, Short.MAX_VALUE))
        );
        pnlUsuariosTabLayout.setVerticalGroup(
            pnlUsuariosTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsuariosTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUsuariosTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator6)
                    .addGroup(pnlUsuariosTabLayout.createSequentialGroup()
                        .addComponent(lblEditarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblRegistrarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblControlGeneralUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 112, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tabPanePrincipal.addTab("Usuarios", null, pnlUsuariosTab, "Usuarios");

        pnlInventarioTab.setBackground(new java.awt.Color(153, 153, 255));

        pnlInventario.setBackground(new java.awt.Color(153, 153, 255));

        lblAgregarProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Add-Inventario.png"))); // NOI18N
        lblAgregarProductos.setText("Agregar productos");
        lblAgregarProductos.setToolTipText("Agregar productos");
        lblAgregarProductos.setColorDeSegundoBorde(new java.awt.Color(204, 204, 204));
        lblAgregarProductos.setOpaque(true);
        lblAgregarProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregarProductosMouseClicked(evt);
            }
        });

        lblEditarProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/edit.png"))); // NOI18N
        lblEditarProductos.setText("Editar productos");
        lblEditarProductos.setToolTipText("Editar productos");
        lblEditarProductos.setColorDeSegundoBorde(new java.awt.Color(204, 204, 204));
        lblEditarProductos.setOpaque(true);
        lblEditarProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEditarProductosMouseClicked(evt);
            }
        });

        lblControlGeneralProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Control.png"))); // NOI18N
        lblControlGeneralProductos.setText("Control general de productos");
        lblControlGeneralProductos.setToolTipText("Control general");
        lblControlGeneralProductos.setColorDeSegundoBorde(new java.awt.Color(204, 204, 204));
        lblControlGeneralProductos.setOpaque(true);
        lblControlGeneralProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblControlGeneralProductosMouseClicked(evt);
            }
        });

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblGeneradorCodigoBarras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Barcode-icon.png"))); // NOI18N
        lblGeneradorCodigoBarras.setText("Generador de código de barras");
        lblGeneradorCodigoBarras.setToolTipText("Código de barras");
        lblGeneradorCodigoBarras.setColorDeSegundoBorde(new java.awt.Color(204, 204, 204));
        lblGeneradorCodigoBarras.setOpaque(true);
        lblGeneradorCodigoBarras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGeneradorCodigoBarrasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlInventarioLayout = new javax.swing.GroupLayout(pnlInventario);
        pnlInventario.setLayout(pnlInventarioLayout);
        pnlInventarioLayout.setHorizontalGroup(
            pnlInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAgregarProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                    .addComponent(lblEditarProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblControlGeneralProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGeneradorCodigoBarras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(507, Short.MAX_VALUE))
        );
        pnlInventarioLayout.setVerticalGroup(
            pnlInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5)
                    .addGroup(pnlInventarioLayout.createSequentialGroup()
                        .addComponent(lblAgregarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblEditarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblControlGeneralProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblGeneradorCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnlInventarioTab.add(pnlInventario, java.awt.BorderLayout.CENTER);

        tabPanePrincipal.addTab("Inventario", null, pnlInventarioTab, "Inventario");

        pnlFacturacionTab.setBackground(new java.awt.Color(153, 153, 255));

        pnlFacturacion.setBackground(new java.awt.Color(153, 153, 255));

        lblIniciarFacturacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cash-register-icon.png"))); // NOI18N
        lblIniciarFacturacion.setText("Iniciar facturación");
        lblIniciarFacturacion.setToolTipText("Iniciar facturación");
        lblIniciarFacturacion.setColorDeSegundoBorde(new java.awt.Color(204, 204, 204));
        lblIniciarFacturacion.setOpaque(true);
        lblIniciarFacturacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIniciarFacturacionMouseClicked(evt);
            }
        });

        lblVerFacturasPendientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/eye-32.png"))); // NOI18N
        lblVerFacturasPendientes.setText("Ver facturas pendientes");
        lblVerFacturasPendientes.setToolTipText("Ver pendientes");
        lblVerFacturasPendientes.setColorDeSegundoBorde(new java.awt.Color(204, 204, 204));
        lblVerFacturasPendientes.setOpaque(true);
        lblVerFacturasPendientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVerFacturasPendientesMouseClicked(evt);
            }
        });

        lblVerFacturasEmitidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Player Next.png"))); // NOI18N
        lblVerFacturasEmitidas.setText("Ver facturas emitidas");
        lblVerFacturasEmitidas.setToolTipText("Ver emitidas");
        lblVerFacturasEmitidas.setColorDeSegundoBorde(new java.awt.Color(204, 204, 204));
        lblVerFacturasEmitidas.setOpaque(true);
        lblVerFacturasEmitidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVerFacturasEmitidasMouseClicked(evt);
            }
        });

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout pnlFacturacionLayout = new javax.swing.GroupLayout(pnlFacturacion);
        pnlFacturacion.setLayout(pnlFacturacionLayout);
        pnlFacturacionLayout.setHorizontalGroup(
            pnlFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFacturacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblVerFacturasPendientes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addComponent(lblVerFacturasEmitidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIniciarFacturacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(505, Short.MAX_VALUE))
        );
        pnlFacturacionLayout.setVerticalGroup(
            pnlFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFacturacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlFacturacionLayout.createSequentialGroup()
                        .addComponent(lblIniciarFacturacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblVerFacturasPendientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblVerFacturasEmitidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 112, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnlFacturacionTab.add(pnlFacturacion, java.awt.BorderLayout.CENTER);

        tabPanePrincipal.addTab("Facturación", null, pnlFacturacionTab, "Facturación");

        pnlClientesTab.setBackground(new java.awt.Color(153, 153, 255));

        lblControlGeneralClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Control.png"))); // NOI18N
        lblControlGeneralClientes.setText("Control general de clientes");
        lblControlGeneralClientes.setToolTipText("Control general");
        lblControlGeneralClientes.setColorDeSegundoBorde(new java.awt.Color(204, 204, 204));
        lblControlGeneralClientes.setOpaque(true);
        lblControlGeneralClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblControlGeneralClientesMouseClicked(evt);
            }
        });

        lblEditarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/user_edit.png"))); // NOI18N
        lblEditarClientes.setText("Editar clientes");
        lblEditarClientes.setToolTipText("Editar clientes");
        lblEditarClientes.setColorDeSegundoBorde(new java.awt.Color(204, 204, 204));
        lblEditarClientes.setOpaque(true);
        lblEditarClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEditarClientesMouseClicked(evt);
            }
        });

        lblAgregarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/customer_add.png"))); // NOI18N
        lblAgregarClientes.setText("Agregar clientes");
        lblAgregarClientes.setToolTipText("Registrar clientes");
        lblAgregarClientes.setColorDeSegundoBorde(new java.awt.Color(204, 204, 204));
        lblAgregarClientes.setOpaque(true);
        lblAgregarClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregarClientesMouseClicked(evt);
            }
        });

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout pnlClientesLayout = new javax.swing.GroupLayout(pnlClientes);
        pnlClientes.setLayout(pnlClientesLayout);
        pnlClientesLayout.setHorizontalGroup(
            pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblControlGeneralClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                    .addComponent(lblEditarClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAgregarClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(501, Short.MAX_VALUE))
        );
        pnlClientesLayout.setVerticalGroup(
            pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlClientesLayout.createSequentialGroup()
                        .addComponent(lblAgregarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblEditarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblControlGeneralClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 112, Short.MAX_VALUE))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pnlClientesTab.add(pnlClientes, java.awt.BorderLayout.CENTER);

        tabPanePrincipal.addTab("Clientes", null, pnlClientesTab, "Clientes");

        pnlSistemaTab.setBackground(new java.awt.Color(153, 153, 255));

        lblExportarRespaldo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/export.png"))); // NOI18N
        lblExportarRespaldo.setText("Exportar resplado");
        lblExportarRespaldo.setToolTipText("Exportar respaldo");
        lblExportarRespaldo.setColorDeSegundoBorde(new java.awt.Color(204, 204, 204));
        lblExportarRespaldo.setOpaque(true);
        lblExportarRespaldo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExportarRespaldoMouseClicked(evt);
            }
        });

        lblImportarRespaldo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/download-database.png"))); // NOI18N
        lblImportarRespaldo.setText("Importar respaldo");
        lblImportarRespaldo.setToolTipText("Importar respaldo");
        lblImportarRespaldo.setColorDeSegundoBorde(new java.awt.Color(204, 204, 204));
        lblImportarRespaldo.setOpaque(true);
        lblImportarRespaldo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImportarRespaldoMouseClicked(evt);
            }
        });

        lblHistorialInicioSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/History_clock.png"))); // NOI18N
        lblHistorialInicioSesion.setText("Historial de inicio de sesión");
        lblHistorialInicioSesion.setToolTipText("Historial de sesión");
        lblHistorialInicioSesion.setColorDeSegundoBorde(new java.awt.Color(204, 204, 204));
        lblHistorialInicioSesion.setOpaque(true);
        lblHistorialInicioSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHistorialInicioSesionMouseClicked(evt);
            }
        });

        lblHistorialVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/history-icon.png"))); // NOI18N
        lblHistorialVentas.setText("Historial de ventas");
        lblHistorialVentas.setToolTipText("Historial de ventas");
        lblHistorialVentas.setColorDeSegundoBorde(new java.awt.Color(204, 204, 204));
        lblHistorialVentas.setOpaque(true);
        lblHistorialVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHistorialVentasMouseClicked(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout pnlSistemaLayout = new javax.swing.GroupLayout(pnlSistema);
        pnlSistema.setLayout(pnlSistemaLayout);
        pnlSistemaLayout.setHorizontalGroup(
            pnlSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSistemaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImportarRespaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblExportarRespaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHistorialVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHistorialInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(502, Short.MAX_VALUE))
        );
        pnlSistemaLayout.setVerticalGroup(
            pnlSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSistemaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(pnlSistemaLayout.createSequentialGroup()
                        .addComponent(lblHistorialInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblHistorialVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblExportarRespaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblImportarRespaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnlSistemaTab.add(pnlSistema, java.awt.BorderLayout.CENTER);

        tabPanePrincipal.addTab("Sistema", null, pnlSistemaTab, "Sistema");

        pnlInformacionTab.setBackground(new java.awt.Color(153, 153, 255));

        lblActivarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Security_Circle_Red.png"))); // NOI18N
        lblActivarProducto.setText("Activar producto");
        lblActivarProducto.setToolTipText("Activar producto");
        lblActivarProducto.setColorDeSegundoBorde(new java.awt.Color(204, 204, 204));
        lblActivarProducto.setOpaque(true);
        lblActivarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblActivarProductoMouseClicked(evt);
            }
        });

        lblBuscarActualizaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/actuality.png"))); // NOI18N
        lblBuscarActualizaciones.setText("Buscar actualizaciones");
        lblBuscarActualizaciones.setToolTipText("Buscar actualizaciones");
        lblBuscarActualizaciones.setColorDeSegundoBorde(new java.awt.Color(102, 102, 102));
        lblBuscarActualizaciones.setOpaque(true);
        lblBuscarActualizaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuscarActualizacionesMouseClicked(evt);
            }
        });

        lblAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/help.png"))); // NOI18N
        lblAyuda.setText("Ayuda");
        lblAyuda.setToolTipText("Ayuda");
        lblAyuda.setColorDeSegundoBorde(new java.awt.Color(204, 204, 204));
        lblAyuda.setOpaque(true);
        lblAyuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAyudaMouseClicked(evt);
            }
        });

        lblInformacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Informacion.png"))); // NOI18N
        lblInformacion.setText("Acerca de...");
        lblInformacion.setToolTipText("Acerca de");
        lblInformacion.setColorDeSegundoBorde(new java.awt.Color(204, 204, 204));
        lblInformacion.setOpaque(true);
        lblInformacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInformacionMouseClicked(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout pnlInformacionLayout = new javax.swing.GroupLayout(pnlInformacion);
        pnlInformacion.setLayout(pnlInformacionLayout);
        pnlInformacionLayout.setHorizontalGroup(
            pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                    .addComponent(lblAyuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblActivarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBuscarActualizaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(503, Short.MAX_VALUE))
        );
        pnlInformacionLayout.setVerticalGroup(
            pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(pnlInformacionLayout.createSequentialGroup()
                        .addComponent(lblAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblActivarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblBuscarActualizaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnlInformacionTab.add(pnlInformacion, java.awt.BorderLayout.CENTER);

        tabPanePrincipal.addTab("Información", null, pnlInformacionTab, "Información");

        jToolBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jLabel1.setText("Nombre de usuario:");
        jLabel1.setName(""); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(117, 14));
        jToolBar1.add(jLabel1);

        lblDatoNombreUsuario.setText("Sin registros");
        jToolBar1.add(lblDatoNombreUsuario);

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));
        jToolBar1.add(jSeparator7);

        jLabel2.setText("Cajero:");
        jLabel2.setPreferredSize(new java.awt.Dimension(50, 14));
        jToolBar1.add(jLabel2);

        lblDatoNombre.setText("Sin registros");
        jToolBar1.add(lblDatoNombre);

        jSeparator8.setBackground(new java.awt.Color(0, 0, 0));
        jToolBar1.add(jSeparator8);

        jLabel3.setText("Departamento:");
        jLabel3.setPreferredSize(new java.awt.Dimension(95, 14));
        jToolBar1.add(jLabel3);

        lblDatoDepartamento.setText("Sin registros");
        jToolBar1.add(lblDatoDepartamento);

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPanePrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addComponent(tabPanePrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(151, 151, 151)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlPrincipal.add(pnlBackground, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblEditarUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditarUsuariosMouseClicked
        // TODO add your handling code here:
        frmEditarEmpleado oEdit = new frmEditarEmpleado(this, rootPaneCheckingEnabled, cnx,lblDatoNombre.getText());
        oEdit.setVisible(true);
    }//GEN-LAST:event_lblEditarUsuariosMouseClicked

    private void lblAgregarProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarProductosMouseClicked
        // TODO add your handling code here:
        frmAgregarProducto oAdd = new frmAgregarProducto(this, rootPaneCheckingEnabled, cnx);
        oAdd.setVisible(true);
    }//GEN-LAST:event_lblAgregarProductosMouseClicked

    private void lblEditarProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditarProductosMouseClicked
        // TODO add your handling code here:
        frmEditarProducto oEdit = new frmEditarProducto(this, rootPaneCheckingEnabled, cnx);
        oEdit.setVisible(true);

    }//GEN-LAST:event_lblEditarProductosMouseClicked

    private void lblControlGeneralProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblControlGeneralProductosMouseClicked
        // TODO add your handling code here:
        frmControlTotalInventario oControl = new frmControlTotalInventario(cnx);
        oControl.setVisible(true);
    }//GEN-LAST:event_lblControlGeneralProductosMouseClicked

    private void lblIniciarFacturacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIniciarFacturacionMouseClicked
        frmFacturacion oFacturacion = new frmFacturacion(this, rootPaneCheckingEnabled, cnx, lblDatoNombre.getText());
        oFacturacion.setVisible(true);
    }//GEN-LAST:event_lblIniciarFacturacionMouseClicked

    private void lblVerFacturasPendientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVerFacturasPendientesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblVerFacturasPendientesMouseClicked

    private void lblVerFacturasEmitidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVerFacturasEmitidasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblVerFacturasEmitidasMouseClicked

    private void lblControlGeneralClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblControlGeneralClientesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblControlGeneralClientesMouseClicked

    private void lblEditarClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditarClientesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblEditarClientesMouseClicked

    private void lblAgregarClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarClientesMouseClicked
frmRegistrarCliente oRegistrar = new frmRegistrarCliente(this, rootPaneCheckingEnabled);
oRegistrar.setVisible(true);
    }//GEN-LAST:event_lblAgregarClientesMouseClicked

    private void lblExportarRespaldoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExportarRespaldoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblExportarRespaldoMouseClicked

    private void lblImportarRespaldoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImportarRespaldoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblImportarRespaldoMouseClicked

    private void lblHistorialInicioSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHistorialInicioSesionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblHistorialInicioSesionMouseClicked

    private void lblHistorialVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHistorialVentasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblHistorialVentasMouseClicked

    private void lblActivarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblActivarProductoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblActivarProductoMouseClicked

    private void lblBuscarActualizacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarActualizacionesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblBuscarActualizacionesMouseClicked

    private void lblAyudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAyudaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblAyudaMouseClicked

    private void lblInformacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInformacionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblInformacionMouseClicked

    private void lblGeneradorCodigoBarrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGeneradorCodigoBarrasMouseClicked
        // TODO add your handling code here:
        GestionTxt oTxt = new GestionTxt();
        oTxt.escrituraConexionTxt(
                cnx.getServidor(), cnx.getPuerto(),
                cnx.getBaseDatos(), cnx.getUsuario(),
                cnx.getPassword(), cnx.getEsquema()
        );
        if (oTxt.isError()) {
            JOptionPane.showMessageDialog(null, "Error al intentar abrir la aplicación. Detalle técnico: " + oTxt.getErrorDescripcion(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                File miDir = new File("C:\\Sistema Punto Venta\\frmCodigoBarras\\bin\\Debug\\");
                if (miDir.exists()) {
                    Process proceso = Runtime.getRuntime().exec("C:\\Sistema Punto Venta\\frmCodigoBarras\\bin\\Debug\\frmCodigoBarras.exe");
                } else {
                    JOptionPane.showMessageDialog(null, "Problemas al intentar iniciar la aplicación, posible inexistencia de ésta herramienta.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception xp) {
                JOptionPane.showMessageDialog(null, "Error al intentar ejecutar la aplicación. Detalle técnico: " + xp.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_lblGeneradorCodigoBarrasMouseClicked

    private void tabPanePrincipalStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabPanePrincipalStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tabPanePrincipalStateChanged

    private void lblRegistrarUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrarUsuariosMouseClicked
        // TODO add your handling code here:
        frmRegistrarEmpleado oRegistrar = new frmRegistrarEmpleado(this, rootPaneCheckingEnabled, cnx, lblDatoNombre.getText());
        oRegistrar.setVisible(true);
    }//GEN-LAST:event_lblRegistrarUsuariosMouseClicked

    private void lblControlGeneralUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblControlGeneralUsuariosMouseClicked

    }//GEN-LAST:event_lblControlGeneralUsuariosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar jToolBar1;
    private org.edisoncor.gui.label.LabelTask lblActivarProducto;
    private org.edisoncor.gui.label.LabelTask lblAgregarClientes;
    private org.edisoncor.gui.label.LabelTask lblAgregarProductos;
    private org.edisoncor.gui.label.LabelTask lblAyuda;
    private org.edisoncor.gui.label.LabelTask lblBuscarActualizaciones;
    private org.edisoncor.gui.label.LabelTask lblControlGeneralClientes;
    private org.edisoncor.gui.label.LabelTask lblControlGeneralProductos;
    private org.edisoncor.gui.label.LabelTask lblControlGeneralUsuarios;
    private javax.swing.JLabel lblDatoDepartamento;
    private javax.swing.JLabel lblDatoNombre;
    private javax.swing.JLabel lblDatoNombreUsuario;
    private org.edisoncor.gui.label.LabelTask lblEditarClientes;
    private org.edisoncor.gui.label.LabelTask lblEditarProductos;
    private org.edisoncor.gui.label.LabelTask lblEditarUsuarios;
    private org.edisoncor.gui.label.LabelTask lblExportarRespaldo;
    private org.edisoncor.gui.label.LabelTask lblGeneradorCodigoBarras;
    private org.edisoncor.gui.label.LabelTask lblHistorialInicioSesion;
    private org.edisoncor.gui.label.LabelTask lblHistorialVentas;
    private org.edisoncor.gui.label.LabelTask lblImportarRespaldo;
    private org.edisoncor.gui.label.LabelTask lblInformacion;
    private org.edisoncor.gui.label.LabelTask lblIniciarFacturacion;
    private org.edisoncor.gui.label.LabelTask lblRegistrarUsuarios;
    private org.edisoncor.gui.label.LabelTask lblVerFacturasEmitidas;
    private org.edisoncor.gui.label.LabelTask lblVerFacturasPendientes;
    private org.edisoncor.gui.panel.PanelShadow pnlBackground;
    private org.edisoncor.gui.panel.PanelShadow pnlClientes;
    private org.edisoncor.gui.panel.PanelNice pnlClientesTab;
    private org.edisoncor.gui.panel.PanelShadow pnlFacturacion;
    private org.edisoncor.gui.panel.PanelNice pnlFacturacionTab;
    private org.edisoncor.gui.panel.PanelShadow pnlInformacion;
    private org.edisoncor.gui.panel.PanelNice pnlInformacionTab;
    private org.edisoncor.gui.panel.PanelShadow pnlInventario;
    private org.edisoncor.gui.panel.PanelNice pnlInventarioTab;
    private org.edisoncor.gui.panel.PanelNice pnlPrincipal;
    private org.edisoncor.gui.panel.PanelShadow pnlSistema;
    private org.edisoncor.gui.panel.PanelNice pnlSistemaTab;
    private org.edisoncor.gui.panel.PanelNice pnlUsuariosTab;
    private org.edisoncor.gui.tabbedPane.TabbedPaneHeader tabPanePrincipal;
    // End of variables declaration//GEN-END:variables
}
