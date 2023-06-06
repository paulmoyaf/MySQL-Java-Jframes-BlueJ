package formularios;

/* Importamos las componentes Swing, así como el paquete con los interfaces para los eventos */
import javax.swing.*;

//import com.diozero.devices.LED;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;
import java.util.concurrent.*;

//import tabla.Tabla;
//import terminal.MenuTerminal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/* La clase JFrame encapsula el concepto de una ventana, para implementar una aplicación que muestre una ventana debemos plantear una clase que herede de la clase JFrame e implemente a a ActionListener para el evento del botón*/
public class FormLed extends JFrame implements ActionListener {

  /* Definimos variables. */
  // public static JTextArea txt_id, txt_marca, txt_precio, txt_dcto, txt_tipo, txt_color, txt_teclas, txt_conector, txt_envio, txt_pvp, txt_code;
  public static JTextField txt_id, txt_marca, txt_precio, txt_dcto, txt_tipo, txt_color, txt_teclas, txt_conector, txt_envio, txt_pvp,txt_titulo;
  public JLabel lb_id, lb_marca, lb_precio, lb_dcto, lb_tipo, lb_color, lb_teclas, lb_conector, lb_envio, lb_pvp;
  public static JLabel lb_bulbON, lb_bulbOFF;
  public static JButton btON, btOFF,btMenu;
  public JPanel p;
  ImageIcon bulb_on = new ImageIcon("icono/bulb_on.png");
  ImageIcon bulb_off = new ImageIcon("icono/bulb_off.png");
  ImageIcon raspberri = new ImageIcon("icono/raspberry.svg");
  public static GpioController gpio = GpioFactory.getInstance();
  public static GpioPinDigitalOutput ledPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08);
  

  public FormLed() throws Exception {
  

    /* Configuración del JFrame */
    setLayout(null);
    setBounds(0, 0, 300, 620);
    setTitle("BLINK LED - RASPBERRI");
    setResizable(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    getContentPane().setBackground(Color.white);

    lb_bulbON = new JLabel();
    lb_bulbON.setBounds(90, 10, 500, 500);
    lb_bulbON.setIcon(bulb_on);
    lb_bulbON.setVisible(false);
    add(lb_bulbON);

    lb_bulbOFF = new JLabel();
    lb_bulbOFF.setBounds(90, 10, 500, 500);
    lb_bulbOFF.setIcon(bulb_off);
    add(lb_bulbOFF);


    txt_titulo = new JTextField();
    txt_titulo.setBounds(0, 0, 300, 80);
    txt_titulo.setBackground(Color.ORANGE);
    txt_titulo.setForeground(Color.white);
    txt_titulo.setText("BOMBILLA RASPBERRI");
    txt_titulo.setFont(new Font("MONOSPACED",1,16));
    txt_titulo.setHorizontalAlignment(0);
    txt_titulo.setEditable(false);
    add(txt_titulo);


    btON= new JButton("ENCENDER");
    btON.setBounds(25, 400,100, 30);
    btON.setBackground(Color.CYAN);
    btON.setForeground(Color.black);
    add(btON);

    btOFF = new JButton("APAGAR");
    btOFF.setBounds(160, 400, 100, 30);
    btOFF.setBackground(Color.LIGHT_GRAY);
    btOFF.setForeground(Color.black);
    add(btOFF);    

    btMenu = new JButton("MENU");
    btMenu.setBounds(80, 500, 100, 30);
    btMenu.setBackground(Color.red);
    btMenu.setForeground(Color.white);
    add(btMenu);




    /* Inicializo escuchador del botón */
    btON.addActionListener(this);
    btOFF.addActionListener(this);
    btMenu.addActionListener(this);
    


 
  }

//////////////////////////////////////////////////////////////////////////////////
  /* Método que implementa la acción del botón */


  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == btON) {
        try{
	    lb_bulbOFF.setVisible(false);
            lb_bulbON.setVisible(true);
	    ledON();
        } catch (Exception e1) {
            // TODO: handle exception
        }
    
    
    }
    
    if (e.getSource() == btOFF) {
	try{
	    lb_bulbOFF.setVisible(true);
	    lb_bulbON.setVisible(false);
	    ledOFF();
	} catch (Exception e1) {   
            // TODO: handle exception
        }
    }

    if (e.getSource() == btMenu) {
      JOptionPane.showMessageDialog(null, "BYE BYE !!!\n", "Información", 1);
      dispose();
    }

  }
  
  

    public static void ledON() {
	
	    /** create gpio controller */


	    try {
		
	    //final GpioController gpio = GpioFactory.getInstance();
	    // final GpioPinDigitalOutput ledPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08);
	    //final GpioPinDigitalOutput ledPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08,"LED",PinState.LOW);
	    
	    System.out.println("Encendiendo...");
	    /*
	    ledPin.high();
	    TimeUnit.SECONDS.sleep(20);
	    System.out.println("Apagando.");
	    ledPin.low();
	    gpio.shutdown();*/
	    /** Blink every second */
	    ledPin.high();
	    //ledPin.blink(1000, 15000);
	    //gpio.shutdown();

	    /** keep program running until user aborts (CTRL-C) */
	    /*
	    for (int i = 0; i < 10; i++) {
		//while (true) {
		Thread.sleep(2000);
		System.out.println("en loop");
	    }*/
	    

	} catch (Exception e) {
	    e.printStackTrace();
	}

    }
    
        public static void ledOFF() {
	try {
	    //gpio.shutdown();

	    //final GpioController gpio = GpioFactory.getInstance();
	    //final GpioPinDigitalOutput ledPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08);
	    //final GpioPinDigitalOutput ledPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08,"LED",PinState.LOW);
	    
	    System.out.println("Apagando...");
	    //ledPin.high();
	    ledPin.low();
	    //gpio.shutdown();


	} catch (Exception e) {
	    e.printStackTrace();
	}
    
    }




}





