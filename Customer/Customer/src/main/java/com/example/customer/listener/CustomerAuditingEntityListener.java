package com.example.customer.listener;

import com.example.customer.model.AbstractAuditEnity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.data.auditing.AuditingHandler;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

public class CustomerAuditingEntityListener extends AuditingEntityListener {
    public CustomerAuditingEntityListener(ObjectFactory<AuditingHandler> handler) {
        super.setAuditingHandler(handler);
    }

    @Override
    @PrePersist
    public void touchForCreate(Object target) {
        super.touchForCreate(target);
        AbstractAuditEnity auditEnity = (AbstractAuditEnity) target;
        if (auditEnity.getCreatedBy() == null) {
            super.touchForCreate(target);
        } else {
            if(auditEnity.getLastModifiedBy() == null) {
                auditEnity.setLastModifiedBy(auditEnity.getCreatedBy());
            }
        }
    }

    @Override
    @PreUpdate
    public void touchForUpdate(Object target) {
        super.touchForUpdate(target);
        AbstractAuditEnity auditEnity = (AbstractAuditEnity) target;
        if (auditEnity.getLastModifiedBy() == null) {
            super.touchForUpdate(target);
        }
    }
}
