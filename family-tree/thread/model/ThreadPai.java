/* ***************************************************************
* Autor............: Antonio Vinicius Silva Dutra
* Matricula........: 202110810
* Inicio...........: 22/03/2023
* Ultima alteracao.: 24/03/2023
* Nome.............: ThreadPai.java
* Funcao...........: executa comandos de thread do pai
*************************************************************** */
package model;

import java.lang.Thread;
import control.*;

public class ThreadPai extends Thread{
  //instanciando as threads filhas da thread pai na arvore
  ThreadFilhoUm filhoUm = new ThreadFilhoUm();
  ThreadFilhoDois filhoDois = new ThreadFilhoDois();
  ThreadFilhoTres filhoTres = new ThreadFilhoTres();
  
  //instanciando controlador que sera usado na classe
  private TreeControl controller;
  private int idade = 0;

  /* ***************************************************************
  * Metodo: setController()
  * Funcao: definindo o controlador que sera usado nessa classe
  * Parametros: controller principal
  * Retorno: void
  *************************************************************** */
  public void setController(TreeControl controller){
    this.controller = controller;
  } //fim do metodo setController()
  
  /* ***************************************************************
  * Metodo: run()
  * Funcao: inicia as threads de acordo com o pai: filho um, filho dois e filho tres.
            troca as imagens do pai conforme a idade/segundos for passando
  * Parametros: nenhum
  * Retorno: void
  *************************************************************** */
  public void run(){
    try{
      for(idade = 0; idade <=90; idade++){
        System.out.println("Segundos passados: " + idade);
        if(idade == 0){
          controller.startPai();
        }
        if(idade == 13){
          controller.changeImagePai("assets/pai13.png");
        }
        if(idade == 18){
          controller.changeImagePai("assets/pai18.png");
        }
        if(idade == 22){
          controller.changeImagePai("assets/pai22.png");
          controller.startFilhoUm();//inicia filho um aos 22 anos de idade(pai)
        }
        if(idade == 25){
          controller.startFilhoDois();//inicia filho dois aos 25 anos de idade(pai)
        }
        if(idade == 32){
          controller.changeImagePai("assets/pai32.png");
          controller.startFilhoTres();//inicia filho tres aos 32 anos de idade(pai)
        }
        if(idade == 60){
          controller.changeImagePai("assets/pai60.png");
        }
        if(idade == 90){
          controller.changeImagePai("assets/ghost.png");
      }
        sleep(1000);
      }
    }catch(Exception e){//pegando o erro do tipo Exception caso ocorra
        e.printStackTrace();//imprime o erro 
    }
  }//fim do metodo run()
}//fim da classe ThreadPai

