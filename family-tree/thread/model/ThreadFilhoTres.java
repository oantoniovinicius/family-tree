/* ***************************************************************
* Autor............: Antonio Vinicius Silva Dutra
* Matricula........: 202110810
* Inicio...........: 22/03/2023
* Ultima alteracao.: 24/03/2023
* Nome.............: ThreadFilhoTres.java
* Funcao...........: executa comandos de thread do filho tres
*************************************************************** */
package model;

import java.lang.Thread;
import control.TreeControl;

public class ThreadFilhoTres extends Thread{
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
  }//fim do metodo setController

  /* ***************************************************************
  * Metodo: run()
  * Funcao: ja que o filho tres nao starta nenhuma outra thread, 
  apenas troca as imagens do filho tres um conforme a idade/segundos for passando
  * Parametros: nenhum
  * Retorno: void
  *************************************************************** */
  public void run(){
    try{
      for(idade = 0; idade <=55; idade++){
        if(idade == 13){
          controller.changeImageTerceiroFilho("assets/filhoTres13.png");
        }
        if(idade == 20){
          controller.changeImageTerceiroFilho("assets/filhoTres20.png");
        }
        if(idade == 35){
          controller.changeImageTerceiroFilho("assets/filhoTres35.png");
        }
        if(idade == 55){
            controller.changeImageTerceiroFilho("assets/ghost.png");
        }
        sleep(1000);
      }
    }catch(Exception e){//pegando o erro do tipo Exception caso ocorra
        e.printStackTrace();//imprime o erro 
    }
  }//fim do metodo run()
}//fim da classe ThreadFilhoTres