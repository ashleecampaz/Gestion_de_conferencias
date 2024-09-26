
package com.easyconference.presentation;

import com.easyconference.domain.entities.Articulo;
import com.easyconference.domain.entities.Conference;
import com.easyconference.domain.entities.Usuario;
import com.easyconference.domain.service.ArticuloService;
import com.easyconference.domain.service.ConferenceService;
import com.easyconference.domain.service.IUserService;
import com.easyconference.domain.service.UserService;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Interfaz contenedora 
 * 
 * @author 
 * @version 1.0
 * @since 2024
 */
public class GUIcontainer extends javax.swing.JFrame {

    private Usuario usuario;
    private ConferenceService conferenceService;
    private ArticuloService articuloService;

    /**
     * Creates new form GUIcontainer
     */
    public GUIcontainer(Usuario us, ConferenceService con, ArticuloService artService) {
        this.usuario = us;
        this.conferenceService = con;
        this.articuloService = artService;
        initComponents();
        listConferences();
        listArticles();
    }

    @SuppressWarnings("unchecked")
    // Método que se ejecuta cuando el usuario hace clic en "Listado de conferencias"
    public void listConferences() {
        pnlListadoCon.removeAll();  // Limpiamos el contenido actual del panel de conferencias

        // Configuramos el layout del panel para mantener el título arriba
        pnlListadoCon.setLayout(new BorderLayout());

        // Creamos un panel para listar las conferencias con un BoxLayout para apilar verticalmente
        JPanel panelConferencias = new JPanel();
        panelConferencias.setLayout(new BoxLayout(panelConferencias, BoxLayout.Y_AXIS));  // Apilamos verticalmente los mini paneles

        // Añadimos nuevamente el título "Listado de conferencias" en la parte superior
        pnlListadoCon.add(lbListadoCon, BorderLayout.NORTH);

        // Obtenemos todas las conferencias desde el servicio
        List<Conference> conferences = conferenceService.listarConferencias();

        // Por cada conferencia, creamos un mini panel con su información
        for (Conference conference : conferences) {
            JPanel conferencePanel = new JPanel();  // Creamos un panel para cada conferencia
            conferencePanel.setLayout(new BorderLayout());  // Usamos BorderLayout para organizar componentes
            conferencePanel.setPreferredSize(new Dimension(277, 30));  // Ajustamos el tamaño del panel
            conferencePanel.setMaximumSize(new Dimension(277, 30));  // Evita que los paneles se estiren más allá de este tamaño

            // Etiquetas con la información de la conferencia
            JLabel nameLabel = new JLabel("Conferencia: " + conference.getName());  // Etiqueta con el nombre de la conferencia
            JLabel dateLabel = new JLabel("Fecha: " + conference.getStartDate());  // Etiqueta con la fecha de la conferencia

            // Botón con el símbolo "+"
            JButton detallesButton = new JButton("+");
            detallesButton.setPreferredSize(new Dimension(45, 40));  // Ajustamos el tamaño del botón
            detallesButton.addActionListener(e -> {
                // Abre la ventana GUIcreateArticle para la conferencia seleccionada
                GUIcreateArticle createArticleView = new GUIcreateArticle(articuloService, conference,this);  // Pasamos ArticuloService y Conference al constructor

                // Añadimos GUIcreateArticle al JDesktopPane
                dskpaneContenedor.add(createArticleView);  // Agregamos la ventana al JDesktopPane

                // Configuramos el JInternalFrame para que se muestre correctamente
                createArticleView.setVisible(true);  // Hacemos visible el JInternalFrame
                try {
                    createArticleView.setMaximum(true);  // Lo maximizamos dentro del JDesktopPane (opcional)
                } catch (PropertyVetoException ex) {
                    ex.printStackTrace();
                }
                // Actualizamos la lista de artículos después de abrir la ventana de creación de artículo
                listArticles();
            });

            // Añadimos las etiquetas de información en un sub-panel
            JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));  // Usamos FlowLayout para alinear a la izquierda
            infoPanel.add(nameLabel);
            infoPanel.add(dateLabel);

