package UASPBO.DataMahasiswa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mahasiswa_")
public class Mahasiswa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "nim")
	private long nim;
	
	@Column(name = "email")
	private String email;
	
	
	
	
	public Mahasiswa() {
		super();
	}

	public Mahasiswa(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getNim() {
		return nim;
	}
	public void setNim(long nim) {
		this.nim = nim;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
