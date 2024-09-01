/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vrenamer;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Carlos Verdier <carlos@yourappeasy.com>
 */
public class CreaValores {
    private static GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();    
    private static GraphicsDevice device = ge.getDefaultScreenDevice();
    public static int alturaP = device.getDisplayMode().getHeight();
    public static int anchuraP = device.getDisplayMode().getWidth();
    
    private static ClassLoader cldr = CreaValores.class.getClassLoader();
    public static idiomas Idioma;    
    public static RenombraControl cc;
    public static vRenamer RE;
    public static java.util.List<BarraRenombra> listaBarras = new ArrayList<>();
    private static final java.net.URL ADD_IMG = cldr.getResource("img/list-add.png");    
    private static final java.net.URL REMOVE_IMG = cldr.getResource("img/list-remove.png");
    public static ImageIcon addOk = new ImageIcon(ADD_IMG);
    public static ImageIcon removeOk = new ImageIcon(REMOVE_IMG);    
    
    public static JPanel pnlBuscaTotal;
    public static boolean automaticPreview;
}

