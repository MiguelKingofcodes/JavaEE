package model;

// TODO: Auto-generated Javadoc
/**
 * The Class JavaBeans.
 */
public class JavaBeans {
	
	/** The idcon. */
	// Atributos do Servidor de BD dbagenda
	private int idcon;
	
	/** The nome. */
	private String nome;
	
	/** The phone. */
	private String phone;
	
	/** The email. */
	private String email;
	
	
	/**
	 * Instantiates a new java beans.
	 */
	// Construtor sem campos
	public JavaBeans() {
		super();

	}
	
	/**
	 * Instantiates a new java beans.
	 *
	 * @param idcon the idcon
	 * @param nome the nome
	 * @param phone the phone
	 * @param email the email
	 */
	// Construto com campos
	public JavaBeans(int idcon, String nome, String phone, String email) {
		super();
		this.idcon = idcon;
		this.nome = nome;
		this.phone = phone;
		this.email = email;
	}


	/**
	 * Gets the idcon.
	 *
	 * @return the idcon
	 */
	// Getters and Setters
	public int getIdcon() {
		return idcon;
	}
	
	/**
	 * Sets the idcon.
	 *
	 * @param idcon the new idcon
	 */
	public void setIdcon(int idcon) {
		this.idcon = idcon;
	}
	
	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
