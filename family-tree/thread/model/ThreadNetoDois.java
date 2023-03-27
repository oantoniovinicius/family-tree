/* ***************************************************************
* Autor............: Antonio Vinicius Silva Dutra
* Matricula........: 202110810
* Inicio...........: 22/03/2023
* Ultima alteracao.: 24/03/2023
* Nome.............: ThreadNetoDois.java
* Funcao...........: executa comandos de thread do neto dois
*************************************************************** */
package model;

import java.lang.Thread;
import control.TreeControl;

public class ThreadNetoDois extends Thread{
  //instanciando controlador que sera usado na classe  
  private TreeControl controller;
  private int idade = 0;
    
  /* ***************************************************************
  * Metodo: setController()
  * Funcao: definindo o controlador que sera usado nessa classe
  * Parametros: controller principal
  * Retorno: void
  *************************************************************** */
  public void setController(TreeControl control){
    this.controller = control;
  }//fim do metodo setController()
  
  /* ***************************************************************
  * Metodo: run()
  * Funcao: apenas realiza a troca de imagens conforme a idade passa
  * Parametros: nenhum
  * Retorno: void
  *************************************************************** */
  public void run(){
    try{
      for(idade = 0; idade <=33; idade++){
        if(idade == 18){
          controller.changeImageSegundoNeto("assets/netoDois18.png");
        }
        if(idade == 28){
          controller.changeImageSegundoNeto("assets/netoDois28.png");
        }
        if(idade == 33){
          controller.changeImageSegundoNeto("assets/ghost.png");
        }
          sleep(1000);
      }
    }catch(Exception e){//pegando o erro do tipo Exception caso ocorra
        e.printStackTrace();//imprime o erro 
    }
  }//fim do metodo run()
}//fim da classe ThreadNetoDois
