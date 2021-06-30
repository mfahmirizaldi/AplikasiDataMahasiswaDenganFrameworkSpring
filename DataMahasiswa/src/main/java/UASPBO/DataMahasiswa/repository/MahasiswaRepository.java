package UASPBO.DataMahasiswa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import UASPBO.DataMahasiswa.entity.Mahasiswa;

@Repository
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Long>{
	List<Mahasiswa> findByName(String name);
}
