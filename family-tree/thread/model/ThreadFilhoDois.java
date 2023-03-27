/* ***************************************************************
* Autor............: Antonio Vinicius Silva Dutra
* Matricula........: 202110810
* Inicio...........: 22/03/2023
* Ultima alteracao.: 24/03/2023
* Nome.............: ThreadFilhoDois.java
* Funcao...........: executa comandos de thread do filho dois
*************************************************************** */
package model;

import java.lang.Thread;
import control.TreeControl;

public class ThreadFilhoDois extends Thread{
  //instanciando o netoDois filho do filhoDois
  ThreadNetoDois netoDois = new ThreadNetoDois();
  
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
  * Funcao: inicia as threads de acordo com o pai(filhoDois): netoDois
            troca as imagens do filhoDois um conforme a idade/segundos for passando
  * Parametros: nenhum
  * Retorno: void
  *************************************************************** */
  public void run(){
    try{
      for(idade = 0; idade <=55; idade++){
        if(idade == 15){
          controller.changeImageSegundoFilho("assets/filhoDois15.png");
        }
        if(idade == 20){
          controller.changeImageSegundoFilho("assets/filhoDois20.png");
          controller.startNetoDois();
        }
        if(idade == 32){
          controller.changeImageSegundoFilho("assets/filhoDois32.png");
        }
        if(idade == 45){
          controller.changeImageSegundoFilho("assets/filhoDois45.png");
        }
        if(idade == 55){
            controller.changeImageSegundoFilho("assets/ghost.png");
        }
        sleep(1000);
      }
    }catch(Exception e){//pegando o erro do tipo Exception caso ocorra
        e.printStackTrace();//imprime o erro 
    }
  }//fim do metodo run()
}//fim da classe ThreadFilhoDois
