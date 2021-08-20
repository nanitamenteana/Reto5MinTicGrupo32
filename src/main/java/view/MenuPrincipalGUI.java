package view;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Image;
//import java.math.BigInteger;

import controller.ControladorRequerimientosReto4;

//Herencia de una generalizacion
public class MenuPrincipalGUI extends JFrame {

    //Atributos -> Componentes intermedios y componentes
    private JButton btnRequerimiento1;
    private JButton btnRequerimiento3;
    private JButton btnRequerimiento4;
    //private JButton btnCRUD_Materiales;

    //Constructor realizar la composición de la ventana
    public MenuPrincipalGUI(){
    }

	//Imagenes e iconos para la ventana
    private ImageIcon redimensionarIcono(ImageIcon icono,int pixeles){        
        Image image = icono.getImage(); 
        Image newimg = image.getScaledInstance(pixeles, pixeles,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }

    //Método para composición interfaz gráfica
    public void iniciarGUI(ControladorRequerimientosReto4 controlador){

        //Propiedades del frame
        setTitle("Menú Principal Reto 5");
        setTitle("Menú Principal Reto 5 / CRUD");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Agregar componentes y enlazarlos con imagenes

		btnRequerimiento1 = new JButton(redimensionarIcono(new ImageIcon("img/Proyecto.png"), 64));
		btnRequerimiento1.setText("Proyecto Ciudad");

		//El evento relacionado con el boton - Quien me escucha
		btnRequerimiento1.addActionListener(controlador);

		//Lo que el boton dice respecto al evento asociado
		btnRequerimiento1.setActionCommand("ProyectoCiudad");

		btnRequerimiento3 = new JButton(redimensionarIcono(new ImageIcon("img/Compra.png"), 64));
		btnRequerimiento3.setText("Suma Cantidad");

		//El evento relacionado con el boton - Quien me escucha
		btnRequerimiento3.addActionListener(controlador);

		//Lo que el boton dice respecto al evento asociado
		btnRequerimiento3.setActionCommand("SumaCantidad");

		btnRequerimiento4 = new JButton(redimensionarIcono(new ImageIcon("img/Lider.png"), 64));
		btnRequerimiento4.setText("Líder Ciudad");

		//El evento relacionado con el boton - Quien me escucha
		btnRequerimiento4.addActionListener(controlador);

		//Lo que el boton dice respecto al evento asociado
		btnRequerimiento4.setActionCommand("LiderCiudad");

		//Asociar los componentes al componente intermedio o al contenedor

		//Componente intermedio
		JPanel panel = new JPanel(new GridLayout(3,1));
		//JPanel panel = new JPanel(new GridLayout(4,1));
		panel.add(btnRequerimiento1);
		panel.add(btnRequerimiento3);
		panel.add(btnRequerimiento4);

		//Contenedor
		getContentPane().add(panel);
		

        //Mostrar ventana/frame
        setSize(400,400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    //Manejo de acciones y llamados a la lógica -> Modelo (procesos)
    //MVC -> No suceda nada de lo anterior en la vista (Consola o Interfaz Gráfica)    
}
