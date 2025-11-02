package com.davidev.repository;

import com.davidev.account.PartnerRole;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class PartnerRoleSpecifications {
    public static Specification<PartnerRole> searchByCode(String code){
        return (Root<PartnerRole> root,CriteriaQuery<?> criteriaQuery, CriteriaBuilder builder) -> {
            if (code == null) {
                return null;
            }
            return builder.like(builder.lower(root.<String>get("code")), "%:" + code.toLowerCase() + "%");
        };
    }
    public static Specification<PartnerRole> hasCode(String code){
        return (Root<PartnerRole> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder builder)->{
          if(code == null){
              return null;
          }
          return builder.equal(root.get("code"), code);
        };
    }
    public static List<Specification<PartnerRole>> hasCodeIn(List<String> codeList){
        if(codeList.isEmpty()){
            return null;
        }
        codeList.forEach(c->{

        });
    }

    public static Specification<PartnerRole> isPartnerRoleActive(Boolean isActive){
        return (Root<PartnerRole> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder builder)->{
            if(isActive == null){
                return null;
            }
            return builder.equal(root.<Boolean>get("isActive"),isActive);
        };
    }
}