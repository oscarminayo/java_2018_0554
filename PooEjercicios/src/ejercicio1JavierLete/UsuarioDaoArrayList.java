package ejercicio1JavierLete;

import java.util.ArrayList;
import java.util.List;



public class UsuarioDaoArrayList implements CrudAble<Usuario> { 
	private static final String NO_SE_ADMITE_USUARIOS_NULO = "No se admite usuarios nulo";
	private static final String YA_EXISTE_ESE_ID_DE_USUARIO = "Ya existe ese ID de usuario";
	private static final String YA_EXISTE_ESE_EMAIL = "Ya existe ese email";
	private static final String NO_EXISTE_ESE_ID = "No existe ese ID";
	
	private ArrayList<Usuario> usuarios = new ArrayList<>();  // CREO ARRAYLIST DE CLASE USUARIO

	public UsuarioDaoArrayList() {
		usuarios.add(new Usuario(1L, "javier@lete.com", "Pa$$w0rd"));
		usuarios.add(new Usuario(2L, "pepe@perez.com", "Pa$$w0rd"));
	}
	@Override
	public List<Usuario> getAll() {
		return usuarios;
	}

	@Override
	public Usuario getById(Long id) {
		for(Usuario usuario: usuarios) {
			if(usuario.getId() == id) {
				return usuario;
			}
		}
		
		return null;
	}

	@Override  // para insertar un nuevo usuario y validarsi  hay usuarios con la id y el email introducido
	public void insert(Usuario usuario) {
		if(usuario == null) { // si no se ha introducido datos usuario es null y lanza mensajes de excepcion con trhow
			throw new AccesoDatosException(NO_SE_ADMITE_USUARIOS_NULO);
		}
		
		for(int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getId() == usuario.getId()) {
				throw new AccesoDatosException(YA_EXISTE_ESE_ID_DE_USUARIO);
			}
			
			if(usuarios.get(i).getEmail().equals(usuario.getEmail())) {
				throw new AccesoDatosException(YA_EXISTE_ESE_EMAIL);
			}
		}
		
		usuarios.add(usuario);
	}

	@Override  // para actualizar usuario
	public void update(Usuario usuario) { // METDO CON PARAMETRO UN OBJETO DE CLASE USUARO
		int posicionId = -1;  // decaro la variable fuera del for
		
		// ID
		for(int i = 0; i < usuarios.size(); i++) {  // recorro array usuarios
			if(usuarios.get(i).getId() == usuario.getId()) {// si la id que recorre el array (i) es igaul a la que coje de los datos introducidos con el metodo getId
				posicionId = i; // cuando coincida la id que se introduce con la que hay guardada en el array 
		// EMAIL
			}else if(usuarios.get(i).getEmail().equals(usuario.getEmail())) {
				throw new AccesoDatosException(YA_EXISTE_ESE_EMAIL);  // si coinciden los emails lanza excepcion
			}
		}
		if(posicionId == -1) {
			throw new AccesoDatosException(NO_EXISTE_ESE_ID); 
		}
		
		usuarios.set(posicionId, usuario);  // MODIFICO INTRODUZCO LOS DATOS EN EL ARRAY 
	}

	@Override
	public void delete(Long id) {
		for(int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getId() == id) {
				usuarios.remove(i);
				return;
			}
		}
		
		throw new AccesoDatosException(NO_EXISTE_ESE_ID);
	}
}
