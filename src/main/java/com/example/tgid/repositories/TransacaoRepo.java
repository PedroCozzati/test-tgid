package com.example.tgid.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.tgid.transacao.Transacao;

@Repository
public interface TransacaoRepo extends JpaRepository<Transacao, Long> {
}
