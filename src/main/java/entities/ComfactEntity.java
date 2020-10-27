package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "comfact", schema = "public", catalog = "d3aoi5pdhq46hl")
public class ComfactEntity {
    private int numcommande;
    private Integer numfact;
    private Date datecom;
    private String etat;
    private BigDecimal montant;
    private ClientEntity apiClientByIdclient;
    @Id
    @Column(name = "numcommande", nullable = false)
    public int getNumcommande() {
        return numcommande;
    }
    public void setNumcommande(int numcommande) {
        this.numcommande = numcommande;
    }
    @Basic
    @Column(name = "numfact", nullable = true)
    public Integer getNumfact() {
        return numfact;
    }
    public void setNumfact(Integer numfact) {
        this.numfact = numfact;
    }
    @Basic
    @Column(name = "datecom", nullable = true)
    public Date getDatecom() {
        return datecom;
    }
    public void setDatecom(Date datecom) {
        this.datecom = datecom;
    }
    @Basic
    @Column(name = "etat", nullable = true, length = -1)
    public String getEtat() {
        return etat;
    }
    public void setEtat(String etat) {
        this.etat = etat;
    }
    @Basic
    @Column(name = "montant", nullable = true, precision = 0)
    public BigDecimal getMontant() {
        return montant;
    }
    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComfactEntity that = (ComfactEntity) o;
        if (numcommande != that.numcommande) return false;
        if (numfact != null ? !numfact.equals(that.numfact) : that.numfact != null) return
                false;
        if (datecom != null ? !datecom.equals(that.datecom) : that.datecom != null) return
                false;
        if (etat != null ? !etat.equals(that.etat) : that.etat != null) return false;
        if (montant != null ? !montant.equals(that.montant) : that.montant != null) return
                false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = numcommande;
        result = 31 * result + (numfact != null ? numfact.hashCode() : 0);
        result = 31 * result + (datecom != null ? datecom.hashCode() : 0);
        result = 31 * result + (etat != null ? etat.hashCode() : 0);
        result = 31 * result + (montant != null ? montant.hashCode() : 0);
        return result;
    }
    @ManyToOne
    @JoinColumn(name = "fkclient", referencedColumnName = "idclient", nullable = false)
    public ClientEntity getApiClientByIdclient() {
        return apiClientByIdclient;
    }
    public void setApiClientByIdclient(ClientEntity apiClientByIdclient) {
        this.apiClientByIdclient = apiClientByIdclient;
    }
}
