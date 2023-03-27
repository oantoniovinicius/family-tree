/* ***************************************************************
* Autor............: Antonio Vinicius Silva Dutra
* Matricula........: 202110810
* Inicio...........: 21/03/2023
* Ultima alteracao.: 23/03/2023
* Nome.............: Principal.cpp
* Funcao...........: Arvore genealógica com comando fork()
*************************************************************** */
#include <unistd.h>
#include <iostream>
#include <time.h>
#include <sys/types.h>

using namespace std;

int main() {
  //Declarando id que sera utilizado nas verifiacoes, etc
  pid_t pId;
  
  cout << "\nINICIO DA ARVORE\n" <<endl;
  
  pId = fork();

  //Verificacao de erro
  if(pId == -1){//se o id do processo for menor que 0, significa que deu erro na criacao do processo
    cout << "Erro na criacao do processo!" << endl;
    exit(1);//caso de erro o exit encerra o processo
  }
  else if(pId == 0){//se id do processo for igual a 0, ele cria outra thread
    sleep(22);//coloca o processo para dormir
    cout << "Nasce o primeiro filho! :)" <<endl;
    cout << "ID do pai: " << getppid() << "\nID do filho: " << getpid() << "\n\n";
    pId = fork(); //fork utilizado para criar outra thread

    if(pId == -1){//se o id do processo for menor que 0, significa que deu erro na criacao do processo
      cout << "Erro na criacao do processo!" << endl;
      exit(1);//caso de erro o exit encerra o processo
    }
    //processo de criacao de thread do primeiro neto
    else if(pId == 0){//se id do processo for igual a 0, ele cria outra thread
        sleep(16);//coloca o processo para dormir por 16s
        cout << "Nasce o primeiro neto! :)" << endl;
        cout << "ID do pai: " << getppid() << "\nID do filho: " << getpid() << "\n\n";
        pId = fork();
        if(pId == -1){//se o id do processo for menor que 0, significa que deu erro na criacao do processo
          cout << "Erro na criacao do processo!" << endl;
          exit(1);
        }
        else if(pId == 0){
          sleep(30);//apos 30 anos de idade (neto um) nasce o bisneto
          cout << "Nasce o primeiro bisneto! :)" << endl;
          cout << "ID do pai: " << getppid() << "\nID do filho: " << getpid() << "\n\n";

          sleep(12);//apos 12 anos de idade, o bisneto morre
          cout << "O primeiro bisneto morreu! :(" << "\n\n";
          exit(0);//encerra o processo bisneto
        }
        sleep(35);//apos 35 anos de idade o primeiro neto morre
        cout << "O primeiro neto morreu! :(" << "\n\n";
        exit(0);//encerra processo 
    }
    sleep(61);//apos 61 anos o primeiro filho morre
    cout << "O primeiro filho morreu! :(" << "\n\n";
    exit(0);//encerra o processo
  } else {
    cout << "Nasce o pai! :)\nID do pai: " << getpid() << "\n\n"; //nascimento do pai
    pId = fork();
    if(pId == -1){//se o id do processo for menor que 0, significa que deu erro na criacao do processo
      cout << "Erro na criacao do processo!" << endl;
      exit(1);//caso de erro o exit encerra o processo
    }
    else if(pId == 0){
      sleep(25);//aos 25 anos o pai tem o segundo filho
      cout << "Nasce o segundo filho! :)\n";
      cout << "ID do pai: " << getppid() << "\nID do filho: " << getpid() << "\n\n";
      pId = fork();
      if(pId == -1){//se o id do processo for menor que 0, significa que deu erro na criacao do processo
        cout << "Erro na criacao do processo!" << endl;
        exit(1);//caso de erro o exit encerra o processo
      }
      else if(pId == 0){
        sleep(20);//aos 20 anos o segundo filho vira pai
        cout << "Nasce o segundo neto! :)\n";
        cout << "ID do pai: " << getppid() << "\nID do filho: " << getpid() << "\n\n";

        sleep(33); //aos 33 anos o segundo neto morre
        cout << "O segundo neto morreu! :(" << "\n\n";
        exit(0);//encerra o processo
      }
      sleep(55);//o segundo filho morre aos 55 anos
      cout << "O segundo filho morreu! :(" << "\n\n";
      exit(0);//encerra o processo
    }
    
    pId = fork();//inicia thread do terceiro filho
    if(pId == -1){//se o id do processo for menor que 0, significa que deu erro na criacao do processo
      cout << "Erro na criacao do processo!" << endl;
      exit(1);//caso de erro o exit encerra o processo
    }
    else if(pId == 0){
      sleep(32);//o pai aos 32 anos tem o terceiro filho
      cout << "Nasce o terceiro filho! :)\n";
      cout << "ID do pai: " << getppid() << "\nID do filho: " << getpid() << "\n\n";
      
      sleep(55);//terceiro filho morre aos 55 anos
      cout << "O terceiro filho morreu! :(" << "\n\n";
      exit(0);//encerra o processo
    }
    sleep(90);//aos 90 anos, o pai morre
    cout << "O pai morreu! :'(\n";
    exit(0);
  } //fim do else
} //fim da main