            // Añadimos las etiquetas de información en el centro del mini panel
            conferencePanel.add(infoPanel, BorderLayout.CENTER);

            // Añadimos el botón "+" en el lado derecho del mini panel
            conferencePanel.add(detallesButton, BorderLayout.EAST);

            // Añadimos el mini panel al panel de conferencias
            panelConferencias.add(conferencePanel);

            // Añadimos un espacio entre los paneles para que no se vean juntos
            panelConferencias.add(Box.createRigidArea(new Dimension(0, 1)));
        }

        // Ahora, ponemos el panelConferencias dentro de un JScrollPane para agregar scroll si es necesario
        JScrollPane scrollPane = new JScrollPane(panelConferencias);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);  // Barra de desplazamiento vertical cuando sea necesario
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  // Deshabilitar barra horizontal

        // Añadimos el JScrollPane al centro de pnlListadoCon
        pnlListadoCon.add(scrollPane, BorderLayout.CENTER);

        // Refrescamos y repintamos el panel para que los cambios se reflejen
        pnlListadoCon.revalidate();
        pnlListadoCon.repaint();
    }

    // Método para listar los artículos del usuario
    @SuppressWarnings("unchecked")
    public void listArticles() {
        pnlListadoAr.removeAll();  // Limpiamos el contenido actual del panel de artículos

        // Configuramos el layout del panel para mantener el título arriba
        pnlListadoAr.setLayout(new BorderLayout());

        // Creamos un panel para listar los artículos con un BoxLayout para apilar verticalmente
        JPanel panelArticulos = new JPanel();
        panelArticulos.setLayout(new BoxLayout(panelArticulos, BoxLayout.Y_AXIS));  // Apilamos verticalmente los mini paneles

        // Añadimos nuevamente el título "Listado de artículos" en la parte superior
        pnlListadoAr.add(lbListadoAr, BorderLayout.NORTH);

        // Obtenemos todos los artículos desde el servicio
        List<Articulo> articulos = articuloService.listarArticulos();

        // Por cada artículo, creamos un mini panel con su información
        for (Articulo articulo : articulos) {
            JPanel articuloPanel = new JPanel();  // Creamos un panel para cada artículo
            articuloPanel.setLayout(new BorderLayout());  // Usamos BorderLayout para organizar componentes
            articuloPanel.setPreferredSize(new Dimension(277, 30));  // Ajustamos el tamaño del panel
            articuloPanel.setMaximumSize(new Dimension(277, 30));  // Evita que los paneles se estiren más allá de este tamaño

            // Etiqueta con el nombre del artículo
            JLabel nameLabel = new JLabel("Artículo: " + articulo.getNombre());  // Mostramos el título del artículo

            // Añadimos la etiqueta de información en el centro del mini panel
            articuloPanel.add(nameLabel, BorderLayout.CENTER);

            // Añadimos el mini panel al panel de artículos
            panelArticulos.add(articuloPanel);

            // Añadimos un espacio entre los paneles para que no se vean juntos
            panelArticulos.add(Box.createRigidArea(new Dimension(0, 1)));
        }

        // Ahora, ponemos el panelArticulos dentro de un JScrollPane para agregar scroll si es necesario
        JScrollPane scrollPane = new JScrollPane(panelArticulos);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);  // Barra de desplazamiento vertical cuando sea necesario
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  // Deshabilitar barra horizontal

        // Añadimos el JScrollPane al centro de pnlListadoAr
        pnlListadoAr.add(scrollPane, BorderLayout.CENTER);

        // Refrescamos y repintamos el panel para que los cambios se reflejen
        pnlListadoAr.revalidate();
        pnlListadoAr.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlFondo = new javax.swing.JPanel();
        dskpaneContenedor = new javax.swing.JDesktopPane();
        intfInicio = new javax.swing.JInternalFrame();
        lbBienvenido = new javax.swing.JLabel();
        txtfBusqueda = new javax.swing.JTextField();
        pnlListadoCon = new javax.swing.JPanel();
        lbListadoCon = new javax.swing.JLabel();
        pnlListadoAr = new javax.swing.JPanel();
        lbListadoAr = new javax.swing.JLabel();
        pnlBotonCrearCon = new javax.swing.JPanel();
        lbCrearCon = new javax.swing.JLabel();
        lbBtnBuscar = new javax.swing.JLabel();
        pnlSuperior = new javax.swing.JPanel();
        lbeasyConference = new javax.swing.JLabel();
        lbCerrarSesion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(873, 650));
        setSize(new java.awt.Dimension(873, 650));

        pnlFondo.setMinimumSize(new java.awt.Dimension(873, 650));
        pnlFondo.setPreferredSize(new java.awt.Dimension(873, 650));
        pnlFondo.setLayout(new java.awt.BorderLayout());

        dskpaneContenedor.setSelectedFrame(intfInicio);
        dskpaneContenedor.setLayout(new java.awt.BorderLayout());

        intfInicio.setBackground(new java.awt.Color(255, 255, 255));
        intfInicio.setBorder(null);
        intfInicio.setFrameIcon(null);
        intfInicio.setMinimumSize(new java.awt.Dimension(873, 650));
        intfInicio.setPreferredSize(new java.awt.Dimension(873, 650));
        intfInicio.setVisible(true);
        try {
            intfInicio.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(GUIcontainer.class.getName()).log(Level.SEVERE, null, ex);
        }
        intfInicio.getContentPane().setLayout(new java.awt.GridBagLayout());

        lbBienvenido.setFont(new java.awt.Font("Segoe UI Semilight", 1, 24)); // NOI18N
        lbBienvenido.setText("Bienvenido! "+ usuario.getName() + " " + usuario.getLastName());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 479;
        gridBagConstraints.ipady = -1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(95, 56, 0, 0);
        intfInicio.getContentPane().add(lbBienvenido, gridBagConstraints);

        txtfBusqueda.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        txtfBusqueda.setText("Buscar conferencia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 373;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(51, 267, 0, 0);
        intfInicio.getContentPane().add(txtfBusqueda, gridBagConstraints);

        pnlListadoCon.setBackground(new java.awt.Color(236, 236, 236));
        pnlListadoCon.setPreferredSize(new java.awt.Dimension(136, 204));
        pnlListadoCon.setLayout(new java.awt.BorderLayout());

        lbListadoCon.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lbListadoCon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbListadoCon.setText("Listado de conferencias");
        lbListadoCon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(197, 197, 197)));
        pnlListadoCon.add(lbListadoCon, java.awt.BorderLayout.PAGE_START);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 136;
        gridBagConstraints.ipady = 204;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 46, 98, 0);
        intfInicio.getContentPane().add(pnlListadoCon, gridBagConstraints);

        pnlListadoAr.setBackground(new java.awt.Color(236, 236, 236));
        pnlListadoAr.setMinimumSize(new java.awt.Dimension(145, 22));
        pnlListadoAr.setPreferredSize(new java.awt.Dimension(136, 204));
        pnlListadoAr.setLayout(new java.awt.BorderLayout());

        lbListadoAr.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lbListadoAr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbListadoAr.setText("Listado de articulos");
        lbListadoAr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(197, 197, 197)));
        pnlListadoAr.add(lbListadoAr, java.awt.BorderLayout.PAGE_START);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 136;
        gridBagConstraints.ipady = 204;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 22, 98, 0);
        intfInicio.getContentPane().add(pnlListadoAr, gridBagConstraints);

        pnlBotonCrearCon.setBackground(new java.awt.Color(129, 218, 199));
        pnlBotonCrearCon.setLayout(new java.awt.BorderLayout());

        lbCrearCon.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lbCrearCon.setForeground(new java.awt.Color(255, 255, 255));
        lbCrearCon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCrearCon.setText("Crear conferencia");
        lbCrearCon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCrearCon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCrearConMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbCrearConMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbCrearConMouseExited(evt);
            }
        });
        pnlBotonCrearCon.add(lbCrearCon, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 83;
        gridBagConstraints.ipady = 72;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 18, 0, 61);
        intfInicio.getContentPane().add(pnlBotonCrearCon, gridBagConstraints);

        lbBtnBuscar.setText("buscar");
        lbBtnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBtnBuscarMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(57, 6, 0, 0);
        intfInicio.getContentPane().add(lbBtnBuscar, gridBagConstraints);

        dskpaneContenedor.add(intfInicio, java.awt.BorderLayout.CENTER);
        //getContentPane().add(intfInicio, java.awt.BorderLayout.CENTER);

        pnlFondo.add(dskpaneContenedor, java.awt.BorderLayout.CENTER);
        //getContentPane().add(dskpaneContenedor, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlFondo, java.awt.BorderLayout.CENTER);

        pnlSuperior.setBackground(new java.awt.Color(0, 153, 153));
        pnlSuperior.setPreferredSize(new java.awt.Dimension(1028, 52));
        pnlSuperior.setLayout(new java.awt.BorderLayout(10, 0));

        lbeasyConference.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        lbeasyConference.setForeground(new java.awt.Color(255, 255, 255));
        lbeasyConference.setText("easyConference");
        pnlSuperior.add(lbeasyConference, java.awt.BorderLayout.CENTER);
        pnlSuperior.add(lbeasyConference, java.awt.BorderLayout.WEST);

        lbCerrarSesion.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        lbCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        lbCerrarSesion.setText("Cerrar sesion");
        lbCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCerrarSesionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbCerrarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbCerrarSesionMouseExited(evt);
            }
        });
        pnlSuperior.add(lbCerrarSesion, java.awt.BorderLayout.PAGE_START);
        pnlSuperior.add(lbCerrarSesion, java.awt.BorderLayout.EAST);

        getContentPane().add(pnlSuperior, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(pnlSuperior, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbCrearConMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCrearConMouseEntered
        // TODO add your handling code here:
        lbCrearCon.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15));
    }//GEN-LAST:event_lbCrearConMouseEntered

    private void lbCrearConMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCrearConMouseExited
        // TODO add your handling code here:
        lbCrearCon.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14));
    }//GEN-LAST:event_lbCrearConMouseExited

    private void lbCrearConMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCrearConMouseClicked
        GUIcreateConference crearConferencia = new GUIcreateConference(conferenceService, this);
        try {
            crearConferencia.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(GUIcontainer.class.getName()).log(Level.SEVERE, null, ex);
        }

        dskpaneContenedor.add(crearConferencia, java.awt.BorderLayout.CENTER);
        crearConferencia.setVisible(true);
    }//GEN-LAST:event_lbCrearConMouseClicked

    private void lbBtnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBtnBuscarMouseClicked

    }//GEN-LAST:event_lbBtnBuscarMouseClicked

    private void lbCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarSesionMouseEntered
        lbCerrarSesion.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14));
    }//GEN-LAST:event_lbCerrarSesionMouseEntered

    private void lbCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarSesionMouseExited
        lbCerrarSesion.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14));
    }//GEN-LAST:event_lbCerrarSesionMouseExited

    private void lbCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarSesionMouseClicked
        this.dispose();
        UserService userService = new UserService((IUserService) conferenceService.getReferenceRepositoryConferency());
        GUIlogin login = new GUIlogin(userService);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }//GEN-LAST:event_lbCerrarSesionMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dskpaneContenedor;
    private javax.swing.JInternalFrame intfInicio;
    private javax.swing.JLabel lbBienvenido;
    private javax.swing.JLabel lbBtnBuscar;
    private javax.swing.JLabel lbCerrarSesion;
    private javax.swing.JLabel lbCrearCon;
    private javax.swing.JLabel lbListadoAr;
    private javax.swing.JLabel lbListadoCon;
    private javax.swing.JLabel lbeasyConference;
    private javax.swing.JPanel pnlBotonCrearCon;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlListadoAr;
    private javax.swing.JPanel pnlListadoCon;
    private javax.swing.JPanel pnlSuperior;
    private javax.swing.JTextField txtfBusqueda;
    // End of variables declaration//GEN-END:variables
}
