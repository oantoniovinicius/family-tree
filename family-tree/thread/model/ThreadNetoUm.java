/* ***************************************************************
* Autor............: Antonio Vinicius Silva Dutra
* Matricula........: 202110810
* Inicio...........: 22/03/2023
* Ultima alteracao.: 24/03/2023
* Nome.............: ThreadNetoUm.java
* Funcao...........: executa comandos de thread do neto um
*************************************************************** */

package model;

import java.lang.Thread;
import control.TreeControl;

public class ThreadNetoUm extends Thread{
  //instanciando o bisneto filho do neto um
  ThreadBisneto bisneto = new ThreadBisneto();

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
  * Funcao: inicia as threads de acordo com o pai(neto Um): bisneto
            troca as imagens do neto um conforme a idade/segundos for passando
  * Parametros: nenhum
  * Retorno: void
  *************************************************************** */
  public void run(){
    try{
      for(idade = 0; idade <=35; idade++){
        if(idade == 18){
          controller.changeImagePrimeiroNeto("assets/netoUm18.png");
        }
        if(idade == 28){
          controller.changeImagePrimeiroNeto("assets/netoUm28.png");
        }
        if(idade == 30){
          controller.startBisneto();//inicia o bisneto aos 30 anos de idade do neto Um
        }
        if(idade == 35){
            controller.changeImagePrimeiroNeto("assets/ghost.png");
        }
        sleep(1000);
      }
    }catch(Exception e){//pegando o erro do tipo Exception caso ocorra
        e.printStackTrace();//imprime o erro 
    }
  }//fim do metodo run()
}//fim da classe ThreadNetoUm

