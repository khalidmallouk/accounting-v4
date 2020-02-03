/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author hp
 */
@Entity
public class CompteComptable implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;
    private int numero;
    @OneToMany(mappedBy = "compteComptable")
    private List<OperationSaisie> operationSaisies;

    public CompteComptable() {
    }

    public CompteComptable(Long id, String libelle, int numero, List<OperationSaisie> operationSaisies) {
        this.id = id;
        this.libelle = libelle;
        this.numero = numero;
        this.operationSaisies = operationSaisies;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<OperationSaisie> getOperationSaisies() {
        return operationSaisies;
    }

    public void setOperationSaisies(List<OperationSaisie> operationSaisies) {
        this.operationSaisies = operationSaisies;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompteComptable)) {
            return false;
        }
        CompteComptable other = (CompteComptable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.CompteComptable[ id=" + id + " ]";
    }
    
}
