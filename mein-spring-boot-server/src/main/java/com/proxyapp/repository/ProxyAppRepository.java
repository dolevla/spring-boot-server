package com.proxyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proxyapp.model.ProxyAppModel;

@Repository
public interface ProxyAppRepository extends JpaRepository<ProxyAppModel, Long> {
    // Add custom query methods here
}