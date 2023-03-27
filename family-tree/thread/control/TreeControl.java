/* ***************************************************************
* Autor............: Antonio Vinicius Silva Dutra
* Matricula........: 202110810
* Inicio...........: 22/03/2023
* Ultima alteracao.: 24/03/2023
* Nome.............: TreeControl.java
* Funcao...........: gerencia e controla a GUI do fxml
*************************************************************** */
package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.*;

public class TreeControl implements Initializable{
  //todos os ImageView da arvore genealogica.
  @FXML
  private ImageView background;
  @FXML
  private ImageView sakuraTree;
  @FXML
  private ImageView imagePai;
  @FXML
  private ImageView imageFilhoUm;
  @FXML
  private ImageView imageFilhoDois;
  @FXML
  private ImageView imageFilhoTres;
  @FXML
  private ImageView imageNetoUm;
  @FXML
  private ImageView imageNetoDois;
  @FXML
  private ImageView imageBisneto;
  @FXML
  private ImageView textLogo;
  @FXML
  private Button Iniciar;

  //instanciando as threads pois serao startas nessa classe
  ThreadFilhoUm filhoUm = new ThreadFilhoUm();
  ThreadFilhoDois filhoDois = new ThreadFilhoDois();
  ThreadFilhoTres filhoTres = new ThreadFilhoTres();
  ThreadNetoUm netoUm = new ThreadNetoUm();
  ThreadNetoDois netoDois = new ThreadNetoDois();
  ThreadBisneto bisneto = new ThreadBisneto();
  ThreadPai pai = new ThreadPai();

  //botao para iniciar a arvore
  @FXML
  void clickButton(ActionEvent event) {
    pai.start();//inicia a arvore pelo pai
  }//fim do clickButton
  
  /* ***************************************************************
  * Metodo: initialize()
  * Funcao: inicia o controlador de fato e instancia o controlador nas threads
  * Parametros: URL location, ResourceBundle resources
  * Retorno: void
  *************************************************************** */
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    pai.setController(this);
    filhoUm.setController(this);
    filhoDois.setController(this);
    filhoTres.setController(this);
    netoUm.setController(this);
    netoDois.setController(this);
    bisneto.setController(this);
  }//fim do metodo initialize()

  /* ***************************************************************
  * Metodo: start[...];
  * Funcao: da inicio a thread na arvore e seta a imagem do pai, filho, neto ou bisneto na arvore
  * Parametros: nenhum
  * Retorno: void
  *************************************************************** */
  public void startPai(){
    imagePai.setImage(new Image("assets/pai1.png"));//apenas seta a imagem inicial do pai
  }//fim do metodo startPai()
  public void startFilhoUm(){
    filhoUm.start();//inicio do filho um
    imageFilhoUm.setImage(new Image("assets/filhoUm1.png"));
  }//fim do metodo startFilhoUm()
  public void startFilhoDois(){
    filhoDois.start();//inicio do filho dois
    imageFilhoDois.setImage(new Image("assets/filhoDois1.png"));
  }//fim do metodo startFilhoDois()
  public void startFilhoTres(){
    filhoTres.start();//inicio do filho tres
    imageFilhoTres.setImage(new Image("assets/filhoTres1.png"));
  }//fim do metodo startFilhoTres()
  public void startNetoUm(){
    netoUm.start();//inicio do neto um
    imageNetoUm.setImage(new Image("assets/netoUm1.png"));
  }//fim do metodo startNetoUm()
  public void startNetoDois(){
    netoDois.start();//inicio do neto dois
    imageNetoDois.setImage(new Image("assets/netoDois1.png"));
  }//fim do metodo startNetoDois()
  public void startBisneto(){
    bisneto.start();//inicio do bisneto
    imageBisneto.setImage(new Image("assets/bisneto.png"));
  }//fim do metodo startBisneto()
  
  /* ***************************************************************
  * Metodo: changeImage[...];
  * Funcao: troca as imagens das threads na arvore
  * Parametros: String url(diretorio da imagem)
  * Retorno: void
  *************************************************************** */
  public void changeImagePai(String url){
    imagePai.setImage(new Image(url));
  }//fim do metodo changeImagePai()

  public void changeImagePrimeiroFilho(String url){
    imageFilhoUm.setImage(new Image(url));
  }//fim do metodo changeImagePrimeiroFilho()
  
  public void changeImageSegundoFilho(String url){
    imageFilhoDois.setImage(new Image(url));
  }//fim do metodo changeImageSegundoFilho()

  public void changeImageTerceiroFilho(String url){
    imageFilhoTres.setImage(new Image(url));
  }//fim do metodo changeImageTerceiroFilho()
  
  public void changeImagePrimeiroNeto(String url){
    imageNetoUm.setImage(new Image(url));
  }//fim do metodo changeImagePrimeiroNeto()
  
  public void changeImageSegundoNeto(String url){
    imageNetoDois.setImage(new Image(url));
  }//fim do metodo changeImageSegundoNeto()
  
  public void changeImageBisneto(String url){
    imageBisneto.setImage(new Image(url));
  }//fim do metodo changeImageBisneto()
}//fim da classe TreeControl

