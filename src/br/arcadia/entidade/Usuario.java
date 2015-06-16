package br.arcadia.entidade;
public class Usuario {
	protected int Codigo;
	protected String Nome;
	protected String EMail;
	
	
	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int codigo) {
		Codigo = codigo;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getEMail() {
		return EMail;
	}

	public void setEMail(String idade) {
		EMail = idade;
	}

	@Override
	public String toString() {
		return "Pessoa [Codigo=" + Codigo + ", Nome=" + Nome + ", Idade="
				+ EMail + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Codigo;
		result = prime * result + ((EMail == null) ? 0 : EMail.hashCode());
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (Codigo != other.Codigo)
			return false;
		if (EMail == null) {
			if (other.EMail != null)
				return false;
		} else if (!EMail.equals(other.EMail))
			return false;
		if (Nome == null) {
			if (other.Nome != null)
				return false;
		} else if (!Nome.equals(other.Nome))
			return false;
		return true;
	}

	

	

	
	
}
