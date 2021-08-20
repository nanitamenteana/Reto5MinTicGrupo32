package view;
//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Image;
//import java.math.BigInteger;

import controller.ControladorRequerimientosReto4;

import model.vo.SumaProveedor;
import java.util.ArrayList;

//Herencia de una generalizacion
public class Requerimiento3_GUI extends JFrame {

    //Atributos -> Componentes intermedios y componentes
	private JTable jtProveedor;

    //Constructor realizar la composición de la ventana
    public Requerimiento3_GUI(ArrayList<SumaProveedor> rankingSumaProveedor,ControladorRequerimientosReto4 controlador){

		//Propiedades del frame
        setTitle("-----Suma Cantidades de Compra del Proveedor JUMBO-----");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		//Construccion de la tabla que presentara los proyectos
		String[] encabezado = {"Suma_Cantidades"};
		this.jtProveedor = new JTable(this.formatoRegistros(rankingSumaProveedor, encabezado.length), encabezado);
		JScrollPane sp = new JScrollPane(this.jtProveedor);

		//Componente intermedio - Tabla
		JPanel panel = new JPanel(new GridLayout());
		panel.setBorder(new TitledBorder("Proveedor JUMBO"));
		panel.add(sp);

		//Contenedor
		getContentPane().add(panel);
		
		//Mostrar ventana/frame
        setSize(400,400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

	//Imagenes e iconos para la ventana
    private ImageIcon redimensionarIcono(ImageIcon icono,int pixeles){        
        Image image = icono.getImage(); 
        Image newimg = image.getScaledInstance(pixeles, pixeles,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }

	//JTable requiere String
	private String [][] formatoRegistros(ArrayList<SumaProveedor> rankingSumaProveedor, int numeroEncabezado){
		//Declaracion del contenedor de retorno

		String [][] registros = new String[rankingSumaProveedor.size()][numeroEncabezado];

		for (int i = 0; i < rankingSumaProveedor.size(); i++){
			registros[i][0] = String.valueOf(rankingSumaProveedor.get(i).getCantidad());
			}
		
		return registros;

	}
}


