package vrenamer;
/*
 * Christopher Deckers (chrriis@nextencia.net)
 * http://www.nextencia.net
 *
 * See the file "readme.txt" for information on usage and redistribution of
 * this file, and for a DISCLAIMER OF ALL WARRANTIES.
 */
//package chrriis.dj.swingsuite;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.Border;

/**
 * @author Christopher Deckers
 */
class AutoScrollActivator {

  private AutoScrollActivator() {
  }

  private static class AutoScrollProperties {
    public Point startLocation;
    public Point currentLocation;
    public Timer timer;
    public AWTEventListener toolkitListener;
    public boolean isDragMode;
    public JPopupMenu iconPopupMenu;
    private JScrollPane scrollPane;
  }

  private AutoScrollProperties autoScrollProperties;

  private void deactivateAutoScroll() {
    autoScrollProperties.timer.stop();
    try {
      Toolkit.getDefaultToolkit().removeAWTEventListener(autoScrollProperties.toolkitListener);
    } catch(Exception e) {
      // This is possible if we deactivate because of an exception when activating.
    }
    autoScrollProperties.iconPopupMenu.setVisible(false);
    autoScrollProperties = null;
  }

  private void activateAutoScroll(MouseEvent e) {
    Component c = e.getComponent();
    while(c!= null && !(c instanceof JScrollPane)) {
      c = c.getParent();
    }
    if(c == null) {
      return;
    }
    autoScrollProperties = new AutoScrollProperties();
    autoScrollProperties.scrollPane = (JScrollPane)c;
    autoScrollProperties.isDragMode = false;
    JViewport viewport = autoScrollProperties.scrollPane.getViewport();
    autoScrollProperties.currentLocation = MouseInfo.getPointerInfo().getLocation();
    SwingUtilities.convertPointFromScreen(autoScrollProperties.currentLocation, viewport);
    autoScrollProperties.startLocation = autoScrollProperties.currentLocation;
    // We use a popup menu so that it can be heavyweight or lightweight depending on the context.
    // By default it is probably lightweight and thus uses alpha transparency
    final JPopupMenu iconPopupMenu = new JPopupMenu() {
      @Override
      public void setBorder(Border border) {
        // Overriden to avoid having a border set by the L&F
      }
    };
    iconPopupMenu.setFocusable(false);
    iconPopupMenu.setOpaque(false);
    iconPopupMenu.setBorder(BorderFactory.createEmptyBorder());
    iconPopupMenu.setBackground(new Color(0, 0, 0, 0));
    JLabel iconLabel = new JLabel(getAutoScrollIcon());
    iconPopupMenu.add(iconLabel);
    iconPopupMenu.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        iconPopupMenu.setVisible(false);
      }
    });
    autoScrollProperties.iconPopupMenu = iconPopupMenu;
    Dimension iconPopupMenuSize = iconPopupMenu.getPreferredSize();
    iconPopupMenu.show(viewport, autoScrollProperties.startLocation.x - iconPopupMenuSize.width / 2, autoScrollProperties.startLocation.y - iconPopupMenuSize.height / 2);
    // Assumption: the popup menu has a parent that is itself added to the glass pane or to a window.
    // Some L&F will create borders to that parent, and we don't want that.
    Container parent = iconPopupMenu.getParent();
    if(parent instanceof JComponent) {
      ((JComponent)parent).setBorder(null);
    }
    ActionListener actionListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JViewport viewport = autoScrollProperties.scrollPane.getViewport();
        Component view = viewport.getView();
        if(view == null) {
          return;
        }
        Point viewPosition = viewport.getViewPosition();
        int offsetX = autoScrollProperties.currentLocation.x - autoScrollProperties.startLocation.x;
        int offsetY = autoScrollProperties.currentLocation.y - autoScrollProperties.startLocation.y;
        offsetX = offsetX > 0? Math.max(0, offsetX - 4): Math.min(0, offsetX + 4);
        offsetY = offsetY > 0? Math.max(0, offsetY - 4): Math.min(0, offsetY + 4);
        viewPosition = new Point(viewPosition.x + offsetX, viewPosition.y + offsetY);
        Dimension extentSize = viewport.getExtentSize();
        Dimension viewSize = view.getSize();
        if(viewSize.width - viewPosition.x < extentSize.width) {
          viewPosition.x = viewSize.width - extentSize.width;
        }
        if(viewSize.height - viewPosition.y < extentSize.height) {
          viewPosition.y = viewSize.height - extentSize.height;
        }
        if(viewPosition.x < 0) {
          viewPosition.x = 0;
        }
        if(viewPosition.y < 0) {
          viewPosition.y = 0;
        }
        viewport.setViewPosition(viewPosition);
      }
    };
    autoScrollProperties.timer = new Timer(50, actionListener);
    autoScrollProperties.timer.start();
    autoScrollProperties.toolkitListener = new AWTEventListener() {
      @Override
      public void eventDispatched(AWTEvent e) {
        int eventID = e.getID();
        switch(eventID) {
          case MouseEvent.MOUSE_MOVED:
          case MouseEvent.MOUSE_DRAGGED:
            JViewport viewport = autoScrollProperties.scrollPane.getViewport();
            autoScrollProperties.currentLocation = MouseInfo.getPointerInfo().getLocation();
            SwingUtilities.convertPointFromScreen(autoScrollProperties.currentLocation, viewport);
            if(!autoScrollProperties.isDragMode && eventID == MouseEvent.MOUSE_DRAGGED) {
              Dimension size = new Dimension(Math.abs(autoScrollProperties.currentLocation.x - autoScrollProperties.startLocation.x), Math.abs(autoScrollProperties.currentLocation.y - autoScrollProperties.startLocation.y));
              autoScrollProperties.isDragMode = size.width > HV_IMAGE_ICON.getIconWidth() / 2 || size.height > HV_IMAGE_ICON.getIconHeight() / 2;
            }
            break;
          case MouseEvent.MOUSE_PRESSED:
          case MouseWheelEvent.MOUSE_WHEEL:
            deactivateAutoScroll();
            break;
          case MouseEvent.MOUSE_RELEASED:
            if(autoScrollProperties.isDragMode && ((MouseEvent)e).getButton() == 2) {
              deactivateAutoScroll();
            }
            break;
          case WindowEvent.WINDOW_LOST_FOCUS:
            deactivateAutoScroll();
            break;
        }
      }
    };
    try {
      Toolkit.getDefaultToolkit().addAWTEventListener(autoScrollProperties.toolkitListener, AWTEvent.MOUSE_MOTION_EVENT_MASK | AWTEvent.MOUSE_EVENT_MASK | AWTEvent.MOUSE_WHEEL_EVENT_MASK | AWTEvent.WINDOW_FOCUS_EVENT_MASK);
    } catch(Exception ex) {
      deactivateAutoScroll();
      // If an exception is thrown, well, too bad, no activation of this feature.
    }
  }

  private static final ImageIcon H_IMAGE_ICON = new ImageIcon(AutoScrollActivator.class.getResource("resource/autoscroll_h.png"));
  private static final ImageIcon V_IMAGE_ICON = new ImageIcon(AutoScrollActivator.class.getResource("resource/autoscroll_v.png"));
  private static final ImageIcon HV_IMAGE_ICON = new ImageIcon(AutoScrollActivator.class.getResource("resource/autoscroll_all.png"));

  private ImageIcon getAutoScrollIcon() {
    ImageIcon icon;
    if(autoScrollProperties.scrollPane.getHorizontalScrollBar().isVisible()) {
      if(autoScrollProperties.scrollPane.getVerticalScrollBar().isVisible()) {
        icon = HV_IMAGE_ICON;
      } else {
        icon = H_IMAGE_ICON;
      }
    } else {
      if(autoScrollProperties.scrollPane.getVerticalScrollBar().isVisible()) {
        icon = V_IMAGE_ICON;
      } else {
        icon = HV_IMAGE_ICON;
      }
    }
    return icon;
  }

  private static class AutoScrollMouseListener extends MouseAdapter {
    @Override
    public void mousePressed(MouseEvent e) {
      if(e.getButton() != MouseEvent.BUTTON2) {
        return;
      }
      new AutoScrollActivator().activateAutoScroll(e);
    }
  }

  private static AutoScrollMouseListener autoScrollMouseListener = new AutoScrollMouseListener();

  public static void setAutoScrollEnabled(final JComponent component, boolean isEnabled) {
    for(MouseListener mouseListener: component.getMouseListeners()) {
      if(mouseListener instanceof AutoScrollMouseListener) {
        if(isEnabled) {
          // Already registered.
          return;
        }
        // Not registered, but we want to unregister.
        component.removeMouseListener(mouseListener);
        return;
      }
    }
    if(isEnabled) {
      component.addMouseListener(autoScrollMouseListener);
    }
  }

}
