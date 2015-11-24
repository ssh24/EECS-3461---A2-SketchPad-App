package view.basics.toolbars;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.primary.MainControl;


public class ZoomToolBar extends JToolBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton zoomIn;
	private JButton zoomOut;
	private JSlider zoomSlider;
	
	private final Color BACKGROUND = new Color(230, 230, 230);

	public ZoomToolBar()
	{
		setLayout(new FlowLayout(FlowLayout.CENTER));
		init_zoom();
		setBackground(BACKGROUND);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setFloatable(false);
		this.setRollover(true);
	}
	
	private static void showLabel(JSlider slider, Map<Integer, Integer> values) {

		Hashtable<Integer, JLabel> label = new Hashtable<Integer, JLabel>();
		JLabel jLabel = new JLabel(values.get(slider.getValue()).toString()
				+ "%");
		label.put(slider.getValue(), jLabel);
		slider.setLabelTable(label);
		slider.setPaintLabels(true);
	}
	
	private void init_zoom() {
		
		JLabel zoom = new JLabel("<html><font size = 4><b>Zoom level - </b></html>");
		
		/*zoomIn = new JButton(new ImageIcon(
				"images/main-tool-bar-images/zoom_in.png"));
		zoomIn.setBackground(Color.WHITE);

		MainControl.zoomIn = zoomIn;

		zoomOut = new JButton(new ImageIcon(
				"images/main-tool-bar-images/zoom_out.png"));
		zoomOut.setBackground(Color.WHITE);

		MainControl.zoomOut = zoomOut;*/

		zoomSlider = new JSlider(JSlider.HORIZONTAL, 0, 6, 3);
		zoomSlider.setBackground(BACKGROUND);
		MainControl.zoomSlider = zoomSlider;

		final Map<Integer, Integer> zoomValues = new HashMap<Integer, Integer>();
		zoomValues.put(0, 25);
		zoomValues.put(1, 50);
		zoomValues.put(2, 75);
		zoomValues.put(3, 100);
		zoomValues.put(4, 200);
		zoomValues.put(5, 400);
		zoomValues.put(6, 800);

		zoomSlider.setMajorTickSpacing(1);
		zoomSlider.setPaintTicks(true);
		zoomSlider.setSnapToTicks(true);

		zoomSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				showLabel(zoomSlider, zoomValues);
				MainControl.zoom = (double) zoomValues.get(zoomSlider.getValue()) / 100;
				MainControl.drawingArea.zoom();
			}
		});
		showLabel(zoomSlider, zoomValues);
/*
		zoomIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (zoomSlider.getValue() < zoomSlider.getMaximum()) {
					zoomSlider.setValue(zoomSlider.getValue() + 1);
				}
			}
		});
		zoomOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (zoomSlider.getValue() > zoomSlider.getMinimum()) {
					zoomSlider.setValue(zoomSlider.getValue() - 1);
				}
			}
		});*/

		add(zoom);
		add(zoomSlider);
	}
	
}
