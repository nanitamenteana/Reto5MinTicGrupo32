package controller;

//Estructuras de datos (colecciones)
import java.util.ArrayList;
import javax.swing.JButton;
//import javax.swing.JOptionPane;

//Modelos (acceso y objetos contenedores)
//Requerimiento 1
import model.dao.ProyectoCiudadDao;
import model.vo.ProyectoCiudad;
//Requerimiento 4
import model.dao.LiderCiudadDao;
import model.vo.LiderCiudad;
//Requerimiento 3
import model.dao.SumaProveedorDao;
import model.vo.SumaProveedor;

//View
import view.MenuPrincipalGUI;
import view.Requerimiento1_GUI;
import view.Requerimiento3_GUI;
import view.Requerimiento4_GUI;

//Action Listener
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//Librerías para bases de datos
import java.sql.SQLException;

public class ControladorRequerimientosReto4 implements ActionListener {

    //Alojar objetos del modelo
    private final ProyectoCiudadDao proyectoCiudadDao;
    private final LiderCiudadDao liderCiudadDao;
    private final SumaProveedorDao sumaProveedorDao;

    //Alojar objetos de la vista
    private final MenuPrincipalGUI menuPrincipalGUI;
    private Requerimiento1_GUI requerimiento1_GUI;
    private Requerimiento3_GUI requerimiento3_GUI;
    private Requerimiento4_GUI requerimiento4_GUI;

    //Constructor
    public ControladorRequerimientosReto4(){
        //Instancia de los DAO
        this.proyectoCiudadDao = new ProyectoCiudadDao();
        this.liderCiudadDao = new LiderCiudadDao();
        this.sumaProveedorDao = new SumaProveedorDao();
        //Instanciamos las interfaces
        this.menuPrincipalGUI = new MenuPrincipalGUI();
    }

    //Requerimientos y sus casos de uso

    //Requerimiento 1
    public ArrayList<ProyectoCiudad> consultarProyectoCiudad() throws SQLException {
        return this.proyectoCiudadDao.rankingProyectosCiudad();
    }

    //Requerimiento 4
    public ArrayList<LiderCiudad> consultarLiderCiudad() throws SQLException {
        return this.liderCiudadDao.rankingLiderCiudad();
        
    }

    //Requerimiento 3
    public ArrayList<SumaProveedor> consultarSumaProveedor() throws SQLException {
        return this.sumaProveedorDao.rankingSumaProveedor();
    }

    //Controlador iniciando aplicacion
    public void iniciarAplicacion(){
        this.menuPrincipalGUI.iniciarGUI(this);
    }

    //Conectado con el action listener. El controlador maneja los eventos
    @Override
    public void actionPerformed(ActionEvent e) {
        //Obtener el evento asociado al botón
        String actionCommand = ((JButton)e.getSource()).getActionCommand();

        switch(actionCommand){

            case "ProyectoCiudad":
                System.out.println("()()()Interfaz Proyecto Ciudad");
                try{
                    ArrayList<ProyectoCiudad>rankingProyectoCiudad = new ArrayList<ProyectoCiudad>();
                    rankingProyectoCiudad = this.proyectoCiudadDao.rankingProyectosCiudad();
                    this.requerimiento1_GUI = new Requerimiento1_GUI(rankingProyectoCiudad, this);
                }catch(SQLException eProyectoCiudad){
                    System.err.println("Error cargando requerimiento 1 en la ventana!"+eProyectoCiudad);
                }
            break;

            case "SumaCantidad":
                System.out.println("$$$Interfaz Suma Cantidad");
                try{
                    ArrayList<SumaProveedor> rankingSumaProveedor = new ArrayList<SumaProveedor>();
                    rankingSumaProveedor = this.sumaProveedorDao.rankingSumaProveedor();
                    this.requerimiento3_GUI = new Requerimiento3_GUI(rankingSumaProveedor, this);
                }catch(SQLException eProyectoCiudad){
                    System.err.println("Error cargando requerimiento 3 en la ventana!"+eProyectoCiudad);
                }
            break;


            case "LiderCiudad":
                System.out.println("---Interfaz Lider Ciudad---");
                try{
                    ArrayList<LiderCiudad> rankingLiderCiudad = new ArrayList<LiderCiudad>();
                    rankingLiderCiudad = this.liderCiudadDao.rankingLiderCiudad();
                    this.requerimiento4_GUI = new Requerimiento4_GUI(rankingLiderCiudad, this);
                }catch(SQLException eLiderCiudad){
                    System.err.println("Error cargando requerimiento 4 en la ventana!"+eLiderCiudad);
                }
                
            break;
        }
    }

}
