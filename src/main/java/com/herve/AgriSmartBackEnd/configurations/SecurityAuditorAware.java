package com.herve.AgriSmartBackEnd.configurations;

import com.herve.AgriSmartBackEnd.users.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SecurityAuditorAware implements AuditorAware<Integer> {

    @Override
    public Optional<Integer> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 1. Gérer les cas non-authentifiés
        if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
            // Puisque 'created_by' est NOT NULL, vous devez retourner un ID par défaut.
            // Si vous n'avez pas d'ID 'SYSTEM', utilisez 'Optional.of(-1)' ou retirez 'nullable=false' de la BDD.
            return Optional.of(-1);
        }

        // 2. Récupérer et caster l'objet User
        Object principal = authentication.getPrincipal();

        if (principal instanceof User) {
            // Récupérer l'ID à partir de votre entité User
            Integer userId = ((User) principal).getId();
            return Optional.ofNullable(userId);
        }

        // Si le Principal n'est pas l'objet User attendu (parfois c'est juste le nom d'utilisateur String)
        return Optional.of(-1);
    }
}
