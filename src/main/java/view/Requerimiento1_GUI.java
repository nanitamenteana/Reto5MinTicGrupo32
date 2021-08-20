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

import model.vo.ProyectoCiudad;
import java.util.ArrayList;

//Herencia de una generalizacion
public class Requerimiento1_GUI extends JFrame {

    //Atributos -> Componentes intermedios y componentes
	private JTable jtProyectos;

    //Constructor realizar la composición de la ventana
    public Requerimiento1_GUI(ArrayList<ProyectoCiudad> rankingProyectoCiudad,ControladorRequerimientosReto4 controlador){

		//Propiedades del frame
        setTitle("------Proyecto Ciudad------");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		//Construccion de la tabla que presentara los proyectos
		String[] encabezado = {"Constructora",
		"Fecha_Inicio", "Clasificación"};
		this.jtProyectos = new JTable(this.formatoRegistros(rankingProyectoCiudad, encabezado.length), encabezado);
		JScrollPane sp = new JScrollPane(this.jtProyectos);

		//Componente intermedio - Tabla
		JPanel panel = new JPanel(new GridLayout());
		panel.setBorder(new TitledBorder("Ranking Proyecto Ciudad"));
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
	private String [][] formatoRegistros(ArrayList<ProyectoCiudad> rankingProyectoCiudad, int numeroEncabezados){
		//Declaracion del contenedor de retorno
		String[][] registros = new String[rankingProyectoCiudad.size()][numeroEncabezados];

		//Desenvolver los objetos de la coleccion
		for (int i = 0; i< rankingProyectoCiudad.size(); i++){
			registros[i][0] = rankingProyectoCiudad.get(i).getConstructora();
			registros[i][1] = String.valueOf(rankingProyectoCiudad.get(i).getFechaInicio());
			registros[i][2] = rankingProyectoCiudad.get(i).getClasificacion();
		}

		//retornar los registros en formato JTable
		return registros;

	}

}
