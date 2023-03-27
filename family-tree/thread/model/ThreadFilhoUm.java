/* ***************************************************************
* Autor............: Antonio Vinicius Silva Dutra
* Matricula........: 202110810
* Inicio...........: 22/03/2023
* Ultima alteracao.: 24/03/2023
* Nome.............: ThreadFilhoUm.java
* Funcao...........: executa comandos de thread do filho um
*************************************************************** */
package model;

import java.lang.Thread;
import control.TreeControl;

public class ThreadFilhoUm extends Thread{
  //instanciando o netoUm filho do filhoUm
  ThreadNetoUm netoUm = new ThreadNetoUm();

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
  }//fim do metodoSetController

  /* ***************************************************************
  * Metodo: run()
  * Funcao: inicia as threads de acordo com o pai(filhoUm): netoUm
            troca as imagens do filhoUm um conforme a idade/segundos for passando
  * Parametros: nenhum
  * Retorno: void
  *************************************************************** */
  public void run(){
    try{
      for(idade = 0; idade <=61; idade++){
        if(idade == 16){
          controller.changeImagePrimeiroFilho("assets/filhoUm16.png");
          controller.startNetoUm();//nasce o netoUm aos 16 anos do filho um
        }
        if(idade == 22){
          controller.changeImagePrimeiroFilho("assets/filhoUm22.png");
        }
        if(idade == 40){
          controller.changeImagePrimeiroFilho("assets/filhoUm40.png");
        }
        if(idade == 55){
          controller.changeImagePrimeiroFilho("assets/filhoUm60.png");
        }
        if(idade == 61){
            controller.changeImagePrimeiroFilho("assets/ghost.png");
        }
        sleep(1000);
      }
    }catch(Exception e){//pegando o erro do tipo Exception caso ocorra
        e.printStackTrace();//imprime o erro 
    }
  }//fim do metodo run()
}//fim da classe ThreadFilhoUm()
