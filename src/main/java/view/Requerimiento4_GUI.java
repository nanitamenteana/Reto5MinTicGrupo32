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

import model.vo.LiderCiudad;
import java.util.ArrayList;

//Herencia de una generalizacion
public class Requerimiento4_GUI extends JFrame {

    //Atributos -> Componentes intermedios y componentes
	private JTable jtLider;

    //Constructor realizar la composición de la ventana
    public Requerimiento4_GUI(ArrayList<LiderCiudad> rankingLiderCiudad,ControladorRequerimientosReto4 controlador){

		//Propiedades del frame
        setTitle("-----Proyecto Ciudad-------");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		//Construccion de la tabla que presentara los proyectos
		String[] encabezado = {"Nombre Lider"};
		this.jtLider = new JTable(this.formatoRegistros(rankingLiderCiudad, encabezado.length), encabezado);
		JScrollPane sp = new JScrollPane(this.jtLider);

		//Componente intermedio - Tabla
		JPanel panel = new JPanel(new GridLayout());
		panel.setBorder(new TitledBorder("Ranking Lider de Dubaí"));
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
	private String [][] formatoRegistros(ArrayList<LiderCiudad> rankingLiderCiudad, int numeroEncabezados){
		
		String [][] registros = new String[rankingLiderCiudad.size()][numeroEncabezados];

		for (int i = 0; i < rankingLiderCiudad.size(); i++){
			registros[i][0] = String.valueOf(rankingLiderCiudad.get(i).getNombreLider());
			}
		
		//retornar los registros en formato JTable
		return registros;
		}


}


