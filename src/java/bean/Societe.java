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
public class Societe implements Serializable {
//     ACHATS, VENTES, BANQUE, CAISSE, OPERATIONDIVERS, REPORTANOUVEAU;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String raisonSociale;
    private String iFiscal;
    private String ice;
    @OneToMany(mappedBy = "societe")
    private List<OperationSaisie> operationSaisies;
    @OneToMany(mappedBy = "societe")
    private List<Facture> factures;

    public Societe() {
    }

    public Societe(Long id, String raisonSociale, String iFiscal, String ice) {
        this.id = id;
        this.raisonSociale = raisonSociale;
        this.iFiscal = iFiscal;
        this.ice = ice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getiFiscal() {
        return iFiscal;
    }

    public void setiFiscal(String iFiscal) {
        this.iFiscal = iFiscal;
    }

    public String getIce() {
        return ice;
    }

    public void setIce(String ice) {
        this.ice = ice;
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
        if (!(object instanceof Societe)) {
            return false;
        }
        Societe other = (Societe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Societe[ id=" + id + " ]";
    }

}
