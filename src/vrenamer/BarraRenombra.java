/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vrenamer;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import static vrenamer.CreaValores.*;
import static vrenamer.vRenamer.separador;

/**
 *
 * @author Carlos Verdier <carlos@yourappeasy.com>
 */
public class BarraRenombra extends JPanel {

    private JCheckBox ckEnabled;
    private JButton btnMas;
    private JButton btnMenos;
    private final String[] opcionesBusca = {Idioma.getComboText(),Idioma.getComboNumber(),Idioma.getComboFile(),Idioma.getComboFolder(),Idioma.getComboDate(),Idioma.getComboDatePicture(),Idioma.getComboCamera(),Idioma.getComboMusic()};
    private final String[] separaOpcionesCampos = {"_","-","{ }",separador,"off"};
    
    private JLabel indicadorDrop;
    
    private JComboBox<String> comboBusca;
    private JComboBox<String> jSeparaCampos;
    private JTextField textoBusca;
    private int separaIndex = 0;
    private String separaText = "_";
    private JSpinner numeracionSalto;
    private SpinnerModel ns;
    private JLabel lblSalto;
    private JWidePopupComboBox resetNumera;
    private JComboBox<String> secuenciaTipo;
    private JComboBox<String> secuenciaTipoCase;    
    private JComboBox<String> jNumeracion;
    private JSpinner numeracionTexto;
    private JLabel lblEmpieza;
    private SpinnerModel sm;
    
    private JComboBox<String> jArchivo;
    private JTextField jCorte;
    private JSpinner numeracionCorte;
    private JWidePopupComboBox hastaFinal;
    private JSpinner archivoDesde;
    private JSpinner archivoHasta;
    private JTextField archivoTextoDesde;
    private JTextField archivoTextoHasta;
    private JLabel lblSeccion;
    private JLabel lblArchivoHasta;
    private JLabel lblArchivoTextoHasta;
    
    private JComboBox<String> jFecha;
    
    private JComboBox<String> jCarpeta;
    private JWidePopupComboBox separaFecha;
    private JComboBox<String> jMetadata;
    
    private JComboBox<String> jMetadataCamara;
    private JComboBox<String> jMp3;
    
    private int numeroEnabled = 3;
    private int numeroEnabledInicio = 2;
    
