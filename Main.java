import javax.swing.*; //para mensagens pop-up
import java.util.*; //para arraylist

class Main {

//cria lista de aviões
static ArrayList<Aviao> listaAviao = new ArrayList<Aviao>();
//cria lista de 10 voos
static ArrayList<Voo> listaVoo = new ArrayList<Voo>(10);

/*MÉTODO MAIN*/
public static void main(String[] args) {

  menuPrincipal();

}

/*MENU PRINCIPAL*/
public static void menuPrincipal() {

  //usuário escolhe menu
  int menu = Integer.parseInt(JOptionPane.showInputDialog("Menu Principal\n\t1 - Parâmetros do Sistema\n\t2 - Reserva de Passagens\n\t3 - Sair"));
  
  //opções do menu
  switch(menu){
    case 1: parametroSistema(); break;
    case 2: reservaPassagem(); break;
    case 3: System.exit(0); break;
    default: JOptionPane.showMessageDialog(null, "Opção inválida"); menuPrincipal();
  }
}

/*PARÂMETROS DO SISTEMA*/
public static void parametroSistema() {

  //usuário escolhe menu
  int menu = Integer.parseInt(JOptionPane.showInputDialog("Parâmetros do Sistema\n\t1 - Cadastrar Aeronave\n\t2 - Cadastrar Voo\n\t3 - Voltar"));

  //opções do menu
  switch(menu){
    case 1: cadastraAviao(); parametroSistema(); break;
    case 2: cadastraVoo(); parametroSistema(); break;
    case 3: menuPrincipal(); break;
    default: JOptionPane.showMessageDialog(null, "Opção inválida"); parametroSistema();
  }
}

/*RESERVA DE PASSAGENS*/
public static void reservaPassagem() {

  //usuário escolhe menu
  int menu = Integer.parseInt(JOptionPane.showInputDialog("Reserva de Passagens\n\t1 - Fazer reserva\n\t2 - Consultar lugares vazios\n\t3 - Consultar reservas realizadas\n\t4 - Voltar"));

  //opções do menu
  switch(menu){
    case 1: fazerReserva(); reservaPassagem(); break;
    case 2: consultaLugar(); reservaPassagem(); break;
    case 3: consultaReserva(); reservaPassagem(); break;
    case 4: menuPrincipal(); break;
    default: JOptionPane.showMessageDialog(null, "Opção inválida"); reservaPassagem();
  }
}

/*CADASTRO DE AVIÃO*/
public static void cadastraAviao() {

  //usuário digita dados do avião
  String modelo = JOptionPane.showInputDialog("Digite o modelo do avião");
  int fileiras = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de fileiras:"));
  int assentos = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de assentos por fileira:"));

  //novo avião é criado
  listaAviao.add(new Aviao(modelo, fileiras, assentos));
  
  //iterador do vetor de avião - NECESSÁRIO?
  Iterator<Aviao> itr = listaAviao.iterator(); 

  //mostra todos os aviões - NECESSÁRIO?
	while(itr.hasNext()){
	  Aviao av =(Aviao)itr.next();                   
	  System.out.println(av.modelo + " " + av.fileiras + " " + av.assentos);
  }
  
  //aviso de conclusão para o usuário
  JOptionPane.showMessageDialog(null, "Avião" + modelo + " criado com sucesso.");
}

/*FUNÇÃO DE CADASTRAR VOOS*/
public static void cadastraVoo() {

  //usuário digita dados do voo
  int aviao = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do avião:"));
  int num = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do Voo:"));
  String data = JOptionPane.showInputDialog("Digite a data do voo:");
  String hora = JOptionPane.showInputDialog("Digite a hora do voo:");

  //novo voo é criado
  listaVoo.add(new Voo(listaAviao.get(aviao-1), num, data, hora));
}

/*FUNÇÃO DE FAZER RESERVA*/
public static void fazerReserva() {

}

/*FUNÇÃO DE CONSULTAR LUGAR*/
public static void consultaLugar() {

}

/*FUNÇÃO DE CONSULTAR RESERVA*/
public static void consultaReserva() {
  
}

}