/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author hp
 */
@Entity
public class OperationSaisie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Societe societe;
    @ManyToOne
    private TypeJournal typeJournal;
    private Double numeroEnregistrement;
    private String numeroFacture;
    @ManyToOne
    private CompteComptable compteComptable;
    private String libelle;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOperation;
    private BigDecimal montant;

    @ManyToOne
    private TypeOperationSaisie typeOperationSaisie;

    public OperationSaisie() {
    }

    public OperationSaisie(Long id, Double numeroEnregistrement, String numeroFacture, String libelle, Date dateOperation, BigDecimal montant) {
        this.id = id;
        this.numeroEnregistrement = numeroEnregistrement;
        this.numeroFacture = numeroFacture;
        this.libelle = libelle;
        this.dateOperation = dateOperation;

    }

    public Long getId() {
        return id;
    }

    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

    public TypeJournal getTypeJournal() {
        return typeJournal;
    }

    public void setTypeJournal(TypeJournal typeJournal) {
        this.typeJournal = typeJournal;
    }

    public Double getNumeroEnregistrement() {
        return numeroEnregistrement;
    }

    public void setNumeroEnregistrement(Double numeroEnregistrement) {
        this.numeroEnregistrement = numeroEnregistrement;
    }

    public String getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(String numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public CompteComptable getCompteComptable() {
        return compteComptable;
    }

    public void setCompteComptable(CompteComptable compteComptable) {
        this.compteComptable = compteComptable;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montantDebit) {
        this.montant = montantDebit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeOperationSaisie getTypeOperationSaisie() {
        return typeOperationSaisie;
    }

    public void setTypeOperationSaisie(TypeOperationSaisie typeOperationSaisie) {
        this.typeOperationSaisie = typeOperationSaisie;
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
        if (!(object instanceof OperationSaisie)) {
            return false;
        }
        OperationSaisie other = (OperationSaisie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.OperationSaisie[ id=" + id + " ]";
    }

}