    private static ClassLoader cldr = BarraRenombra.class.getClassLoader();
    private static final java.net.URL DRAG_IMG = cldr.getResource("img/drag_indicator_FILL0_wght400_GRAD0_opsz24.png");
    public static ImageIcon dragOk = new ImageIcon(DRAG_IMG);
    
    
    public BarraRenombra() {
        super();        
        iniciaValores();
    }
    private void iniciaValores() {
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setBorder(BorderFactory.createEmptyBorder(0,0,5,0));    
        indicadorDrop = new JLabel(dragOk);
        ckEnabled = new JCheckBox();
        ckEnabled.setSelected(true);   
        comboBusca = new JComboBox(opcionesBusca);
	vRenamer.setFont(comboBusca, 11, Font.BOLD);
	comboBusca.setRenderer(new RenderCombos());
	if (anchuraP > 1900) {
	    comboBusca.setPreferredSize(new Dimension(165,23));
	    comboBusca.setMaximumSize(new Dimension(165,23));
	} else {
	    comboBusca.setPreferredSize(new Dimension(145,23));
	    comboBusca.setMaximumSize(new Dimension(145,23));
	}
        
        
        jSeparaCampos = new JComboBox(separaOpcionesCampos);
	jSeparaCampos.setEditable(true);
	jSeparaCampos.setPreferredSize(new Dimension(53,23));
	jSeparaCampos.setMaximumSize(new Dimension(53,23));
	jSeparaCampos.setRenderer(new RenderCombos());
	jSeparaCampos.getEditor().getEditorComponent().setFont(new Font("Arial", Font.BOLD, 8));        
	separaIndex = 0;
	separaText = "_";        
        
        btnMas = new JButton(addOk);
	btnMas.setPreferredSize(new Dimension(18,15));
	btnMas.setMaximumSize(new Dimension(18,15));
        btnMas.addActionListener((e) -> {
            pulsaMas();
        });
        btnMenos = new JButton(removeOk);
	btnMenos.setPreferredSize(new Dimension(18,15));
	btnMenos.setMaximumSize(new Dimension(18,15));    
        btnMenos.addActionListener((e) -> {
            pulsaMenos();
        });
        ckEnabled.addActionListener((e) -> {
            setEnabled(ckEnabled.isSelected(), false);  
            if (automaticPreview) {
                RE.seleccionadosNuevo();                        
            }
        });
        comboBusca.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                JComboBox comboSource = (JComboBox) e.getSource();
                int index = comboSource.getSelectedIndex();
                switch(index) {
                    case 0 -> { 
                        creaText();
                        if (automaticPreview) {
                            RE.seleccionadosNuevo();                        
                        }
                    }
                    case 1 -> { 
                        creaNumeracion();
                        addElementosNumeracion();
                        if (automaticPreview) {
                            RE.seleccionadosNuevo();
                        }
                    }
                    case 2 -> { 
                        creaNombreArchivo();
                        addElementosNombreArchivo();                           
                        if (automaticPreview) {
                            RE.seleccionadosNuevo();
                        }
                    }
                    case 3 -> { 
                        creaNombreCarpeta();
                        if (automaticPreview) {
                            RE.seleccionadosNuevo();
                        }
                    }
                    case 4 -> { 
                        creaFecha();
                        if (automaticPreview) {
                            RE.seleccionadosNuevo();
                        }
                    }
                    case 5 -> {
                        creaMetaImg();                       
                        if (automaticPreview) {
                            RE.seleccionadosNuevo();
                        }
                    }
                    case 6 -> {
                        creaCamara();                       
                        if (automaticPreview) {
                            RE.seleccionadosNuevo();
                        }
                    }                    
                    case 7 -> {
                        creaMp3();              
                        addElementosMp3();                        
                        if (automaticPreview) {
                            RE.seleccionadosNuevo();
                        }
                    }                                        
                }
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
            }
        });
        jSeparaCampos.addPopupMenuListener(popListen());
        jSeparaCampos.getEditor().getEditorComponent().addKeyListener(keyListen());
        creaText();
    }
    public void setComboBusca(int index) {
        comboBusca.setSelectedIndex(index);
    }
    public JComboBox<String> getComboBusca() {
        return comboBusca;
    }
    public JCheckBox getCkEnabled() {
        return ckEnabled;
    }
    public void setCkEnabled(boolean b) {
        ckEnabled.setSelected(b);
    }
    public JComboBox<String> getJSeparaCampos() {
        return jSeparaCampos;
    }
    public String getSeparaText() {
        return separaText;
    }
    public JButton getBotonMas() {
        return btnMas;
    }
    public JButton getBotonMenos() {
        return btnMenos;
    }    
    public void setSeparaText(String txtSepara) {
        JTextField tSeparaCampos = (JTextField)jSeparaCampos.getEditor().getEditorComponent();
        tSeparaCampos.setText(txtSepara);
    }
    public void setSeparaIndex(int index) {
        jSeparaCampos.setSelectedIndex(index);
    }
    public void creaText() {
        removeAll();
        if (textoBusca == null) {
            textoBusca = new JTextField();
            vRenamer.setFont(textoBusca, 11, Font.PLAIN);
            textoBusca.setPreferredSize(new Dimension(240,23));
            textoBusca.setMaximumSize(new Dimension(1500,23));
            textoBusca.setName("textoBusca");
            textoBusca.addKeyListener(keyListen());
        }
        add(indicadorDrop);
        add(ckEnabled);
        add(comboBusca);
        add(Box.createRigidArea(new Dimension(5,0)));
        add(textoBusca);
        add(Box.createRigidArea(new Dimension(5,0)));
        add(jSeparaCampos);
        jSeparaCampos.setSelectedIndex(separaIndex);
        JTextField tSeparaCampos = (JTextField)jSeparaCampos.getEditor().getEditorComponent();
        separaText = tSeparaCampos.getText();
        tSeparaCampos.setText(separaText);
        add(Box.createRigidArea(new Dimension(5,0)));
        add(btnMenos);    
        add(Box.createRigidArea(new Dimension(5,0)));
        add(btnMas);
        updateUI();

    }
    public String getText () {
        return textoBusca.getText();
    }
    public void setText(String text) {
        textoBusca.setText(text);
    }
    public void creaNumeracion() {
        removeAll();        
        
        if (jNumeracion == null) {
            
            String[] Numeracion = {"1","01","001","0001","00001"};
            String[] opcionesNumera = {Idioma.getNumberOptionsUno(), Idioma.getNumberOptionsDos(), Idioma.getNumberOptionsTres(), Idioma.getNumberOptionsCuatro(), Idioma.getNumberOptionsCinco()};
            String[] opcionesSecuencia = {Idioma.getSeqArab(), Idioma.getSeqRoman(), Idioma.getSeqLetters(), Idioma.getSeqBinary(), Idioma.getSeqHex(), Idioma.getSeqOc()};
            String[] opcionesSecuenciaCase = {Idioma.getSeqUpp(), Idioma.getSeqLow()};    
            jNumeracion = new JComboBox(Numeracion);
            jNumeracion.setRenderer(new RenderCombos());
            vRenamer.setFont(jNumeracion, 11, Font.PLAIN);
            jNumeracion.setPreferredSize(new Dimension(60,23));
            jNumeracion.setMaximumSize(new Dimension(195,23));        
            if (anchuraP > 1900) {
                secuenciaTipo = new JComboBox(opcionesSecuencia);
            } else {
                secuenciaTipo = new JWidePopupComboBox(opcionesSecuencia);
            }
            secuenciaTipo.setPreferredSize(new Dimension(20,16));	
            secuenciaTipo.setMaximumSize(new Dimension(20,16));	
            vRenamer.setFont(secuenciaTipo, 10, Font.PLAIN);
            secuenciaTipo.setRenderer(new RenderCombos());
            secuenciaTipoCase = new JComboBox(opcionesSecuenciaCase);
            secuenciaTipoCase.setRenderer(new RenderCombos());
            vRenamer.setFont(secuenciaTipoCase, 9, Font.PLAIN);
            secuenciaTipoCase.setPreferredSize(new Dimension(60,23));
            secuenciaTipoCase.setMaximumSize(new Dimension(195,23));

            resetNumera = new JWidePopupComboBox(opcionesNumera);
            resetNumera.setPreferredWidth(40);
            vRenamer.setFont(resetNumera, 11, Font.PLAIN);
            resetNumera.setPreferredSize(new Dimension(20,16));	
            resetNumera.setMaximumSize(new Dimension(20,16));	
            resetNumera.setRenderer(new RenderCombos());        

            sm = new SpinnerNumberModel(1,0,999999,1);
            lblEmpieza = new JLabel(Idioma.getNumberLabel());
            lblEmpieza.setFont(new Font("Helvetica", Font.PLAIN, 9));    
            numeracionTexto = new JSpinner(sm);
            numeracionTexto.setPreferredSize(new Dimension(43,23));
            numeracionTexto.setMaximumSize(new Dimension(350,23));
            vRenamer.setFont(numeracionTexto, 8, Font.PLAIN);
            ((JSpinner.DefaultEditor)numeracionTexto.getEditor()).getTextField().addKeyListener(keyListen());
            numeracionTexto.addChangeListener((e) -> {
                if (automaticPreview) {
                    RE.seleccionadosNuevo();
                }
            });
            SpinnerNumberModel ns = new SpinnerNumberModel(1,1,9999,1);

            lblSalto = new JLabel (Idioma.getNumberSkip());
            lblSalto.setFont(new Font("Helvetica", Font.PLAIN, 9));    
            numeracionSalto = new JSpinner(ns);
            numeracionSalto.setPreferredSize(new Dimension(43,23));
            numeracionSalto.setMaximumSize(new Dimension(350,23));
            vRenamer.setFont(numeracionSalto, 8, Font.PLAIN);
            ((JSpinner.DefaultEditor)numeracionSalto.getEditor()).getTextField().addKeyListener(keyListen());
            numeracionSalto.addChangeListener((e) -> {
                if (automaticPreview) {
                    RE.seleccionadosNuevo();
                }
            });            
            if (secuenciaTipo.getSelectedIndex() == 0) {
                sm = new SpinnerNumberModel(1,0,999999,1);
            } else {
                java.util.List<String> listaModeloNumeracion = MotorBusca.getListaModeloNumeracion(secuenciaTipo.getSelectedIndex());
                sm = new SpinnerListModel(listaModeloNumeracion);
            }
            numeracionTexto.setModel(sm);  
                                                               
            secuenciaTipo.addPopupMenuListener(new PopupMenuListener() {
                @Override
                public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                }

                @Override
                public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                    removeAll();
                    switch(secuenciaTipo.getSelectedIndex()) {
                        case 0 -> {
                            sm = new SpinnerNumberModel(1,0,999999,1);
                            numeracionTexto.setModel(sm);
                        }
                        case 1 -> {
                            java.util.List<String> listaModeloNumeracion = MotorBusca.getListaModeloNumeracion(1);
                            sm = new SpinnerListModel(listaModeloNumeracion);
                            numeracionTexto.setModel(sm);
                        }
                        case 2 -> {
                            List<String> listaModeloNumeracion = MotorBusca.getListaModeloNumeracion(2);
                            sm = new SpinnerListModel(listaModeloNumeracion);
                            numeracionTexto.setModel(sm);
                        }
                        case 3 -> {
                            List<String> listaModeloNumeracion = MotorBusca.getListaModeloNumeracion(3);
                            sm = new SpinnerListModel(listaModeloNumeracion);
                            numeracionTexto.setModel(sm);
                        }
                        case 4 -> {
                            List<String> listaModeloNumeracion = MotorBusca.getListaModeloNumeracion(4);
                            sm = new SpinnerListModel(listaModeloNumeracion);
                            numeracionTexto.setModel(sm);
                        }
                        case 5 -> {
                            List<String> listaModeloNumeracion = MotorBusca.getListaModeloNumeracion(5);
                            sm = new SpinnerListModel(listaModeloNumeracion);
                            numeracionTexto.setModel(sm);                                                                                                              
                        }
                    }
                    addElementosNumeracion(); 
                    if (automaticPreview) {
                        RE.seleccionadosNuevo();                        
                    }                    
                }

                @Override
                public void popupMenuCanceled(PopupMenuEvent e) {
                }
            });
            secuenciaTipoCase.addPopupMenuListener(popListen());
            jNumeracion.addPopupMenuListener(popListen());
            resetNumera.addPopupMenuListener(popListen());
        }
        
    }    
    public void addElementosNumeracion() {
        add(indicadorDrop);
        add(ckEnabled);        
	add(comboBusca);
	add(Box.createRigidArea(new Dimension(5,0)));
	add(secuenciaTipo);
	add(Box.createRigidArea(new Dimension(5,0)));
        switch (secuenciaTipo.getSelectedIndex()) {
            case 0, 5 -> {
                add(jNumeracion);
                add(Box.createRigidArea(new Dimension(5,0)));
            }
            case 1, 2, 4 -> {
                add(secuenciaTipoCase);
                add(Box.createRigidArea(new Dimension(5,0)));
            }
            default -> {
                numeracionTexto.setMaximumSize(new Dimension(650,23));
                numeracionSalto.setMaximumSize(new Dimension(250,23));
            }
        }
	add(lblEmpieza);
	add(Box.createRigidArea(new Dimension(5,0)));
	add(numeracionTexto);
	add(Box.createRigidArea(new Dimension(5,0)));
	add(lblSalto);
	add(Box.createRigidArea(new Dimension(5,0)));
	add(numeracionSalto);
	add(Box.createRigidArea(new Dimension(5,0)));
	add(resetNumera);
	add(Box.createRigidArea(new Dimension(5,0)));
	add(jSeparaCampos);
	add(Box.createRigidArea(new Dimension(5,0)));
	jSeparaCampos.setSelectedIndex(separaIndex);
	JTextField tSeparaCampos = (JTextField)jSeparaCampos.getEditor().getEditorComponent();
        separaText = tSeparaCampos.getText();
	tSeparaCampos.setText(separaText);
        add(btnMenos);
        add(Box.createRigidArea(new Dimension(5,0)));
        add(btnMas);
        updateUI();        
    }
    public JComboBox<String> getSecuenciaTipo() {
        return secuenciaTipo;
    }
    public JComboBox<String> getSecuenciaTipoCase() {
        return secuenciaTipoCase;
    }    
    public JSpinner getNumeracionTexto() {
        return numeracionTexto;
    }
    public void setModeloNumeracion(SpinnerModel spin) {
        numeracionTexto.setModel(spin);
    }
    public JComboBox<String> getJNumeracion() {
        return jNumeracion;
    }
    public JSpinner getNumeracionSalto() {
        return numeracionSalto;
    }    
    public JWidePopupComboBox getResetNumera() {
        return resetNumera;
    }
    public void setSecuenciaTipo(int index) {
        secuenciaTipo.setSelectedIndex(index);
    }
    public void setSecuenciaTipoCase (int index) {
        secuenciaTipoCase.setSelectedIndex(index);
    }   
    public void setJNumeracion(int index) {
        jNumeracion.setSelectedIndex(index);
    }    
    public void setNumeracionTexto(Integer i) {
        numeracionTexto.getModel().setValue(i);
    }
    public void setNumeracionSalto(Integer i) {
        numeracionSalto.getModel().setValue(i);
    }
    public void setResetNumera(int index) {
        resetNumera.setSelectedIndex(index);
    }
    public void creaNombreArchivo() {
        removeAll();      
        if (jArchivo == null) {
            String[] hFinal = {Idioma.getFileOnly(), Idioma.getFileEnd(), Idioma.getFileBeginning()};
            String[] opcionesArchivo = {Idioma.getFileCut(), Idioma.getFileFrom(), Idioma.getFileBetween()};
            jArchivo = new JComboBox(opcionesArchivo);
            vRenamer.setFont(jArchivo, 11, Font.PLAIN);
            jArchivo.setPreferredSize(new Dimension(95,23));
            jArchivo.setMaximumSize(new Dimension(95,23));
            jArchivo.setRenderer(new RenderCombos());

            jCorte = new JTextField();
            vRenamer.setFont(jCorte, 11, Font.PLAIN);
            jCorte.setPreferredSize(new Dimension(32,23));
            jCorte.setMaximumSize(new Dimension(1500,23));
            jCorte.setToolTipText(Idioma.getTipCut());	  
            jCorte.addKeyListener(keyListen());
            jCorte.addMouseListener(cc);

            SpinnerNumberModel spCorte = new SpinnerNumberModel(1,1,50,1);
            numeracionCorte = new JSpinner(spCorte);
            numeracionCorte.setToolTipText(Idioma.getTipSection());
            numeracionCorte.setPreferredSize(new Dimension(43,23));
            numeracionCorte.setMaximumSize(new Dimension(43,23));
            vRenamer.setFont(numeracionCorte, 8, Font.PLAIN);
            numeracionCorte.addChangeListener((e) -> {
                if (automaticPreview) {
                    RE.seleccionadosNuevo();                        
                }                                  
            });
            numeracionCorte.addMouseListener(cc);

            ((JSpinner.DefaultEditor)numeracionCorte.getEditor()).getTextField().addKeyListener(keyListen());

            lblSeccion = new JLabel(Idioma.getFileSection());
            vRenamer.setFont(lblSeccion, 9, Font.PLAIN);

            hastaFinal = new JWidePopupComboBox(hFinal);
            hastaFinal.setPreferredWidth(40);
            vRenamer.setFont(hastaFinal, 11, Font.PLAIN);
            hastaFinal.setPreferredSize(new Dimension(20,16));
            hastaFinal.setMaximumSize(new Dimension(20,16));
            hastaFinal.setRenderer(new RenderCombos());
            hastaFinal.addPopupMenuListener(popListen());

            SpinnerNumberModel spArchivoDesde = new SpinnerNumberModel(1,1,150,1);
            archivoDesde = new JSpinner(spArchivoDesde);
            vRenamer.setFont(archivoDesde, 8, Font.PLAIN);
            archivoDesde.setPreferredSize(new Dimension(46,23));
            archivoDesde.setMaximumSize(new Dimension(1500,23));
            archivoDesde.addChangeListener(cc);
            ((JSpinner.DefaultEditor)archivoDesde.getEditor()).getTextField().addKeyListener(keyListen());

            lblArchivoHasta = new JLabel(Idioma.getFileTo());
            lblArchivoHasta.setFont(new Font("Helvetica", Font.PLAIN, 11));

            SpinnerNumberModel spArchivoHasta = new SpinnerNumberModel(1,1,150,1);
            archivoHasta = new JSpinner(spArchivoHasta);
            vRenamer.setFont(archivoHasta, 8, Font.PLAIN);
            archivoHasta.setPreferredSize(new Dimension(46,23));
            archivoHasta.setMaximumSize(new Dimension(1500,23));
            archivoHasta.addChangeListener((e) -> {
                if (automaticPreview) {
                    RE.seleccionadosNuevo();                        
                }                                                
            });
            ((JSpinner.DefaultEditor)archivoHasta.getEditor()).getTextField().addKeyListener(keyListen());

            archivoTextoDesde = new JTextField();
            archivoTextoDesde.setToolTipText(Idioma.getTipReplace());
            archivoTextoDesde.setPreferredSize(new Dimension(55,23));
            archivoTextoDesde.setMaximumSize(new Dimension(1500,23));
            vRenamer.setFont(archivoTextoDesde, 11, Font.PLAIN);
            archivoTextoDesde.addKeyListener(keyListen());
            archivoTextoDesde.addMouseListener(cc);

            lblArchivoTextoHasta = new JLabel(Idioma.getFileAnd());
            lblArchivoTextoHasta.setFont(new Font("Helvetica", Font.PLAIN, 11));

            archivoTextoHasta = new JTextField();
            archivoTextoHasta.setToolTipText(Idioma.getTipReplace());
            archivoTextoHasta.setPreferredSize(new Dimension(55,23));
            archivoTextoHasta.setMaximumSize(new Dimension(1500,23));
            vRenamer.setFont(archivoTextoHasta, 11, Font.PLAIN);
            archivoTextoHasta.addKeyListener(keyListen());
            archivoTextoHasta.addMouseListener(cc);

            if (anchuraP > 1900) {
                archivoDesde.setPreferredSize(new Dimension(50,23));
                archivoHasta.setPreferredSize(new Dimension(50,23));
                numeracionCorte.setPreferredSize(new Dimension(48,23));
            }
            jArchivo.addPopupMenuListener(new PopupMenuListener() {
                @Override
                public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                }

                @Override
                public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                  removeAll();
                  addElementosNombreArchivo(); 
                  if (automaticPreview) {
                      RE.seleccionadosNuevo();                        
                  }                                  
                }

                @Override
                public void popupMenuCanceled(PopupMenuEvent e) {
                }
            });          
        }
    }
    public void addElementosNombreArchivo() {
        add(indicadorDrop);
        add(ckEnabled);    
        add(comboBusca);
        add(Box.createRigidArea(new Dimension(5,0)));
        add(jArchivo);
        add(Box.createRigidArea(new Dimension(5,0)));
        System.out.println(jArchivo.getSelectedIndex());
        
        switch (jArchivo.getSelectedIndex()) {
            case 0 -> {
                add(jCorte);
                add(Box.createRigidArea(new Dimension(5,0)));
                add(lblSeccion);
                add(Box.createRigidArea(new Dimension(5,0)));
                add(numeracionCorte);
                add(Box.createRigidArea(new Dimension(5,0)));
                add(hastaFinal);
                add(Box.createRigidArea(new Dimension(5,0)));
            }
            case 1 -> {
                add(archivoDesde);
                add(Box.createRigidArea(new Dimension(5,0)));
                add(lblArchivoHasta);
                add(Box.createRigidArea(new Dimension(5,0)));
                add(archivoHasta);
                add(Box.createRigidArea(new Dimension(5,0)));
            }
            case 2 -> {
                System.out.println("Desde - Hasta");
                add(archivoTextoDesde);
                add(Box.createRigidArea(new Dimension(5,0)));
                add(lblArchivoTextoHasta);
                add(Box.createRigidArea(new Dimension(5,0)));
                add(archivoTextoHasta);
                add(Box.createRigidArea(new Dimension(5,0)));
            }
            default -> {
            }
        }
        add(jSeparaCampos);
        add(Box.createRigidArea(new Dimension(5,0)));
        jSeparaCampos.setSelectedIndex(separaIndex);
        JTextField tSeparaCampos = (JTextField)jSeparaCampos.getEditor().getEditorComponent();
        separaText = tSeparaCampos.getText();
        tSeparaCampos.setText(separaText);
        add(btnMenos);
        add(Box.createRigidArea(new Dimension(5,0)));
        add(btnMas); 
        updateUI();   
    }
    public JComboBox<String> getJArchivo() {
        return jArchivo;
    }
    public JTextField getJCorte() {
        return jCorte;
    }
    public JSpinner getNumeracionCorte() {
        return numeracionCorte;
    }
    public JWidePopupComboBox getHastaFinal() {
        return hastaFinal;
    }
    public JSpinner getArchivoDesde() {
        return archivoDesde;
    }
    public JSpinner getArchivoHasta() {
        return archivoHasta;
    }    
    public JTextField getArchivoTextoDesde() {
        return archivoTextoDesde;
    }
    public JTextField getArchivoTextoHasta() {
        return archivoTextoHasta;
    }    
    public void setJCorte (String txt) {
        jCorte.setText(txt);
    }
    public void setNumeracionCorte (Integer i) {
        numeracionCorte.getModel().setValue(i);
    }
    public void setHastaFinal(int index) {
        hastaFinal.setSelectedIndex(index);
    }
    public void setJArchivo(int index) {
        jArchivo.setSelectedIndex(index);
    }
    public void setArchivoDesde(Integer i) {
        archivoDesde.getModel().setValue(i);
    }
    public void setArchivoHasta(Integer i) {
        archivoHasta.getModel().setValue(i);
    }    
    public void setArchivoTextoDesde(String txt) {
        archivoTextoDesde.setText(txt);
    }
    public void setArchivoTextoHasta(String txt) {
        archivoTextoHasta.setText(txt);
    }    
    public void creaNombreCarpeta() {
        removeAll();
        if (jCarpeta == null) {
            String[] nCarpeta = {Idioma.getFolderSame(),Idioma.getFolderUpper(),Idioma.getFolderLower()};
            jCarpeta = new JComboBox(nCarpeta);
            jCarpeta.setRenderer(new RenderCombos());
            vRenamer.setFont(jCarpeta, 11, Font.PLAIN);
            jCarpeta.setPreferredSize(new Dimension(240,23));
            jCarpeta.setMaximumSize(new Dimension(1500,23));
            jCarpeta.addPopupMenuListener(popListen());
        }
        add(indicadorDrop);
        add(ckEnabled);    
        add(comboBusca);
        add(Box.createRigidArea(new Dimension(5,0)));
        add(jCarpeta);
        add(Box.createRigidArea(new Dimension(5,0)));
        add(jSeparaCampos);
        add(Box.createRigidArea(new Dimension(5,0)));
        jSeparaCampos.setSelectedIndex(separaIndex);
        JTextField tSeparaCampos = (JTextField)jSeparaCampos.getEditor().getEditorComponent();
        separaText = tSeparaCampos.getText();
        tSeparaCampos.setText(separaText);
        add(btnMenos);
        add(Box.createRigidArea(new Dimension(5,0)));
        add(btnMas);
        updateUI();
    }
    public JComboBox<String> getJCarpeta() {
        return jCarpeta;
    }
    public void setJCarpeta(int index) {
        jCarpeta.setSelectedIndex(index);
    }
    public void creaFecha() {
      removeAll();
      if (jFecha == null) {
	  String[] Fecha = {Idioma.getDateOne(), Idioma.getDateTwo(), Idioma.getDateThree(), Idioma.getDateFour(), Idioma.getDateFive(), Idioma.getDateSix(), Idioma.getDateSeven(), Idioma.getDateEight(), Idioma.getDateNine(), Idioma.getDateTen(), Idioma.getDateEleven(), "HHMMSS", "HHMM"};
	  String[] sFechas = {"off", "-", "_", ".","{ }"};

	  separaFecha = new JWidePopupComboBox(sFechas);
	  separaFecha.setPreferredWidth(40);
	  vRenamer.setFont(separaFecha, 11, Font.PLAIN);
	  separaFecha.setPreferredSize(new Dimension(20,16));
	  separaFecha.setMaximumSize(new Dimension(20,16));
	  separaFecha.setRenderer(new RenderCombos());
	  separaFecha.setName("separaFecha");
	  separaFecha.addPopupMenuListener(popListen());

	  jFecha = new JComboBox(Fecha);
	  jFecha.setRenderer(new RenderCombos());
	  vRenamer.setFont(jFecha, 11, Font.PLAIN);
	  jFecha.setPreferredSize(new Dimension(215,23));
	  jFecha.setMaximumSize(new Dimension(1500,23));
	  jFecha.setName("Jfecha");
	  jFecha.addPopupMenuListener(popListen());
      }
     
      add(indicadorDrop);
      add(ckEnabled);      
      add(comboBusca);
      add(Box.createRigidArea(new Dimension(5,0)));
      add(separaFecha);
      add(Box.createRigidArea(new Dimension(5,0)));
      add(jFecha);
      add(Box.createRigidArea(new Dimension(5,0)));
      add(jSeparaCampos);
      add(Box.createRigidArea(new Dimension(5,0)));
      jSeparaCampos.setSelectedIndex(separaIndex);
      JTextField tSeparaCampos = (JTextField)jSeparaCampos.getEditor().getEditorComponent();
      separaText = tSeparaCampos.getText();
      tSeparaCampos.setText(separaText);
      add(btnMenos);
      add(Box.createRigidArea(new Dimension(5,0)));
      add(btnMas);
      updateUI();        
    }
    public JComboBox<String> getJFecha() {
        return jFecha;
    }
    public JWidePopupComboBox getSeparaFecha() {
        return separaFecha;
    }
    public void setJFecha(int index) {
        jFecha.setSelectedIndex(index);
    }
    public void setSeparaFecha(int index) {
        separaFecha.setSelectedIndex(index);
    }    
    
    public void creaMetaImg() {
        removeAll();
        if (jMetadata == null) {
            String[] Fecha = {Idioma.getDateOne(), Idioma.getDateTwo(), Idioma.getDateThree(), Idioma.getDateFour(), Idioma.getDateFive(), Idioma.getDateSix(), Idioma.getDateSeven(), Idioma.getDateEight(), Idioma.getDateNine(), Idioma.getDateTen(), Idioma.getDateEleven(), "HHMMSS", "HHMM"};
            String[] sFechas = {"off", "-", "_", ".","{ }"};

            separaFecha = new JWidePopupComboBox(sFechas);
            separaFecha.setPreferredWidth(40);
            vRenamer.setFont(separaFecha, 11, Font.PLAIN);
            separaFecha.setPreferredSize(new Dimension(20,16));
            separaFecha.setMaximumSize(new Dimension(20,16));
            separaFecha.setRenderer(new RenderCombos());
            separaFecha.addPopupMenuListener(popListen());

            jMetadata = new JComboBox(Fecha);
            jMetadata.setRenderer(new RenderCombos());
            vRenamer.setFont(jMetadata, 11, Font.PLAIN);
            jMetadata.setPreferredSize(new Dimension(215,23));
            jMetadata.setMaximumSize(new Dimension(1500,23));
            jMetadata.addPopupMenuListener(popListen());
        }
        add(indicadorDrop);
        add(ckEnabled);    
        add(comboBusca);
        add(Box.createRigidArea(new Dimension(5,0)));
        add(separaFecha);
        add(Box.createRigidArea(new Dimension(5,0)));
        add(jMetadata);
        add(Box.createRigidArea(new Dimension(5,0)));
        add(jSeparaCampos);
        add(Box.createRigidArea(new Dimension(5,0)));
        jSeparaCampos.setSelectedIndex(separaIndex);
        JTextField tSeparaCampos = (JTextField)jSeparaCampos.getEditor().getEditorComponent();
        separaText = tSeparaCampos.getText();
        tSeparaCampos.setText(separaText);
        add(btnMenos);
        add(Box.createRigidArea(new Dimension(5,0)));
        add(btnMas);
        updateUI();        
    }
    public JComboBox<String> getJMetadata() {
        return jMetadata;
    }    
    public void setJMetadata(int index) {
        jMetadata.setSelectedIndex(index);
    }
    public void creaCamara() {
        removeAll(); 
        if (jMetadataCamara == null) {
            String[] metadatos = {Idioma.getCamMake(),Idioma.getCamModel(),Idioma.getCamWidth(),Idioma.getCamHeight(),Idioma.getCamAperture(),Idioma.getCamExposure(),Idioma.getCamExposureBias(),Idioma.getCamIso(),Idioma.getCamBrightness(),Idioma.getCamFocal(),Idioma.getCamColor()};
            jMetadataCamara = new JComboBox(metadatos);
            jMetadataCamara.setRenderer(new RenderCombos());
            vRenamer.setFont(jMetadataCamara, 11, Font.PLAIN);
            jMetadataCamara.setPreferredSize(new Dimension(240,23));
            jMetadataCamara.setMaximumSize(new Dimension(1500,23));            
            jMetadataCamara.addPopupMenuListener(popListen());
        }
        add(indicadorDrop);
        add(ckEnabled);    
        add(comboBusca);
        add(Box.createRigidArea(new Dimension(5,0)));
        add(jMetadataCamara);
        add(Box.createRigidArea(new Dimension(5,0)));
        add(jSeparaCampos);
        add(Box.createRigidArea(new Dimension(5,0)));
        jSeparaCampos.setSelectedIndex(separaIndex);
        JTextField tSeparaCampos = (JTextField)jSeparaCampos.getEditor().getEditorComponent();
        separaText = tSeparaCampos.getText();
        tSeparaCampos.setText(separaText);
        add(btnMenos);
        add(Box.createRigidArea(new Dimension(5,0)));
        add(btnMas);
        updateUI();        
    }
    public JComboBox<String> getJMetadataCamara() {
        return jMetadataCamara;
    }    
    public void setJMetadataCamara(int index) {
        jMetadataCamara.setSelectedIndex(index);
    }
    public void creaMp3() {
        removeAll(); 
        if (jMp3 == null) {
            String[] Numeracion = {"1","01","001","0001","00001"};
            String[] mp3 = {Idioma.getTagArtist(), Idioma.getTagTitle(), Idioma.getTagTrack(), Idioma.getTagAlbum(), Idioma.getTagYear(), Idioma.getTagGenre()};

            jNumeracion = new JComboBox(Numeracion);
            jNumeracion.setRenderer(new RenderCombos());
            vRenamer.setFont(jNumeracion, 11, Font.PLAIN);
            jNumeracion.setPreferredSize(new Dimension(60,23));
            jNumeracion.setMaximumSize(new Dimension(195,23));           
            jNumeracion.addPopupMenuListener(popListen());

            jMp3 = new JComboBox(mp3);
            jMp3.addPopupMenuListener(new PopupMenuListener() {
                @Override
                public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                }

                @Override
                public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                    removeAll();
                    addElementosMp3(); 
                    if (automaticPreview) {
                        RE.seleccionadosNuevo();                        
                    }                                  
                    
                }

                @Override
                public void popupMenuCanceled(PopupMenuEvent e) {
                }
            });
            jMp3.setRenderer(new RenderCombos());
            jMp3.setPreferredSize(new Dimension(240,23));
            jMp3.setMaximumSize(new Dimension(1500,23));
            vRenamer.setFont(jMp3, 11, Font.PLAIN);
        }
        jMp3.setPreferredSize(new Dimension(240,23));        
    }
    public void addElementosMp3() {
        add(indicadorDrop);
        add(ckEnabled);    
        add(comboBusca);
        add(Box.createRigidArea(new Dimension(5,0)));
        add(jMp3);
        add(Box.createRigidArea(new Dimension(5,0)));
        if (jMp3.getSelectedIndex() == 2) {
            jMp3.setPreferredSize(new Dimension(176,23));
            jMp3.setMaximumSize(new Dimension(1500,23));
            add(jNumeracion);
            add(Box.createRigidArea(new Dimension(5,0)));
        }
        add(jSeparaCampos);
        add(Box.createRigidArea(new Dimension(5,0)));
        jSeparaCampos.setSelectedIndex(separaIndex);
        JTextField tSeparaCampos = (JTextField)jSeparaCampos.getEditor().getEditorComponent();
        separaText = tSeparaCampos.getText();
        tSeparaCampos.setText(separaText);
        add(btnMenos);
        add(Box.createRigidArea(new Dimension(5,0)));
        add(btnMas);
        updateUI();
    }
    public JComboBox<String> getJMp3() {
        return jMp3;
    }
    public void setJMp3 (int index) {
        jMp3.setSelectedIndex(index);
    }
    private PopupMenuListener popListen() {
        PopupMenuListener pop = new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                if (automaticPreview) {
                    RE.seleccionadosNuevo();                        
                }                                                        
            }
            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
            }
        };
        return pop;
    }
    private KeyListener keyListen() {
        KeyListener key = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (automaticPreview) {
                    RE.seleccionadosNuevo();                        
                }                                                                        
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        return key;
    }
    private void pulsaMas() {
        int posicion = getComponenteIndex(this);
        RE.pulsaMas(posicion);
    }
    private void pulsaMenos() {
        RE.pulsaMenos(this);
    }
    public static int getComponenteIndex(Component component) {
        if (component != null && component.getParent() != null) {
            JPanel c = (JPanel) component.getParent();
            for (int i = 0; i < c.getComponentCount(); i++) {
              if (c.getComponent(i) == component) {
                return i;
              }
            }
        }
        return -1;
    }              
    public void setEnabled(boolean enabled, boolean completo) {
        numeroEnabled = (completo) ? 0 : 3;
        numeroEnabledInicio = (completo) ? 1 : 2;
        setEnabled(enabled);
    }
    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        Component[] components = this.getComponents();          
        int s = numeroEnabledInicio;      
        int l = components.length - numeroEnabled;
        if (components.length > 0) {
            int count = l;
            for (int i = s; i < count; i++) {
                components[i].setEnabled(enabled);
            }
        }
    }    

}
