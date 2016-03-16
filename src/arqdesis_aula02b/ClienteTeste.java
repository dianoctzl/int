package arqdesis_aula02b;


public class ClienteTeste {
	public static void main(String[] args) {
		Cliente cliente = new Cliente(3, "Bela Lugosi", null);
		cliente.criar();
		cliente.carregar();
		System.out.println(cliente);
		cliente.setFone("123123333");
		cliente.atualizar();
		cliente.carregar();
		System.out.println(cliente);
		cliente.excluir();
		cliente.carregar();
		System.out.println(cliente);		
	}
}
