/* ***************************************************************
* Autor............: Antonio Vinicius Silva Dutra
* Matricula........: 202110810
* Inicio...........: 22/03/2023
* Ultima alteracao.: 24/03/2023
* Nome.............: Principal.java
* Funcao...........: Inicia a GUI da arvore genealogica pelo start()
*************************************************************** */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import control.TreeControl;

public class Principal extends Application{
  //Instanciando o controller 
  TreeControl controller = new TreeControl();
  
  /* ***************************************************************
  * Metodo: main
  * Funcao: metodo inicial da principal classe da arvore
  * Parametros: String[] args
  * Retorno: nenhum
  *************************************************************** */
  public static void main(String[] args) {
    launch(args);
  }//fim do metodo main
  
  /* ***************************************************************
  * Metodo: start()
  * Funcao: iniciar a GUI 
  * Parametros: stage principal que sera mostrada na tela
  * Retorno: nenhum
  *************************************************************** */
  @Override
  public void start(Stage primaryStage) throws Exception {  
    primaryStage.setTitle("ARVORE GENEALOGICA");//definindo nome da aplicacao
    
    Parent loader = FXMLLoader.load((getClass().getResource("/view/TreeControllerFXML.fxml")));
   
    Scene scene = new Scene(loader);  
    
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }//fim do metodo start()
}//fim da classe Principal

